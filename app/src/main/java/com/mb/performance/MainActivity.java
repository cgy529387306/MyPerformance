package com.mb.performance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onMemory(View view) {
        startActivity(new Intent(this,MemoryActivity.class));
    }

    public void onTrace(View view) {
        startActivity(new Intent(this,TraceViewActivity.class));
    }

    public void onLeak(View view) {
        startActivity(new Intent(this,LeakActivity.class));
    }
}
