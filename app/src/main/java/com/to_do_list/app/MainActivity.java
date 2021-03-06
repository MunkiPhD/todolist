package com.to_do_list.app;

import android.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class MainActivity extends ActionBarActivity
        implements NewItemFragment.IOnNewItemAddedListener {

    private ArrayList<ToDoItem> _toDoItems;
    private ToDoItemAdapter _adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _toDoItems = new ArrayList<ToDoItem>();

        FragmentManager fragmentManager = getFragmentManager();
        ToDoListFragment toDoListFragment = (ToDoListFragment) fragmentManager.findFragmentById(R.id.ToDoListFragment);

        _adapter = new ToDoItemAdapter(this, R.layout.todolist_item, _toDoItems);
        toDoListFragment.setListAdapter(_adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onNewItemAdded(String newItem) {
        ToDoItem newToDoItem = new ToDoItem(newItem);
        _toDoItems.add(0, newToDoItem);
        _adapter.notifyDataSetChanged();
    }
}
