package com.dawnsoft.dawn.nepalyoga.helper;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dawnsoft.dawn.nepalyoga.R;

import java.util.List;

/**
 * Created by dawn on 3/28/2018.
 */

public class YogaDescAdapter extends ArrayAdapter<YogaDescription>{
    public YogaDescAdapter(@NonNull Context context, @NonNull List<YogaDescription> objects) {
        super(context,0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;
        if (view == null){
            view = LayoutInflater.from(getContext()).inflate(R.layout.yoga_card_description, parent, false);
        }

        YogaDescription yogaDescription = getItem(position);
        ImageView imageView = (ImageView)view.findViewById(R.id.ycd_thumbnail);
        assert yogaDescription != null;
        imageView.setImageResource(yogaDescription.getImage());

        TextView sanskritName = (TextView)view.findViewById(R.id.ycd_sn);
        sanskritName.setText(yogaDescription.getSanskritName());

        TextView englishName = (TextView)view.findViewById(R.id.ycd_en);
        englishName.setText(yogaDescription.getEnglishName());

        TextView overviewDesc = (TextView)view.findViewById(R.id.ycd_overview_desc);
        overviewDesc.setText(yogaDescription.getOverviewDesc());

        TextView moveIntoAsana = (TextView)view.findViewById(R.id.ycd_moveintoasana);
        moveIntoAsana.setText(yogaDescription.getMoveIntoAsana());

        TextView pictureStep = (TextView)view.findViewById(R.id.ycd_picturestep);
        pictureStep.setText(yogaDescription.getPictureStep());

        TextView benefits = (TextView)view.findViewById(R.id.ycd_benefits);
        benefits.setText(yogaDescription.getBenefit());

        TextView precautions = (TextView)view.findViewById(R.id.ycd_precautions);
        precautions.setText(yogaDescription.getPrecaution());

        return view;
    }


}
