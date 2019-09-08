package xiaokai.api.form.api.lis;

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
}
