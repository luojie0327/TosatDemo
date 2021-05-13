package com.example.toastdemo;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ToastUtils {

    private Toast toast;
    private LinearLayout toastView;
    private static ToastUtils toastUtils;


    public static class Builder {

        public Builder(Context context, int duration) {

            toastUtils = new ToastUtils(context, duration);
        }

        public Builder setView(View view) {

            toastUtils.setView(view);
            return this;
        }

        public Builder addView(View view,int postion) {
            toastUtils.addView(view,postion);
            return this;
        }

        public Builder setToastText(int messageColor, float textsize, TextView message, String s){
            if (message != null) {

                message.setTextColor(messageColor);
                message.setTextSize(textsize);
                message.setText(s + "");
            }

            return this;
        }

        public ToastUtils build(){
            return  toastUtils;
        }


    }


    /**
     * 完全自定义布局Toast
     */
    private ToastUtils(Context context, int duration) {
        toast = new Toast(context);
        toast.setDuration(duration);
    }


    public void setView(View view) {

        toast.setView(view);
    }


    /**
     * 向Toast中添加自定义View
     */
    public ToastUtils addView(View view, int position) {
        toastView = (LinearLayout) toast.getView();
        toastView.addView(view,position);
        return this;
    }

    /**
     * 设置Toast字体及背景
     */
    public ToastUtils setToastText(int messageColor, float textsize, TextView message, String s) {

        if (message != null) {

            message.setTextColor(messageColor);
            message.setTextSize(textsize);
            message.setText(s + "");
        }

        return this;
    }

    /**
     * 短时间显示Toast
     */
    public ToastUtils Short(Context context, CharSequence message) {
        if (toast == null
                || (toastView != null && toastView.getChildCount() > 1)) {
            toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
            toastView = null;
        } else {
            toast.setText(message);
            toast.setDuration(Toast.LENGTH_SHORT);
        }
        return this;
    }

    /**
     * 长时间显示toast
     */
    public ToastUtils Long(Context context, CharSequence message) {
        if (toast == null
                || (toastView != null && toastView.getChildCount() > 1)) {
            toast = Toast.makeText(context, message, Toast.LENGTH_LONG);
            toastView = null;
        } else {
            toast.setText(message);
            toast.setDuration(Toast.LENGTH_LONG);
        }
        return this;
    }

    /**
     * 自定义显示Toast的时长
     */
    public ToastUtils Indefinite(Context context, CharSequence message,
                                                           int duration) {
        if (toast == null
                || (toastView != null && toastView.getChildCount() > 1)) {
            toast = Toast.makeText(context, message, duration);
            toastView = null;
        } else {
            toast.setText(message);
            toast.setDuration(duration);
        }

        return this;
    }

    /**
     * 显示Toast
     */
    public ToastUtils show() {
        toast.show();
        return this;
    }

    /**
     * 获取Toast
     */
    public Toast getToast() {
        return toast;
    }
}
