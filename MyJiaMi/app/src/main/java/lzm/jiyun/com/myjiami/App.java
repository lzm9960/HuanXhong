package lzm.jiyun.com.myjiami;

import android.app.Application;

import lzm.jiyun.com.myjiami.utitls.TokenUtil;


/******************************************
 * 类名称：App
 * 类描述：
 *
 * @version: 1.0
 * @author: chj
 * @time: 2018/1/2
 * @email: chj294671171@126.com
 * @github: https://github.com/cngmsy
 ******************************************/
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        TokenUtil.init(getApplicationContext());
        //必须调用初始化
//        OkHttpUtils.init(this);
        //以下都不是必须的，根据需要自行选择
                                              //设置全局公共参数


    }




}
