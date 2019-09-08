package xiaokai.api.form;

import xiaokai.api.form.api.BaseForm;
import xiaokai.api.form.api.data.ReskeyCustom;
import xiaokai.api.form.api.data.ReskeyModal;
import xiaokai.api.form.api.data.ReskeySimple;
import xiaokai.api.form.api.lis.CustomCallbackListener;
import xiaokai.api.form.api.lis.ModalCallbackListener;
import xiaokai.api.form.api.lis.SimpleCallbackListener;
import xiaokai.tool.Tool;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerFormRespondedEvent;
import cn.nukkit.form.response.FormResponse;
import cn.nukkit.plugin.PluginBase;

@SuppressWarnings("unchecked")
public class Main extends PluginBase implements Listener {
	private LinkedHashMap<String, Map<Integer, BaseForm>> data = new LinkedHashMap<>();
	public static Main main;

	@Override
	public void onEnable() {
		main = this;
		super.onEnable();
		getServer().getPluginManager().registerEvents(this, this);
		this.getServer().getLogger().info(Tool.getColorFont("欢迎使用" + getName() + "！作者：么么哒滴帅比凯；QQ：2508543202"));
	}

	@Override
	public void onDisable() {
		super.onDisable();
		this.getServer().getLogger().info(Tool.getColorFont(getName() + "关闭！感谢使用~"));
	}

	/**
	 * 添加对口项目数据
	 * 
	 * @param player
	 * @param ID
	 * @param callback
	 */
	public void putForm(BaseForm form, Player player) {
		Object obj = data.get(player.getName());
		Map<Integer, BaseForm> map = (obj != null && (obj instanceof Map)) ? (HashMap<Integer, BaseForm>) obj
				: new HashMap<>();
		map.put(form.ID, form);
		data.put(player.getName(), map);
	}

	/**
	 * 监听事件返回
	 * 
	 * @param e
	 */
	@EventHandler(priority = EventPriority.HIGH, ignoreCancelled = false)
	public void onPlayerForm(PlayerFormRespondedEvent e) {
		Player player = e.getPlayer();
		int ID = e.getFormID();
		FormResponse da = e.getResponse();
		if (data.containsKey(player.getName())) {
			Map<Integer, BaseForm> map = data.get(player.getName());
			if (map.containsKey(ID)) {
				BaseForm form = map.get(ID);
				map.remove(ID);
				data.put(player.getName(), map);
				if (!form.callback.CallbackEvent(e))
					switch (form.getType()) {
					case "Modal":
						((ModalCallbackListener) form.callback)
								.CallbackReskey(new ReskeyModal(player, form.ID, da, form));
						break;
					case "Custom":
						((CustomCallbackListener) form.callback)
								.CallbackReskey(new ReskeyCustom(player, form.ID, da, form));
						break;
					case "Simple":
						((SimpleCallbackListener) form.callback)
								.CallbackReskey(new ReskeySimple(player, form.ID, da, form));
						break;
					}
			}
		}
	}
}
