package com.sample.basemvvm.ui.main.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.view.View;

import com.sample.basemvvm.R;
import com.sample.basemvvm.base.BaseActivity;
import com.sample.basemvvm.base.NoViewModel;
import com.sample.basemvvm.databinding.ActivityKnowDetailBinding;
import com.sample.basemvvm.util.StatusBarUtil;
import com.sample.basemvvm.util.ToolbarHelper;

/**
 * Created by Administrator on 2019/2/25.
 */

public class KnowageDetailActivity extends BaseActivity<NoViewModel, ActivityKnowDetailBinding> {

    // private ActivityKnowDetailBinding bindingView;
    private CollapsingToolbarLayoutState state;

    private enum CollapsingToolbarLayoutState {
        EXPANDED,
        COLLAPSED,
        INTERNEDIATE
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_know_detail);
        showContentView();
        //bindingView = DataBindingUtil.setContentView(this, R.layout.activity_know_detail);
        // ToolbarHelper.initFullBar(bindingView.toolbar, this);
        initView();
        bindingView.toolbar.setNavigationOnClickListener(v -> {
            finish();
        });
        bindingView.appbar.addOnOffsetChangedListener((appBarLayout, verticalOffset) -> {
            if (verticalOffset == 0) {
                if (state != CollapsingToolbarLayoutState.EXPANDED) {
                    bindingView.mLayTitle.setVisibility(View.GONE);
                    bindingView.collapsing.setTitle("EXPAND");
                    state = CollapsingToolbarLayoutState.EXPANDED;//修改状态标记为展开
                }
            } else if (Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()) {
                if (state != CollapsingToolbarLayoutState.COLLAPSED) {
                    bindingView.mLayTitle.setVisibility(View.VISIBLE);
                    bindingView.collapsing.setTitle("");
                    state = CollapsingToolbarLayoutState.COLLAPSED;//修改状态标记为折叠
                }
            } else {
                if (state != CollapsingToolbarLayoutState.INTERNEDIATE) {
                    bindingView.collapsing.setTitle("INTERNEDIATE");//设置title为INTERNEDIATE
                    state = CollapsingToolbarLayoutState.INTERNEDIATE;//修改状态标记为中间
                }
            }
        });
    }

    private void initView() {
        bindingView.tvCategoryNum.setText("12");
        bindingView.collapsing.setTitle("cest");
    }

    public static void start(Context mContext) {
        Intent intent = new Intent(mContext, KnowageDetailActivity.class);
        mContext.startActivity(intent);
    }
}
