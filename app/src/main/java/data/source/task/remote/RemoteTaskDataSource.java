package data.source.task.remote;

import data.model.Task;
import data.source.task.TaskDataSource;

/**
 * Created by ducpm on 09/07/17.
 */
public class RemoteTaskDataSource implements TaskDataSource {
    @Override
    public void addTask(Task task, Callback<Boolean> callback) {

    }

    @Override
    public void editTask(int id, String title, Callback<Boolean> callback) {
    }

    @Override
    public void deleteTask(Task task, Callback<Boolean> callback) {
    }

    @Override
    public void finishTask(Task task, Callback<Boolean> callback) {
    }

    @Override
    public void getTasks(Callbacks<Task> callbacks) {
    }

    @Override
    public void getTaskByID(int id, Callback<Task> callback) {
    }

    @Override
    public void getTaskByName(String name, Callbacks<Task> callbacks) {
    }
}
