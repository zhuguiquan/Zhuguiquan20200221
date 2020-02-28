package com.bw.zhuguiquan20200221.base;

/**
 * DateTime:2020/2/21 0021
 * author:朱贵全(Administrator)
 * function:
 */
public abstract class BasePresenter<V> {
    protected V view;

    public void attach(V view) {
        this.view = view;
    }
    public void datach(){
        view=null;
    }

    public BasePresenter() {
      initModel();
    }

    protected abstract void initModel();
}
