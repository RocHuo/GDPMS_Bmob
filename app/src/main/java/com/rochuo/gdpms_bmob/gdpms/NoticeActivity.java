package com.rochuo.gdpms_bmob.gdpms;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.rochuo.gdpms_bmob.fragment.AnswerFragment;
import com.rochuo.gdpms_bmob.fragment.BookFragment;
import com.rochuo.gdpms_bmob.fragment.CommitFragment;
import com.rochuo.gdpms_bmob.fragment.ContentFragment;
import com.rochuo.gdpms_bmob.fragment.DoneFragment;
import com.rochuo.gdpms_bmob.fragment.LoadFragment;
import com.rochuo.gdpms_bmob.fragment.NoticeFragment;
import com.rochuo.gdpms_bmob.fragment.ResultFragment;
import com.rochuo.gdpms_bmob.fragment.ScanFragment;
import com.rochuo.gdpms_bmob.lowgdpms.UserInfoActivity;
import com.rochuo.gdpms_bmob.view.SlidingMenu;
import com.rochuo.gdpms_bmob.R;
import com.rochuo.gdpms_bmob.view.SlidingMenu;

/**
 * Created by Administrator on 2016/4/13.
 */
public class NoticeActivity extends Activity {
    private DbHelper mDate;
    private SQLiteDatabase mDateReate;
    private SimpleCursorAdapter adapter;
    private TextView title;
    private ListView main_list;
    private SlidingMenu changeState;
    private Button userInfoButton;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notcie);

        init();
        initList();
        initListener();
        userInfoButton = (Button) findViewById(R.id.userInfo);
        userInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(NoticeActivity.this, UserInfoActivity.class);
                startActivity(i);
            }
        });
    }

    private void init() {

        mDate = new DbHelper(this);
        mDateReate = mDate.getReadableDatabase();
        main_list = (ListView) findViewById(R.id.main_list);
        changeState = (SlidingMenu) findViewById(R.id.sliding);
        title = (TextView) findViewById(R.id.title);
//        Cursor c = mDateReate.query("notice", null, null, null, null, null, null);
//        adapter = new SimpleCursorAdapter(this, R.layout.notice_item, c, new String[]{"content", "issuer"}, new int[]{R.id.content, R.id.issuer});
//        listView = (ListView) findViewById(R.id.content_list_view);
//        listView.setAdapter(adapter);

        android.app.FragmentManager contentfragment = getFragmentManager();
        FragmentTransaction transaction = contentfragment.beginTransaction();

        ContentFragment noticefragment = new ContentFragment();
        transaction.add(R.id.content, noticefragment, "noticefragment");

    }

    private void initList() {

        String[] main_list_string = {"公告","选题浏览", "已选课题", "任务书", "任务提交", "教师答疑", "答辩成绩", "下载",};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.array_item, main_list_string);
        main_list.setAdapter(adapter);
    }

    private void initListener() {
        main_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {

                    case 0: {
                        Log.i("guanyong", "onItemClick: ");
                        title.setText("公告");
                        android.app.FragmentManager i = getFragmentManager();
                        FragmentTransaction j = i.beginTransaction();
                        NoticeFragment noticeFragment = new NoticeFragment();
                        j.replace(R.id.content, noticeFragment);
                        j.commit();
                        return;
                    }
                    case 1: {
                        Log.i("guanyong", "onItemClick: ");
                        title.setText("选题浏览");
                        android.app.FragmentManager i = getFragmentManager();
                        FragmentTransaction j = i.beginTransaction();
                        ScanFragment scanfragment = new ScanFragment();
                        j.replace(R.id.content, scanfragment);
                        j.commit();
                        return;
                    }
                    case 2: {
                        Log.i("guanyong", "onItemClick: ");
                        title.setText("已选课题");

                        android.app.FragmentManager i = getFragmentManager();
                        FragmentTransaction j = i.beginTransaction();
                        DoneFragment doneFragment = new DoneFragment();
                        j.replace(R.id.content, doneFragment);
                        j.commit();
                        return;
                    }
                    case 3: {
                        Log.i("guanyong", "onItemClick: ");
                        title.setText("任务书");
                        android.app.FragmentManager i = getFragmentManager();
                        FragmentTransaction j = i.beginTransaction();
                        BookFragment bookFragment = new BookFragment();
                        j.replace(R.id.content, bookFragment);
                        j.commit();
                        return;
                    }
                    case 4: {
                        Log.i("guanyong", "onItemClick: ");
                        title.setText("任务提交");
                        android.app.FragmentManager i = getFragmentManager();
                        FragmentTransaction j = i.beginTransaction();
                        CommitFragment commitFragment = new CommitFragment();
                        j.replace(R.id.content, commitFragment);
                        j.commit();
                        return;
                    }
                    case 5: {
                        Log.i("guanyong", "onItemClick: ");
                        title.setText("教师指导");
                        android.app.FragmentManager i = getFragmentManager();
                        FragmentTransaction j = i.beginTransaction();
                        AnswerFragment answerFragment = new AnswerFragment();
                        j.replace(R.id.content, answerFragment);
                        j.commit();
                        return;
                    }
                    case 6: {
                        Log.i("guanyong", "onItemClick: ");
                        title.setText("答辩成绩");
                        android.app.FragmentManager i = getFragmentManager();
                        FragmentTransaction j = i.beginTransaction();
                        ResultFragment resultFragment = new ResultFragment();
                        j.replace(R.id.content, resultFragment);
                        j.commit();
                        return;
                    }
                    case 7: {
                        Log.i("guanyong", "onItemClick: ");
                        title.setText("下载");
                        android.app.FragmentManager i = getFragmentManager();
                        FragmentTransaction j = i.beginTransaction();
                        LoadFragment loadFragment = new LoadFragment();
                        j.replace(R.id.content, loadFragment);
                        j.commit();
                        return;
                    }
                }
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //判断返回页面，设置显示的Fragment。
        if(requestCode==1&&resultCode==3){
            Log.d("1", "onActivityResult: ");
            title.setText("已选课题");

            android.app.FragmentManager i = getFragmentManager();
            FragmentTransaction j = i.beginTransaction();
            DoneFragment doneFragment = new DoneFragment();
            j.replace(R.id.content, doneFragment);
            j.commit();
        }

    }

    public void changeState(View view) {
        changeState.changeState();
    }

}
