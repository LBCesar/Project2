package com.example.project2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment2 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    Button button1;
//    Button btnGalleryView;
    CheckBox checkBox;

    public fragment2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment2.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment2 newInstance(String param1, String param2) {
        fragment2 fragment = new fragment2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view =  inflater.inflate(R.layout.fragment_fragment2, container, false);

//         action listener with button
//        btnGalleryView = view.findViewById(R.id.btnGalleryView);
//        btnGalleryView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                GalleryViewFragment galleryFragment = new GalleryViewFragment();
//                FragmentManager manager = getFragmentManager();
//                manager.beginTransaction()
//                        .replace(R.id.main, galleryFragment, galleryFragment.getTag())
//                        .commit();
//            }
//        });

        //checkbox gallery

        checkBox = view.findViewById(R.id.checkBox);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isChecked = checkBox.isChecked();

                if (isChecked){
                    GalleryViewFragment galleryFragment = new GalleryViewFragment();
                    FragmentManager manager = getFragmentManager();
                    manager.beginTransaction()
                            .replace(R.id.main, galleryFragment, galleryFragment.getTag())
                            .commit();
                    checkBox.setEnabled(true);
                }
                else{
                    checkBox.setChecked(false); // do same for above or it will not be enabled?
                }


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