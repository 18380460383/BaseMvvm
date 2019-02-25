package com.sample.basemvvm.ui.main.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.sample.basemvvm.R;
import com.sample.basemvvm.base.BaseFragment;
import com.sample.basemvvm.base.NoViewModel;
import com.sample.basemvvm.databinding.FragmentKnowmainBinding;
import com.sample.basemvvm.ui.main.activity.KnowageDetailActivity;

/**
 * Created by Administrator on 2019/2/25.
 */

public class KnowageFragment extends BaseFragment<NoViewModel, FragmentKnowmainBinding> {

    public static KnowageFragment newInstance(String title) {
        KnowageFragment fragment = new KnowageFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initView();
        bindingView.mTvTitle.setOnClickListener(v->{
            KnowageDetailActivity.start(getContext());
        });
    }

    private void initView() {
        bindingView.mTvTitle.setText("" + getArguments().getString("title"));
        switch (getArguments().getString("title")){
            case "0":
                setSwipFresh(false);
                showContentView();
                break;
            case "1":
                showLoading();
                break;
            case "2":
                setSwipFresh(true);
                showError();
                break;
        }
    }

    @Override
    public int setContent() {
        return R.layout.fragment_knowmain;
    }

}
