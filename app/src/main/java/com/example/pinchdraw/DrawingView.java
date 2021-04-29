package com.example.pinchdraw;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DrawingView extends View {

    private Paint paint;
    private Path path;
    private Circle currentCircle;
    private Line line;
    private List<Circle> circles = new ArrayList<>();
    private List<Line> lines = new ArrayList<>();
    private  List<Path> pathList = new ArrayList<>();
    private Paint circlePaint;
    private Paint backgroundPaint;
 //   private GestureDetector gestureDetector;
    private int activePointerId;
   /* boolean inTouch = false;
    int upPi = 0;
    int downPi = 0;
    float startX = 0;
    float startY = 0;
    float endX = 0;
    float endY = 0;
*/
    public DrawingView(Context context){
        super(context);
    }


    public DrawingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        path = new Path();
        paint.setAntiAlias(true);
        paint.setColor(Color.BLACK);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5f);


    }


    public void clear(){
        circles.clear();
        invalidate();
    }



    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        circlePaint = new Paint();
        backgroundPaint = new Paint();

        Resources resources = getResources();
        int circleColor = resources.getColor(R.color.black);
        int backgroundColor = resources.getColor(R.color.white);

        circlePaint.setColor(circleColor);
        backgroundPaint.setColor(backgroundColor);
        canvas.drawPaint(backgroundPaint); //заполняем фон кругами
        for (Circle circle : circles) {
            float cx = Math.min(circle.getStartPoint().x, circle.getEndPoint().x);
            float cy = Math.max(circle.getStartPoint().y, circle.getEndPoint().y);
            float radius;
            if (cx > cy) {
                radius = cy / 4;
            } else {
                radius = cx / 4;
            }
            canvas.drawCircle(cx, cy, radius, circlePaint);
        }
       /* for(Line line : lines){
            float startX = Math.min(line.getStartX().x, line.getStopX().x);
            float startY= Math.max(line.getStartX().y, line.getStopX().y);

            float endX = Math.min(line.getStartY().x, line.getStopY().x);
            float endY = Math.max(line.getStartX().y, line.getStopX().y);

            canvas.drawLine(startX, startY, endX, endY, paint);
}
*/

       canvas.drawPath(path, paint);
    }


/*
    class MyListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

    }*/


    @Override
    public boolean onTouchEvent(MotionEvent event) {
       PointF current = new PointF(event.getX(), event.getY());
       activePointerId = event.getPointerId(0);

       int pointerIndex = event.findPointerIndex(activePointerId);
       int maskedAction = event.getActionMasked();
       float xPos = event.getX(pointerIndex);
       float yPos = event.getY(pointerIndex);


    //   gestureDetector = new GestureDetector(DrawingView.this.getContext(), new MyListener());

        switch (maskedAction) {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(xPos, yPos);
                /* startX = endX;
                  startY = endY;
                  endX = event.getX();
                  endY = event.getY();*/
                  lines.add(line);
               // inTouch = true;
                invalidate();
            case MotionEvent.ACTION_POINTER_DOWN:
               // downPi = pointerIndex;
                currentCircle = new Circle(current);
                current.x = event.getX(pointerIndex);
                current.y = event.getY(pointerIndex);
                circles.add(currentCircle);

                return true;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(xPos, yPos);
                if(currentCircle != null){
                        currentCircle.setEndPoint(current);

                }
                break;
            case MotionEvent.ACTION_UP:
                //inTouch = false;
                 case MotionEvent.ACTION_POINTER_UP:
              //       upPi = pointerIndex;
                break;
            case MotionEvent.ACTION_CANCEL:
                    currentCircle = null;
                break;

            default:
                return false;
        }
        invalidate();
    // gestureDetector.onTouchEvent(event);
        return true;

    }

}
