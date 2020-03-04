package com.bw.zhuguiquan20200221;

import com.bw.zhuguiquan20200221.model.bean.LoginBean;
import com.bw.zhuguiquan20200221.model.bean.RegistBean;
import com.bw.zhuguiquan20200221.model.bean.ShouyeBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * DateTime:2020/2/26 0026
 * author:朱贵全(Administrator)
 * function:
 */
public interface Api {
    @FormUrlEncoded
    @POST("small/user/v1/register")
    Observable<RegistBean> registData(@Field("phone") String  phone,@Field("pwd") String pwd);
    @FormUrlEncoded
    @POST("small/user/v1/login")
    Observable<LoginBean> loginData(@Field("phone") String phone, @Field("pwd") String pwd);
    @GET("small/commodity/v1/commodityList")
    Observable<ShouyeBean> shouyeData();

}
