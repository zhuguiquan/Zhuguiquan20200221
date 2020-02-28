package com.bw.zhuguiquan20200221.view.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.bw.zhuguiquan20200221.R;
import com.bw.zhuguiquan20200221.base.BaseFragment;
import com.bw.zhuguiquan20200221.base.BasePresenter;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShouyeFragment extends BaseFragment {

    @BindView(R.id.tv)
    TextView tv;



    @Override
    protected void initView(View inflate) {

    }

    @Override
    protected BasePresenter provideMpresenter() {
        return null;
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_shouye;
    }

    @Override
    protected void initData() {
        Bundle arguments = getArguments();
        String name = arguments.getString("name");
        tv.setText(name);
    }

    public static ShouyeFragment getInstance(String name) {
        ShouyeFragment shouyeFragment = new ShouyeFragment();
        Bundle bundle = new Bundle();
        bundle.putString("name", name);
        shouyeFragment.setArguments(bundle);
        return shouyeFragment;
    }

}
