package com.rochuo.gdpms_bmob.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rochuo.gdpms_bmob.undergdpms.DoneActivity;
import com.rochuo.gdpms_bmob.R;

/**
 * Created by Administrator on 2016/4/15.
 */
public class DoneFragment extends Fragment {
public static final int FASD =1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.done_fragment,container,false);
    }

    @Override
    public void onStart() {
        super.onStart();
        TextView done_name= (TextView) getActivity().findViewById(R.id.done_name);
        done_name.setText("基于Android的毕设管理系统");
        done_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(),DoneActivity.class);
                startActivityForResult(i,1);

            }
        });



        }
    }

