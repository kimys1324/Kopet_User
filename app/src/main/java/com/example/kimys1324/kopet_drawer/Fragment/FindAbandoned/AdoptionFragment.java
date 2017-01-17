package com.example.kimys1324.kopet_drawer.Fragment.FindAbandoned;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.kimys1324.kopet_drawer.R;

/**
 * Created by kimys1324 on 7/13/16.
 */
public class AdoptionFragment extends Fragment {

    ImageButton requestBtn;

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_adoption, container, false);

        requestBtn = (ImageButton)rootView.findViewById(R.id.request_adoption);

        requestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment fragment = new RequestAdoptionFragment();

                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.main_content, fragment)
                        .addToBackStack(null)
                        .commit();

            }
        });

        return rootView;

    }
}
