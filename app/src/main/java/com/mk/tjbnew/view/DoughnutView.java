package com.mk.tjbnew.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;

import com.mk.tjbnew.R;

/**
 * 圆环按钮自定义View
 * */
public class DoughnutView extends View {
    //View默认最小宽度
    private static final int DEFAULT_MIN_WIDTH = 400;
    //圆环颜色
    private int[] doughnutColors = new int[]{Color.GREEN, Color.YELLOW, Color.RED};

    private int width;
    private int height;
    private float currentValue = 0f;
    private Paint paint = new Paint();

    public DoughnutView(Context context) {
        super(context);
    }

    public DoughnutView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DoughnutView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void resetParams() {
        width = getWidth();
        height = getHeight();
    }

    private void initPaint() {
        paint.reset();
        paint.setAntiAlias(true);
    }

    public void setValue(float value) {
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(currentValue, value);
        valueAnimator.setDuration(300);
        valueAnimator.setInterpolator(new Interpolator() {
            @Override
            public float getInterpolation(float v) {
                return 1-(1-v)*(1-v)*(1-v);
            }
        });
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                currentValue = (float) valueAnimator.getAnimatedValue();
                invalidate();
            }
        });
        valueAnimator.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        resetParams();
        //画背景色#f43334圆环
        initPaint();
        float doughnutWidth = Math.min(width, height) / 2 * 0.4f;
        paint.setStrokeWidth(doughnutWidth);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(getResources().getColor(R.color.color_orange));//Color.WHITE
        paint.setAntiAlias(true);
        RectF rectF = new RectF((width > height ? Math.abs(width - height) / 2 : 0) + doughnutWidth / 2,   //left
                (height > width ? Math.abs(height - width) / 2 : 0) + doughnutWidth / 2,     //top
                width - (width > height ? Math.abs(width - height) / 2 : 0) - doughnutWidth / 2,   //right
                height - (height > width ? Math.abs(height - width) / 2 : 0) - doughnutWidth / 2);  //bottom
        canvas.drawArc(rectF, 0, 360, false, paint);

        //画彩色圆环
        initPaint();
        //旋转:顺时针旋转 -90为旋转的角度
        canvas.rotate(-90, width / 2, height / 2);
        /**
         * 设置空心线宽
         【功能说明】该方法用于设置画笔的空心线宽。该方法在矩形、圆形等图形上有明显的效果。
         【基本语法】public void setStrokeWidth (float width)
         其中，参数width为线宽，浮点型数据。
         * */
        paint.setStrokeWidth(doughnutWidth);
        paint.setStyle(Paint.Style.STROKE);
        if (doughnutColors.length > 1) {
            paint.setShader(new SweepGradient(width / 2, height / 2, doughnutColors, null));
        } else {
            paint.setColor(doughnutColors[0]);
        }
        /**public void drawArc(RectF oval, float startAngle, float sweepAngle, boolean useCenter, Paint paint)
         oval :指定圆弧的外轮廓矩形区域。
         startAngle: 圆弧起始角度，单位为度。
         sweepAngle: 圆弧扫过的角度，顺时针方向，单位为度。
         useCenter: 如果为True时，在绘制圆弧时将圆心包括在内，通常用来绘制扇形。
         paint: 绘制圆弧的画板属性，如颜色，是否填充等。*/
        canvas.drawArc(rectF, 0, currentValue, false, paint);

        //画中间数值的背景
        int fontSize = 50;
        initPaint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.WHITE);
//        canvas.drawCircle(width / 2, height / 2, fontSize * 2, paint);
        /**
         * 该方法用于在画布上绘制圆形，通过指定圆形圆心的坐标和半径来实现。该方法是绘制圆形的主要方法，同时也可以通过设置画笔的空心效果来绘制空心的圆形。
         * public void drawCircle (float cx, float cy, float radius, Paint paint)
         * cx：圆心的x坐标。 cy：圆心的y坐标。 radius：圆的半径。 paint：绘制时所使用的画笔。
         * */
        canvas.drawCircle(width / 2, height / 2, doughnutWidth * 1.45f , paint);

        //画中间数值
        canvas.rotate(90, width / 2, height / 2);
        initPaint();
        paint.setColor(ColorUtils.getCurrentColor(currentValue / 360f, doughnutColors));
        paint.setTextSize(fontSize);
        paint.setTextAlign(Paint.Align.CENTER);
        float baseLine = height / 2 - (paint.getFontMetrics().descent + paint.getFontMetrics().ascent) / 2;
//        canvas.drawText((int) (currentValue / 360f * 100) + "%", width / 2, baseLine, paint);
        canvas.drawText("快速体检", width / 2, baseLine, paint);
    }

    /**
     * 当布局为wrap_content时设置默认长宽
     *
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(measure(widthMeasureSpec), measure(heightMeasureSpec));
    }

    private int measure(int origin) {
        int result = DEFAULT_MIN_WIDTH;
        int specMode = MeasureSpec.getMode(origin);
        int specSize = MeasureSpec.getSize(origin);
        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        } else {
            if (specMode == MeasureSpec.AT_MOST) {
                result = Math.min(result, specSize);
            }
        }
        return result;
    }

}