package xiaokai.api.form.api;

import xiaokai.api.form.api.lis.CustomCallbackListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cn.nukkit.form.element.Element;
import cn.nukkit.form.element.ElementButtonImageData;
import cn.nukkit.form.element.ElementDropdown;
import cn.nukkit.form.element.ElementInput;
import cn.nukkit.form.element.ElementLabel;
import cn.nukkit.form.element.ElementSlider;
import cn.nukkit.form.element.ElementStepSlider;
import cn.nukkit.form.element.ElementToggle;
import cn.nukkit.form.window.FormWindow;
import cn.nukkit.form.window.FormWindowCustom;

/**
 * @author Winfxk
 */
public class CustomForm extends BaseForm {
	/**
	 * 控件列表
	 */
	public List<Element> list = new ArrayList<>();
	/**
	 * 贴图对象
	 */
	public ElementButtonImageData Icon = null;
	/**
	 * 数据键
	 */
	public List<String> Keys = new ArrayList<>();

	/**
	 * 获取数据键列表
	 * 
	 * @return
	 */
	public List<String> getKeys() {
		return Keys;
	}

	/**
	 * 获取组件列表
	 * 
	 * @return
	 */
	public List<Element> getList() {
		return list;
	}

	/**
	 * 自定义界面
	 * 
	 * @param ID               界面的ID
	 * @param Title            界面的标题
	 * @param Icon             界面内提交按钮的贴图，若无请设置为null
	 * @param callbackListener 事件处理类
	 */
	public CustomForm(int ID, String Title, String Icon, CustomCallbackListener callbackListener) {
		this(ID, Title, callbackListener);
		this.Icon = Icon == null ? null : new ElementButtonImageData(ElementButtonImageData.IMAGE_DATA_TYPE_URL, Icon);
	}

	/**
	 * 自定义界面
	 * 
	 * @param ID               界面的ID
	 * @param Title            界面的标题
	 * @param callbackListener 事件处理类
	 */
	public CustomForm(int ID, String Title, CustomCallbackListener callbackListener) {
		super(ID, Title, callbackListener);
	}

	/**
	 * 自定义界面
	 * 
	 * @param ID    界面的ID
	 * @param Title 界面的标题
	 */
	public CustomForm(int ID, String Title) {
		this(ID, Title, null, null);
	}

	/**
	 * 自定义界面
	 * 
	 * @param ID 界面的ID
	 */
	public CustomForm(int IDe) {
		this(IDe, "", null, null);
	}

	/**
	 * 添加一个编辑框
	 * 
	 * @param text 编辑框标题
	 * @return
	 */
	public CustomForm addInput(String text) {
		return addInput(text, "");
	}

	/**
	 * 添加一个编辑框
	 * 
	 * @param text    编辑框标题
	 * @param Default 编辑框默认显示的内容
	 * @return
	 */
	public CustomForm addInput(String text, String Default) {
		return addInput(text, Default, "");
	}

	/**
	 * 添加一个编辑框
	 * 
	 * @param text    编辑框标题
	 * @param Default 编辑框默认显示的内容
	 * @param Hint    编辑框为空时显示的内容
	 * @return
	 */
	public CustomForm addInput(String text, String Default, String Hint) {
		return addInput(text, Default, Hint, text);
	}

	/**
	 * 添加一个编辑框
	 * 
	 * @param text    编辑框标题
	 * @param Default 编辑框默认显示的内容
	 * @param Hint    编辑框为空时显示的内容
	 * @param Key     数据键
	 * @return
	 */
	public CustomForm addInput(String text, String Default, String Hint, String Key) {
		list.add(new ElementInput(text, Hint == null ? "" : Hint, Default == null ? "" : Default));
		Keys.add(Key);
		return this;
	}

	/**
	 * 添加一个下拉菜单
	 * 
	 * @param Text    下拉菜单标题
	 * @param Options 下拉菜单内容
	 * @return
	 */
	public CustomForm addDropdown(String Text, String[] Options) {
		return addDropdown(Text, Options, Text);
	}

	/**
	 * 添加一个下拉菜单
	 * 
	 * @param Text    下拉菜单标题
	 * @param Options 下拉菜单内容
	 * @param Key     数据键
	 * @return
	 */
	public CustomForm addDropdown(String Text, String[] Options, String Key) {
		return addDropdown(Text, Options, 0, Key);
	}

	/**
	 * 添加一个下拉菜单
	 * 
	 * @param Text          下拉菜单标题
	 * @param Options       下拉菜单内容
	 * @param DefaultOption 默认显示选项
	 * @return
	 */
	public CustomForm addDropdown(String Text, String[] Options, int DefaultOption) {
		return addDropdown(Text, Options, DefaultOption, Text);
	}

	/**
	 * 添加一个下拉菜单
	 * 
	 * @param Text          下拉菜单标题
	 * @param Options       下拉菜单内容
	 * @param DefaultOption 默认显示选项
	 * @param Key           数据键
	 * @return
	 */
	public CustomForm addDropdown(String Text, String[] Options, int DefaultOption, String Key) {
		list.add(new ElementDropdown(Text, Arrays.asList(Options), DefaultOption));
		Keys.add(Key);
		return this;
	}

	/**
	 * 添加一个标签
	 * 
	 * @param Text 标签标题
	 * @return
	 */
	public CustomForm addLabel(String Text) {
		return addLabel(Text, Text);
	}

