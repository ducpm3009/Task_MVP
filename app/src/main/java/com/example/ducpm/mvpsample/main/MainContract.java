package com.example.ducpm.mvpsample.main;

import java.util.List;

import data.model.Task;

/**
 * Created by ducpm on 09/07/17.
 */
public interface MainContract {
    interface View {
        void onAddSuccess(Task task);

        void onDeleteSuccess(int id);

        void onEditSuccess(Task task);

        void onFinishSuccess(Task task);

        void onGetTasksSuccess(List<Task> tasks);

        void onGetTaskByIDSuccess();

        void onAddFailed(String msg);

        void onDeleteFailed(String msg);

        void onEditFailed(String msg);

        void onFinishFailed(String msg);

        void onGetTasksFailed(String msg);

        void onGetTaskByIDFailed(String msg);
    }

    interface Presenter {
        void addTask( Task task, String msg);

        void editTask( int id, String title, String msg);

        void deleteTask(int id, String msg);

        void finishTask(String title, String msg);

        void getTaskByID( int id, String msg);

        void getTasks();

        void detachView();
    }
}
