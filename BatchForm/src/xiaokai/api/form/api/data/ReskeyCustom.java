package xiaokai.api.form.api.data;

import xiaokai.api.form.api.BaseForm;
import xiaokai.api.form.api.CustomForm;
import xiaokai.api.form.tool.Tool;

import cn.nukkit.Player;
import cn.nukkit.form.element.Element;
import cn.nukkit.form.element.ElementDropdown;
import cn.nukkit.form.element.ElementStepSlider;
import cn.nukkit.form.element.ElementToggle;
import cn.nukkit.form.response.FormResponse;
import cn.nukkit.form.response.FormResponseCustom;

/**
 * @author Winfxk
 */
public class ReskeyCustom extends Reskey {
	private FormResponseCustom data;
	private CustomForm form;

	public ReskeyCustom(Player player, int ID, FormResponse data, BaseForm form) {
		super(player, ID, data, form);
		this.data = (FormResponseCustom) data;
		this.form = (CustomForm) form;
	}

	/**
	 * 获取双精类型的数据
	 * 
	 * @param Key 数据键
	 * @return
	 */
	public double getDouble(String Key) {
		return getDouble(Key, 0d);
	}

	/**
	 * 获取双精类型的数据
	 * 
	 * @param Key 数据键
	 * @param obj 默认值
	 * @return
	 */
	public double getDouble(String Key, double obj) {
		String string = getString(Key);
		if (string == null || string.isEmpty() || !Tool.isInteger(string))
			return obj;
		return Double.valueOf(string);
	}

	/**
	 * 获取整数型数据
	 * 
	 * @param Key 数据键
	 * @return
	 */
	public int getInt(String Key) {
		return getInt(Key, 0);
	}

	/**
	 * 获取整数型数据
	 * 
	 * @param Key 数据键
	 * @param obj 默认值
	 * @return
	 */
	public int getInt(String Key, int obj) {
		for (int i = 0; i < form.getKeys().size(); i++)
			if (form.getKeys().get(i).equals(Key)) {
				Element ui = form.getList().get(i);
				if (ui instanceof ElementDropdown)
					return data.getDropdownResponse(i).getElementID();
				if (ui instanceof ElementStepSlider)
					return data.getStepSliderResponse(i).getElementID();
				return Tool.ObjectToInt(get(Key), obj);
			}
		return obj;
	}

	/**
	 * 获取布尔值类型的数据s
	 * 
	 * @param Key 数据键
	 * @return
	 */
	public boolean getBoolean(String Key) {
		return getBoolean(Key, false);
	}

	/**
	 * 获取布尔值类型的数据
	 * 
	 * @param Key 数据键
	 * @param obj 默认值
	 * @return
	 */
	public boolean getBoolean(String Key, boolean obj) {
		for (int i = 0; i < form.getKeys().size(); i++)
			if (form.getKeys().get(i).equals(Key)) {
				Element ui = form.getList().get(i);
				if (ui instanceof ElementToggle)
					return data.getToggleResponse(i);
				return Tool.ObjToBool(get(Key), obj);
			}
		return obj;
	}

	/**
	 * 获取对应的文本值
	 * 
	 * @param Key 数据键
	 * @return
	 */
	public String getString(String Key) {
		return getString(Key, null);
	}

	/**
	 * 获取对应的文本值
	 * 
	 * @param Key 数据键
	 * @param obj 默认值
	 * @return
	 */
	public String getString(String Key, String obj) {
		Object object = get(Key);
		return object == null ? obj : String.valueOf(get(Key, obj));
	}

	/**
	 * 获取数据
	 * 
	 * @param Key 对应数据的数据键
	 * @return
	 */
	public Object get(String Key) {
		return get(Key, null);
	}

	/**
	 * 获取数据
	 * 
	 * @param Key 对应数据的数据键
	 * @param obj 默认值
	 * @return
	 */
	public Object get(String Key, Object obj) {
		for (int i = 0; i < form.getKeys().size(); i++)
			if (form.getKeys().get(i).equals(Key)) {
				Element ui = form.getList().get(i);
				if (ui instanceof ElementDropdown)
					return data.getDropdownResponse(i).getElementContent();
				if (ui instanceof ElementStepSlider)
					return data.getStepSliderResponse(i).getElementContent();
				return data.getResponse(i);
			}
		return obj;
	}
}
