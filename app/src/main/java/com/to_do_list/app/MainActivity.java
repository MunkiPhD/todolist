package com.to_do_list.app;


import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class MainActivity extends Activity
        implements NewItemFragment.IOnNewItemAddedListener {

    private ArrayList<String> _toDoItems;
    private ArrayAdapter<String> _adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _toDoItems = new ArrayList<String>();

        FragmentManager fragmentManager = getFragmentManager();
        ToDoListFragment toDoListFragment = (ToDoListFragment) fragmentManager.findFragmentById(R.id.ToDoListFragment);

        _adapter = new ArrayAdapter<String>(this, R.layout.todolist_item, _toDoItems);
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
        _toDoItems.add(newItem);
        _adapter.notifyDataSetChanged();
    }
}
