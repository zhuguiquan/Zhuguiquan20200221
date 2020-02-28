package com.bw.zhuguiquan20200221.view.activity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bw.zhuguiquan20200221.R;
import com.bw.zhuguiquan20200221.base.BaseActivity;
import com.bw.zhuguiquan20200221.base.BasePresenter;
import com.bw.zhuguiquan20200221.view.fragment.FaxianFragment;
import com.bw.zhuguiquan20200221.view.fragment.FenleiFragment;
import com.bw.zhuguiquan20200221.view.fragment.MyFragment;
import com.bw.zhuguiquan20200221.view.fragment.ShopFragment;
import com.bw.zhuguiquan20200221.view.fragment.ShouyeFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {


    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.tab)
    TabLayout tab;
List<Fragment>fragmentList=new ArrayList<>();
List<String>list=new ArrayList<>();
    @Override
    protected void initData() {
        ShouyeFragment shouyeFragment = ShouyeFragment.getInstance("首页");
        FaxianFragment faxianFragment = FaxianFragment.getInstance("发现");
        ShopFragment shopFragment = ShopFragment.getInstance("购物");
        FenleiFragment fenleiFragment = FenleiFragment.getInstance("分类");
        MyFragment myFragment = MyFragment.getInstance("我的");
        fragmentList.add(shouyeFragment);
        fragmentList.add(faxianFragment);
        fragmentList.add(shopFragment);
        fragmentList.add(fenleiFragment);
        fragmentList.add(myFragment);
       list.add("首页");
       list.add("发现");
       list.add("购物");
       list.add("分类");
       list.add("我的");
        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }
            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return list.get(position);
            }

        });
        tab.setupWithViewPager(vp);

    }

    @Override
    protected void initView() {

    }

    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected int layooutId() {
        return R.layout.activity_main;
    }


}
