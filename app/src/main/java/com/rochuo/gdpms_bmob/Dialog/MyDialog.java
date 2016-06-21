package com.rochuo.gdpms_bmob.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

import com.rochuo.gdpms_bmob.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/4/21.
 */
public class MyDialog extends Dialog {
    private View mView ;
    private ListView mListView;
    private static final int TITILE_NAME=1;
    private List<Title> mItem=new ArrayList<>();


    public MyDialog(Context context,int type) {
        super(context);
        setCanceledOnTouchOutside(true);
        mView= LayoutInflater.from(context).inflate(R.layout.dialog_show,null);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public class Title{
        public String name;
        public int id;
    }
}


