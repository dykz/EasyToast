package com.beanbean.easytoast;

import android.content.Context;
import android.content.res.ColorStateList;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 简便弹出框
 */
public class EasyToast {
    private Context mContext;
    private Toast toast;
    private View toastView;

    public EasyToast(@NonNull Context context) {
        toast = new Toast(context);
        mContext = context;
        toast.setGravity(Gravity.CENTER, 0, 0);
        toastView = LayoutInflater.from(mContext).inflate(R.layout.layout_tip_dialog, null);
    }

    /**
     * 设置提示类型，目前提供成功和失败；可选
     * @param type
     * @return
     */
    public EasyToast withType(ToastType type) {
        checkNotNull(toast);
        ImageView iv_tip = toastView.findViewById(R.id.iv_tip);
        switch (type) {
            case FAIL:
                iv_tip.setImageResource(R.drawable.easy_toast_ic_bad);
                break;
            case SUCCESS:
                iv_tip.setImageResource(R.drawable.easy_toast_ic_ok);
                break;
            default:
                break;
        }
        return this;
    }

    /**
     * 设置背景颜色；可选
     * @param color
     * @return
     */
    public EasyToast setBackgroundColor(int color) {
        checkNotNull(toast);
        toastView.setBackgroundTintList(ColorStateList.valueOf(color));
        return this;
    }

    /**
     * 设置提示图标；可选
     * @param icon
     * @return
     */
    public EasyToast setIcon(int icon) {
        checkNotNull(toast);
        ImageView iv_tip = toastView.findViewById(R.id.iv_tip);
        iv_tip.setImageResource(icon);
        return this;
    }

    /**
     * 设置提示内容；可选
     * @param msg
     * @return
     */
    public EasyToast setMessage(Object msg) {
        checkNotNull(toast);
        TextView tv_tip = toastView.findViewById(R.id.tv_tip);
        tv_tip.setSelected(true);
        if (msg instanceof Integer) {
            tv_tip.setText((Integer) msg);
        } else if (msg instanceof String) {
            tv_tip.setText((String) msg);
        } else {
            throw new IllegalArgumentException("msg is Illegal");
        }
        return this;
    }

    /**
     * 设置提示时间--短
     * @return
     */
    public EasyToast showShort() {
        checkNotNull(toast);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(toastView);
        toast.show();
        return this;
    }

    /**
     * 设置提示时间--长
     * @return
     */
    public EasyToast showLong() {
        checkNotNull(toast);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(toastView);
        toast.show();
        return this;
    }

    /**
     * 设置提示时间
     * @param time
     * @return
     */
    public EasyToast showTime(int time) {
        checkNotNull(toast);
        toast.setDuration(time);
        toast.setView(toastView);
        toast.show();
        return this;
    }

    /**
     * 检测参数合法
     * @param o
     */
    private void checkNotNull(Toast o) {
        if (o == null) throw new NullPointerException("Toast can not null");
    }
}
