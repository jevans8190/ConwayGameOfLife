package com.example.jevan.conwaygol;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;

/**
 * PixelGridView.java
 *
 * A view representing a grid of cells whose size
 * can change dynamically.
 *
 * Created by Jack Evans on 8/1/2016.
 */
public class PixelGridView extends View{
    private ScaleGestureDetector mScaleDetector;
    private int numCols, numRows;
    private int cellWidth, cellHeight;
    private int mode;
    private float mScaleFactor = 1.f;
    private float oldDist;
    private Paint blackPaint = new Paint();
    private boolean[][] checked;

    // Modes
    private final static int NORMAL = 1;
    private final static int DRAG = 2;
    private final static int ZOOM = 3;

    // Log tag
    private final static String LOG_TAG = PixelGridView.class.getSimpleName();

    public PixelGridView(Context context) {
        super(context, null);
        mScaleDetector = new ScaleGestureDetector(context, new ScaleListener());
    }

    public PixelGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setNumCols(int numCols) {
        this.numCols = numCols;
        calculateDimensions();
    }

    public int getNumCols() {
        return this.numCols;
    }

    public void setNumRows(int numRows) {
        this.numRows = numRows;
        calculateDimensions();
    }

    public int getNumRows() {
        return this.numRows;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        calculateDimensions();
    }

    private void calculateDimensions() {
        if (numRows < 1 || numCols < 1) {
            return;
        }

        cellWidth = getWidth() / numCols;
        cellHeight = getHeight() / numRows;

        checked = new boolean[numCols][numRows];
        invalidate();
    }

    @Override
    public void onDraw(Canvas canvas) {
        canvas.drawColor(Color.WHITE);

        if (numRows == 0 || numCols == 0) {
            return;
        }

        int width = getWidth();
        int height = getHeight();

        for (int i = 0; i < numCols; i++) {
            for (int j = 0; j < numRows; j++) {
                if (checked[i][j]) {
                    canvas.drawRect(
                            i * cellWidth,
                            j * cellHeight,
                            (i+1) * cellWidth,
                            (j+1) * cellHeight,
                            blackPaint);
                }
            }
        }

        for (int i = 1; i < numCols; i++) {
            canvas.drawLine(i * cellWidth, 0, i*cellWidth, height, blackPaint);
        }

        for (int i = 1; i < numRows; i ++) {
            canvas.drawLine(0, i * cellHeight , width, i*cellHeight, blackPaint);
        }

        canvas.save();
        canvas.scale(mScaleFactor, mScaleFactor);
        canvas.restore();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mScaleDetector.onTouchEvent(event);
        return true;
    }

    private float spacing(MotionEvent event) {
        float x = event.getX(0) - event.getX(1);
        float y = event.getY(0) - event.getY(1);
        return (float) Math.sqrt(x*x + y*y);
    }

    private class ScaleListener
            extends ScaleGestureDetector.SimpleOnScaleGestureListener {

        @Override
         public boolean onScale(ScaleGestureDetector detector) {
             mScaleFactor *= detector.getScaleFactor();

             // limit the range of the scale factor
             mScaleFactor = Math.max(0.1f, Math.min(mScaleFactor, 5.0f));

             Log.d(LOG_TAG, "New scale: " + mScaleFactor);
             invalidate();
             return true;
         }
    }
}