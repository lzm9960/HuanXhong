package comhu.dreamtea.administrator.huanchongdemo.contract.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.jude.rollviewpager.RollPagerView;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import comhu.dreamtea.administrator.huanchongdemo.R;
import comhu.dreamtea.administrator.huanchongdemo.adapter.RollAdapter;

public class LunBoActivity extends AppCompatActivity {

    @InjectView(R.id.rollview)
    RollPagerView rollview;
    @InjectView(R.id.eee)
    TextView eee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lun_bo);
        ButterKnife.inject(this);
        initData();
    }

    private void initData() {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(R.mipmap.pager01);
        integers.add(R.mipmap.pager02);
        integers.add(R.mipmap.pager03);
        RollAdapter rollAdapter = new RollAdapter(integers, LunBoActivity.this);
        rollview.setAdapter(rollAdapter);
//        finish();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        finish();
    }
}
