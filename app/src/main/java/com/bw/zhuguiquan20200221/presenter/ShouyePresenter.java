package com.bw.zhuguiquan20200221.presenter;

import com.bw.zhuguiquan20200221.base.BasePresenter;
import com.bw.zhuguiquan20200221.contract.ShouyeContract;
import com.bw.zhuguiquan20200221.model.ShouyeModel;
import com.bw.zhuguiquan20200221.model.bean.ShouyeBean;

/**
 * DateTime:2020/3/4 0004
 * author:朱贵全(Administrator)
 * function:
 */
public class ShouyePresenter extends BasePresenter<ShouyeContract.IView> implements ShouyeContract.IPresenter {

    private ShouyeModel mShouyeModel;

    @Override
    protected void initModel() {
        mShouyeModel = new ShouyeModel();
    }

    @Override
    public void getShouyeData() {
        mShouyeModel.getShouyeData(new ShouyeContract.IModel.IModelCallBack() {
            @Override
            public void onShouyeSuccess(ShouyeBean shouyeBean) {
                view.onShouyeSuccess(shouyeBean);
            }

            @Override
            public void onShouyeFailure(Throwable throwable) {
                view.onShouyeFailure(throwable);

            }
        });

    }
}
