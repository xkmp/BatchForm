<h1>BatchForm<img src="https://raw.githubusercontent.com/xkmp/BatchForm/master/UI_iocn.png" height="64" width="64" align="left"></img></h1>
<br>

# 什么是BatchForm？

> BatchForm是一个辅助，简化，便捷NukkitX插件开发者进行UI开发的集成工具
> 插件本身并无任何实质性的功能，若可以，直接将UI包导入您的插件更好哦~ 

# BatchForm有哪些功能？
> - 支持创建三种UI
>   - `CustomForm.java`
>   - `ModalForm.java`
>   - `SimpleForm.java`
> - 支持监听玩家点击界面后事件
>   - `CallbackListener.java`
> - 集成小工具
>   - `Tool.java`
> - 主要是方便创建UI，还有管理

# BatchForm该如何使用？
#### 监听玩家点击界面后事件
```java
import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.player.PlayerFormRespondedEvent;
import cn.nukkit.form.response.FormResponse;
import cn.nukkit.form.window.FormWindow;

/**
 * Created by Anders on 2019/5/14.
 */
public class CallbackListener implements cn.epicfx.xiaokai.niuppie_form.CallbackListener{

	@EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = false)
	public void onPlayerForm(PlayerFormRespondedEvent event){
		Player player = event.getPlayer();
		int ID = event.getFormID();
		FormResponse Response = event.getResponse();
		FormWindow Window = event.getWindow();
		//尽情创造
    }
}
```
#### 创建UI，`CustomForm`示例
```java
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event){
	    CustomForm UI = new CustomForm(9527,"UI标题");
	    UI.addLabel("这是一段文字");
	    UI.addInput("一个简单的输入框", "默认输入内容", "占位符");
	    UI.addSlider("一个没什么卵用的滑块", 1, 9);
	    UI.sendPlayer(player);// 有时间补充图片
	}
```

### 计划实现功能
> - [x] 支持创建三种UI
>   - [x] `CustomForm.java`
>   - [x] `ModalForm.java`
>   - [x] `SimpleForm.java`
> - [x] 支持监听玩家点击界面后事件
>   - [x] `CallbackListener.java`
> - [x] 集成小工具
>   - [x] `Tool.java`
> - [ ] 物品ID表，通过物品ID或名称获取ID或名称或图像路径
>   - [ ] `ItemIDSunName.java`

### 问题反馈
###### 在使用中有任何问题，欢迎反馈给我，可以用以下联系方式跟我交流

![](http://q2.qlogo.cn/headimg_dl?bs=2508543202&dst_uin=2508543202&dst_uin=2508543202&;dst_uin=2508543202&spec=100&url_enc=0&referer=bu_interface&term_type=PC)
- ~~帅逼~~凯:
  - Mail: winfxk@qq.com
  - QQ: [冰月] 2508543202
  - GayHub: [WinfXK](https://github.com/WinfXK)
---
![](http://q2.qlogo.cn/headimg_dl?bs=2641541097&dst_uin=2641541097&dst_uin=2641541097&;dst_uin=2641541097&spec=100&url_enc=0&referer=bu_interface&term_type=PC)
- Code3zero:
  - Mail: 3zeroed@gmail.com
  - QQ: [3zero] 2641541097
  - GitHub: [3zero](https://github.com/3zeroed)


### 捐助开发者
> 在兴趣的驱动下,写一个`免费`的东西，有欣喜，也还有汗水
> 希望你喜欢我的作品，同时也能支持一下。
> 当然，有钱捧个钱场（下方支付宝捐助），没钱捧个人场，谢谢各位。

<img src="https://raw.githubusercontent.com/xkmp/Test/master/Alipay-WinfXK.jpg" height="389" width="250" align="left"></img>
<img src="https://raw.githubusercontent.com/xkmp/Test/master/Alipay-FFF.jpg" height="389" width="250" align="left"></img>
