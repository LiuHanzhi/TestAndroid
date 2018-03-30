package com.lhz.testdrawtext.tool;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Rect;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * UI工具
 */
public class UITool {

    /**
     * 根据资源ID得到View
     */
    public static View inflate(Context context, int resource, ViewGroup root, boolean attachToRoot) {
        return LayoutInflater.from(context).inflate(resource, root, attachToRoot);
    }

    /**
     * 根据资源ID得到View
     */
    public static View inflate(Context context, int resource, ViewGroup root) {
        return LayoutInflater.from(context).inflate(resource, root);
    }

    /**
     * 根据资源ID得到View
     */
    public static View inflate(LayoutInflater inflater, int resource, ViewGroup root, boolean attachToRoot) {
        return inflater.inflate(resource, root, attachToRoot);
    }


    /**
     * 返回实际屏幕宽度与基准屏幕宽度（320px）的比例
     *
     * @param context
     * @return
     */
    public static float getWidthRatio(Context context) {
        return getScreenWidth(context) / 320f;
    }

    /**
     * 将一倍尺寸缩放到当前屏幕大小的尺寸（宽）
     */
    public static int zoomByWidth(Context context, int w) {
        if (w <= 0) {
            return w;
        }
        int sw = 0;
        sw = getScreenWidth(context);

        return (int) (w * sw / 320f + 0.5f);
    }

    /**
     * 缩放控件按照屏幕宽度
     */
    public static void zoomViewByWidth(int w, int h, View view) {
        if (view == null) {
            return;
        }

        ViewGroup.LayoutParams params = view.getLayoutParams();

        if (params == null) {
            return;
        }
        params.width = zoomByWidth(view.getContext(), w);
        params.height = zoomByWidth(view.getContext(), h);
    }

    /**
     * 缩放控件宽度按照屏幕宽度比例
     */
    public static void zoomViewWidthByWidth(int w, View view) {
        if (view == null) {
            return;
        }

        ViewGroup.LayoutParams params = view.getLayoutParams();

        if (params == null) {
            return;
        }

        params.width = zoomByWidth(view.getContext(), w);
    }

    /**
     * 缩放控件
     */
    public static void zoomViewFull(View view) {
        if (view == null) {
            return;
        }

        ViewGroup.LayoutParams params = view.getLayoutParams();

        if (params == null) {
            return;
        }

        params.width = getScreenWidth(view.getContext());
        params.height = getScreenHeight(view.getContext());
    }


    public static int getPPI(Context context) {
        return context.getResources().getDisplayMetrics().densityDpi;
    }

    /**
     * dip转px
     */
    public static int dipToPx(Context context, int dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        int pxValue = (int) (dipValue * scale + 0.5f);

        return pxValue;
    }

    /**
     * px转dip
     */
    public static float dipToPxFloat(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        float pxValue = dipValue * scale;

        return pxValue;
    }

    /**
     * 得到屏幕宽度
     */
    public static int getScreenWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    /**
     * 得到屏幕高度
     */
    public static int getScreenHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    /**
     * 设置状态栏透明且悬浮
     */
    public static void setTranslucent(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // 设置状态栏透明
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // 设置根布局的参数
            ViewGroup rootView = (ViewGroup) ((ViewGroup) activity.findViewById(android.R.id.content)).getChildAt(0);
            rootView.setFitsSystemWindows(false);
            rootView.setClipToPadding(false);
        }
    }

    public static int getStatusBarHeight(Context context) {
        // 获得状态栏高度
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return context.getResources().getDimensionPixelSize(resourceId);
    }

    /**
     * 状态栏高度
     *
     * @param view
     * @return
     */
    public static int getStatusBarHeight(View view) {
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
//        LogTool.e("status bar height = " + rect.top);
        return rect.top;
    }

    /**
     * 获得listview内容高度
     *
     * @param listView
     * @return
     */
    public static int getTotalHeightofListView(ListView listView) {
        ListAdapter mAdapter = (ListAdapter) listView.getAdapter();
        if (mAdapter == null) {
            return 0;
        }
        int totalHeight = 0;
        for (int i = 0; i < mAdapter.getCount(); i++) {
            View mView = mAdapter.getView(i, null, listView);
            mView.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                    View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
            //mView.measure(0, 0);
            totalHeight += mView.getMeasuredHeight();
        }
        return totalHeight + (listView.getDividerHeight() * (mAdapter.getCount() - 1));

    }

    /**
     * 设置为横屏
     */
    public static void screenLandscape(Activity activity) {
        activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }

    /**
     * 设置为竖屏
     */
    public static void screenPortrait(Activity activity) {
        activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    public static void showToast(Context context, int upload_cover_success) {
        Toast.makeText(context, upload_cover_success, Toast.LENGTH_LONG).show();
    }

    /**
     * 得到view的顶部坐标
     *
     * @param view
     * @return
     */
    public static int getTopOf(View view) {
        int[] locs = new int[2];
        view.getLocationInWindow(locs);
        return locs[1];
    }

    public static void measureView(View child) {
        ViewGroup.LayoutParams p = child.getLayoutParams();
        if (p == null) {
            p = new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.FILL_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
        }

        int childWidthSpec = ViewGroup.getChildMeasureSpec(0,
                0 + 0, p.width);
        int lpHeight = p.height;
        int childHeightSpec;
        if (lpHeight > 0) {
            childHeightSpec = View.MeasureSpec.makeMeasureSpec(lpHeight, View.MeasureSpec.EXACTLY);
        } else {
            childHeightSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        }
        child.measure(childWidthSpec, childHeightSpec);
    }

}
