package lzm.jiyun.com.mysvg;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jude.rollviewpager.RollPagerView;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class Main3Activity extends AppCompatActivity {

    @InjectView(R.id.rollview)
    RollPagerView rollview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ButterKnife.inject(this);
        initData();
    }

    private void initData() {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(R.mipmap.pager01);
        integers.add(R.mipmap.pager02);
        integers.add(R.mipmap.pager03);
        RollAdapter rollAdapter = new RollAdapter(integers, Main3Activity.this);
        rollview.setAdapter(rollAdapter);
    }
}
