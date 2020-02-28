package com.bw.zhuguiquan20200221.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.blankj.utilcode.util.EncryptUtils;
import com.bw.zhuguiquan20200221.R;
import com.bw.zhuguiquan20200221.base.BaseActivity;
import com.bw.zhuguiquan20200221.contract.LoginContract;
import com.bw.zhuguiquan20200221.model.bean.LoginBean;
import com.bw.zhuguiquan20200221.model.bean.RegistBean;
import com.bw.zhuguiquan20200221.presenter.LoginPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.IView {


    @BindView(R.id.phone)
    EditText phone;
    @BindView(R.id.pwd)
    EditText pwd;
    @BindView(R.id.login)
    Button login;
    @BindView(R.id.regist)
    Button regist;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected LoginPresenter providePresenter() {
        return new LoginPresenter();
    }

    @Override
    protected int layooutId() {
        return R.layout.activity_login;
    }

    @Override
    public void onRegistSuccess(RegistBean registBean) {
        Toast.makeText(this, ""+registBean.getMessage(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onRegistFailure(Throwable throwable) {
        Toast.makeText(this, ""+throwable.getMessage(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onLoginSuccess(LoginBean loginBean) {
        LoginBean.ResultBean result = loginBean.getResult();
        String headPic = result.getHeadPic();

        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        intent.putExtra("head",headPic);
        startActivity(intent);
      finish();

    }

    @Override
    public void onLoginFailure(Throwable throwable) {
        Toast.makeText(this, ""+throwable.getMessage(), Toast.LENGTH_SHORT).show();


    }



    @OnClick({R.id.login, R.id.regist})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login:
                String phones = phone.getText().toString();
                String pwds = pwd.getText().toString();
                Toast.makeText(this, ""+pwds, Toast.LENGTH_SHORT).show();
                String pws = EncryptUtils.encryptMD5ToString(pwds);
                String substring = pws.substring(0, 6);
                mpresenter.getLoginData(phones,substring);
                break;
            case R.id.regist:
                String p = phone.getText().toString();
                String s = pwd.getText().toString();
                String s1 = EncryptUtils.encryptMD5ToString(s);
                String substring1 = s1.substring(0, 6);
                mpresenter.getRegistData(p,substring1);
                break;
        }
    }
}
