package com.example.saumyaawasthi.timetabels;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
        int value;
    ListView list ;
    public void generate(int value){
        ArrayList<Integer> num = new ArrayList<Integer>();
        for (int i = 1; i <= 10; i++) {
            num.add(value * i);
        }
        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1, num);
        list.setAdapter(arrayAdapter);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = findViewById(R.id.list);
        generate(10);
        final SeekBar seek=findViewById(R.id.seekBar);
        seek.setMax(30);
        seek.setProgress(10);
        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Log.i("seek bar",Integer.toString(i));
                int min=1;
                if(i<min)
                {
                    seek.setProgress(min);
                    i=min;
                    value=min;
                }
                else {
                    value = i;
                    generate(value);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
