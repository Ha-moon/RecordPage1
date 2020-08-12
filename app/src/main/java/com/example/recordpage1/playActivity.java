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

//    Context cThis;//context 설정
//    String LogTT="[STT]";//LOG타이틀
//    //음성 인식용
//    Intent SttIntent;
//    SpeechRecognizer mRecognizer;
//    //음성 출력용
//    TextToSpeech tts;
//
//    // 화면 처리용
//    ImageButton btnSttStart;
//    EditText txtInMsg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        cThis = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playopen);

//        final ListView lv;
//        ListViewAdapter adapter;
//        adapter = new ListViewAdapter();
//        lv = (ListView)findViewById(R.id.playlist);
//        listView.setAdapter(adapter);


        File directory = getApplicationContext().getFilesDir();
//      path = directory.getAbsolutePath();
        path = "/data/data/com.example.recordpage1/files";

        File dir = new File(path);
        File[] fileList = dir.listFiles();
        for (File file : fileList) {
            if (file.isFile()) {
                String fileName = file.getName();
                Log.d("file ", fileName);
                System.out.println(fileName);
            }
        }

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




//        //음성인식
//        SttIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
//        SttIntent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, getApplicationContext().getPackageName());
//        SttIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "ko-KR");//한국어 사용
//        mRecognizer = SpeechRecognizer.createSpeechRecognizer(cThis);
////        mRecognizer.setRecognitionListener(listener);
//
//        //음성출력 생성, 리스너 초기화
//        tts = new TextToSpeech(cThis, new TextToSpeech.OnInitListener() {
//            @Override
//            public void onInit(int status) {
//                if (status != android.speech.tts.TextToSpeech.ERROR) {
//                    tts.setLanguage(Locale.KOREAN);
//                }
//            }
//        });
//        //버튼설정
//        btnSttStart = (ImageButton) findViewById(R.id.record_btn);
//        btnSttStart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                System.out.println("음성인식 시작!");
//                if (ContextCompat.checkSelfPermission(cThis, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
//                    ActivityCompat.requestPermissions(playActivity.this, new String[]{Manifest.permission.RECORD_AUDIO}, 1);
//                    //권한을 허용하지 않는 경우
//                } else {
//                    //권한을 허용한 경우
//                    try {
//                        mRecognizer.startListening(SttIntent);
//                    } catch (SecurityException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });
//        txtInMsg = (EditText) findViewById(R.id.txtInMsg);
//
//        //어플이 실행되면 자동으로 1초뒤에 음성 인식 시작
//        new android.os.Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//
//                btnSttStart.performClick();
//            }
//        }, 1000);//바로 실행을 원하지 않으면 지워주시면 됩니다
//    }
//
//
//
//    public void onResults(Bundle results) {
//        String key= "";
//        key = SpeechRecognizer.RESULTS_RECOGNITION;
//        ArrayList<String> mResult =results.getStringArrayList(key);
//        String[] rs = new String[mResult.size()];
//        mResult.toArray(rs);
//        txtInMsg.setText(rs[0]+"\r\n"+txtInMsg.getText());
//        FuncVoiceOrderCheck(rs[0]);
//        mRecognizer.startListening(SttIntent);
//
//    }
//
//    //입력된 음성 메세지 확인 후 동작 처리
//    private void FuncVoiceOrderCheck(String VoiceMsg){
//        if(VoiceMsg.length()<1)return;
//
//        VoiceMsg=VoiceMsg.replace(" ","");//공백제거
//
//        if(VoiceMsg.indexOf("카카오톡")>-1 || VoiceMsg.indexOf("카톡")>-1){
//            Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.kakao.talk");
//            startActivity(launchIntent);
//            onDestroy();
//        }//카카오톡 어플로 이동
//        if(VoiceMsg.indexOf("전동꺼")>-1 || VoiceMsg.indexOf("불꺼")>-1){
//            FuncVoiceOut("전등을 끕니다");//전등을 끕니다 라는 음성 출력
//        }
//    }
//
//
//
//    //음성 메세지 출력용
//    private void FuncVoiceOut(String OutMsg){
//        if(OutMsg.length()<1)return;
//
//        tts.setPitch(1.0f);//목소리 톤1.0
//        tts.setSpeechRate(1.0f);//목소리 속도
//        tts.speak(OutMsg,TextToSpeech.QUEUE_FLUSH,null);
//
//        //어플이 종료할때는 완전히 제거
//
//    }
//    //카톡으로 이동을 했는데 음성인식 어플이 종료되지 않아 계속 실행되는 경우를 막기위해 어플 종료 함수
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        if(tts!=null){
//            tts.stop();
//            tts.shutdown();
//            tts=null;
//        }
//        if(mRecognizer!=null){
//            mRecognizer.destroy();
//            mRecognizer.cancel();
//            mRecognizer=null;
//        }
    }
}