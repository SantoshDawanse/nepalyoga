package com.dawnsoft.dawn.nepalyoga;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.dawnsoft.dawn.nepalyoga.helper.YogaDescAdapter;
import com.dawnsoft.dawn.nepalyoga.helper.YogaDescription;

import java.util.ArrayList;
import java.util.List;

public class YogaDescriptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yoga_card_description);

        final ArrayList<YogaDescription> yogaDescriptionArrayList = new ArrayList<>();
        yogaDescriptionArrayList.add(new YogaDescription(R.drawable.image_butterfly, "Naukasan", "Boat Pose",
                "@string/ycd_overview_desc", "@string/ycd_moveintoasana", "@string/ycd_picturestep",
                "@string/ycd_benefits", "@string/ycd_precautions"));
        yogaDescriptionArrayList.add(new YogaDescription(R.drawable.image_double_pigeon, "", "",
                "", "", "", "", ""));
        yogaDescriptionArrayList.add(new YogaDescription(R.drawable.image_extended_wide_squat, "", "",
                "", "", "", "", ""));
        yogaDescriptionArrayList.add(new YogaDescription(R.drawable.image_head_knee, "", "",
                "", "", "", "", ""));
        yogaDescriptionArrayList.add(new YogaDescription(R.drawable.image_open_lizard, "", "",
                "", "", "", "", ""));
        yogaDescriptionArrayList.add(new YogaDescription(R.drawable.image_pigeon, "", "",
                "", "", "", "", ""));
        yogaDescriptionArrayList.add(new YogaDescription(R.drawable.image_wide_legged_split, "", "",
                "", "", "", "", ""));



        new YogaDescAdapter(this, yogaDescriptionArrayList);
        int position = getIntent().getIntExtra("position", 0);
        Toast.makeText(getApplicationContext(), "Item " + position + " is clicked.", Toast.LENGTH_SHORT).show();



    }
}
