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
public class MyFragment extends BaseFragment {


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
        return R.layout.fragment_my;
    }

    @Override
    protected void initData() {
        Bundle arguments = getArguments();
        String name = arguments.getString("name");
        tv.setText(name);

    }

    public static MyFragment getInstance(String name) {
        MyFragment myFragment = new MyFragment();
        Bundle bundle = new Bundle();
        bundle.putString("name", name);
        myFragment.setArguments(bundle);
        return myFragment;
    }

}
