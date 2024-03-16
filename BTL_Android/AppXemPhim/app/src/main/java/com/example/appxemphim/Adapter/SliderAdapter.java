package com.example.appxemphim.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.appxemphim.Domain.Slider;
import com.example.appxemphim.R;

import java.util.List;

public class SliderAdapter extends PagerAdapter {
    private Context context;
    private List<Slider> item;

    public SliderAdapter(Context context, List<Slider> item) {
        this.context = context;
        this.item = item;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.slider_item, null);

        ImageView image = view.findViewById(R.id.ivSlider);
        TextView tieuDe = view.findViewById(R.id.tvTieuDe);
        image.setImageResource(item.get(position).getImage());
        tieuDe.setText(item.get(position).getTieude());

        container.addView(view);

        return view;
    }

    @Override
    public int getCount() {
        return item.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
