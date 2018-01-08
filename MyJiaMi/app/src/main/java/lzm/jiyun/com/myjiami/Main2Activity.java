package lzm.jiyun.com.myjiami;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import lzm.jiyun.com.myjiami.entity.LoginUser;
import lzm.jiyun.com.myjiami.utitls.IPUtils;
import lzm.jiyun.com.myjiami.utitls.Md5Utils;
import lzm.jiyun.com.myjiami.utitls.SignUtil;
import lzm.jiyun.com.myjiami.utitls.TokenUtil;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 *  fastjson用法:
 *  http://blog.csdn.net/jilongliang/article/details/42870951
 */
public class Main2Activity extends AppCompatActivity {

    //拼接url字符串
    String url=AppUtils.REQUESTURL+"/user/register.jhtml";
    private String userPhone;
    private String userName;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         // 注册
     //   getRegister("18837956500","123458","18837956500");


        //登录
        getLogin("15639238023","123456");
    }

    /**
     * 这个是所有对象的post请求方式,按照这个可以完成网络请求
     * @param phone   用户电话号码
     * @param psw     用户密码
     */
    private void getLogin(String phone, String psw) {
        //1、获取bean对象的相应参数
        String password= Md5Utils.md5(psw, "UTF-8");
        String ip = IPUtils.getIp(Main2Activity.this);
        String token = TokenUtil.createToken();
        Map<String,Object> map1=new HashMap<>() ;
        map1.put("userPhone",phone);
        map1.put("password",password);
        String signString= SignUtil.getSign(map1);

        //2、创建bean对象
        LoginUser loginUser =new LoginUser();

        //3、创建bean对象的body体
        LoginUser.BodyBean bodyBean=new LoginUser.BodyBean();
        bodyBean.setUserPhone(phone);
        bodyBean.setPassword(password);


        //4、将参数添加到bean对象的请求头中
        LoginUser.HeaderBean headerBean=new   LoginUser.HeaderBean();
        headerBean.setChannel("android");
        headerBean.setIp(ip);
        headerBean.setSign(signString);
        headerBean.setToken(token);


        //5、填充请求头和请求体到请求中
        loginUser.setBody(bodyBean);
        loginUser.setHeader(headerBean);


        //6、使用JSON.toJSONString(obj)方式来实现Bean对象转化为json字符串,并打印输出
        String loginString= JSON.toJSONString(loginUser);
        System.out.println("转化后的json字符串为=="+loginString);

        //7、使用okhttp发送请求
        OkHttpClient okHttpClient=new OkHttpClient();
        FormBody.Builder bodyBuilder = new FormBody.Builder();

        bodyBuilder.add("data",loginString);
        Request.Builder requestBuilder= new Request.Builder();

        Request request= requestBuilder.url(url).post(bodyBuilder.build()).build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(okhttp3.Call call, IOException e) {

            }

            @Override
            public void onResponse(okhttp3.Call call, Response response) throws IOException {
                final String data = response.body().string();
                Log.e( "onResponse: ",data );
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(Main2Activity.this, data, Toast.LENGTH_SHORT).show();
                    }
                });
            }
//
//            @Override
//            public void onFailure(Call call, IOException e) {
//                String message = e.getMessage();
//                //  Toast.makeText(Main2Activity.this, message, Toast.LENGTH_SHORT).show();
//            }

//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                final String data = response.body().string();
//                Log.e( "onResponse: ",data );
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        Toast.makeText(Main2Activity.this, data, Toast.LENGTH_SHORT).show();
//                    }
//                });
//
//            }
        });



    }

    private void getRegister(String phone, String psw, String name) {
//
//        String password= Md5Utils.md5(psw, "UTF-8");
//        String ip = IPUtils.getIp(Main2Activity.this);
//        String token = TokenUtil.createToken();
//        Map<String,Object> map=new HashMap<>() ;
//        map.put("userPhone",phone);
//        map.put("userName",name);
//        map.put("password",password);
//        String signString= SignUtil.getSign(map);
//
//
//        RegisterUser reginUser =new RegisterUser();
//
//        RegisterUser.BodyBean bodyBean=new RegisterUser.BodyBean();
//        bodyBean.setUserPhone(phone);
//        bodyBean.setPassword(password);
//        bodyBean.setUserName(name);
//
//
//        RegisterUser.HeaderBean headerBean=new   RegisterUser.HeaderBean();
//        headerBean.setChannel("android");
//        headerBean.setIp(ip);
//        headerBean.setSign(signString);
//        headerBean.setToken(token);
//
//
//
//
//        reginUser.setHeader(headerBean);
//        reginUser.setBody(bodyBean);
//
//
//        //使用JSON.toJSONString(obj)方式来实现javaBean到json
//        String reginString=JSON.toJSONString(reginUser);
//        System.out.println("转化后的json字符串为=="+reginString);
//
//        OkHttpClient okHttpClient=new OkHttpClient();
//        FormBody.Builder bodyBuilder = new FormBody.Builder();
//
//
//        bodyBuilder.add("data",reginString);
//
//        Request.Builder requestBuilder= new Request.Builder();
//        Request request= requestBuilder.url(url).post(bodyBuilder.build()).build();
//
//
//        okHttpClient.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                String message = e.getMessage();
//                //  Toast.makeText(Main2Activity.this, message, Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                final String data = response.body().string();
//                Log.e( "onResponse: ",data );
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        Toast.makeText(Main2Activity.this, data, Toast.LENGTH_SHORT).show();
//                    }
//                });
//
//            }
//        });
//


    }


}
