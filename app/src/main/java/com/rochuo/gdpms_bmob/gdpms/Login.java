package com.rochuo.gdpms_bmob.gdpms;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.rochuo.gdpms_bmob.R;
import com.rochuo.gdpms_bmob.entity.Notice;

import java.util.Date;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.datatype.BmobDate;
import cn.bmob.v3.listener.SaveListener;

public class Login extends Activity {
    private  Button mLoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_login);
        Bmob.initialize(this, "35b04196ec3e7484d4831babd16c53ab");
        Toast.makeText(getApplicationContext(), "初始化Bmob成功！",Toast.LENGTH_SHORT).show();
        Notice notice = new Notice();
        notice.setTitle("今夜多云转晴");
        notice.setContent("我的心情突然就转晴了！");
        notice.setAuthor("鸭蛋");
        notice.setTime(new BmobDate(new Date()));
        notice.save(this, new SaveListener() {
            @Override
            public void onSuccess() {
                Toast.makeText(getApplicationContext(), "载入数据成功！",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(int i, String s) {
                Toast.makeText(getApplicationContext(), "载入数据失败！",Toast.LENGTH_SHORT).show();
            }
        });
        mLoginButton=(Button)findViewById(R.id.login);
        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Login.this,NoticeActivity.class);
                startActivity(i);

            }
        });


    }
}
