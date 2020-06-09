package com.example.project2;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import java.sql.Time;
import java.util.Timer;

public class fragment2 extends Fragment  {

    private String mParam1;
    private String mParam2;
    private Context context;

    Button fwd = null;
    Button rvrs = null;
    CheckBox checkBox;
    CheckBox checkBox2;

    int[] animals = {R.drawable.animal13, R.drawable.animal14, R.drawable.animal15,
            R.drawable.animal16, R.drawable.animal17, R.drawable.animal18,
            R.drawable.animal15, R.drawable.animal16, R.drawable.animal17 };

    //TIGER->LION->EAGLE->DOG->BIRD->SNAKE
    private  fragment1 mFrag1;
    int s = 0;

    // Empty public constructor
    public fragment2() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_fragment2,
                container, false);

        fwd = root.findViewById(R.id.fwdButton);
        rvrs=root.findViewById(R.id.rvrsButton);

        // move to Next picture
        fwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(s!=animals.length-1) {
                    s++;
                    Toast toast = Toast.makeText(getActivity(), "Next", Toast.LENGTH_LONG);
                    toast.show();
                    mFrag1 = fragment1.newInstance(animals[s], "Ha");
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment, mFrag1);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
            }
        });

        // move to previous picture button
        rvrs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(s!=0) {
                    s--;
                    Toast toast = Toast.makeText(getActivity(), "Reverse", Toast.LENGTH_LONG);
                    toast.show();
                    mFrag1 = fragment1.newInstance(animals[s], "Ha");
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment, mFrag1);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
            }
        });

        // Gallery View with Checkbox
        checkBox = root.findViewById(R.id.checkBox);
        checkBox.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {   // onClick
                boolean isChecked = checkBox.isChecked();
                FragmentManager manager = getFragmentManager();

                    if (isChecked) {
                        GalleryViewFragment galleryFragment = new GalleryViewFragment();
                        Toast.makeText(getActivity(), "Gallery View", Toast.LENGTH_LONG).show();
                        manager.beginTransaction()
//                            .replace(R.id.main, galleryFragment, galleryFragment.getTag())    // Not working: should replace fragment1
                                .replace(R.id.fragment, galleryFragment)
                                .commit();
                        checkBox.setEnabled(true);
                    }
                    else {       // upon uncheck fragment1 should return -> so probably store it in a stack before replacing?
                        fragment1 fragment = new fragment1();
                        Toast.makeText(getActivity(), "Exit Gallery", Toast.LENGTH_LONG).show();
                        manager.beginTransaction().replace(R.id.fragment, fragment).commit();
                        checkBox.setEnabled(true);
                    }
                }

        });

        // slideshow view with animation onClick checkbox
        checkBox2 = root.findViewById(R.id.checkBox2);
        checkBox2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                boolean isChecked = checkBox2.isChecked();
                FragmentManager manager = getFragmentManager();
                int x = 0;

                if (isChecked){
                    SlideShowFragment slideFragment = new SlideShowFragment();
                    Toast.makeText(getActivity(), "Slide Show Preview", Toast.LENGTH_LONG).show();
                    manager.beginTransaction().replace(R.id.fragment, slideFragment).commit();
                }
                else{
                    fragment1 fragment = new fragment1();
                    Toast.makeText(getActivity(), "End Slide Show", Toast.LENGTH_LONG).show();
                    manager.beginTransaction().replace(R.id.fragment, fragment).commit();
                }
            }
        });

        return root;
    }

}   // end fragment2

