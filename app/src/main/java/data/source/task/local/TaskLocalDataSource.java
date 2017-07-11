package data.source.task.local;

import data.model.Task;
import data.source.task.TaskDataSource;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ducpm on 09/07/17.
 */
public class TaskLocalDataSource extends TaskLocalDbHelper
        implements TaskDataSource, TaskDataSource.Callback, TaskDataSource.Callbacks {
    public static TaskDataSource mSource;

    public static TaskDataSource createTaskDataSource(Context context) {
        if (mSource == null) {
            mSource = new TaskLocalDataSource(context);
        }
        return mSource;
    }

    public TaskLocalDataSource(Context context) {
        super(context);
    }

    @Override
    public void addTask(Task task, Callback<Integer> callback) {
        if (task == null) callback.onFailed("action failed");
        SQLiteDatabase db = getWritableDatabase();
        long result =
                db.insert(TaskLocalContract.TaskEntry.TABLE_NAME, null, task.getContentValues());
        db.close();
        callback.onSuccess((int) result);
    }

    @Override
    public void editTask(int id, String title, Callback<Integer> callback) {
        SQLiteDatabase db = getWritableDatabase();
        String[] whereClauseArgs = new String[] { String.valueOf(id) };
        ContentValues contentValues = new ContentValues();
        contentValues.put(TaskLocalContract.TaskEntry.TABLE_NAME, title);
        int result = db.update(TaskLocalContract.TaskEntry.TABLE_NAME, contentValues,
                TaskLocalContract.TaskEntry._ID + "=?", whereClauseArgs);
        db.close();
    }

    @Override
    public void deleteTask(int id, Callback<Integer> callback) {
        String[] whereClauseArgs = new String[] { String.valueOf(id) };
        SQLiteDatabase db = getWritableDatabase();
        long result = db.delete(TaskLocalContract.TaskEntry.TABLE_NAME,
                TaskLocalContract.TaskEntry._ID + "=?", whereClauseArgs);
        db.close();
        if (result > 0) {
            callback.onSuccess((int) result);
        } else {
            callback.onFailed("delete failed");
        }
    }

    @Override
    public void finishTask(Task task, Callback<Integer> callback) {
    }

    @Override
    public void getTasks(Callbacks<Task> callbacks) {
        List<Task> tasks = new ArrayList<>();
        SQLiteDatabase db = getWritableDatabase();
        String[] columns = {
                TaskLocalContract.TaskEntry._ID, TaskLocalContract.TaskEntry.COLUMN_TITLE,
        };
        Cursor c = db.query(TaskLocalContract.TaskEntry.TABLE_NAME, columns, null, null, null, null,
                null, null);
        if (c != null && c.moveToFirst()) {
            do {
                int taskId = c.getInt(c.getColumnIndex(TaskLocalContract.TaskEntry._ID));
                String title =
                        c.getString(c.getColumnIndex(TaskLocalContract.TaskEntry.COLUMN_TITLE));
                Task task = new Task(title);
                tasks.add(task);
            } while (c.moveToNext());
        }
        if (c != null) {
            c.close();
        }
        db.close();
        if (tasks.isEmpty()) {
            callbacks.onFailed("");
        } else {
            callbacks.onSuccess(tasks);
        }
    }

    @Override
    public void getTaskByID(int id, Callback<Task> callback) {
        SQLiteDatabase db = getWritableDatabase();
        String[] projection = {
                TaskLocalContract.TaskEntry.TABLE_NAME, TaskLocalContract.TaskEntry.COLUMN_TITLE,
        };
        String selection = TaskLocalContract.TaskEntry._ID + "= ?";
        String[] selectionArgs = { String.valueOf(id) };
        Cursor c = db.query(TaskLocalContract.TaskEntry.TABLE_NAME, projection, selection,
                selectionArgs, null, null, null);
        Task task = null;
        if (c != null && c.getCount() > 0) {
            c.moveToFirst();
            int taskID = c.getInt(c.getColumnIndexOrThrow(TaskLocalContract.TaskEntry._ID));
            String title =
                    c.getString(c.getColumnIndexOrThrow(TaskLocalContract.TaskEntry.COLUMN_TITLE));
            task = new Task(title);
        }
        if (c != null) {
            c.close();
        }
        db.close();
        if (task != null) {
            callback.onSuccess(task);
        } else {
            callback.onFailed("action failed");
        }
    }

    @Override
    public void getTaskByName(String name, Callbacks<Task> callbacks) {
        // TODO: 09/07/17  
    }

    @Override
    public void onSuccess(Object data) {
    }

    @Override
    public void onSuccess(List data) {
    }

    @Override
    public void onFailed(String msg) {
    }
}