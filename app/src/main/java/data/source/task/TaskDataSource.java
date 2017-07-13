package data.source.task;

import java.util.List;

import data.model.Task;

/**
 * Created by ducpm on 09/07/17.
 */
public interface TaskDataSource {
    void addTask(Task task, Callback<Integer> callback);

    void editTask(int id, String title, Callback<Integer> callback);

    void deleteTask(int id, Callback<Integer> callback);

    void finishTask(Task task, Callback<Integer> callback);

    void getTasks(Callbacks<Task> callbacks);

    void getTaskByID(int id, Callback<Task> callback);

    void getTaskByName(String name, Callbacks<Task> callbacks);

    interface Callback<T> {
        void onSuccess(T data);

        void onFailed(String msg);
    }

    interface Callbacks<T> {
        void onSuccess(List<T> data);

        void onFailed(String msg);
    }
}
