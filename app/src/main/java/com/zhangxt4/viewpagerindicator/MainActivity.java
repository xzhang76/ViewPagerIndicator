package com.zhangxt4.viewpagerindicator;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import com.zhangxt4.view.ViewPagerIndicator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends FragmentActivity {
    private ViewPagerIndicator mIndicator;
    private ViewPager mViewPager;

    private List<String> mTitles = Arrays.asList("短信", "收藏", "推荐");
    private List<SimpleFragment> mFragments = new ArrayList<>();
    private FragmentPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        initViews();
        initDatas();
        mViewPager.setAdapter(mAdapter);
    }

    private void initViews() {
        mViewPager = (ViewPager) findViewById(R.id.id_viewpager);
        mIndicator = (ViewPagerIndicator) findViewById(R.id.id_indicator);

    }

    private void initDatas() {
        for (String title: mTitles){
            SimpleFragment simpleFragment = SimpleFragment.newInstance(title);
            mFragments.add(simpleFragment);
        }

        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragments.get(position);
            }

            @Override
            public int getCount() {
                return mFragments.size();
            }
        };
    }


}
