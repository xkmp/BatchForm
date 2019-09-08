package xiaokai.api.form.api.data;

import xiaokai.api.form.api.BaseForm;
import xiaokai.api.form.api.SimpleForm;

import cn.nukkit.Player;
import cn.nukkit.form.response.FormResponse;
import cn.nukkit.form.response.FormResponseSimple;

/**
 * @author Winfxk
 */
public class ReskeySimple extends Reskey {
	private SimpleForm form;
	private FormResponseSimple data;

	public ReskeySimple(Player player, int ID, FormResponse data, BaseForm form) {
		super(player, ID, data, form);
		this.form = (SimpleForm) form;
		this.data = (FormResponseSimple) data;
	}

	/**
	 * 获取点击的按钮的数据键
	 * 
	 * @return
	 */
	public String getKey() {
		return form.getKeys().get(getButtonID());
	}

	/**
	 * 获取玩家点击的按钮的文本内容
	 * 
	 * @return
	 */
	public String getString() {
		return data.getClickedButton().getText();
	}

	/**
	 * 获取指定的文本
	 * 
	 * @param obj 数据键
	 * @return
	 */
	public String getString(Object obj) {
		return getString(obj, null);
	}

	/**
	 * 获取指定的文本
	 * 
	 * @param obj    数据键
	 * @param string 默认显示的内容
	 * @return
	 */
	public String getString(Object obj, String string) {
		for (int i = 0; i < form.getKeys().size(); i++)
			if (form.getKeys().get(i).equals(obj))
				return form.getButtons().get(i).getText();
		return string;
	}

	/**
	 * 获取玩家点击的是第几个按钮（从零开始）
	 * 
	 * @return
	 */
	public int getButtonID() {
		return data.getClickedButtonId();
	}
}
