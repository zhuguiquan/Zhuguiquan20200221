package com.bw.zhuguiquan20200221.presenter;

import com.bw.zhuguiquan20200221.base.BasePresenter;
import com.bw.zhuguiquan20200221.contract.LoginContract;
import com.bw.zhuguiquan20200221.model.LoginModel;
import com.bw.zhuguiquan20200221.model.bean.LoginBean;
import com.bw.zhuguiquan20200221.model.bean.RegistBean;

/**
 * DateTime:2020/2/26 0026
 * author:朱贵全(Administrator)
 * function:
 */
public class LoginPresenter extends BasePresenter<LoginContract.IView> implements LoginContract.IPresenter {

    private LoginModel loginModel;

    @Override
    protected void initModel() {
        loginModel = new LoginModel();
    }

    @Override
    public void getRegistData(String phone, String pwd) {
        loginModel.getRegistData(phone, pwd, new LoginContract.IModel.IModelCallBack() {
            @Override
            public void onRegistSuccess(RegistBean registBean) {
                view.onRegistSuccess(registBean);
            }

            @Override
            public void onRegistFailure(Throwable throwable) {
                view.onRegistFailure(throwable);

            }

            @Override
            public void onLoginSuccess(LoginBean loginBean) {
                view.onLoginSuccess(loginBean);

            }

            @Override
            public void onLoginFailure(Throwable throwable) {
                view.onLoginFailure(throwable);

            }
        });

    }

    @Override
    public void getLoginData(String phone, String pwd) {
        loginModel.getLoginData(phone, pwd, new LoginContract.IModel.IModelCallBack() {
            @Override
            public void onRegistSuccess(RegistBean registBean) {
                view.onRegistSuccess(registBean);
            }

            @Override
            public void onRegistFailure(Throwable throwable) {
                view.onRegistFailure(throwable);

            }

            @Override
            public void onLoginSuccess(LoginBean loginBean) {
                view.onLoginSuccess(loginBean);

            }

            @Override
            public void onLoginFailure(Throwable throwable) {
                view.onLoginFailure(throwable);

            }
        });
    }
}
