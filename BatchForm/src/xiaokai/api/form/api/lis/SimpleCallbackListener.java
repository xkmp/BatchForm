package xiaokai.api.form.api.lis;

import xiaokai.api.form.api.data.ReskeySimple;

/**
 * @author Winfxk
 */
public interface SimpleCallbackListener extends CallbackListener {

	/**
	 * 返回自定义数据
	 * 
	 * @param reskey 返回的数据内容
	 * @return
	 */
	public abstract boolean CallbackReskey(ReskeySimple reskey);
}
