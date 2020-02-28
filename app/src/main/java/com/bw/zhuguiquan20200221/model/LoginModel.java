package com.bw.zhuguiquan20200221.model;

import com.bw.zhuguiquan20200221.contract.LoginContract;
import com.bw.zhuguiquan20200221.model.bean.LoginBean;
import com.bw.zhuguiquan20200221.model.bean.RegistBean;
import com.bw.zhuguiquan20200221.util.NetUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * DateTime:2020/2/26 0026
 * author:朱贵全(Administrator)
 * function:
 */
public class LoginModel implements LoginContract.IModel {
    @Override
    public void getRegistData(String phone, String pwd, IModelCallBack iModelCallBack) {
        NetUtil.getInstance().getApi().registData(phone,pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RegistBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RegistBean registBean) {
                        if("0000".equals(registBean.getStatus())){
                            iModelCallBack.onRegistSuccess(registBean);
                        }else{
                            iModelCallBack.onRegistFailure(new Throwable(registBean.getMessage()));
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallBack.onRegistFailure(e);

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getLoginData(String phone, String pwd, IModelCallBack iModelCallBack) {
        NetUtil.getInstance().getApi().loginData(phone,pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        if("0000".equals(loginBean.getStatus())){
                            iModelCallBack.onLoginSuccess(loginBean);
                        }else{
                            iModelCallBack.onLoginFailure(new Throwable(loginBean.getMessage()));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallBack.onLoginFailure(e);

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
