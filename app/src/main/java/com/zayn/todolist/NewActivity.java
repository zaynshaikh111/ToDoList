package com.zayn.todolist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class NewActivity extends AppCompatActivity
{
    private Button ButtonStart;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        ButtonStart = (Button) findViewById(R.id.ButtonStart);
        ButtonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start();
            }
        });
    }
    private void start()
    {
        Intent intent = new Intent(NewActivity.this , ScheduleActivity.class);
        startActivity(intent);
    }
}
