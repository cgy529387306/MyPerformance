package com.mb.performance;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * use memory profiler and mat analyze
 */
public class MemoryActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory);
        mRecyclerView = findViewById(R.id.mRecyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new NormalAdapter(getDataList()));
    }

    private List<String> getDataList(){
        List<String> dataList = new ArrayList<>();
        for (int i=0; i<10000; i++){
            dataList.add("memory" + i);
        }
        return dataList;
    }


    class NormalAdapter extends RecyclerView.Adapter<NormalAdapter.VH>{
        //② 创建ViewHolder

        private List<String> mDataList;

        class VH extends RecyclerView.ViewHolder{
            final TextView tvName;
            VH(View v) {
                super(v);
                tvName = (TextView) v.findViewById(R.id.tv_name);
            }
        }

        NormalAdapter(List<String> data) {
            this.mDataList = data;
        }

        //③ 在Adapter中实现3个方法
        @Override
        public void onBindViewHolder(VH holder, int position) {
            holder.tvName.setText(mDataList.get(position));
        }

        @Override
        public int getItemCount() {
            return mDataList.size();
        }

        @Override
        public VH onCreateViewHolder(ViewGroup parent, int viewType) {
            //LayoutInflater.from指定写法
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_memory, parent, false);
            return new VH(v);
        }
    }
}
