package com.rochuo.gdpms_bmob.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.rochuo.gdpms_bmob.R;

/**
 * Created by Administrator on 2016/4/15.
 */
public class NoticeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.notice_fragment,container,false);
    }

//    @Override
//    public void onStart() {
//        super.onStart();
//        Button add_answer_note= (Button) getActivity().findViewById(R.id.add_answar_note);
//        add_answer_note.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //可以参考gite中的操作
//            }
//        });
////answer_list应该先setAdapter。
//        ListView answer_list= (ListView) getActivity().findViewById(R.id.answer_list);
//
//
//        answer_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                //同样参考gite中的操作
//            }
//        });
//
//    }
}
