package com.shixia.sliding;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openLeft(View view){
        startActivity(new Intent(this,LeftActivity.class));
    }

    public void openRight(View view){
        startActivity(new Intent(this,RightActivity.class));
    }

    public void openLeftOrRight(View view){
        startActivity(new Intent(this,LeftOrRightActivity.class));
    }
}
