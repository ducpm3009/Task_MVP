package data.source.task;

import data.model.Task;

/**
 * Created by ducpm on 09/07/17.
 */
public class TaskRepository implements TaskDataSource{
    private TaskDataSource mLocalDataSource;
    @Override
    public void addTask(Task task, Callback<Boolean> callback) {

    }

    @Override
    public void editTask(Task task, Callback<Boolean> callback) {
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