	/**
	 * 添加一个标签
	 * 
	 * @param Text 标签标题
	 * @param Key  数据键
	 * @return
	 */
	public CustomForm addLabel(String Text, String Key) {
		list.add(new ElementLabel(Text));
		Keys.add(Key);
		return this;
	}

	/**
	 * 添加一个滑动控件
	 * 
	 * @param Text 控件标题
	 * @param Min  最小值
	 * @param Max  最大值
	 * @return
	 */
	public CustomForm addSlider(String Text, int Min, int Max) {
		return addSlider(Text, Min, Max, Text);
	}

	/**
	 * 添加一个滑动控件
	 * 
	 * @param Text 控件标题
	 * @param Min  最小值
	 * @param Max  最大值
	 * @param Key  数据键
	 * @return
	 */
	public CustomForm addSlider(String Text, int Min, int Max, String Key) {
		return addSlider(Text, Min, Max, 1, 0, Key);
	}

	/**
	 * 添加一个滑动控件
	 * 
	 * @param Text 控件标题
	 * @param Min  最小值
	 * @param Max  最大值
	 * @param Step 步长
	 * @return
	 */
	public CustomForm addSlider(String Text, int Min, int Max, int Step) {
		return addSlider(Text, Min, Max, Step, 0);
	}

	/**
	 * 添加一个滑动控件
	 * 
	 * @param Text 控件标题
	 * @param Min  最小值
	 * @param Max  最大值
	 * @param Step 步长
	 * @param Key  数据键
	 * @return
	 */
	public CustomForm addSlider(String Text, int Min, int Max, int Step, String Key) {
		return addSlider(Text, Min, Max, Step, 0, Key);
	}

	/**
	 * 添加一个滑动控件
	 * 
	 * @param Text         控件标题
	 * @param Min          最小值
	 * @param Max          最大值
	 * @param Step         步长
	 * @param DefaultValue 默认显示
	 * @return
	 */
	public CustomForm addSlider(String Text, int Min, int Max, int Step, int DefaultValue) {
		return addSlider(Text, Min, Max, Step, DefaultValue, Text);
	}

	/**
	 * 添加一个滑动控件
	 * 
	 * @param Text         控件标题
	 * @param Min          最小值
	 * @param Max          最大值
	 * @param Step         步长
	 * @param DefaultValue 默认显示
	 * @param Key          数据键
	 * @return
	 */
	public CustomForm addSlider(String Text, int Min, int Max, int Step, int DefaultValue, String Key) {
		list.add(new ElementSlider(Text, Min, Max, Step, DefaultValue));
		Keys.add(Key);
		return this;
	}

	/**
	 * 添加一个滑动选项条
	 * 
	 * @param Text    控件标题
	 * @param Options 控件选项
	 * @param Key     数据键
	 * @return
	 */
	public CustomForm addStepSlider(String Text, String[] Options, String Key) {
		return addStepSlider(Text, Options, 0, Key);
	}

	/**
	 * 添加一个滑动选项条
	 * 
	 * @param Text    控件标题
	 * @param Options 控件选项
	 * @return
	 */
	public CustomForm addStepSlider(String Text, String[] Options) {
		return addStepSlider(Text, Options, 0, Text);
	}

	/**
	 * 添加一个滑动选项条
	 * 
	 * @param Text    控件标题
	 * @param Options 控件选项
	 * @param Default 控件默认显示
	 * @return
	 */
	public CustomForm addStepSlider(String Text, String[] Options, int Default) {
		return addStepSlider(Text, Options, Default, Text);
	}

	/**
	 * 添加一个滑动选项条
	 * 
	 * @param Text    控件标题
	 * @param Options 控件选项
	 * @param Default 控件默认显示
	 * @param Key     数据键
	 * @return
	 */
	public CustomForm addStepSlider(String Text, String[] Options, int Default, String Key) {
		list.add(new ElementStepSlider(Text, Arrays.asList(Options), Default));
		Keys.add(Key);
		return this;
	}

	/**
	 * 添加一个开关控件
	 * 
	 * @param Text 控件显示的文字
	 * @return
	 */
	public CustomForm addToggle(String Text) {
		return addToggle(Text, Text);
	}

	/**
	 * 添加一个开关控件
	 * 
	 * @param Text 控件显示的文字
	 * @param Key  数据获取键
	 * @return
	 */
	public CustomForm addToggle(String Text, String Key) {
		return addToggle(Text, false, Key);
	}

	/**
	 * 添加一个开关控件
	 * 
	 * @param Text    控件显示的文字
	 * @param Default 开关的默认状态
	 * @return
	 */
	public CustomForm addToggle(String Text, Boolean Default) {
		return addToggle(Text, Default, Text);
	}

	/**
	 * 添加一个开关控件
	 * 
	 * @param Text    控件显示的文字
	 * @param Default 开关的默认状态
	 * @param Key     数据获取键
	 * @return
	 */
	public CustomForm addToggle(String Text, Boolean Default, String Key) {
		list.add(new ElementToggle(Text, Default));
		Keys.add(Key);
		return this;
	}

	@Override
	public FormWindow getFormWindow() {
		return new FormWindowCustom(Title, list, Icon);
	}

	@Override
	public String getType() {
		return "Custom";
	}
}
