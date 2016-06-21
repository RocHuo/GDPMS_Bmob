package com.rochuo.gdpms_bmob.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.rochuo.gdpms_bmob.R;

/**
 * Created by Administrator on 2016/4/15.
 */
public class ScanFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.v("scanfragment","how");

        return inflater.inflate(R.layout.scan_fragment,container,false);
    }

    @Override
    public void onStart() {
        super.onStart();
        ListView scan_list= (ListView) getActivity().findViewById(R.id.scan_list);

        scan_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //待定
            }
        });


    }
}
