package comhu.dreamtea.administrator.huanchongdemo.app;

import android.app.Application;

import com.lzy.okhttputils.OkHttpUtils;

import comhu.dreamtea.administrator.huanchongdemo.contract.base.BaseActivity;
import comhu.dreamtea.administrator.huanchongdemo.utils.TokenUtil;

/**
 * Created by Administrator on 2018/1/8.
 */

public class App extends Application {
     public  static BaseActivity baseActivity;
    @Override
    public void onCreate() {
        super.onCreate();
        TokenUtil.init(getApplicationContext());
        //必须调用初始化
        OkHttpUtils.init(this);
        //以下都不是必须的，根据需要自行选择
        //设置全局公共参数


    }
}
