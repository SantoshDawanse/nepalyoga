package com.dawnsoft.dawn.nepalyoga.helper;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.dawnsoft.dawn.nepalyoga.R;

/**
 * Created by dawn on 3/26/2018.
 */

public class ExerciseViewPagerAdapter extends PagerAdapter {

    private Context context;
    private int images[];
    private LayoutInflater layoutInflater;

    public ExerciseViewPagerAdapter(Context context, int images[]) {
        this.context = context;
        this.images = images;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {

        return view == (LinearLayout)object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.frag_exercise_viewpager, null);

        ImageView imageView = (ImageView) view.findViewById(R.id.image_viewpager);

//        imageView.setImageResource(images[position]);
        Glide.with(context).load(images[position]).into(imageView);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }
}
