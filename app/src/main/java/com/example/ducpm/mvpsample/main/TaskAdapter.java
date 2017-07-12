package com.example.ducpm.mvpsample.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import data.model.Task;

/**
 * Created by ducpm on 10/07/17.
 */
public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {
    private List<Task> mTaskList;
    private MainContract.Presenter mPresenter;
    private RecyclerView mRecyclerView;

    public TaskAdapter(List<Task> mTaskList, MainContract.Presenter mPresenter,
            RecyclerView mRecyclerView) {
        this.mTaskList = mTaskList;
        this.mPresenter = mPresenter;
        this.mRecyclerView = mRecyclerView;
    }

    public List<Task> getTaskList() {
        return mTaskList;
    }

    public void setTaskList(List<Task> mTaskList) {
        this.mTaskList = mTaskList;
    }

    @Override
    public TaskAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //        View v  = LayoutInflater.from(parent.getContext()).inflate(
        //            android.support.v7.appcompat.R.layout.item_task)
        return null;
    }

    public void replaceTask(List<Task> newData) {
        setTaskList(newData);
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(TaskAdapter.ViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
