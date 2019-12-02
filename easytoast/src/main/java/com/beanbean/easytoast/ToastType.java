package com.beanbean.easytoast;

/**
 * 提示框 类型
 */
public enum ToastType {
    //成功，失败
    SUCCESS(0), FAIL(1);
    private int value;

    ToastType(int val) {
        value = val;
    }

    public static ToastType valueOf(int value) {
        switch (value) {
            case 0:
                return SUCCESS;
            case 1:
                return FAIL;
            default:
                return null;
        }
    }

    public int value() {
        return this.value;
    }
}
