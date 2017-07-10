package com.example.ducpm.mvpsample.main;

/**
 * Created by ducpm on 09/07/17.
 */
public interface MainContract {
    interface View {
        void onActionSuccess();
        void onActionFailed();
    }

    interface Presenter {
        void addTask();
        void editTask();
        void deleteTask();
        void finishTask();
    }
}
