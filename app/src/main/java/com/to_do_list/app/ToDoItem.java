package com.to_do_list.app;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Menace on 2/11/14.
 */
public class ToDoItem {
    String task;
    Date created;


    public String getTask(){
        return task;
    }

    public Date getCreated(){
        return created;
    }

    public ToDoItem(String task){
        this(task, new Date(java.lang.System.currentTimeMillis()));
    }

    public ToDoItem(String task, Date created){
        this.task = task;
        this.created = created;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy");
        String dateString = dateFormat.format(created);
        return "(" + dateString + ") " + task;
    }
}
