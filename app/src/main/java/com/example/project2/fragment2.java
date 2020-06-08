package com.example.project2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

public class fragment2 extends Fragment {


    Button button1;
    Button btnGalleryView;

    public fragment2() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_fragment2, container, false);

        // action listener with button
        btnGalleryView = view.findViewById(R.id.btnGalleryView);
        btnGalleryView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GalleryViewFragment galleryFragment = new GalleryViewFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction()
                        .replace(R.id.main, galleryFragment, galleryFragment.getTag())
                        .commit();
            }
        });

        return view;
    }


    // same function for both checkboxes (gallery & slideshow)??
    public void onCheckboxClicked(View view){
        // is view checked?
        boolean checked = ((CheckBox) view).isChecked();
        // Check if the box was checked or not?
        switch (view.getId()){
            case R.id.checkBox: // this is gallery checkbox id
                if (checked){   // open a new fragment with grid layout
                    // coding
                }
                else{
                    //coding
                    break;
                }
        }
    }   // end on-click check box



}   // end fragment2