package xiaokai.api.form.api.data;

import xiaokai.api.form.api.BaseForm;

import cn.nukkit.Player;
import cn.nukkit.form.response.FormResponse;

/**
 * @author Winfxk
 */
public abstract class Reskey {
	public Player player;
	public int ID;
	public FormResponse data;
	public BaseForm form;

	public Reskey(Player player, int ID, FormResponse data, BaseForm form) {
		this.player = player;
		this.ID = ID;
		this.data = data;
		this.form = form;
	}

}
