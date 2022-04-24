package com.example.canvas;

import static android.provider.Settings.System.getString;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;

import androidx.core.content.res.ResourcesCompat;

import java.util.ArrayList;
import java.util.List;

public class MyView extends View {
    Paint paint = null;
    Context context;


    //    private Canvas mCanvas;
//    private Paint mPaint = new Paint();
//    private Paint mPaintText = new Paint(Paint.UNDERLINE_TEXT_FLAG);
//    private Bitmap mBitmap;
//    private ImageView mImageView;
//
//    private Rect mRect = new Rect();
//    private Rect mBounds = new Rect();
//
//    private static final int OFFSET = 120;
//    private int mOffset = OFFSET;
//
//    private static final int MULTIPLIER = 100;
//
    private int mColorBackground;
    private int mColorRectangle;
    private int mColorAccent;


    Drawable imageShaprak, imageIranKish;


    public MyView(Context context) {
        super(context);
        this.context = context;
        paint = new Paint();

        imageShaprak = context.getResources().getDrawable(R.drawable.ic_shaparak);
        imageIranKish = context.getResources().getDrawable(R.drawable.irankish2);

    }

    @SuppressLint("ResourceType")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Typeface typefaceText = Typeface.create(Typeface.createFromAsset(context.getAssets(), "fonts/iran_sans.ttf"), Typeface.BOLD);
        Typeface typefaceNumber = Typeface.create(Typeface.createFromAsset(context.getAssets(), "fonts/irsansfanum.ttf"), Typeface.BOLD);


        mColorBackground = ResourcesCompat.getColor(getResources(),
                R.color.white, null);
        mColorRectangle = ResourcesCompat.getColor(getResources(),
                R.color.teal_200, null);
        mColorAccent = ResourcesCompat.getColor(getResources(),
                R.color.purple_200, null);


        int x = getWidth();
        int y = getHeight();
        int xx = (y - x) / 2;
        Log.e("111", "onDraw: X =" + x);
        Log.e("111", "onDraw: y =" + y);
        Log.e("111", "onDraw: XX =" + xx);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.WHITE);
        canvas.drawPaint(paint);


        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(2);
        canvas.drawLine(0, y / 3, getWidth(), y / 3, paint);
        canvas.drawLine(0, y * 2 / 3, getWidth(), y * 2 / 3, paint);
        canvas.drawLine(0, (y * 11) / 18, getWidth(), (y * 11) / 18, paint);
        canvas.drawLine(0, (y * 15) / 18, getWidth(), (y * 15) / 18, paint);

        // for image
        Rect imageBounds = canvas.getClipBounds();
        imageBounds.set((3 * x) / 4, (int) ((y * 3.5) / 18), x - 20, 5 * y / 18);
        imageShaprak.setBounds(imageBounds);
        imageShaprak.draw(canvas);

        imageBounds.set(20, (int) ((y * 3.5) / 18), (1 * x) / 4, 5 * y / 18);
        imageIranKish.setBounds(imageBounds);
        imageIranKish.draw(canvas);

        imageBounds.set(20, (int) ((y * 3.5) / 18), (1 * x) / 4, 5 * y / 18);
        imageIranKish.setBounds(imageBounds);
        imageIranKish.draw(canvas);


        setText(Color.BLACK, 25, Paint.Align.CENTER, typefaceText, "کارت اعتباری ایران کیش", x / 2, (y * 4) / 18, paint, canvas);
        setText(Color.BLACK, 28, Paint.Align.CENTER, typefaceNumber, "1688", x / 2, (y * 4.7f) / 18, paint, canvas);

        setText(Color.BLACK, 28, Paint.Align.RIGHT, typefaceText, "تست شاپرک", x - 20, (y * 5.6f) / 18, paint, canvas);
        setText(Color.BLACK, 28, Paint.Align.LEFT, typefaceNumber, "Tel : 0251556787", 20, (y * 5.6f) / 18, paint, canvas);


        setText(Color.BLACK, 28, Paint.Align.RIGHT, typefaceText, "خرید", x - 20, (y * 6.5f) / 18, paint, canvas);
        setText(Color.BLACK, 28, Paint.Align.LEFT, typefaceText, "رسید مشتری", 20, (y * 6.5f) / 18, paint, canvas);
        setText(Color.BLACK, 28, Paint.Align.RIGHT, typefaceText, "پایانه", x - 20, (y * 7.5f) / 18, paint, canvas);
        setText(Color.BLACK, 28, Paint.Align.RIGHT, typefaceText, "بانک مسکن", x - 20, (y * 8.5f) / 18, paint, canvas);
        setText(Color.BLACK, 28, Paint.Align.RIGHT, typefaceNumber, "1401/1/29", x - 20, (y * 9.5f) / 18, paint, canvas);
        setText(Color.BLACK, 28, Paint.Align.RIGHT, typefaceText, "پیگیری", x - 20, (y * 10.5f) / 18, paint, canvas);

        setText(Color.BLACK, 28, Paint.Align.LEFT, typefaceNumber, "98088", 20, (y * 7.5f) / 18, paint, canvas);
        setText(Color.BLACK, 28, Paint.Align.LEFT, typefaceNumber, "0574446876", 20, (y * 8.5f) / 18, paint, canvas);
        setText(Color.BLACK, 28, Paint.Align.LEFT, typefaceNumber, "16:54", 20, (y * 9.5f) / 18, paint, canvas);
        setText(Color.BLACK, 28, Paint.Align.LEFT, typefaceNumber, "109", 20, (y * 10.5f) / 18, paint, canvas);

        setText(Color.BLACK, 25, Paint.Align.CENTER, typefaceNumber, "تراکنش نامعتبر است (91)", x / 2, (y * 11.6f) / 18, paint, canvas);

        setText(Color.BLACK, 25, Paint.Align.CENTER, typefaceText, "در صورت کسر وجه از حساب شما مبلغ مذکور ظرف ", x / 2, (y * 12.5f) / 18, paint, canvas);
        setText(Color.BLACK, 25, Paint.Align.CENTER, typefaceText, "72 ساعت به حساب شما عودت خواهد شد در غیر اینصورت", x / 2, (y * 13.5f) / 18, paint, canvas);
        setText(Color.BLACK, 25, Paint.Align.CENTER, typefaceNumber, "  جهت پیگیری لطفا با شماره تلفن 1688 تماس حاصل کنید.", x / 2, (y * 14.5f) / 18, paint, canvas);

        setText(Color.BLACK, 25, Paint.Align.CENTER, typefaceNumber, "9284584/85  4838/345", x / 2, (y * 15.6f) / 18, paint, canvas);


