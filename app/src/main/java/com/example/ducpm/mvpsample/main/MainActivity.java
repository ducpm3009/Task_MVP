package com.example.ducpm.mvpsample.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.ducpm.mvpsample.R;

import java.util.ArrayList;
import java.util.List;

import data.model.Task;
import data.source.task.TaskRepository;
import data.source.task.local.TaskLocalDataSource;
import data.source.task.remote.RemoteTaskDataSource;

public class MainActivity extends AppCompatActivity
        implements MainContract.View, View.OnClickListener {
    private MainContract.Presenter mPresenter;
    private RecyclerView mRecyclerTask;
    private TaskAdapter mTaskAdapter;
    private List<Task> mTaskList;

    public MainActivity(MainContract.Presenter presenter, RecyclerView recyclerTask,
            TaskAdapter taskAdapter, List<Task> taskList) {
        this.mPresenter = presenter;
        this.mRecyclerTask = recyclerTask;
        this.mTaskAdapter = taskAdapter;
        this.mTaskList = taskList;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPresenter = new MainPresenter(this,
                new TaskRepository(new TaskLocalDataSource(this), new RemoteTaskDataSource()));
        mTaskList = new ArrayList<>();
        mRecyclerTask.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerTask.setAdapter(mTaskAdapter);
        mPresenter.getTasks();
        findViewById(R.id.add_button).setOnClickListener(this);
    }

    @Override
    public void onAddSuccess(Task task) {
        mTaskList.add(task);
        mTaskAdapter.replaceTask(mTaskList);
    }

    @Override
    public void onDeleteSuccess() {

    }

    @Override
    public void onEditSuccess(Task task) {

        int index = mTaskList.indexOf(task);
        mTaskList.set(index, task);
        mTaskAdapter.notifyItemChanged(index);
    }

    @Override
    public void onFinishSuccess(Task task) {

    }

    @Override
    public void onGetTasksSuccess(List<Task> tasks) {
        mTaskList = tasks;
        mTaskAdapter.replaceTask(tasks);
    }

    @Override
    public void onGetTaskByIDSuccess() {

    }

    @Override
    public void onAddFailed(String msg) {
    }

    @Override
    public void onDeleteFailed(String msg) {
    }

    @Override
    public void onEditFailed(String msg) {
    }

    @Override
    public void onFinishFailed(String msg) {
    }

    @Override
    public void onGetTasksFailed(String msg) {
    }

    @Override
    public void onGetTaskByIDFailed(String msg) {
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add_button:

                break;
            default:
                break;
        }
    }
}
