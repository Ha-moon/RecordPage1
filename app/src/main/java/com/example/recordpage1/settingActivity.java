package com.example.recordpage1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;

public class settingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);

        Button button= (Button) findViewById(R.id.makeroom);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), recordActivity.class);

                EditText edit_filename = (EditText) findViewById(R.id.edit_filename);
                intent.putExtra("key", edit_filename.getText().toString());


                startActivity(intent);
            }
        });



    }


}