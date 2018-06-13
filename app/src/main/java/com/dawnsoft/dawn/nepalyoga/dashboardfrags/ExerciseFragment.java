package com.dawnsoft.dawn.nepalyoga.dashboardfrags;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.dawnsoft.dawn.nepalyoga.R;
import com.dawnsoft.dawn.nepalyoga.YogaDescriptionActivity;
import com.dawnsoft.dawn.nepalyoga.helper.ExerciseViewPagerAdapter;
import com.dawnsoft.dawn.nepalyoga.helper.Yoga;
import com.dawnsoft.dawn.nepalyoga.helper.YogaAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExerciseFragment extends Fragment {

    ViewPager viewPager;
    private int[] images = new int[]{R.drawable.image_butterfly, R.drawable.image_double_pigeon,
            R.drawable.image_extended_wide_squat, R.drawable.image_head_knee, R.drawable.image_open_lizard,
            R.drawable.image_pigeon, R.drawable.image_wide_legged_split};


    public ExerciseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_exercise, container, false);

        //adding the data in array
        final ArrayList<Yoga> yogas = new ArrayList<>();
        yogas.add(new Yoga(R.drawable.album1, "Yoga 1", 12, "Beginner", 10));
        yogas.add(new Yoga(R.drawable.album2, "Yoga 1", 12, "Beginner", 10));
        yogas.add(new Yoga(R.drawable.album3, "Yoga 1", 12, "Beginner", 10));
        yogas.add(new Yoga(R.drawable.album4, "Yoga 1", 12, "Beginner", 10));
        yogas.add(new Yoga(R.drawable.album5, "Yoga 1", 12, "Beginner", 10));
        yogas.add(new Yoga(R.drawable.album6, "Yoga 1", 12, "Beginner", 10));
        yogas.add(new Yoga(R.drawable.album7, "Yoga 1", 12, "Beginner", 10));
        yogas.add(new Yoga(R.drawable.album8, "Yoga 1", 12, "Beginner", 10));
        yogas.add(new Yoga(R.drawable.album9, "Yoga 1", 12, "Beginner", 10));
        yogas.add(new Yoga(R.drawable.album10, "Yoga 1", 12, "Beginner", 10));
        yogas.add(new Yoga(R.drawable.album11, "Yoga 1", 12, "Beginner", 10));

        //viewpager initialization
        viewPager = (ViewPager) rootView.findViewById(R.id.viewpager_exercise_frag);

        //adapter initialization for header view
        ExerciseViewPagerAdapter exerciseViewPagerAdapter = new ExerciseViewPagerAdapter(getActivity(), images);
        viewPager.setAdapter(exerciseViewPagerAdapter);

        //tablayout initialization
        TabLayout tabLayout = (TabLayout)rootView.findViewById(R.id.tablayout_exercise_frag);
        tabLayout.setupWithViewPager(viewPager);

        //recycler view initialization
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        recyclerView.hasFixedSize();
        YogaAdapter yogaAdapter = new YogaAdapter(getContext(), yogas);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(yogaAdapter);
        recyclerView.setNestedScrollingEnabled(false);

        //recycler view on item click listener
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(getActivity(), "Single Click on position:"+ position, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), YogaDescriptionActivity.class);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        }));

        return rootView;
    }


    //creating interface for clicking items in recycler view
    public interface ClickListener{
        public void onClick(View view, int position);
    }

     class RecyclerTouchListener implements RecyclerView.OnItemTouchListener{

        private ClickListener clickListener;
        private GestureDetector gestureDetector;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {

                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }


                @Override
                public void onLongPress(MotionEvent e) {

                }

            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

            View child=rv.findChildViewUnder(e.getX(),e.getY());
            if(child!=null && clickListener!=null && gestureDetector.onTouchEvent(e)){
                clickListener.onClick(child,rv.getChildAdapterPosition(child));
            }

            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {

        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }
}
