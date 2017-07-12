package data.source.task;

import data.model.Task;

/**
 * Created by ducpm on 09/07/17.
 */
public class TaskRepository implements TaskDataSource {
    private TaskDataSource mLocalDataSource;
    private TaskDataSource mRemoteDataSource;

    public TaskRepository(TaskDataSource localDataSource, TaskDataSource remoteDataSource) {
        this.mLocalDataSource = localDataSource;
        this.mRemoteDataSource = remoteDataSource;
    }

    @Override
    public void addTask(Task task, Callback<Integer> callback) {
        mLocalDataSource.addTask(task, callback);
        mRemoteDataSource.addTask(task, callback);
    }

    @Override
    public void editTask(int id, String title, Callback<Integer> callback) {
        mLocalDataSource.editTask(id, title, callback);
        mRemoteDataSource.editTask(id, title, callback);
    }

    @Override
    public void deleteTask(int id, Callback<Integer> callback) {
        mLocalDataSource.deleteTask(id, callback);
        mRemoteDataSource.deleteTask(id, callback);
    }

    @Override
    public void finishTask(Task task, Callback<Integer> callback) {
        mLocalDataSource.finishTask(task, callback);
        mRemoteDataSource.finishTask(task, callback);
    }

    @Override
    public void getTasks(final Callbacks<Task> callbacks) {
        mLocalDataSource.getTasks(callbacks);
        mRemoteDataSource.getTasks(callbacks);
    }

    @Override
    public void getTaskByID(final int id, final Callback<Task> callback) {
        mLocalDataSource.getTaskByID(id , callback);
        mRemoteDataSource.getTaskByID(id , callback);
    }

    @Override
    public void getTaskByName(String name, Callbacks<Task> callbacks) {
        mLocalDataSource.getTaskByName(name , callbacks);
        mRemoteDataSource.getTaskByName(name , callbacks);


    }
}
