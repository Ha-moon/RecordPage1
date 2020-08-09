package com.example.recordpage1;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaRecorder;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;


import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.IOException;


public class recordActivity extends AppCompatActivity {

    public MediaRecorder recorder;

//    int position = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_record);

        permissionCheck();

        ImageButton record = (ImageButton) findViewById(R.id.record_btn) ;
        record.setOnClickListener(new Button.OnClickListener() {
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
    }





    public void recordAudio() {
        recorder = new MediaRecorder();

        recorder.setAudioSource(MediaRecorder.AudioSource.MIC); // 어디에서 음성 데이터를 받을 것인지
        recorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4); // 압축 형식 설정
        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);



        try {
//            if(recorder == null){
//                recorder.prepare();
//                recorder.start();
//            }
//            else if{ recorder.resume();} //resume녹음다시시작
            recorder.prepare();
            recorder.start();

            Toast.makeText(getApplicationContext(), "녹음 시작됨.", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stopRecording() {


        if (recorder != null) {
            recorder.stop(); //pause
            recorder.release();
            recorder = null;

            Toast.makeText(getApplicationContext(), "녹음 중지됨.", Toast.LENGTH_LONG).show();
        }
    }

    public void stopandsave() {

        if (recorder != null) {
            recorder.stop(); //stop에서 오류남..저장시켜야되서..?
            recorder.release();
            recorder = null;

            Toast.makeText(getApplicationContext(), "녹음 중지됨.", Toast.LENGTH_LONG).show();
        }
    }


    public void permissionCheck() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.RECORD_AUDIO}, 1);
        }
    }

}