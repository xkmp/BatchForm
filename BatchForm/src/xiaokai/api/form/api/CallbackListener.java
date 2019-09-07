package xiaokai.api.form.api;

import xiaokai.api.form.api.data.Reskey;

import cn.nukkit.event.player.PlayerFormRespondedEvent;

/**
 * 处理玩家截面数据回调事件类
 * 
 * @author Winfxk
 */
public interface CallbackListener {
	/**
	 * 直接返回事件对象
	 * 
	 * @param e
	 * @return
	 */
	public abstract boolean CallbackEvent(PlayerFormRespondedEvent e);

	/**
	 * 返回自定义数据
	 * 
	 * @param reskey    返回的数据内容
	 * @param wasClosed 玩家是点击提交的界面还是关闭了界面
	 * @return
	 */
	public abstract boolean CallbackReskey(Reskey reskey);
}
