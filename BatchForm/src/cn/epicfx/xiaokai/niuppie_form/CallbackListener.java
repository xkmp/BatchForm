package cn.epicfx.xiaokai.niuppie_form;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.player.PlayerFormRespondedEvent;

public interface CallbackListener {
	@EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = false)
	public abstract void onPlayerForm(PlayerFormRespondedEvent e);
}
