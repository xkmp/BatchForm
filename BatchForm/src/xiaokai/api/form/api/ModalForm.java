package xiaokai.api.form.api;

import cn.nukkit.form.window.FormWindow;
import cn.nukkit.form.window.FormWindowModal;

/**
 * @author Winfxk
 */
public class ModalForm extends BaseForm {
	private String Content = "", trueButtonText = "§6确定", falseButtonText = "§4取消";

	/**
	 * 选择型界面
	 * 
	 * @param ID               界面ID
	 * @param Title            界面标题
	 * @param callbackListener 回调对象
	 */
	public ModalForm(int ID, String Title, CallbackListener callbackListener) {
		super(ID, Title, callbackListener);
	}

	/**
	 * 获取确定文本
	 * 
	 * @return
	 */
	public String getTrueButtonText() {
		return trueButtonText;
	}

	/**
	 * 获取否定文本
	 * 
	 * @return
	 */
	public String getFalseButtonText() {
		return falseButtonText;
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
	 * 选择型界面
	 * 
	 * @param ID 界面ID
	 */
	public ModalForm(int ID) {
		this(ID, "");
	}

	/**
	 * 选择型界面
	 * 
	 * @param ID    界面ID
	 * @param Title 界面标题
	 */
	public ModalForm(int ID, String Title) {
		this(ID, Title, "", "§6确定", "§4取消", null);
	}

	/**
	 * 选择型界面
	 * 
	 * @param ID               界面ID
	 * @param Title            界面标题
	 * @param Content          界面内容
	 * @param callbackListener 回调对象
	 */
	public ModalForm(int ID, String Title, String Content, CallbackListener callbackListener) {
		this(ID, Title, Content, "§6确定", "§4取消", callbackListener);
	}

	/**
	 * 选择型界面
	 * 
	 * @param ID      界面ID
	 * @param Title   界面标题
	 * @param Content 界面内容
	 */
	public ModalForm(int ID, String Title, String Content) {
		this(ID, Title, Content, "§6确定", "§4取消", null);
	}

	/**
	 * 选择型界面
	 * 
	 * @param ID              界面ID
	 * @param Title           界面标题
	 * @param Content         界面内容
	 * @param trueButtonText  确定按钮的内容
	 * @param falseButtonText 取消按钮的内容
	 */
	public ModalForm(int ID, String Title, String Content, String trueButtonText, String falseButtonText) {
		this(ID, Title, Content, trueButtonText, falseButtonText, null);
	}

	/**
	 * 选择型界面
	 * 
	 * @param ID               界面ID
	 * @param Title            界面标题
	 * @param Content          界面内容
	 * @param trueButtonText   确定按钮的内容
	 * @param falseButtonText  取消按钮的内容
	 * @param callbackListener 回调对象
	 */
	public ModalForm(int ID, String Title, String Content, String trueButtonText, String falseButtonText,
			CallbackListener callbackListener) {
		this(ID, Content, callbackListener);
		this.Content = Content;
		this.trueButtonText = trueButtonText;
		this.falseButtonText = falseButtonText;
	}

	@Override
	public FormWindow getFormWindow() {
		return new FormWindowModal(Title, Content, trueButtonText, falseButtonText);
	}

	@Override
	public String getType() {
		return "Modal";
	}

	/**
	 * 设置确定按钮的文字
	 * 
	 * @param string
	 * @return
	 */
	public ModalForm setTrueButton(String string) {
		trueButtonText = string;
		return this;
	}

	/**
	 * 设置界面按钮文本
	 * 
	 * @param trueButtonText  确定按钮的文字内容
	 * @param falseButtonText 取消按钮的文字内容
	 * @return
	 */
	public ModalForm setButton(String trueButtonText, String falseButtonText) {
		this.trueButtonText = trueButtonText;
		this.falseButtonText = falseButtonText;
		return this;
	}

	/**
	 * 设置取消按钮的文字
	 * 
	 * @param string
	 * @return
	 */
	public ModalForm setFalseButton(String string) {
		falseButtonText = string;
		return this;
	}
}
