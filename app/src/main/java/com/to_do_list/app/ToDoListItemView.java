package com.to_do_list.app;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Menace on 2/7/14.
 */
public class ToDoListItemView extends TextView {
    public ToDoListItemView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public ToDoListItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ToDoListItemView(Context context) {
        super(context);
        init();
    }


    private Paint _marginPaint;
    private Paint _linePaint;
    private int _paperColor;
    private float _margin;

    //
    private void init() {
        // get a reference ot the resources table
        Resources myResources = getResources();

        // create the brush
        _marginPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        _linePaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        _marginPaint.setColor(myResources.getColor(R.color.notepad_margin));
        _linePaint.setColor(myResources.getColor(R.color.notepad_lines));
        _paperColor = myResources.getColor(R.color.notepad_paper);

        _margin = myResources.getDimension(R.dimen.notepad_margin);
    }

    @Override
    public void onDraw(Canvas canvas) {
        // color the paper
        canvas.drawColor(_paperColor);

        // draw ruled lines
        canvas.drawLine(0, 0, 0, getMeasuredHeight(), _linePaint);
        canvas.drawLine(0, getMeasuredHeight(), getMeasuredWidth(), getMeasuredHeight(), _linePaint);

        // draw the margin
        canvas.drawLine(_margin, 0, _margin, getMeasuredHeight(), _marginPaint);

        // move the text across from the margin
        canvas.save();
        canvas.translate(_margin, 0);

        // use the base textview to render the text
        super.onDraw(canvas);
        canvas.restore();
    }
}
