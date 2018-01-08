package lzm.jiyun.com.mysvg.net;

import lzm.jiyun.com.mysvg.base.BaseModel;
import lzm.jiyun.com.mysvg.base.BasePresenter;
import lzm.jiyun.com.mysvg.base.BaseView;

/**
 * Created by lenovo on 2018/1/7.
 */

public interface NetContract {

    interface View extends BaseView {
      
    }

    interface Model extends BaseModel {
        
    }

    abstract static class Presenter extends BasePresenter<Model, View> {
    }
}