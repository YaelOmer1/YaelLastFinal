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

public class MyCanvasView extends View {
    private Paint paint;
    private Bitmap bitmapJar;

    private Bitmap bitmapJarResized;

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
        bitmapJarResized = Bitmap.createScaledBitmap(bitmapJar, 50, 90, true);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);

        canvas.drawCircle(130, 130, 100, paint);

        canvas.drawColor(Color.WHITE);

        if (bitmapJar != null)
        {

            canvas.drawBitmap(bitmapJarResized, 150, 150, paint);
        }
    }
}
