package lzm.jiyun.com.mysvg.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import lzm.jiyun.com.mysvg.tutli.Tutlis;

/**
 * Created by lenovo on 2018/1/7.
 */

public abstract class BaseActivity<P extends BasePresenter,M extends BaseModel> extends AppCompatActivity {

    public P mPresenter;
    public M mModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
//        Apps.activity=this;
        mPresenter = Tutlis.getT(this,0);
        mModel = Tutlis.getT(this,1);

        if (this instanceof BaseView ) {
            mPresenter.setVM(mModel,this);
        }
        initView();

    }

    protected abstract int getLayoutId();

    public abstract void initView() ;
}
