package comhu.dreamtea.administrator.huanchongdemo.contract.model;

import android.widget.Toast;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import comhu.dreamtea.administrator.huanchongdemo.app.App;
import comhu.dreamtea.administrator.huanchongdemo.contract.net.Contract;
import comhu.dreamtea.administrator.huanchongdemo.contract.cal.Callbacks;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by TMVPHelper on 2018/01/08
 */
public class Model implements Contract.Model {
    private static Model m;
    //在这里开始请求数据
    private OkHttpClient okhttp;

    private Set<String> set;


    //调用这个方法来实例化OkHTTP

    public Model() {
        okhttp = new OkHttpClient();
    }

    public static Model getModel() {
        if (m == null) {
            synchronized (Model.class) {
                m = new Model();
            }
        }
        return m;
    }


    @Override
    public void setString(String string, Map<String, Object> map, final Callbacks callbacks) {
        StringBuffer stringBuffer = new StringBuffer(string);
        String nullString = "";
        if (map != null && map.size() > 0) {
            stringBuffer.append("?");
            set = map.keySet();
            for (String ring :
                    set) {
                Object o = map.get(ring);
                stringBuffer
                        .append(ring)
                        .append("=")
                        .append(o)
                        .append("&");
            }
            nullString = stringBuffer.deleteCharAt(stringBuffer.length() - 1).toString();
        }
        Request request = new Request.Builder()
                .url(string)
                .build();
        okhttp.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(App.baseActivity, "请求失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(final Call call, final Response response) throws IOException {
                   App.baseActivity.runOnUiThread(new Runnable() {
                       @Override
                       public void run() {
                           try {
                               callbacks.setCall(response.body().string());
                           } catch (IOException e) {
                               e.printStackTrace();
                           }
                       }
                   });
            }
        });


    }
}