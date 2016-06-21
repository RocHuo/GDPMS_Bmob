package com.rochuo.gdpms_bmob.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.rochuo.gdpms_bmob.R;

/**
 * Created by Administrator on 2016/4/14.
 */
public class ContentFragment extends android.app.Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

       return inflater.inflate(R.layout.content_fragment,container,false);
    }
}
