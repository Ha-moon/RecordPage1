package com.example.recordpage1;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.AudioFormat;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.ParseException;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;



public class recordActivity extends AppCompatActivity {

    public String filename;
    public MediaRecorder recorder;
    public MediaPlayer player;
    String path;

//    int position = 0;

//    public List<String> search(String key){
//
//        key = "#" + key + "#";
//
//        List<String> files = new ArrayList<>();
//
//
//        // 폴더 안에 있는 모든 파일 명들을 읽어온다.는 코드넣기
//        // 리스트 안에 저장한다.는 코드넣기
//        // 리스트 들은 순회한다.는 코드넣기
//        // 그 절대 주소(파일1개)로 파일을 읽어온다.는 코드넣기
//        File file = new File("path");
//        Scanner scan = new Scanner(file);
//        String contents = "";
//        while(scan.hasNext()) {
//            contents += scan.nextLine();
//        }
//        if(contents.contains(key)){
//            files.add(file.path())
//        }
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_record);

//        Date d = new Date();
//        CharSequence s  = DateFormat.format("MMMM d, yyyy ", d.getTime());

        permissionCheck();

        TextView filename_textView = (TextView)findViewById(R.id.filename_recordpage);
        String filename1 = getIntent().getStringExtra("key");
        filename=filename1;
        if(filename != null){
            filename_textView.setText(filename);
        }
//        else{
//            try {
//                long lNow; Date dt;
//                SimpleDateFormat sdfFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//                lNow = System.currentTimeMillis();
//                dt = new Date(lNow);
//                filename_textView.setText(sdfFormat.format(dt));
//
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//        }



        ImageButton record = (ImageButton) findViewById(R.id.record_btn) ;
        record.setOnClickListener(new Button.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.N)//stopRecording때문
            @Override
            public void onClick(View view) {
                view.setSelected(!view.isSelected());

                if (view.isSelected()) {
                    //Handle selected state change//녹음시작
                    recordAudio();
                }
                else {
                    //Handle de-select state change//녹음멈춤
                    stopRecording();
                }
            }

        });


        Button save = (Button) findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopandsave();

                Intent intent = new Intent(getApplicationContext(), settingActivity.class);
                startActivity(intent);


                Toast.makeText(getApplicationContext(), "저장했습니다:)", Toast.LENGTH_LONG).show();

            }
        });


        Button playBtn = (Button) findViewById(R.id.playBtn);
        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                playAudio();//아래선언
            }

        });

        Button button4 = (Button) findViewById(R.id.stopBtn);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopAudio();
            }
        });
    }



    @RequiresApi(api = Build.VERSION_CODES.N)
    public void recordAudio() {

//        filename = "record.mp4";
        File file = new File(getApplicationContext().getFilesDir(), filename);
        path = file.getAbsolutePath();

//        String path = "/data/data/com.example.recordpage1/files";
//
//        File dir = new File(path);
//        File[] fileList = dir.listFiles();
//        for (File file : fileList) {
//            if (file.isFile()) {
//                String fileName = file.getName();
//                Log.d("file ", fileName);
//                System.out.println(fileName);
//            }
//        }


        recorder = new MediaRecorder();
//    wav flac
        recorder.setAudioSource(MediaRecorder.AudioSource.MIC); // 어디에서 음성 데이터를 받을 것인지
        recorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4); // 압축 형식 설정
        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);

        recorder.setOutputFile(path);

        try {
            recorder.prepare();
            recorder.start();
            Toast.makeText(getApplicationContext(), "녹음 시작됨.", Toast.LENGTH_SHORT).show();
//            if(recorder == null){
//                recorder.prepare();
//                recorder.start();
//                Toast.makeText(getApplicationContext(), "녹음 시작됨.", Toast.LENGTH_SHORT).show();
//            }
//            else {
//                recorder.resume(); //resume녹음다시시작..오류남...!!!!!!!
//                Toast.makeText(getApplicationContext(), "녹음 다시 시작됨.", Toast.LENGTH_SHORT).show();
//            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)//? pause땜에..
    public void stopRecording() {


        if (recorder != null) {
            recorder.pause(); //됨..?



            Toast.makeText(getApplicationContext(), "녹음 중지됨.", Toast.LENGTH_LONG).show();
        }
    }

    public void stopandsave() {

        if (recorder != null) {
            recorder.stop(); //
            recorder.release();
            recorder = null;

//            Toast.makeText(getApplicationContext(), "녹음 중지됨.", Toast.LENGTH_LONG).show();
        }



    }


    public void permissionCheck() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.RECORD_AUDIO}, 1);
        }
    }







    public void playAudio() {
        try {
            closePlayer(); //항상 처음시작에 죽임

            player = new MediaPlayer();
            //player.setDataSource(url); //인터넷에서 가져와서 플레이
            player.setDataSource(this, Uri.parse(path)); //녹음된파일 플레이
            player.prepare();
            player.start();

            Toast.makeText(this, "재생 시작됨.", Toast.LENGTH_LONG).show(); //메세지띄움
        } catch (Exception e) {
            Log.e("SampleAudioRecorder", "Audio play failed.", e);
        }
    }

    public void stopAudio() { //재시작
        if (player != null && player.isPlaying()) {
            closePlayer();

            Toast.makeText(this, "정지됨.", Toast.LENGTH_LONG).show();
        }
    }

    public void closePlayer() { //항상 처음시작에 죽임
        if (player != null) {
            player.stop();
            player.release();
            player = null;
        }
    }

}