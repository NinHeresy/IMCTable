package com.example.ramonlopes.imctable.fragmets;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ramonlopes.imctable.R;

/**
 * Created by Ramon Lopes on 10/02/2017.
 */

public class TableThree extends Fragment implements View.OnClickListener {
    public View mView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.layout_fragment_oldman, container,false);







        return mView;


    }

    @Override
    public void onClick(View v) {

    }
}
