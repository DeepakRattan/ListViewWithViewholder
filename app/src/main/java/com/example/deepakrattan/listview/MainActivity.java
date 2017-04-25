package com.example.deepakrattan.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView lv;
    private SingleRow singleRow;
    private ArrayList<SingleRow> singleRowArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //findviewById
        lv = (ListView) findViewById(R.id.lv);

        //Data source
        String[] name = {"Raj", "Ravi", "virender", "Rahul", "Raman", "Varun", "virender", "Rahul", "Raman", "Varun"};
        String[] desc = {"This is desc", "This is desc", "This is desc", "This is desc", "This is desc", "This is desc", "This is desc", "This is desc", "This is desc", "This is desc"};
        int[] image = {R.drawable.image, R.drawable.image, R.drawable.image, R.drawable.image, R.drawable.image, R.drawable.image, R.drawable.image, R.drawable.image, R.drawable.image, R.drawable.image};

        singleRowArrayList = new ArrayList<>();
        for (int i = 0; i < name.length; i++) {
            singleRow = new SingleRow(name[i], desc[i], image[i]);
            singleRowArrayList.add(singleRow);
        }

        MyAdapter adapter = new MyAdapter(this, singleRowArrayList);
        lv.setAdapter(adapter);

        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,name);
        // ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.my_layout,name);
        //lv.setAdapter(adapter);

        registerForContextMenu(lv);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.edit:
                Toast.makeText(this, "Edit Selected", Toast.LENGTH_LONG).show();
                return true;
            case R.id.delete:
                Toast.makeText(this, "Delete Selected", Toast.LENGTH_LONG).show();
                return true;
            case R.id.setting:
                Toast.makeText(this, "Setting Selected", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }


    }
}
