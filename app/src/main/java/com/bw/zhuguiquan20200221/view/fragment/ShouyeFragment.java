package com.bw.zhuguiquan20200221.view.fragment;


import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.zhuguiquan20200221.R;
import com.bw.zhuguiquan20200221.base.BaseFragment;
import com.bw.zhuguiquan20200221.base.BasePresenter;
import com.bw.zhuguiquan20200221.contract.ShouyeContract;
import com.bw.zhuguiquan20200221.model.bean.ShouyeBean;
import com.bw.zhuguiquan20200221.presenter.ShouyePresenter;
import com.bw.zhuguiquan20200221.view.adapter.MlssAdapter;
import com.bw.zhuguiquan20200221.view.adapter.PzssAdapter;
import com.bw.zhuguiquan20200221.view.adapter.RxxpAdapter;

import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShouyeFragment extends BaseFragment<ShouyePresenter> implements ShouyeContract.IView {


    @BindView(R.id.rxxp)
    RecyclerView rxxp;
    @BindView(R.id.mlss)
    RecyclerView mlss;
    @BindView(R.id.pzss)
    RecyclerView pzss;

    @Override
    protected void initView(View inflate) {

    }

    @Override
    protected ShouyePresenter provideMpresenter() {
        return new ShouyePresenter();
    }


    @Override
    protected int layoutId() {
        return R.layout.fragment_shouye;
    }

    @Override
    protected void initData() {
        mpresenter.getShouyeData();

    }





    public static ShouyeFragment getInstance(String name) {
        ShouyeFragment shouyeFragment = new ShouyeFragment();
        Bundle bundle = new Bundle();
        bundle.putString("name", name);
        shouyeFragment.setArguments(bundle);
        return shouyeFragment;
    }

    @Override
    public void onShouyeSuccess(ShouyeBean shouyeBean) {
        ShouyeBean.ResultBean result = shouyeBean.getResult();
        ShouyeBean.ResultBean.RxxpBean rxxps = result.getRxxp();
        List<ShouyeBean.ResultBean.RxxpBean.CommodityListBean> rxxpscommodityList = rxxps.getCommodityList();
        rxxp.setLayoutManager(new GridLayoutManager(getContext(),3));
        RxxpAdapter rxxpAdapter = new RxxpAdapter(rxxpscommodityList);
        rxxp.setAdapter(rxxpAdapter);

        ShouyeBean.ResultBean.MlssBean mlsss = result.getMlss();
        List<ShouyeBean.ResultBean.MlssBean.CommodityListBeanXX> mlsssCommodityList = mlsss.getCommodityList();
        mlss.setLayoutManager(new LinearLayoutManager(getContext()));
        MlssAdapter mlssAdapter = new MlssAdapter(mlsssCommodityList);
        mlss.setAdapter(mlssAdapter);

        ShouyeBean.ResultBean.PzshBean pzshs = result.getPzsh();
        List<ShouyeBean.ResultBean.PzshBean.CommodityListBeanX> pzshsCommodityList = pzshs.getCommodityList();
        pzss.setLayoutManager(new GridLayoutManager(getContext(),2));
        PzssAdapter pzssAdapter = new PzssAdapter(pzshsCommodityList);
        pzss.setAdapter(pzssAdapter);


    }

    @Override
    public void onShouyeFailure(Throwable throwable) {

    }
}
