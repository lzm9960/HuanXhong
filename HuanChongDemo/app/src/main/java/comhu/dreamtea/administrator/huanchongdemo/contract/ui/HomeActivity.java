package comhu.dreamtea.administrator.huanchongdemo.contract.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import comhu.dreamtea.administrator.huanchongdemo.R;
import comhu.dreamtea.administrator.huanchongdemo.contract.base.BaseActivity;
import comhu.dreamtea.administrator.huanchongdemo.contract.model.Model;
import comhu.dreamtea.administrator.huanchongdemo.contract.net.Contract;
import comhu.dreamtea.administrator.huanchongdemo.contract.net.Presenter;

public class HomeActivity extends BaseActivity<Presenter, Model> implements Contract.View {
    @InjectView(R.id.home_my)
    ImageView homeMy;
    @InjectView(R.id.home_edtext)
    EditText homeEdtext;
    @InjectView(R.id.home_but)
    Button homeBut;
    @InjectView(R.id.home_dit)
    ImageView homeDit;
    @InjectView(R.id.near_first_name)
    Button nearFirstName;
    @InjectView(R.id.near_first_view)
    ImageView nearFirstView;
    @InjectView(R.id.near_first)
    LinearLayout nearFirst;
    @InjectView(R.id.petclaz_name)
    Button petclazName;
    @InjectView(R.id.petclaz_view)
    ImageView petclazView;
    @InjectView(R.id.petcalz)
    LinearLayout petcalz;
    @InjectView(R.id.filtrate_name)
    Button filtrateName;
    @InjectView(R.id.filtrate_view)
    ImageView filtrateView;
    @InjectView(R.id.filtrate)
    LinearLayout filtrate;
    @InjectView(R.id.img_touxiang)
    ImageView imgTouxiang;
    @InjectView(R.id.message_lin)
    LinearLayout messageLin;
    @InjectView(R.id.pet_lin)
    LinearLayout petLin;
    @InjectView(R.id.oeder_lin)
    LinearLayout oederLin;
    @InjectView(R.id.wallet_lin)
    LinearLayout walletLin;
    @InjectView(R.id.know_lin)
    LinearLayout knowLin;
    @InjectView(R.id.setting_lin)
    LinearLayout settingLin;
    @InjectView(R.id.nav)
    NavigationView nav;
    private boolean isQuit = false;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.inject(this);
    }

    @OnClick(R.id.img_touxiang)
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.img_touxiang:

                startActivity(new Intent(HomeActivity.this, Denglu.class));
                break;
        }


    }
}
