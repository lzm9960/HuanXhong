package comhu.dreamtea.administrator.huanchongdemo.contract.ui;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Toast;

import com.eftimoff.androipathview.PathView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import comhu.dreamtea.administrator.huanchongdemo.R;

public class MainActivity extends AppCompatActivity {


    @InjectView(R.id.pathView)
    PathView pathView;
    private String FILE = "FILE_SHEAR";
    private SharedPreferences preferences;
    private int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        initView();
        initData();
    }

    private void initView() {
        preferences = getSharedPreferences(FILE, MODE_WORLD_READABLE);
    }

    private void initData() {
        count = preferences.getInt("count", 0);
        pathView.getPathAnimator()
                .delay(1000)
                .duration(5000)
                .listenerEnd(new PathView.AnimatorBuilder.ListenerEnd() {
                    @Override
                    public void onAnimationEnd() {
                        Toast.makeText(MainActivity.this,"应用被打开了："+count+"次",Toast.LENGTH_LONG).show();
                        if (count == 0) {
                            SharedPreferences.Editor edit = preferences.edit();
                            edit.putString("XTSJ","系统数据");
                            edit.commit();
                            SharedPreferences.Editor editor = preferences.edit();
                            editor.putInt("count", ++count);
                            editor.commit();
                            Log.e("TAG", "走");
                            startActivity(new Intent(MainActivity.this, LunBoActivity.class));
                            finish();
                        } else {
                            Log.e("TAG", "走着");
                            startActivity(new Intent(MainActivity.this, HomeActivity.class));
                            finish();
                        }

                    }
                })
                .interpolator(new AccelerateDecelerateInterpolator())
                .start();
    }
}

