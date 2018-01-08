package comhu.dreamtea.administrator.huanchongdemo.contract.net;

import java.util.Map;

import comhu.dreamtea.administrator.huanchongdemo.contract.base.BaseModel;
import comhu.dreamtea.administrator.huanchongdemo.contract.base.BasePresenter;
import comhu.dreamtea.administrator.huanchongdemo.contract.base.BaseView;
import comhu.dreamtea.administrator.huanchongdemo.contract.cal.Callbacks;

/**
 * Created by Administrator on 2018/1/8.
 */

public interface Contract {

    public interface View extends BaseView {
        void setShow(String show, String type);
    }

    public interface Model extends BaseModel {
        void setString(String string, Map<String, Object> map, Callbacks callbacks);
    }


    public abstract static class Presenter extends BasePresenter<Model, View> {

        public abstract void setURL(String url, Map<String, Object> map, String Type);

    }
}