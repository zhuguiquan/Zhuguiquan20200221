package com.bw.zhuguiquan20200221.view.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.bw.zhuguiquan20200221.R;
import com.bw.zhuguiquan20200221.base.BaseFragment;
import com.bw.zhuguiquan20200221.base.BasePresenter;
import com.bw.zhuguiquan20200221.util.NetUtil;
import com.bw.zhuguiquan20200221.view.activity.LoginActivity;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShopFragment extends BaseFragment {


    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.tv2)
    TextView tv2;
    @BindView(R.id.tv3)
    TextView tv3;
    @BindView(R.id.tv4)
    TextView tv4;
    @BindView(R.id.tv5)
    TextView tv5;
    @BindView(R.id.bt_img)
    SimpleDraweeView btImg;

    @Override
    protected void initView(View inflate) {

    }

    @Override
    protected BasePresenter provideMpresenter() {
        return null;
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_shop;
    }

    @Override
    protected void initData() {

        String s = "http://mobile.bwstudent.com/images/small/default/user.jpg";
        btImg.setImageURI(s);
       // NetUtil.getInstance().getPhoto(s, btImg);
        btImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), LoginActivity.class));
            }
        });
        tv1.setText("个人资料");
        tv2.setText("我的圈子");
        tv3.setText("我的足迹");
        tv4.setText("我的钱包");
        tv5.setText("收货地址");

    }

    public static ShopFragment getInstance(String name) {
        ShopFragment shopFragment = new ShopFragment();
        Bundle bundle = new Bundle();
        bundle.putString("name", name);
        shopFragment.setArguments(bundle);
        return shopFragment;
    }


}
