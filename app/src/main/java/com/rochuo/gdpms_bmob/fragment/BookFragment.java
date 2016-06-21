package com.rochuo.gdpms_bmob.fragment;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.InputFilter;
import android.text.InputType;
import android.text.method.NumberKeyListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;

import com.rochuo.gdpms_bmob.Dialog.MyDialog;
import com.rochuo.gdpms_bmob.Dialog.NameDialog;
import com.rochuo.gdpms_bmob.R;

/**
 * Created by Administrator on 2016/4/15.
 * 这个类与数据的连接没有实现，主要功能实现了，只是体力活完成。
 */
public class BookFragment extends Fragment {
    public static final int ID_NUMBER=12;
    private RelativeLayout mName,mPhone,mMargin,mTitle;
    private String[] mMarginArray={"教育技术学","软件工程","计算机"};
    private String[] mTitleArray={"基于实例学习的算法分析与实现","基于Android的毕业设计管理系统"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.book_fragment,container,false);
    }

    @Override
    public void onStart() {
        super.onStart();
        init();
        initListener();


    }

    /**
     * 先对前几个注册点击事件，以观后效
     */
    private void initListener() {
        mName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View mView = LayoutInflater.from(getActivity()).inflate(R.layout.name_dialog, null);
                setDialog(mView,"请输入你的姓名");
            }
        } );
        mPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view=LayoutInflater.from(getActivity()).inflate(R.layout.phone_dialog,null);
                EditText et= (EditText) view.findViewById(R.id.phone_dialog);
                et.setKeyListener(new NumberKeyListener() {
                    @Override
                    protected char[] getAcceptedChars() {
                        char[] number = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
                        return number;
                    }

                    @Override
                    public int getInputType() {
                        return InputType.TYPE_CLASS_NUMBER;
                    }
                });
                et.setFilters(new InputFilter[]{new InputFilter.LengthFilter(ID_NUMBER)});
                setDialog(view, "请输入你的学号");
            }
        });
        mMargin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //很有可能会报错，关于list adapter view 的加载顺序
                //还应该对item设置点击事件
                View view=LayoutInflater.from(getActivity()).inflate(R.layout.margin_dialog,null);
                ListView list= (ListView) view.findViewById(R.id.margin_dialog_list);
                ArrayAdapter<String> adapter=
                        new ArrayAdapter<String>(getActivity(),R.layout.margin_item,mMarginArray);
                list.setAdapter(adapter);
                setDialog(view,"请选择你的专业");
            }
        });

        mTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view =LayoutInflater.from(getActivity()).inflate(R.layout.margin_dialog,null);
                ListView list= (ListView) view.findViewById(R.id.margin_dialog_list);
                ArrayAdapter<String> adapter=
                        new ArrayAdapter<String>(getActivity(),R.layout.margin_item,mTitleArray);
                list.setAdapter(adapter);
                setDialog(view,"请选择你的课题名称");


            }
        });


    }

    private void init() {
        mName= (RelativeLayout) getActivity().findViewById(R.id.c_name);
        mPhone= (RelativeLayout) getActivity().findViewById(R.id.c_phone);
        mMargin= (RelativeLayout) getActivity().findViewById(R.id.c_margin);
        mTitle= (RelativeLayout) getActivity().findViewById(R.id.titlename);


    }

    /** 此方法封装了对于Dialog 的设置
     * v  设置的VEIW
     * s  设置的title
     *
     */


    public void setDialog(View v,String s){
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setView(v);
        builder.setPositiveButton("保存", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }
                )
                .setTitle(s)
                .show(); }


}



