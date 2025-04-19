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
import com.omer.yaellastfinal.model.BallPuzzleGame;
import com.omer.yaellastfinal.model.ColorBall;
import com.omer.yaellastfinal.model.Jar;

import java.util.HashMap;
import java.util.Map;

public class MyCanvasView extends View {


    private Paint paint;
    private Bitmap bitmapJar;


    private Map<ColorBall, Bitmap> mapBitmapBalls = new HashMap<>();


    Controller controller;

    private final int X_JARS_START = 10;
    private final int Y_JARS_START = 250;
    private final int JAR_WIDTH = 230;
    private final int JAR_HEIGHT = 550;
    private final int JAR_MARGIN_HORIZONTAL = 20;
    private final int JAR_MARGIN_VERTICAL = 30;
    private final int MAX_JARS_IN_LINE = 4;



    private final int BALL_WIDTH = JAR_WIDTH - 120;
    private final int BALL_HEIGHT = BALL_WIDTH;
    private final int BALL_MARGIN_BOTTOM = 1;

    private int num_lines_of_jars = 0;

    Context context;

    ColorBall[] ballColors = {ColorBall.BLUE, ColorBall.LIGHTBLUE, ColorBall.LIGHTPINK,
            ColorBall.LIGHTPURPLE, ColorBall.PINK, ColorBall.PURPLE, ColorBall.YELLOW,
            ColorBall.RED, ColorBall.GREEN, ColorBall.ORANGE};


    public void setController(Controller controller) {
        this.controller = controller;
    }

    private Map<ColorBall, Integer> mapBallColorToDrawableId =
        Map.of(ColorBall.BLUE, R.drawable.ballblue,
                ColorBall.GREEN, R.drawable.ballgreen,
                ColorBall.LIGHTBLUE, R.drawable.balllightblue,
                ColorBall.LIGHTPINK, R.drawable.balllightpink,
                ColorBall.LIGHTPURPLE, R.drawable.balllightpurple,
                ColorBall.PINK, R.drawable.ballpink,
                ColorBall.PURPLE, R.drawable.ballpurple,
                ColorBall.YELLOW, R.drawable.ballyellow,
                ColorBall.RED, R.drawable.ballred,
                ColorBall.ORANGE, R.drawable.ballorange);


//    private int getBallImage(Ball ball) {
//        if (ball.getColor() == ColorBall.BLUE)
//            return R.drawable.ballblue;
//        if (ball.getColor() == ColorBall.GREEN)
//            return R.drawable.ballgreen;
//        if (ball.getColor() == ColorBall.LIGHTBLUE)
//            return R.drawable.balllightblue;
//        if (ball.getColor() == ColorBall.LIGHTPINK)
//            return R.drawable.balllightpink;
//        if (ball.getColor() == ColorBall.LIGHTPURPLE)
//            return R.drawable.ballpurple;
//        if (ball.getColor() == ColorBall.PURPLE)
//            return R.drawable.ballpink;
//        if (ball.getColor() == ColorBall.PINK)
//            return R.drawable.ballpurple;
//        if (ball.getColor() == ColorBall.YELLOW)
//            return R.drawable.ballyellow;
//        if (ball.getColor() == ColorBall.RED)
//            return R.drawable.ballred;
//        if (ball.getColor() == ColorBall.ORANGE)
//            return R.drawable.ballorange;
//
//        return R.drawable.ballred;
//    }


    public MyCanvasView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    // jars: 4  --> lines: 2
    // jars: 5  --> lines: 2


    private void init(Context context) {

        this.context = context;

        paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(3);
        paint.setStyle(Paint.Style.FILL);

        bitmapJar = BitmapFactory.decodeResource(
                context.getResources(), R.drawable.jar);
        bitmapJar = Bitmap.createScaledBitmap(
                bitmapJar, JAR_WIDTH, JAR_HEIGHT, true);


        Bitmap bitmapBall;
        for (int i=0; i<BallPuzzleGame.MAX_BALLS_COLORS; i++) {
            int ballDrawableId = mapBallColorToDrawableId.get(ballColors[i]);
            bitmapBall = BitmapFactory.decodeResource(
                    context.getResources(), ballDrawableId);
            bitmapBall = Bitmap.createScaledBitmap(
                    bitmapBall, BALL_WIDTH, BALL_HEIGHT, true);
            mapBitmapBalls.put(ballColors[i], bitmapBall);
        }
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //num_of_jars = 4 + 2 * (this.level - 1);
        // num_of_jars is decided by the Game (model)
        int numJars = controller.getBallPuzzleGame().getNumOfJars();

        // num_of_jars is decided in the View
        if (numJars % MAX_JARS_IN_LINE == 0) {
            num_lines_of_jars = numJars / MAX_JARS_IN_LINE;
        } else {
            num_lines_of_jars = numJars / MAX_JARS_IN_LINE + 1;
        }

        // canvas.drawCircle(130, 130, 100, paint);


        canvas.drawColor(Color.WHITE);

        int countJars = 0;
        boolean do_continue = true;
        for (int line = 0; line < num_lines_of_jars && do_continue; line++) {
            int x = X_JARS_START;
            if (line == num_lines_of_jars - 1 &&
                    numJars % MAX_JARS_IN_LINE == 2) {
                x += JAR_WIDTH + JAR_MARGIN_HORIZONTAL;
            }

            int y = Y_JARS_START +
                    line * (JAR_HEIGHT + JAR_MARGIN_VERTICAL);

            for (int numJar = 0; numJar < MAX_JARS_IN_LINE; numJar++) {
                canvas.drawBitmap(bitmapJar, x, y, paint);

                int yBall = y + 70;
                Jar jar = controller.getBallPuzzleGame().getJarsList().get(countJars);
                int numBalls = jar.getBalls().size();
                int missingBallsInJar = Jar.MAX_BALLS_IN_JAR - numBalls;
                yBall += missingBallsInJar * (BALL_HEIGHT + BALL_MARGIN_BOTTOM);
                for (int i = 0; i < jar.getBalls().size(); i++) {
                    Ball ball = jar.getBallsAsList().get(i);
                    //int imageBall = getBallImage(ball);
                    Bitmap bitmapBall = mapBitmapBalls.get(ball.getColor());
                    if (bitmapBall != null) {
                        canvas.drawBitmap(bitmapBall, x + 60, yBall, paint);
                    }
                    yBall += BALL_HEIGHT + BALL_MARGIN_BOTTOM;
                }

                countJars++;

                if (countJars >= numJars) {
                    do_continue = false;
                    break;
                }

                x += JAR_WIDTH + JAR_MARGIN_HORIZONTAL;
            }
        }


    }
}
