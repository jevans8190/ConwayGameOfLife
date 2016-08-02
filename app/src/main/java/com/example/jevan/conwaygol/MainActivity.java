package com.example.jevan.conwaygol;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PixelGridView pgv = new PixelGridView(this);
        pgv.setNumCols(4);
        pgv.setNumRows(6);

        setContentView(pgv);
    }
}
