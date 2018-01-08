package comhu.dreamtea.administrator.huanchongdemo.contract.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import comhu.dreamtea.administrator.huanchongdemo.app.App;
import comhu.dreamtea.administrator.huanchongdemo.utils.Utils;

/**
 * Created by Administrator on 2018/1/8.
 */

public abstract class BaseActivity<P extends BasePresenter, M extends BaseModel> extends AppCompatActivity {

    /*
      公开的Presenter Molde
     */
    public P presenter;
    public M model;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //  初始化App Context
        App.baseActivity = this;
        // 将P 和M 用工具类 通过反射的原理来实例化
        presenter = Utils.getT(this, 0);
        model = Utils.getT(this, 1);


        if (this instanceof  BaseView){
            presenter.setVM(model,this);
        }
        //   寻找布局
        setContentView(getLayoutId());
        // 初始化组件
        inteView();
        // 数据操作
        lodate();
    }

    protected abstract void lodate();

    protected abstract void inteView();

    protected abstract int getLayoutId();
}
