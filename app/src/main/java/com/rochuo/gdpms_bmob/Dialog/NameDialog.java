package com.rochuo.gdpms_bmob.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.rochuo.gdpms_bmob.R;

/**
 * Created by Administrator on 2016/5/13.
 */
public class NameDialog extends Dialog {
    private EditText mChangeName;
    private View mView;
    public NameDialog(Context context) {
        super(context);
        this.setCanceledOnTouchOutside(true);
        this.mView= LayoutInflater.from(context).inflate(R.layout.name_dialog,null);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(mView);

    }
}