//        String s = "در صورت کسر وجه از حساب شما مبلغ مذکور ظرف 72 ساعت به حساب شما عودت خواهد شد در غیر اینصورت جهت پیگیری لطفا با شماره تلفن 1688 تماس حاصل کنید.";
//        ArrayList<String> mm = new ArrayList<>();
//        mm.add(s);
//        Log.e("1111", "onDraw: mm.lenght" + mm.size() );

//        String[] ss = new String[3];
//        for (int i = 0; i < 142; i+=(s.length()/3)) {
//            ss = s.split(String.valueOf(s.charAt(i)));
//        }
//
//        Log.e("len", "onDraw: "+ s.length() );
//
//        for (int i = 0; i < ss.length; i++) {
//            setText(Color.BLACK,25, Paint.Align.CENTER, typeface,ss[i] ,x/2 , (y*(12.5f+i))/18, paint, canvas);
//        }


//        ArrayList<String> rr = new ArrayList<>();
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < mm.size() ; j++) {
//                rr.add(i , "") = mm.get(j);
//            }
//
//        }


//        Bitmap canvasBitmap ;
//        canvasBitmap = BitmapFactory.decodeResource(getResources(),R.drawable.ic_launcher_background) //-->here load your image
//                .copy(Bitmap.Config.ARGB_8888, true);
//        canvas.drawBitmap(canvasBitmap, 0, 0, paint);
//        drawCanvas = new Canvas(canvasBitmap);//-->set bitmap


//       int count = ss.length ;
//        Log.e("222", "onDraw: count  " + count );
//
//        String[] bb= new String[count];
//
//        for (int i = 0; i < count; i++) {
//            for (int g = 0; g < 5; g++) {
//                bb[i] = ss[g];
//        }
//            }
//        for (int i = 0; i < count; i++) {
//        canvas.drawText(bb[i], 20, (y*i)/18 , paint);
//        }
//
//        for (int i = 0; i < ss.length; i++) {
//            if(i % 3 == 0){
//            }
////            canvas.drawText(bb[i], 20, (y*i)/18 , paint);
//        }

    }

    public void setText(int color, int size, Paint.Align align, Typeface typeface, String text, int x, float y, Paint paint, Canvas canvas) {
        paint.setColor(color);
        paint.setTextSize(size);
        paint.setTextAlign(align);
        paint.setTypeface(typeface);
        canvas.drawText(text, x, y, paint);
    }

}
