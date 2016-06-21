package com.rochuo.gdpms_bmob.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rochuo.gdpms_bmob.R;

/**
 * Created by Administrator on 2016/4/15.
 */
public class ResultFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.result_fragment,container,false);
    }
}
