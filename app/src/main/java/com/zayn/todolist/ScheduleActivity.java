package com.zayn.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ScheduleActivity extends AppCompatActivity {

    private EditText schedule_et;
    private Button schedule_add;
    private ListView schedule_list;
    private ArrayList<String> schedule_items= new ArrayList<>();
    private ArrayAdapter adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        schedule_et = findViewById(R.id.schedule_et);
        schedule_add = findViewById(R.id.schedule_add);
        schedule_list = findViewById(R.id.schedule_list);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,schedule_items);
        schedule_list.setAdapter(adapter);

        schedule_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add();
            }
        });

        schedule_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    newActivity();
            }
        });
    }
    public void add(){
        String scheduleItemEntered = schedule_et.getText().toString();
        adapter.add(scheduleItemEntered);
        schedule_et.setText("");
        Toast.makeText(this, "Schedule Added", Toast.LENGTH_SHORT).show();
    }

    public void newActivity(){
        Intent intent = new Intent(ScheduleActivity.this , MainActivity.class);
        startActivity(intent);
    }


}
