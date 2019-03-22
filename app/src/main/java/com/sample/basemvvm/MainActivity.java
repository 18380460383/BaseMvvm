package com.sample.basemvvm;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.sample.basemvvm.adapter.MainFragmentAdapter;
import com.sample.basemvvm.databinding.ActivityMainBinding;
import com.sample.basemvvm.databinding.DrawLayoutBinding;
import com.sample.basemvvm.ui.main.fragment.KnowageFragment;
import com.sample.basemvvm.util.CommonUtils;
import com.sample.basemvvm.widget.statusbar.StatusBarViewUtil;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {
    private ActivityMainBinding mBinding;
    private DrawLayoutBinding binding;

    private Intent endCallIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initStatusView();
        StatusBarViewUtil.setColorNoTranslucentForDrawerLayout(MainActivity.this, mBinding.drawerLayout,
                CommonUtils.getColor(R.color.colorTheme));
        endCallIntent=new Intent(MainActivity.this,EndCallService.class);
        startService(endCallIntent);
        initContentFragment();
        initDraw();
        initListener();
    }


    private void initContentFragment() {
        ArrayList<Fragment> mFragmentList = new ArrayList<>();
        mFragmentList.add(KnowageFragment.newInstance("0"));
        mFragmentList.add(KnowageFragment.newInstance("1"));
        mFragmentList.add(KnowageFragment.newInstance("2"));
        // 注意使用的是：getSupportFragmentManager
        MainFragmentAdapter adapter = new MainFragmentAdapter(getSupportFragmentManager(), mFragmentList);
        mBinding.include.vpContent.setAdapter(adapter);
        // 设置ViewPager最大缓存的页面个数(cpu消耗少)
        mBinding.include.vpContent.setOffscreenPageLimit(2);
        mBinding.include.vpContent.addOnPageChangeListener(this);
        setSupportActionBar(mBinding.include.toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            //去除默认Title显示
            actionBar.setDisplayShowTitleEnabled(false);
        }
        setCurrentItem(0);
    }


    private void initListener() {
        mBinding.include.llTitleMenu.setOnClickListener(this);
        mBinding.include.mLayOne.setOnClickListener(this);
        mBinding.include.mLayTwo.setOnClickListener(this);
        mBinding.include.mLayThree.setOnClickListener(this);
    }

    private void initStatusView() {
        ViewGroup.LayoutParams layoutParams = mBinding.include.viewStatus.getLayoutParams();
        layoutParams.height = StatusBarViewUtil.getStatusBarHeight(this);
        mBinding.include.viewStatus.setLayoutParams(layoutParams);
    }

    private void initDraw() {
        mBinding.navView.inflateHeaderView(R.layout.draw_layout);
        View drawView = mBinding.navView.getHeaderView(0);
        binding = DataBindingUtil.bind(drawView);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_title_menu:
                mBinding.drawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.mLayOne:
                if (mBinding.include.vpContent.getCurrentItem() != 0) {
                    setCurrentItem(0);
                }
                break;
            case R.id.mLayTwo:
                if (mBinding.include.vpContent.getCurrentItem() != 1) {
                    setCurrentItem(1);
                }
                break;
            case R.id.mLayThree:
                if (mBinding.include.vpContent.getCurrentItem() != 2) {
                    setCurrentItem(2);
                }
                break;
        }
    }


    private void setCurrentItem(int pos) {
        boolean isOne = false;
        boolean isTwo = false;
        boolean isThree = false;
        switch (pos) {
            case 0:
                isOne = true;
                break;
            case 1:
                isTwo = true;
                break;
            case 2:
                isThree = true;
                break;
        }
        mBinding.include.vpContent.setCurrentItem(pos);
        mBinding.include.ivTitleOne.setSelected(isOne);
        mBinding.include.ivTitleTwo.setSelected(isTwo);
        mBinding.include.ivTitleThree.setSelected(isThree);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        setCurrentItem(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
