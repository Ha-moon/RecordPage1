package com.example.recordpage1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.os.Environment;
import android.speech.RecognitionListener; //??
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class playActivity extends AppCompatActivity {

    String path;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.playopen);



//        final ListView lv;
//        ListViewAdapter adapter;
//        adapter = new ListViewAdapter();
//        lv = (ListView)findViewById(R.id.playlist);
//        listView.setAdapter(adapter);


//        File directory = getApplicationContext().getFilesDir();
//      path = directory.getAbsolutePath();
        path = "/data/data/com.example.recordpage1/files";

//        File dir = new File(path);
//        File[] fileList = dir.listFiles();
//        for (File file : fileList) {
//            if (file.isFile()) {
//                String fileName = file.getName();
//                Log.d("file ", fileName);
//                System.out.println(fileName);
//            }
//        }

//        ListView playlist = (ListView) findViewById(R.id.playlist);
//        File f = new File(path);
//        File[] files = f.listFiles(new FileFilter() {
//            @Override
//            public boolean accept(File pathname) {
//                return pathname.getName().toLowerCase(Locale.US).endsWith(".mp4"); //확장자
//            }
//        });
//        playlist = files;
//
//
//    DBHelper helper = new DBHelper(playActivity.this, path, null, 1);    // DB 파일명 입력
//    SQLiteDatabase db = helper.getWritableDatabase();
//    ContentValues values = new ContentValues();
//        values.put("context", path);
//    Cursor cursor = db.rawQuery("SELECT _id, context FROM memo", null);    // SELECT문으로 DB 값을 읽어온다
//// 커서에 저장된 값들을 이용하여 Adapter를 만들고, listView랑 매칭시켜 준다
//    Adapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1, cursor, new String[]{"context"}, new int[]{android.R.id.text1});
//            list_view.setAdapter(Adapter);
//    private class DBHelper extends SQLiteOpenHelper {
//
//        public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
//
//            super(context, name, factory, version);
//        }
//
//        public void onCreate(SQLiteDatabase db) {
//
//            String sql = "create table memo (" + "_id integer primary key autoincrement, " + "context text);";
//
//            db.execSQL(sql);    // 위 String에 해당하는 SQL 문장을 실행함
//
//        }
//
//
//        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
////
//            String sql = "drop table if exists memo";
//
//            db.execSQL(sql);
//
//            onCreate(db);
//
//        }
//    }




    }
}
