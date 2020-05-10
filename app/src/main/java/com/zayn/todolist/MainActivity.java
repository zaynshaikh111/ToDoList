package com.zayn.todolist;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    private EditText itemET;
    private Button addItem;
    private ListView itemsList;
    private ArrayList<String> items;    // To store the items in a Array in the String form
    private ArrayAdapter<String> adapter;   // Array Adapter is used for managing the Items in the list or grid view

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        itemET = findViewById(R.id.item_edit_text);
        addItem = findViewById(R.id.add_button);
        itemsList = findViewById(R.id.items_list);
        items = FileHelper.readData(this);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, items);
        itemsList.setAdapter(adapter);
        addItem.setOnClickListener(this);
        itemsList.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add_button:
                String itemEntered = itemET.getText().toString();
                adapter.add(itemEntered);
                itemET.setText("");
                FileHelper.writeData(items, this);
                Toast.makeText(this, "Item Added", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        items.remove(position);
        adapter.notifyDataSetChanged();
        Toast.makeText(this, "Item Deleted", Toast.LENGTH_SHORT).show();
    }
}
