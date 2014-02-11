package com.to_do_list.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Menace on 2/11/14.
 */
public class ToDoItemAdapter extends ArrayAdapter<ToDoItem> {
    int resource;

    public ToDoItemAdapter(Context context, int resource, List<ToDoItem> items){
        super(context, resource, items);
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout todoView;
        ToDoItem item = getItem(position);

        String taskString = item.getTask();
        Date createdDate = item.getCreated();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy");
        String dateString = dateFormat.format(createdDate);

        if(convertView == null){
            todoView = new LinearLayout(getContext());
            String inflater = Context.LAYOUT_INFLATER_SERVICE;
            LayoutInflater li = (LayoutInflater) getContext().getSystemService(inflater);
            li.inflate(resource, todoView, true);
        } else {
            todoView = (LinearLayout) convertView;
        }

        TextView dateView = (TextView) todoView.findViewById(R.id.rowDate);
        TextView taskView = (TextView) todoView.findViewById(R.id.row);

        dateView.setText(dateString);
        taskView.setText(taskString);

        return todoView;
    }
}
