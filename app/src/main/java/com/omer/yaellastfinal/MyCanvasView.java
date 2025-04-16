package com.omer.yaellastfinal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.omer.yaellastfinal.model.Ball;
import com.omer.yaellastfinal.model.ColorBall;

public class MyCanvasView extends View {
    private Paint paint;
    private Bitmap bitmapJar;

    private Bitmap bitmapJarResized;

    private final int X_JARS_START = 10;
    private final int Y_JARS_START = 10;
    private final int JAR_WIDTH = 230;
    private final int JAR_HEIGHT = 500;
    private final int JAR_MARGIN_HORIZONTAL = 20;
    private final int JAR_MARGIN_VERTICAL = 30;
    private final int MAX_JARS_IN_LINE = 4;

    private int num_lines_of_jars = 3;
    private int num_of_jars = 10;

    ColorBall[] ballColors = {ColorBall.BLUE, ColorBall.LIGHTBLUE, ColorBall.LIGHTPINK, ColorBall.LIGHTPURPLE, ColorBall.PINK, ColorBall.PURPLE, ColorBall.YELLOW, ColorBall.RED, ColorBall.GREEN, ColorBall.ORANGE};

    private int getBallImage(Ball ball) {
        if (ball.getColor() == ColorBall.BLUE) {
            return R.drawable.ballblue;
        } else if (ball.getColor() == ColorBall.GREEN) {
            return R.drawable.ballgreen;
        } else if (ball.getColor() == ColorBall.LIGHTBLUE) {
            return R.drawable.balllightblue;
        } else if (ball.getColor() == ColorBall.LIGHTPINK){
            return R.drawable.ballpink;
        } else if (ball.getColor() == ColorBall.LIGHTPURPLE) {
            return R.drawable.ballpurple;
        } else if (ball.getColor() == ColorBall.PINK) {
            return R.drawable.ballpink;
        } else if (ball.getColor() == ColorBall.PURPLE) {
            return R.drawable.ballpurple;
        } else if (ball.getColor() == ColorBall.YELLOW) {
            return R.drawable.ballyellow;
        } else if (ball.getColor() == ColorBall.RED){
               return R.drawable.ballred;
        } else if (ball.getColor() == ColorBall.ORANGE) {
            return R.drawable.ballorange;
        }
        return 0;
    }

    public MyCanvasView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context)
    {

        paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(3);
        paint.setStyle(Paint.Style.FILL);

        bitmapJar = BitmapFactory.decodeResource(
                context.getResources(), R.drawable.jar);
        bitmapJarResized = Bitmap.createScaledBitmap(bitmapJar,
                JAR_WIDTH, JAR_HEIGHT, true);


    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);

        canvas.drawCircle(130, 130, 100, paint);

        canvas.drawColor(Color.WHITE);
        int countJars = 0;
        boolean do_continue = true;
        if (bitmapJar != null)
        {
            for (int line = 0; line < num_lines_of_jars && do_continue; line++) {
                int x = X_JARS_START;
                if (line == num_lines_of_jars-1 &&
                    num_of_jars % MAX_JARS_IN_LINE == 2)
                {
                    x += JAR_WIDTH + JAR_MARGIN_HORIZONTAL;
                }

                int y = Y_JARS_START +
                        line * (JAR_HEIGHT + JAR_MARGIN_VERTICAL);

                for (int numJar = 0; numJar < MAX_JARS_IN_LINE; numJar++)
                {
                    canvas.drawBitmap(bitmapJarResized, x, y, paint);
                    countJars++;

                    if (countJars >= num_of_jars)
                    {
                        do_continue = false;
                        break;
                    }

                    x += JAR_WIDTH + JAR_MARGIN_HORIZONTAL;
                }
            }
        }
    }
}
