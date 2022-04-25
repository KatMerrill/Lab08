package com.example.lab08;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class DrawView extends View {
    Paint p = new Paint();
    public DrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    // y vars = current position, dy = change in pos
    int dy = 3;
    int[] y_pos = new int[]{0, 700, 1200, 1800};

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float h_center = getWidth()*.5f;

        // FLOWER ONE: Blue
        // leaves
        p.setColor(Color.parseColor("#adedaf"));
        canvas.save();
        for(int rot = 0; rot < 3; rot++) {
            canvas.rotate(60, h_center, y_pos[0]);
            canvas.drawOval(h_center - 400, y_pos[0], h_center, y_pos[0] + 200, p);
        }
        canvas.restore();
        // petals
        p.setColor(Color.parseColor("#8cd9fa"));
        for(int rot = 0; rot < 9; rot++) {
            canvas.rotate(40, h_center, y_pos[0]);
            canvas.drawOval(h_center - 350, y_pos[0] - 100, h_center, y_pos[0] + 100, p);
        }
        // center
        p.setColor(Color.parseColor("#f7eb9c"));
        canvas.drawCircle(h_center, y_pos[0], 70, p);

        // FLOWER TWO: Yellow
        h_center = getWidth()*.3f;
        //petals
        p.setColor(Color.parseColor("#ffe057"));
        for(int rot = 0; rot < 8; rot++) {
            canvas.rotate(45, h_center, y_pos[1]);
            canvas.drawOval(h_center - 250, y_pos[1] - 50, h_center, y_pos[1] + 50, p);
        }
        // center
        p.setColor(Color.parseColor("#f0f4f5"));
        canvas.drawCircle(h_center, y_pos[1], 30, p);

        // FLOWER THREE: Purple
        // petals
        h_center = getWidth()*.7f;
        p.setColor(Color.parseColor("#daaeeb"));
        for(int rot = 0; rot < 5; rot++) {
            canvas.rotate(360f/5, h_center, y_pos[2]);
            canvas.drawOval(h_center - 250, y_pos[2] - 100, h_center, y_pos[2] + 100, p);
        }
        // center
        p.setColor(Color.parseColor("#f7eb9c"));
        canvas.drawCircle(h_center, y_pos[2], 50, p);

        // FLOWER FOUR: White
        h_center = getWidth()*.2f;
        p.setColor(Color.parseColor("#f0f4f5"));
        for(int rot = 0; rot < 5; rot++) {
            canvas.rotate(360f/5, h_center, y_pos[3]);
            canvas.drawOval(h_center - 150, y_pos[3] - 50, h_center, y_pos[3] + 50, p);
        }


        // for animation of all flowers
        for(int x = 0; x < y_pos.length; x++) {
            y_pos[x] += dy;
            if(y_pos[x] - 350 > getHeight())
                y_pos[x] = -350;
        }

        invalidate();
    }
}
