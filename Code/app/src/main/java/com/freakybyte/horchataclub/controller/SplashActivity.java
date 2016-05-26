package com.freakybyte.horchataclub.controller;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

import com.freakybyte.horchataclub.R;
import com.freakybyte.horchataclub.controller.DishListActivity;
import com.freakybyte.horchataclub.controller.MainActivity;

public class SplashActivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new CountDownTimer(3000, 1000) {

            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                openDishListActivity();
            }

        }.start();
    }


    private void openDishListActivity() {
        Intent mIntentDishList = new Intent(this, DishListActivity.class);
        startActivity(mIntentDishList);
        finish();
    }
}
