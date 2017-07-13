package com.example.ducpm.mvpsample.main;

import java.util.List;

import data.model.Task;
import data.source.task.TaskDataSource;

/**
 * Created by ducpm on 09/07/17.
 */
public class MainPresenter implements MainContract.Presenter {
    private MainContract.View mView;
    private TaskDataSource mTaskRepository;

    public MainPresenter(MainContract.View view, TaskDataSource taskRepository) {
        this.mView = view;
        this.mTaskRepository = taskRepository;
    }

    @Override
    public void addTask(final Task task, String msg) {
        mTaskRepository.addTask(task, new TaskDataSource.Callback<Integer>() {
            @Override
            public void onSuccess(Integer data) {
                mView.onAddSuccess(task);
            }

            @Override
            public void onFailed(String msg) {
                mView.onAddFailed(msg);
            }
        });
    }

    @Override
    public void editTask(final int id, final String title, String msg) {
        mTaskRepository.editTask(id, title, new TaskDataSource.Callback<Integer>() {
            @Override
            public void onSuccess(Integer data) {
                mView.onEditSuccess(new Task(title));
            }

            @Override
            public void onFailed(String msg) {
                mView.onEditFailed(msg);
            }
        });
    }

    @Override
    public void deleteTask(final int id, String msg) {
        mTaskRepository.deleteTask(id, new TaskDataSource.Callback<Integer>() {

            @Override
            public void onSuccess(Integer data) {
                mView.onDeleteSuccess(data);
            }

            @Override
            public void onFailed(String msg) {
                mView.onDeleteFailed(msg);
            }
        });
    }

    @Override
    public void finishTask(String title, String msg) {

    }

    @Override
    public void getTaskByID( int id, String msg) {
        mTaskRepository.getTaskByID(id, new TaskDataSource.Callback<Task>() {
            @Override
            public void onSuccess(Task data) {
                mView.onGetTaskByIDSuccess();
            }

            @Override
            public void onFailed(String msg) {
                mView.onGetTaskByIDFailed(msg);
            }
        });
    }

    @Override
    public void getTasks() {
        mTaskRepository.getTasks(new TaskDataSource.Callbacks<Task>() {
            @Override
            public void onSuccess(List<Task> data) {
                mView.onGetTasksSuccess(data);
            }

            @Override
            public void onFailed(String msg) {
                mView.onGetTasksFailed(msg);
            }
        });
    }

    @Override
    public void detachView() {
        this.mView = null;
    }
}
