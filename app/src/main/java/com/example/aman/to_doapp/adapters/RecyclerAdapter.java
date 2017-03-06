package com.example.aman.to_doapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.aman.to_doapp.R;
import com.example.aman.to_doapp.interfaces.IPresenter;
import com.example.aman.to_doapp.models.Todo;

/**
 * Created by Aman on 2/24/17.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.DemoViewHolder> {

    IPresenter presenter;

    // inject (pass in) the presenter.
    // the presenter is where we get the data for this adapter.
    // the presenter holds the model, so we ask the presenter for data,
    // the presenter then asks the model for data, and the model asks the data source
    public RecyclerAdapter(final IPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public DemoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // inflate the view holder here
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_list_item, parent, false);
        return new DemoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DemoViewHolder holder, int position) {
        // find the right item in the collection using the position and bind the view to the Thing
        Todo todo = presenter.getTodos().get(position);
        holder.bind(todo);
    }

    @Override
    public int getItemCount() {
        return presenter.getTodos().size();
    }




    class DemoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        TextView name;
        TextView content;
        TextView dueDate;
        CheckBox completed;
        Todo todo;

        public DemoViewHolder(View todoView) {
            super(todoView);
            name = (TextView)todoView.findViewById(R.id.TodoItemNameTextView);
            content = (TextView)todoView.findViewById(R.id.TodoItemContentTextView);
            dueDate = (TextView)todoView.findViewById(R.id.TodoItemDueDateTextView);
            completed = (CheckBox)todoView.findViewById(R.id.TodoItemCompletedCheckBox);
        }

        public void bind(Todo todo1) {
            todo = todo1;
            name.setText(todo.getName());
            content.setText(todo.getContents());
            dueDate.setText(todo.getDueDate());
            completed.setChecked(todo.isCompleted());
            name.setOnClickListener(this);
            name.setOnLongClickListener(this);
            content.setOnClickListener(this);
            content.setOnLongClickListener(this);
            dueDate.setOnClickListener(this);
            dueDate.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View view) {
            switch(view.getId()){
                case R.id.TodoItemNameTextView:
                case R.id.TodoItemContentTextView:
                case R.id.TodoItemDueDateTextView:
                    presenter.handleClick(getAdapterPosition());
                    break;
            }
        }

        @Override
        public boolean onLongClick(View view) {
            switch(view.getId()) {
                case R.id.TodoItemNameTextView:
                case R.id.TodoItemContentTextView:
                case R.id.TodoItemDueDateTextView:
                    presenter.handleLongPress(getAdapterPosition());
                    break;
            }
            return false;
        }

    }
}