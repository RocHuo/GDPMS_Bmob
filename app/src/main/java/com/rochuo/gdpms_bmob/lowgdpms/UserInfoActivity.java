package com.rochuo.gdpms_bmob.lowgdpms;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.rochuo.gdpms_bmob.gdpms.NoticeActivity;
import com.rochuo.gdpms_bmob.R;
import com.rochuo.gdpms_bmob.undergdpms.SetPhoneNumberActivity;

/**
 * Created by Administrator on 2016/4/20.
 */
public class UserInfoActivity extends Activity{
    private RelativeLayout mPhone;
    private View.OnClickListener mPhoneListener;
    private TextView mPhoneNumber;
    private ImageButton mBack;
    private  boolean first = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_info);
        
        init();
        initListener();
    }

    private void init(){
        mBack= (ImageButton) findViewById(R.id.info_back);
        mPhone= (RelativeLayout) findViewById(R.id.phone);
        mPhoneNumber= (TextView) findViewById(R.id.info_setphone);
        //当AlertDialog确定后，将返回的数值传到显示页面




                    mPhoneListener =new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent i=new Intent(UserInfoActivity.this,SetPhoneNumberActivity.class);
                            startActivity(i);

                }
            };


    }

    private void initListener() {

        mPhone.setOnClickListener(mPhoneListener);
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(UserInfoActivity.this,NoticeActivity.class);
                startActivity(i);
            }
        });
    }

}
