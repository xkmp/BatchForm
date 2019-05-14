package cn.epicfx.xiaokai.niuppie_form;

import cn.nukkit.plugin.PluginBase;

public class Main extends PluginBase {
	@Override
	public void onEnable() {
		super.onEnable();
		this.getServer().getLogger()
				.info(Tool.getColorFont("欢迎使用" + getName() + "，本插件没有任何实质性的功能，若可以，直接将UI包导入您的插件更好哦~"));
	}

	@Override
	public void onLoad() {
		this.getServer().getLogger().info(Tool.getColorFont(getName() + "加载"));
	}

	@Override
	public void onDisable() {
		super.onDisable();
		this.getServer().getLogger().info(Tool.getColorFont(getName() + "关闭"));
	}
}
