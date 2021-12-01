package com.example.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.listView = findViewById(R.id.listView);
    }

    private void strArrToLV(String str)
    {
        String[] items = str.split(",");
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);
    }

    public void onBtnDownloadClick(View view) {

        new DataLoader(){
            @Override
            public void onPostExecute(String result)
            {
                strArrToLV(String.valueOf(result));
            }
        }.execute("USD");
    }
}