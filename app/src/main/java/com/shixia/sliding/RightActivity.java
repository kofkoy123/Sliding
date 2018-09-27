package com.shixia.sliding;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

public class RightActivity extends AppCompatActivity {

    private SlidingMenu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_right);
        initSliDingMenu();
    }

    private void initSliDingMenu() {

        // configure the SlidingMenu
        menu = new SlidingMenu(this);
        menu.setMode(SlidingMenu.RIGHT);
        // 设置触摸屏幕的模式
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        menu.setShadowWidthRes(R.dimen.shadow_width);
        menu.setShadowDrawable(R.color.colorAccent);

        // 设置滑动菜单视图的宽度
        menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        // 设置渐入渐出效果的值
        menu.setFadeDegree(0.35f);
        /**
         * SLIDING_WINDOW will include the Title/ActionBar in the content
         * section of the SlidingMenu, while SLIDING_CONTENT does not.
         */
        menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        //为侧滑菜单设置布局
        menu.setMenu(R.layout.left_menu);

        View view = LayoutInflater.from(this).inflate(R.layout.left_menu, null);

        TextView tv = view.findViewById(R.id.tv);
        tv.setText("这是右侧布局");
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (menu.isMenuShowing())
                    menu.toggle();
            }
        });
    }

    public void clickRight(View view) {
        menu.showMenu();
    }
}
