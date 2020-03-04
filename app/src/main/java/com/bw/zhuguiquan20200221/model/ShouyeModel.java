package com.bw.zhuguiquan20200221.model;

import com.bw.zhuguiquan20200221.contract.ShouyeContract;
import com.bw.zhuguiquan20200221.model.bean.ShouyeBean;
import com.bw.zhuguiquan20200221.util.NetUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * DateTime:2020/3/4 0004
 * author:朱贵全(Administrator)
 * function:
 */
public class ShouyeModel implements ShouyeContract.IModel {
    @Override
    public void getShouyeData(IModelCallBack iModelCallBack) {
        NetUtil.getInstance().getApi().shouyeData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ShouyeBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ShouyeBean shouyeBean) {
                        iModelCallBack.onShouyeSuccess(shouyeBean);

                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallBack.onShouyeFailure(e);

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
