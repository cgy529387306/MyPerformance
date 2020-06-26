package com.mb.performance;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

/**
 * use ddms traceview method profiling
 */
public class TraceViewActivity extends AppCompatActivity {
    int count = 0;
    long longCount=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory);
        //线程1
        new Thread(new Runnable() {
            @Override
            public void run() {
                printNum();
            }
        },"printNum_thread").start();
        //线程2
        new Thread(new Runnable() {
            @Override
            public void run() {
                calculate();
            }
        },"calculate_thread").start();
    }

    private void printNum() {
        for (int i = 0; i < 20000; i++) {
            print();
        }
    }

    /**
     * 模拟一个自身占用时间不长，但调用却非常频繁的函数
     */
    private void   print(){
        count=count++;
    }

    /**
     * 模拟一个调用次数不多，但每次调用却需要花费很长时间的函数
     */
    private  void  calculate(){
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {

                for (int l = 0; l < 1000; l++) {
                    if(longCount>10){
                        longCount=-10;
                    }
                }

            }
        }
        Log.e("TraceViewActivity",String.valueOf(longCount));
    }
}
