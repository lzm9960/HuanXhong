package comhu.dreamtea.administrator.huanchongdemo.contract;

import java.util.Map;

import comhu.dreamtea.administrator.huanchongdemo.contract.cal.Callbacks;

/**
 * Created by TMVPHelper on 2018/01/08
 */
public class Presenter extends Contract.Presenter {

    @Override
    public void setURL(String url, Map<String, Object> map, final String Type) {
        m.setString(url, map, new Callbacks() {
            @Override
            public void setCall(String call) {
                v.setShow(call, Type);
            }
        });
    }
}