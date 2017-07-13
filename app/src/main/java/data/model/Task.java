package data.model;

import android.content.ContentValues;
import android.database.Cursor;

import data.source.task.local.TaskLocalContract;

/**
 * Created by ducpm on 09/07/17.
 */
public class Task {
    private String mTitle;
    private int mID;

    public Task(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public Task(Cursor cursor) {
        mTitle = cursor.getString(cursor.getColumnIndex(TaskLocalContract.TaskEntry.COLUMN_TITLE));
        mID = cursor.getInt(cursor.getColumnIndex(TaskLocalContract.TaskEntry._ID));
    }

    public int getID() {
        return mID;
    }

    public void setID(int mID) {
        this.mID = mID;
    }

    public ContentValues getContentValues() {
        ContentValues contentValues = new ContentValues();
        if (mTitle != null) {
            contentValues.put(TaskLocalContract.TaskEntry.COLUMN_TITLE, mTitle);
        }
        if (mID != 0) {
            contentValues.put(TaskLocalContract.TaskEntry._ID, mID);
        }
        return contentValues;
    }
}
