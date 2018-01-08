package comhu.dreamtea.administrator.huanchongdemo.contract.ui;

import comhu.dreamtea.administrator.huanchongdemo.R;
import comhu.dreamtea.administrator.huanchongdemo.contract.Contract;
import comhu.dreamtea.administrator.huanchongdemo.contract.Presenter;
import comhu.dreamtea.administrator.huanchongdemo.contract.base.BaseActivity;
import comhu.dreamtea.administrator.huanchongdemo.contract.model.Model;

public class MainActivity extends BaseActivity<Presenter,Model> implements Contract.View{


    @Override
    protected void lodate() {

    }

    @Override
    protected void inteView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }


      /*
       网络请求  tyoe 进行 多次传值判断
       */
    @Override
    public void setShow(String show, String type) {

    }
}

