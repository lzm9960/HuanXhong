package comhu.dreamtea.administrator.huanchongdemo.contract.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import comhu.dreamtea.administrator.huanchongdemo.R;
import comhu.dreamtea.administrator.huanchongdemo.app.AppUtils;
import comhu.dreamtea.administrator.huanchongdemo.contract.base.BaseActivity;
import comhu.dreamtea.administrator.huanchongdemo.contract.model.Model;
import comhu.dreamtea.administrator.huanchongdemo.contract.net.Contract;
import comhu.dreamtea.administrator.huanchongdemo.contract.net.Presenter;
import comhu.dreamtea.administrator.huanchongdemo.entity.LoginUser;
import comhu.dreamtea.administrator.huanchongdemo.utils.IPUtils;
import comhu.dreamtea.administrator.huanchongdemo.utils.Md5Utils;
import comhu.dreamtea.administrator.huanchongdemo.utils.SignUtil;
import comhu.dreamtea.administrator.huanchongdemo.utils.TokenUtil;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Denglu extends BaseActivity<Presenter, Model> implements Contract.View {
    @InjectView(R.id.loging_back)
    ImageView logingBack;
    @InjectView(R.id.loging_regist)
    TextView logingRegist;
    @InjectView(R.id.textView)
    TextView textView;
    @InjectView(R.id.loging_phone)
    EditText logingPhone;
    @InjectView(R.id.loging_psw)
    EditText logingPsw;
    @InjectView(R.id.loging_forget)
    TextView logingForget;
    @InjectView(R.id.btn_loging)
    ImageView btnLoging;
    @InjectView(R.id.loging_weixin)
    ImageView logingWeixin;
    @InjectView(R.id.linearLayout3)
    LinearLayout linearLayout3;
    @InjectView(R.id.loging_qq)
    ImageView logingQq;
    @InjectView(R.id.linearLayout2)
    LinearLayout linearLayout2;
    private Button button;
    private EditText editText, editText2;
    private boolean inClick = true;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor edit;
    String url = AppUtils.REQUESTURL + "/user/register.jhtml";

    @Override
    public void setShow(String show, String type) {

    }

    @Override
    protected void lodate() {

//        sharedPreferences = getSharedPreferences("user", MODE_PRIVATE);
//        String nameV = sharedPreferences.getString("name", "");
//        String passV = sharedPreferences.getString("pass", "");
//        logingPhone.setText(nameV);
//        logingPsw.setText(passV);

    }
    protected void onResume() {
        super.onResume();
        sharedPreferences = getSharedPreferences("users", MODE_PRIVATE);
        logingPhone.setText(sharedPreferences.getString("name", ""));
        if (inClick) {
            logingPsw.setText(sharedPreferences.getString("pass", ""));
        }

    }
    @Override
    protected void inteView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.denglu;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.inject(this);
    }

    @OnClick({R.id.loging_back, R.id.loging_regist, R.id.textView, R.id.loging_phone, R.id.loging_psw, R.id.loging_forget, R.id.btn_loging, R.id.loging_weixin, R.id.linearLayout3, R.id.loging_qq, R.id.linearLayout2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.loging_back:
                finish();
                break;
            case R.id.loging_regist:
                startActivity(new Intent(Denglu.this, RegisterActivity.class));
                break;
            case R.id.textView:
                break;
            case R.id.loging_phone:
                break;
            case R.id.loging_psw:
                break;
            case R.id.loging_forget:
                break;
            case R.id.btn_loging:
                String name = logingPhone.getText().toString();
                String pass = logingPsw.getText().toString();
                if (name.equals("") || pass.equals("")) {
                    Toast.makeText(this, "输入有误，请重新输入", Toast.LENGTH_SHORT).show();

                } else {
                    edit = sharedPreferences.edit();
                    edit.putString("name", name);
                    edit.putString("pass", pass);
                    edit.commit();
                    getLogin(name, pass);
                }
                break;
            case R.id.loging_weixin:
                break;
            case R.id.linearLayout3:
                break;
            case R.id.loging_qq:
                break;
            case R.id.linearLayout2:
                break;
        }
    }
    /**
     * 这个是所有对象的post请求方式,按照这个可以完成网络请求
     *
     * @param phone 用户电话号码
     * @param psw   用户密码
     */
    private void getLogin(String phone, String psw) {
        //获取bean对象的相应参数
        String password = Md5Utils.md5(psw, "UTF-8");
        String ip = IPUtils.getIp(Denglu.this);
        String token = TokenUtil.createToken();
        Map<String, Object> map1 = new HashMap<>();
        map1.put("userPhone", phone);
        map1.put("password", password);
        String signString = SignUtil.getSign(map1);

        //创建bean对象
        LoginUser loginUser = new LoginUser();

        //创建bean对象的body体
        LoginUser.BodyBean bodyBean = new LoginUser.BodyBean();
        bodyBean.setUserPhone(phone);
        bodyBean.setPassword(password);


        //将参数添加到bean对象的请求头中
        LoginUser.HeaderBean headerBean = new LoginUser.HeaderBean();
        headerBean.setChannel("android");
        headerBean.setIp(ip);
        headerBean.setSign(signString);
        headerBean.setToken(token);


        //填充请求头和请求体到请求中
        loginUser.setBody(bodyBean);
        loginUser.setHeader(headerBean);


        //使用JSON.toJSONString(obj)方式来实现Bean对象转化为json字符串,并打印输出
        String loginString = JSON.toJSONString(loginUser);
        System.out.println("转化后的json字符串为==" + loginString);

        //使用okhttp发送请求
        OkHttpClient okHttpClient = new OkHttpClient();
        FormBody.Builder bodyBuilder = new FormBody.Builder();

        bodyBuilder.add("data", loginString);
        Request.Builder requestBuilder = new Request.Builder();

        Request request = requestBuilder.url(url).post(bodyBuilder.build()).build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String data = response.body().string();
                Log.e("onResponse: ", data);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //  startActivity(new Intent(MainActivity.this, XiangActivity.class));
                    }
                });

            }
        });
    }
}
