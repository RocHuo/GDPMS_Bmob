package com.rochuo.gdpms_bmob.undergdpms;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.rochuo.gdpms_bmob.R;
import com.rochuo.gdpms_bmob.gdpms.DbHelper;

/**
 * Created by Administrator on 2016/4/15.
 */
public class DoneActivity  extends Activity{
    public static final String TASK_ID="";
    public static final int SCAN_FRAGMENT=3;

    private  int task_id;
    private DbHelper db;
    private SQLiteDatabase dbReader,dbWrite;
    private ImageButton mBack;

    private  TextView mTask,mYear,mTeacher,mNumber,mFrom,mModel,mType,mDifficult,mWork,mDegree,mIsok,mHasWorks,mMessageContent,mTaskRequire;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message);
        initText();
        setText();
        initListener();



    }

    private void initListener() {
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent();
                setResult(SCAN_FRAGMENT);

                Log.d("3", "onClick: ");
                finish();
            }
        });
    }


    private void initText() {
        mTask= (TextView) findViewById(R.id.task);
        mYear= (TextView) findViewById(R.id.year);
        mTeacher= (TextView) findViewById(R.id.teacher);
        mNumber= (TextView) findViewById(R.id.number);
        mFrom= (TextView) findViewById(R.id.from);
        mModel= (TextView) findViewById(R.id.model);
        mType= (TextView) findViewById(R.id.type);
        mDifficult= (TextView) findViewById(R.id.difficulty);
        mWork= (TextView) findViewById(R.id.work);
        mDegree= (TextView) findViewById(R.id.degree);
        mIsok= (TextView) findViewById(R.id.isok);
        mHasWorks= (TextView) findViewById(R.id.hasworks);
        mMessageContent= (TextView) findViewById(R.id.message_content);
        mTaskRequire= (TextView) findViewById(R.id.task_require);

        mBack= (ImageButton) findViewById(R.id.back);

        task_id=getIntent().getIntExtra(TASK_ID, -1);

        db=new DbHelper(this);
        dbReader=db.getReadableDatabase();


    }
    private void setText() {
        //对于数据的操作先放一放
        if (!TASK_ID.equals("")){
        task_id=getIntent().getIntExtra(TASK_ID,-1);
            Log.i(task_id+"","你不好");}

        Cursor cursor=dbReader.query(DbHelper.TABLE_NAME_TASK,
                new String[]{DbHelper.TABLE_NAME_TASK_TITLE + ""}, null, null, null, null, null);
        int count=cursor.getCount();
        if (count>0 && cursor!=null){
            mTask.setText(cursor.getString(cursor.getColumnIndex(DbHelper.TABLE_NAME_TASK_TITLE)));
            Log.i("title","nihAO ");
        }


//            mYear.setText(DbHelper.TABLE_NAME_TASK_YEAT + "");
//            mTeacher.setText(DbHelper.TABLE_NAME_TASK_TEACHER + "");
//            mNumber.setText(DbHelper.TABLE_NAME_TASK_NUMBER + "");
//            mFrom.setText(DbHelper.TABLE_NAME_TASK_FROM + "");
//            mModel.setText(DbHelper.TABLE_NAME_TASK_MODEL + "");
//            mType.setText(DbHelper.TABLE_NAME_TASK_TYPE + "");
//            mDifficult.setText(DbHelper.TABLE_NAME_TASK_DIFFICULT + "");
//            mWork.setText(DbHelper.TABLE_NAME_TASK_WORK+ "");
//            mDegree.setText(DbHelper.TABLE_NAME_TASK_DEGREE + "");
//            mIsok.setText(DbHelper.TABLE_NAME_TASK_ISOK + "");
//            mHasWorks.setText(DbHelper.TABLE_NAME_TASK_HASWORKS+ "");
//            mMessageContent.setText(DbHelper.TABLE_NAME_TASK_MESSAGE_CONTENT + "");
//            mTaskRequire.setText(DbHelper.TABLE_NAME_TASK_TASK_REQUIRE + "");

        }
    }

