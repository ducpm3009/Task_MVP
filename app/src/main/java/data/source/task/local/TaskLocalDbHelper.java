package data.source.task.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ducpm on 09/07/17.
 */
public class TaskLocalDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Task.db";
    private static final String SQL_CREATE_TASK = "CREATE TABLE "
            + TaskLocalContract.TaskEntry.TABLE_NAME
            + " ("
            + TaskLocalContract.TaskEntry._ID
            + " INTEGER PRIMARY KEY,"
            + TaskLocalContract.TaskEntry.COLUMN_TITLE
            + " TEXT)";
    private static final String SQL_DELETE_TASK =
            "DROP TABLE IF EXISTS " + TaskLocalContract.TaskEntry.TABLE_NAME;

    public TaskLocalDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_TASK);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQL_DELETE_TASK);
        sqLiteDatabase.execSQL(SQL_CREATE_TASK);
    }
}
