package comhu.dreamtea.administrator.huanchongdemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.jude.rollviewpager.adapter.StaticPagerAdapter;

import java.util.ArrayList;

import comhu.dreamtea.administrator.huanchongdemo.R;
import comhu.dreamtea.administrator.huanchongdemo.contract.ui.HomeActivity;

/**
 * Created by lenovo on 2018/1/5.
 */

public class RollAdapter extends StaticPagerAdapter {
    private ArrayList<Integer> list;
    private Context content;

    public RollAdapter(ArrayList<Integer> list, Context content) {
        this.list = list;
        this.content = content;
    }

    @Override
    public View getView(ViewGroup container, int position) {
        View inflate = LayoutInflater.from(content).inflate(R.layout.roll_item, null);
        ImageView imageitem=(ImageView)inflate.findViewById(R.id.image_item);
        Button but=(Button) inflate.findViewById(R.id.but);
        imageitem.setImageResource(list.get(position));
        if (position==list.size()-1){
            but.setVisibility(View.VISIBLE);
        }
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                content.startActivity(new Intent(content,HomeActivity.class));
            }
        });
        return inflate;
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
