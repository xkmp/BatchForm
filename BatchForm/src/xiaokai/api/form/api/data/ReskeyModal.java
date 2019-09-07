package xiaokai.api.form.api.data;

import xiaokai.api.form.api.BaseForm;

import cn.nukkit.Player;
import cn.nukkit.form.response.FormResponse;
import cn.nukkit.form.response.FormResponseModal;

/**
 * @author Winfxk
 */
public class ReskeyModal extends Reskey {
	public ReskeyModal(Player player, int ID, FormResponse data, BaseForm form) {
		super(player, ID, data, form);
		boolean1 = ((FormResponseModal) data).getClickedButtonId() == 0;
	}

	private Boolean boolean1;

	/**
	 * 获取返回数据
	 * 
	 * @return
	 */
	public FormResponseModal getResponse() {
		return (FormResponseModal) data;
	}

	/**
	 * 取得玩家的选择
	 * 
	 * @return
	 */
	public boolean getSelect() {
		return boolean1;
	}
}
