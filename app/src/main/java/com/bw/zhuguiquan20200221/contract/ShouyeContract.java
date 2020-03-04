package com.bw.zhuguiquan20200221.contract;

import com.bw.zhuguiquan20200221.model.bean.LoginBean;
import com.bw.zhuguiquan20200221.model.bean.RegistBean;
import com.bw.zhuguiquan20200221.model.bean.ShouyeBean;

/**
 * DateTime:2020/2/26 0026
 * author:朱贵全(Administrator)
 * function:
 */
public interface ShouyeContract {
    interface IView{
        void onShouyeSuccess(ShouyeBean shouyeBean);
        void onShouyeFailure(Throwable throwable);


    }
    interface IPresenter{
        void getShouyeData();


    }
    interface IModel{
        void getShouyeData( IModelCallBack iModelCallBack);
        interface IModelCallBack{
            void onShouyeSuccess(ShouyeBean shouyeBean);
            void onShouyeFailure(Throwable throwable);
        }
    }
}
