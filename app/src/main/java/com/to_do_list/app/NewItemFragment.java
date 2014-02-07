package com.to_do_list.app;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * Created by Menace on 2/7/14.
 */
public class NewItemFragment extends Fragment {
    private IOnNewItemAddedListener _onNewItemAddedListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.new_item_fragment, container, false);

        final EditText editText = (EditText) view.findViewById(R.id.myEditText);
        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if(keyEvent.getAction() == KeyEvent.ACTION_DOWN){
                    if(i == KeyEvent.KEYCODE_ENTER){
                        String newItem = editText.getText().toString();
                        _onNewItemAddedListener.onNewItemAdded(newItem);
                        editText.setText("");
                        return true;
                    }
                }
                return false;
            }
        });



        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try{
            _onNewItemAddedListener = (IOnNewItemAddedListener) activity;
        }catch(ClassCastException e){
            throw new ClassCastException(activity.toString()  + " must implement the IOnNewItemAddedListener interface");
        }
    }

    public interface IOnNewItemAddedListener{
        public void onNewItemAdded(String newItem);
    }
}
