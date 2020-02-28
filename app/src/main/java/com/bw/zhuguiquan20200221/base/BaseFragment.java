package com.bw.zhuguiquan20200221.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.facebook.drawee.backends.pipeline.Fresco;

import butterknife.ButterKnife;

/**
 * DateTime:2020/2/21 0021
 * author:朱贵全(Administrator)
 * function:
 */
public abstract class BaseFragment<P extends BasePresenter> extends Fragment {
    protected P mpresenter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = View.inflate(getContext(), layoutId(), null);
        mpresenter=provideMpresenter();
        if (mpresenter != null) {
            mpresenter.attach(this);
        }
        ButterKnife.bind(this,inflate);
        Fresco.initialize(getContext());
        initView(inflate);
        return inflate;
    }

    protected abstract void initView(View inflate);

    protected abstract P provideMpresenter();

    protected abstract int layoutId();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    protected abstract void initData();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mpresenter != null) {
            mpresenter.datach();
        }
    }
}
