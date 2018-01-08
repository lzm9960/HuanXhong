package comhu.dreamtea.administrator.huanchongdemo.contract.ui;

import android.widget.Toast;

import comhu.dreamtea.administrator.huanchongdemo.R;
import comhu.dreamtea.administrator.huanchongdemo.contract.base.BaseActivity;
import comhu.dreamtea.administrator.huanchongdemo.contract.model.Model;
import comhu.dreamtea.administrator.huanchongdemo.contract.net.Contract;
import comhu.dreamtea.administrator.huanchongdemo.contract.net.Presenter;

public class HomeActivity extends BaseActivity<Presenter,Model> implements Contract.View{
    private boolean isQuit=false;
    @Override
    protected void lodate() {

    }

    @Override
    protected void inteView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    public void setShow(String show, String type) {

    }
    @Override
    public void onBackPressed() {
        if (!isQuit) {
            Toast.makeText(HomeActivity.this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            isQuit = true;

            //这段代码意思是,在两秒钟之后isQuit会变成false
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        isQuit = false;
                    }
                }
            }).start();

        } else {
            System.exit(0);
        }
    }
}
