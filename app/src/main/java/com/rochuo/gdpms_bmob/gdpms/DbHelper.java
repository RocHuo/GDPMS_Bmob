package com.rochuo.gdpms_bmob.gdpms;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Administrator on 2016/4/13.
 */
public class DbHelper extends SQLiteOpenHelper{

    public static final String  TABLE_NAME_ID="_id";
    public static final String  TABLE="task";
    //公告表
    public static final String TABLE_NAME_NOTICE="notice";
    public static final String TABLE_NAME_NOTICE_TITEL="title";
    public static final String TABLE_NAME_NOTICE_DATA="date";
    public static final String TABLE_NAME_NOTICE_ISSUER="issuer";
    public static final String TABLE_NAME_NOTICE_CONTEXT="content";

    public static final String TABLE_NAME_TASK="task";
    public static final String TABLE_NAME_TASK_TITLE="title";
    public static final String TABLE_NAME_TASK_YEAR="year";
    public static final String TABLE_NAME_TASK_TEACHER="teacher";
    public static final String TABLE_NAME_TASK_NUMBER="number";
    public static final String TABLE_NAME_TASK_FROM="from";
    public static final String TABLE_NAME_TASK_MODEL="model";
    public static final String TABLE_NAME_TASK_TYPE="type";
    public static final String TABLE_NAME_TASK_DIFFICULT="difficult";
    public static final String TABLE_NAME_TASK_WORK="work";
    public static final String TABLE_NAME_TASK_DEGREE="degree";
    public static final String TABLE_NAME_TASK_ISOK="isok";
    public static final String TABLE_NAME_TASK_HASWORKS="hasword";
    public static final String TABLE_NAME_TASK_MESSAGE_CONTENT="message_content";
//    public static final String TABLE_NAME_ANNOUNCEMENT="announcement";
//    public static final String TABLE_NAME_ANNOUNCEMENT_ID="task_require";
//    public static final String TABLE_NAME_TASK_TASK_REQUIRE="task_require";
//    public static final String TABLE_NAME_TASK_TASK_REQUIRE="task_require";


//    public static final String TABLE_NAME_
//    public static final String
//    public static final String



    public DbHelper(Context context) {
        super(context, TABLE, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME_NOTICE + "(" + TABLE_NAME_ID
                + " INTEGER PRIMARY KEY AUTOINCREMENT," + TABLE_NAME_NOTICE_CONTEXT
                + " TEXT NOT NULL DEFAULT \"\","+ TABLE_NAME_NOTICE_DATA
                + " TEXT NOT NULL DEFAULT \"\"," + TABLE_NAME_NOTICE_ISSUER
                + " TEXT NOT NULL DEFAULT \"\"" + ")");
        db.execSQL("CREATE TABLE " + TABLE_NAME_TASK + "(" + TABLE_NAME_ID
                + " INTEGER PRIMARY KEY AUTOINCREMENT," + TABLE_NAME_TASK_TITLE
                + " TEXT NOT NULL DEFAULT \"\"," + TABLE_NAME_TASK_YEAR
                + " TEXT NOT NULL DEFAULT \"\"," + TABLE_NAME_TASK_TEACHER
                + " TEXT NOT NULL DEFAULT \"\"" + ")");
//        db.execSQL("CREATE TABLE `announcement` (`id` bigint(20) NOT NULL auto_increment,`creat_time` datetime default '2016-01-01 01:00:00',`content` text,`issuer` bigint(20) default NULL,PRIMARY KEY  (`id`),KEY `FK_ANNO_ISSU` (`issuer`),CONSTRAINT `FK_ANNO_ISSU` FOREIGN KEY (`issuer`) REFERENCES `user` (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8");
        db.execSQL("INSERT INTO "+TABLE_NAME_NOTICE+" VALUES (1,'2016-01-01 01:00:00','系统管理员公告','5'),(2,'2016-01-01 01:00:00','学校管理员公告','4')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
