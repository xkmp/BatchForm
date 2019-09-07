package xiaokai.api.form;

import xiaokai.api.form.api.BaseForm;
import xiaokai.api.form.api.data.Reskey;
import xiaokai.api.form.api.data.ReskeyCustom;
import xiaokai.api.form.api.data.ReskeyModal;
import xiaokai.api.form.api.data.ReskeySimple;
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
		super.onEnable();
		getServer().getPluginManager().registerEvents(this, this);
		this.getServer().getLogger().info(Tool.getColorFont("欢迎使用" + getName()));
	}

	@Override
	public void onLoad() {
		main = this;
		this.getServer().getLogger().info(Tool.getColorFont(getName() + "加载"));
	}

	@Override
	public void onDisable() {
		super.onDisable();
		this.getServer().getLogger().info(Tool.getColorFont(getName() + "关闭"));
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
		if (data.containsKey(player.getName())) {
			Map<Integer, BaseForm> map = data.get(player.getName());
			if (map.containsKey(ID)) {
				BaseForm form = map.get(ID);
				map.remove(ID);
				data.put(player.getName(), map);
				if (!form.callback.CallbackEvent(e))
					form.callback.CallbackReskey(getReskey(player, form, e));
			}
		}
	}

	/**
	 * 处理自定义Key
	 * 
	 * @param player
	 * @param ID
	 * @param e
	 * @return
	 */
	public Reskey getReskey(Player player, BaseForm form, PlayerFormRespondedEvent e) {
		FormResponse da = e.getResponse();
		switch (form.getType()) {
		case "Modal":
			return new ReskeyModal(player, form.ID, da, form);
		case "Custom":
			return new ReskeyCustom(player, form.ID, da, form);
		case "Simple":
			return new ReskeySimple(player, form.ID, da, form);
		}
		return null;
	}
}
