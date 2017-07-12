package com.example.ducpm.mvpsample.main;

import android.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.example.ducpm.mvpsample.R;
import data.model.Task;
import java.util.List;

/**
 * Created by ducpm on 10/07/17.
 */
public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {
    private List<Task> mTaskList;
    private MainContract.Presenter mPresenter;
    private RecyclerView mRecyclerView;

    public TaskAdapter(List<Task> mTaskList, MainContract.Presenter mPresenter,
            RecyclerView mRecyclerView) {
        this.mTaskList = mTaskList;
        this.mPresenter = mPresenter;
        this.mRecyclerView = mRecyclerView;
    }

    public List<Task> getTaskList() {
        return mTaskList;
    }

    public void setTaskList(List<Task> mTaskList) {
        this.mTaskList = mTaskList;
    }

    @Override
    public TaskAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_dialog, parent, false);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final int position = mRecyclerView.getChildAdapterPosition(view);
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                View dialogView =
                        LayoutInflater.from(view.getContext()).inflate(R.layout.item_dialog, null);
                final EditText editTitle = dialogView.findViewById(R.id.edit_title);
                editTitle.setText(mTaskList.get(position).getTitle());

                builder.setView(dialogView).setTitle("Update Task");

                builder.create().show();
            }
        });
        return new ViewHolder(v);
    }

    public void replaceTask(List<Task> newData) {
        setTaskList(newData);
        notifyDataSetChanged();
    }

    public void replaceData(List<Task> newData) {
        setTaskList(newData);
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(TaskAdapter.ViewHolder holder, int position) {
        holder.bindData(mTaskList.get(position));
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.text_title);
            itemView.findViewById(R.id.button_delete).setOnClickListener(this);
        }

        public void bindData(Task task) {
            if (task != null) {
                mTitle.setText(task.getTitle());
            }
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.button_delete:
                    mPresenter.deleteTask(mTaskList.get(getAdapterPosition()).getID(), null);
                    break;
            }
        }
    }
}
