package xiaokai.api.form.api;

import xiaokai.api.form.Main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.form.window.FormWindow;

/**
 * @author Winfxk
 */
public abstract class BaseForm {
	/**
	 * 界面的ID
	 */
	public int ID;
	/**
	 * 界面的标题
	 */
	public String Title;
	/**
	 * 回调对象
	 */
	public CallbackListener callback;
	/**
	 * 存储数据Key
	 */
	public Map<Integer, String> map = new HashMap<>();

	/**
	 * @param ID               界面ID
	 * @param Title            界面的标题
	 * @param callbackListener 界面数据回调处理对象
	 */
	public BaseForm(int ID, String Title, CallbackListener callbackListener) {
		this.callback = callbackListener;
		this.ID = ID;
		this.Title = Title;
	}
	/**
	 * 发送一个界面给一个服务器所有在线玩家
	 * 
	 * @return
	 */
	public int sendPlayer() {
		Map<UUID, Player> map = Server.getInstance().getOnlinePlayers();
		List<Player> players = new ArrayList<>();
		for (UUID obj : map.keySet()) {
			Player player = map.get(obj);
			if (player != null && player.isOnline())
				if (callback != null)
					Main.main.putForm(this, player);
		}
		return sendPlayer(players);
	}

	/**
	 * 发送一个界面给一个玩家
	 * 
	 * @param player
	 * @return
	 */
	public int sendPlayer(Player... player) {
		for (Player p : player)
			if (p != null && p.isOnline())
				if (callback != null)
					Main.main.putForm(this, p);
		return ID;
	}

	/**
	 * 发送一个界面给一个玩家
	 * 
	 * @param player
	 * @return
	 */
	public int sendPlayer(List<Player> player) {
		for (Player p : player)
			if (p != null && p.isOnline())
				if (callback != null)
					Main.main.putForm(this, p);
		return ID;
	}

	/**
	 * 返回要显示的截面数据
	 * 
	 * @return
	 */
	public abstract FormWindow getFormWindow();

	/**
	 * 返回界面类型
	 * 
	 * @return
	 */
	public abstract String getType();

	/**
	 * 设置回调方法
	 * 
	 * @param callback
	 */
	public void setCallback(CallbackListener callback) {
		this.callback = callback;
	}

	/**
	 * 设置表单ID
	 * 
	 * @param iD
	 */
	public void setID(int iD) {
		ID = iD;
	}

	/**
	 * 设置表单标题
	 * 
	 * @param title
	 */
	public void setTitle(String title) {
		Title = title;
	}

	/**
	 * 获取回调方法
	 * 
	 * @return
	 */
	public CallbackListener getCallback() {
		return callback;
	}

	/**
	 * 获取表单ID
	 * 
	 * @return
	 */
	public int getID() {
		return ID;
	}

	/**
	 * 获取表单标题
	 * 
	 * @return
	 */
	public String getTitle() {
		return Title;
	}
}
