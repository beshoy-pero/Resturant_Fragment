package com.beshoykamal.resturantfragment.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.beshoykamal.resturantfragment.MainActivity;
import com.beshoykamal.resturantfragment.R;

public class PageFragment3 extends Fragment {

//    Button skipt;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        ViewGroup rootview=(ViewGroup)inflater.inflate(R.layout.layout_3,container,false);

        Button skipt=(Button)rootview.findViewById(R.id.skip);

        skipt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "DON", Toast.LENGTH_SHORT).show();
                Intent in = new Intent(getActivity(), MainActivity.class);
                startActivity(in);
            }
        });

        return rootview;

    }

}
