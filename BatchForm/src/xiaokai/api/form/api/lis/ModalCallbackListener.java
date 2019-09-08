package xiaokai.api.form.api.lis;

import xiaokai.api.form.api.data.ReskeyModal;

/**
 * @author Winfxk
 */
public interface ModalCallbackListener extends CallbackListener {

	/**
	 * 返回自定义数据
	 * 
	 * @param reskey 返回的数据内容
	 * @return
	 */
	public abstract boolean CallbackReskey(ReskeyModal reskey);
}
