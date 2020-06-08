package com.example.project2;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

public class GalleryViewFragment extends Fragment {

    GridView simpleGridView;
    Context context = getActivity();

    int animals[] = {R.drawable.animal13, R.drawable.animal14, R.drawable.animal15,
            R.drawable.animal16, R.drawable.animal17, R.drawable.animal18,
            R.drawable.animal15, R.drawable.animal16, R.drawable.animal17};


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_gallery_view, container, false);

        // class
        simpleGridView = v.findViewById(R.id.gridView);
        CustomAdapter customAdapter = new CustomAdapter(context.getApplicationContext(), animals); // getApplicationContext()
        simpleGridView.setAdapter(customAdapter);

        return v;
    }


}