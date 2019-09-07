package xiaokai.api.form.api;

import java.util.List;

import cn.nukkit.form.element.ElementButton;
import cn.nukkit.form.element.ElementButtonImageData;
import cn.nukkit.form.window.FormWindow;
import cn.nukkit.form.window.FormWindowSimple;

/**
 * @author Winfxk
 */
public class SimpleForm extends BaseForm {
	private String Content = "";
	private List<ElementButton> Buttons;
	private List<String> Keys;

	/**
	 * 按钮界面
	 * 
	 * @param ID               界面的ID
	 * @param Title            界面的标题
	 * @param callbackListener 回调对象
	 */
	public SimpleForm(int ID, String Title, CallbackListener callbackListener) {
		super(ID, Title, callbackListener);
	}

	/**
	 * 按钮界面
	 * 
	 * @param ID 界面的ID
	 */
	public SimpleForm(int ID) {
		this(ID, null);
	}

	/**
	 * 获取文本内容
	 * 
	 * @return
	 */
	public String getContent() {
		return Content;
	}

	/**
	 * 获取数据键
	 * 
	 * @return
	 */
	public List<String> getKeys() {
		return Keys;
	}

	/**
	 * 按钮界面
	 * 
	 * @param ID               界面的ID
	 * @param callbackListener 回调对象
	 */
	public SimpleForm(int ID, CallbackListener callbackListener) {
		this(ID, "", callbackListener);
	}

	/**
	 * 按钮界面
	 * 
	 * @param ID               界面的ID
	 * @param Title            界面的标题
	 * @param Content          界面文本内容
	 * @param callbackListener 回调对象
	 */
	public SimpleForm(int ID, String Title, String Content, CallbackListener callbackListener) {
		this(ID, Title, callbackListener);
		this.Content = Content;
	}

	/**
	 * 添加一个按钮
	 * 
	 * @param Text 按钮内容
	 * @return
	 */
	public SimpleForm addButton(String Text) {
		return addButton(Text, true, null, Text);
	}

	/**
	 * 添加一个按钮
	 * 
	 * @param Text 按钮内容
	 * @param Key  数据键
	 * @return
	 */
	public SimpleForm addButton(String Text, String Key) {
		return addButton(Text, true, null, Key);
	}

	/**
	 * 添加一个按钮
	 * 
	 * @param Text    按钮内容
	 * @param isLocal 是否为本地贴图
	 * @param Path    贴图路径
	 * @return
	 */
	public SimpleForm addButton(String Text, boolean isLocal, String Path) {
		return this.addButton(Text, isLocal, Path, Text);
	}

	/**
	 * 添加一个按钮
	 * 
	 * @param Text    按钮内容
	 * @param isLocal 是否为本地贴图
	 * @param Path    贴图路径
	 * @param Key     数据键
	 * @return
	 */
	public SimpleForm addButton(String Text, boolean isLocal, String Path, String Key) {
		Buttons.add(new ElementButton(Text, new ElementButtonImageData(
				isLocal ? ElementButtonImageData.IMAGE_DATA_TYPE_PATH : ElementButtonImageData.IMAGE_DATA_TYPE_URL,
				Path)));
		Keys.add(Key);
		return this;
	}

	@Override
	public FormWindow getFormWindow() {
		return new FormWindowSimple(Title, Content, Buttons);
	}

	@Override
	public String getType() {
		return "Simple";
	}

}
