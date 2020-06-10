package com.example.project2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class fragment2 extends Fragment  {

    Button forward = null;
    Button reverse = null;
    CheckBox galleryCheckBox;
    CheckBox slideShowCheckBox;

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

       //Replace the blank view with the first image in the folder
        Toast toast = Toast.makeText(getActivity(), s+1+"/"+(animals.length), Toast.LENGTH_SHORT);
        toast.show();//Displays the current picture number over the total number
        mFrag1 = fragment1.newInstance(animals[s], "");
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment, mFrag1);
        transaction.addToBackStack(null);
        transaction.commit();

        forward =root.findViewById(R.id.fwdButton);
        reverse =root.findViewById(R.id.rvrsButton);

        //Forward button to move to the next image
        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(s!=animals.length-1) {//Button does nothing if we have reached the end of the image folder
                    s++;
                    Toast toast = Toast.makeText(getActivity(), s+1+"/"+(animals.length), Toast.LENGTH_SHORT);
                    toast.show();//Displays the current picture number over the total number
                    mFrag1 = fragment1.newInstance(animals[s],"");//Create a new fragment1 and pass the next image as an argument
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment, mFrag1);//Replace the fragment
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
            }
        });

        //Reverse button to move to the previous image
        reverse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(s!=0) {//Button does nothing if we are at the first image
                    s--;
                    Toast toast = Toast.makeText(getActivity(), s+1+"/"+(animals.length), Toast.LENGTH_SHORT);
                    toast.show();//Displays the current picture number over the total number
                    mFrag1 = fragment1.newInstance(animals[s], "");//Create a new fragment1 and pass the previous image as an argument
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment, mFrag1);//Replace the fragment
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
            }
        });

        // Gallery View with Checkbox
        galleryCheckBox = root.findViewById(R.id.checkBox);
        galleryCheckBox.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {   // onClick
                boolean isChecked = galleryCheckBox.isChecked();
                FragmentManager manager = getFragmentManager();

                    if (isChecked) {
                        GalleryViewFragment galleryFragment = new GalleryViewFragment();
                        Toast.makeText(getActivity(), "Gallery View", Toast.LENGTH_LONG).show();
                        manager.beginTransaction()
//                            .replace(R.id.main, galleryFragment, galleryFragment.getTag())    // Not working: should replace fragment1
                                .replace(R.id.fragment, galleryFragment)
                                .commit();
                        galleryCheckBox.setEnabled(true);
                    }
                    else {       // upon uncheck fragment1 should return -> so probably store it in a stack before replacing?
                        //fragment1 fragment = new fragment1();//Old
                        fragment1 fragment = fragment1.newInstance(animals[s], "");//New
                        Toast.makeText(getActivity(), "Exit Gallery", Toast.LENGTH_LONG).show();
                        manager.beginTransaction().replace(R.id.fragment, fragment).commit();
                        galleryCheckBox.setEnabled(true);
                    }
                }

        });

        // slideshow view with animation onClick checkbox
        slideShowCheckBox = root.findViewById(R.id.checkBox2);
        slideShowCheckBox.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                boolean isChecked = slideShowCheckBox.isChecked();
                FragmentManager manager = getFragmentManager();
                int x = 0;

                if (isChecked){
                    SlideShowFragment slideFragment = new SlideShowFragment();
                    Toast.makeText(getActivity(), "Slide Show Preview", Toast.LENGTH_LONG).show();
                    manager.beginTransaction().replace(R.id.fragment, slideFragment).commit();
                }
                else{
                    //fragment1 fragment = new fragment1();                        Old
                    fragment1 fragment = fragment1.newInstance(animals[s], "");//New

                    Toast.makeText(getActivity(), "End Slide Show", Toast.LENGTH_LONG).show();
                    manager.beginTransaction().replace(R.id.fragment, fragment).commit();
                }
            }
        });

        return root;
    }

}   // end fragment2

