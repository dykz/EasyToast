package com.beanbean.easytoast;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void TvClick(View view) {
        new EasyToast(this).withType(ToastType.FAIL).setMessage("你好的，成功你功").showTime(3000);
    }
}
