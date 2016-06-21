package com.rochuo.gdpms_bmob.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

/**
 * Created by Administrator on 2016/4/14.
 */
public class SlidingMenu extends HorizontalScrollView {

    private LinearLayout mWapper;
    private ViewGroup mMenu;
    private ViewGroup mContent;
    private int mScreenWidth;
    private int mMenuRigthPadding = 50;

    private int mMenuWidth;
    private boolean once;
    private boolean isopen;


    public SlidingMenu(Context context, AttributeSet attrs) {
        super(context, attrs);
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrice = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrice);
        mScreenWidth = outMetrice.widthPixels;

        mMenuRigthPadding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 230, context.getResources().getDisplayMetrics());


    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (!once) {
            mWapper = (LinearLayout) getChildAt(0);
            mMenu = (LinearLayout) mWapper.getChildAt(0);
            mContent = (LinearLayout) mWapper.getChildAt(1);

            mMenuWidth = mMenu.getLayoutParams().width = mScreenWidth - mMenuRigthPadding;
            mContent.getLayoutParams().width = mScreenWidth;
            once = true;
        }


        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        if (changed) {
            this.scrollTo(mMenuWidth, 0);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_UP:
                int scrollX = getScrollX();
                if (scrollX >= mMenuWidth / 3) {
                    this.smoothScrollTo(mMenuWidth, 0);
                    isopen = false;
                } else {
                    this.smoothScrollTo(0, 0);
                    isopen = true;
                }
                return true;
        }
        return super.onTouchEvent(ev);
    }

    public void changeState() {
        if (isopen) {
            this.smoothScrollTo(mMenuWidth, 0);
            isopen = false;
        } else {
            this.smoothScrollTo(0, 0);
            isopen = true;
        }
    }

}




















