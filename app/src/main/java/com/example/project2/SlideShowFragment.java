package com.example.project2;

import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class SlideShowFragment extends Fragment {

    private ViewFlipper viewFlipper;

    int[] animals = {R.drawable.animal13, R.drawable.animal14, R.drawable.animal15,
            R.drawable.animal16, R.drawable.animal17, R.drawable.animal18,
            R.drawable.animal15, R.drawable.animal16, R.drawable.animal17 };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_slide_show, container, false);
        viewFlipper = view.findViewById(R.id.viewFlipper);

        for (int i = 0; i < animals.length; i++){
            viewFlipper.setAutoStart(true);
            viewFlipper.setFlipInterval(2000);      // 2 seconds transistion
            viewFlipper.startFlipping();
            ImageView image = new ImageView(view.getContext());
            image.setImageResource(animals[i]);
            viewFlipper.addView(image);
        }
        return view;
    }

}   // end class
