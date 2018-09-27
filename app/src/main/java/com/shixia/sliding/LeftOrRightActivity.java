package com.shixia.sliding;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

public class LeftOrRightActivity extends SlidingFragmentActivity {

    private SlidingMenu menu;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_left_or_right);

        // 初始化SlidingMenu
        initFragmentMenu();

    }

    private void initFragmentMenu() {

        Fragment leftMenuFragment = new LeftMenuFragment();
        setBehindContentView(R.layout.left_menu_frame);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.layout_left_menu_frame, leftMenuFragment)
                .commit();
        menu = getSlidingMenu();
        //设置透明度
        menu.setOffsetFadeDegree(0.4f);
        menu.setMode(SlidingMenu.LEFT_RIGHT);
        // 设置触摸屏幕的模式
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
        menu.setShadowWidthRes(R.dimen.shadow_width);
//        menu.setShadowDrawable(R.color.colorAccent);
        // 设置滑动菜单视图的宽度
        menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        // menu.setBehindWidth()
        // 设置渐入渐出效果的值
        menu.setFadeDegree(0.35f);
        // menu.setBehindScrollScale(1.0f);
//        menu.setSecondaryShadowDrawable(R.color.colorAccent);
        // 设置右边（二级）侧滑菜单
        menu.setSecondaryMenu(R.layout.right_menu_frame);
        Fragment rightMenuFragment = new RightMenuFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.layout_right_menu_frame, rightMenuFragment)
                .commit();

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (menu.isMenuShowing())
                    menu.toggle();
            }
        });
    }

    public void clickLeft(View view) {
        menu.showMenu();
    }

    public void clickRight(View view) {
        menu.showSecondaryMenu();
    }

}
