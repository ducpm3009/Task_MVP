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
    public void addTask(final List<Task> tasks, String title, String msg) {
        final Task task = new Task(title);
        mTaskRepository.addTask(task, new TaskDataSource.Callback<Integer>() {
            @Override
            public void onSuccess(Integer data) {
                task.setID(data);
                tasks.add(task);
                mView.onAddSuccess(task);
            }

            @Override
            public void onFailed(String msg) {
                mView.onAddFailed("");
            }
        });
    }

    @Override
    public void editTask(final List<Task> tasks, int id, String title, String msg) {
        final Task task = new Task(title);
        mTaskRepository.editTask(id, title, new TaskDataSource.Callback<Integer>() {
            @Override
            public void onSuccess(Integer data) {
                task.setID(data);
                tasks.add(task);
                mView.onEditSuccess(task);
            }

            @Override
            public void onFailed(String msg) {
                mView.onEditFailed("");
            }
        });
    }

    @Override
    public void deleteTask(final int id, String msg) {
        mTaskRepository.deleteTask(id, new TaskDataSource.Callback<Integer>() {


            @Override
            public void onSuccess(Integer data) {
                mView.onDeleteSuccess();
            }

            @Override
            public void onFailed(String msg) {
                mView.onDeleteFailed(msg);
            }
        });
    }

    @Override
    public void finishTask(List<Task> tasks, String title, String msg) {
    }

    @Override
    public void getTaskByID(final List<Task> tasks, int id, String msg) {
        mTaskRepository.getTaskByID(id, new TaskDataSource.Callback<Task>() {
            @Override
            public void onSuccess(Task data) {
                mView.onGetTaskByIDSuccess();
            }

            @Override
            public void onFailed(String msg) {
                mView.onGetTaskByIDFailed("");
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
                mView.onGetTasksFailed("");
            }
        });
    }
}
