package data.source.task.local;

import android.provider.BaseColumns;

/**
 * Created by ducpm on 09/07/17.
 */
public class TaskLocalContract {
    public static class TaskEntry implements BaseColumns {
        public static final String TABLE_NAME = "table_task";
        public static final String COLUMN_TITLE = "task_title";
    }
}
