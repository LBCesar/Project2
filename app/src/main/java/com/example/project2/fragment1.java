package com.example.project2;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;


public class fragment1 extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private int mParam1;
    private String mParam2;

    private int imgNum;
    ImageView animalPic;

    // Constructor
    public fragment1(){

    }

    //One parameter has changed to int, so we can take in the R.ID of the images.
    public static fragment1 newInstance(int param1, String param2) {
        fragment1 fragment = new fragment1();
        Bundle args = new Bundle();

        //New-Takes in an Int instead of a string.
        args.putInt(ARG_PARAM1,param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getInt(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup root=(ViewGroup)inflater.inflate(R.layout.fragment_fragment1,container,false);

        if(getArguments()!=null) {
            animalPic = root.findViewById(R.id.animalIMG);
            animalPic.setImageResource(mParam1);
        }

        return root;
    }


} // end class