package com.bw.zhuguiquan20200221.view.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.zhuguiquan20200221.R;
import com.bw.zhuguiquan20200221.model.bean.ShouyeBean;
import com.bw.zhuguiquan20200221.util.NetUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * DateTime:2020/3/4 0004
 * author:朱贵全(Administrator)
 * function:
 */
public class RxxpAdapter extends RecyclerView.Adapter<RxxpAdapter.RxxpViewHolder> {


    private List<ShouyeBean.ResultBean.RxxpBean.CommodityListBean> mRxxpscommodityList;

    public RxxpAdapter(List<ShouyeBean.ResultBean.RxxpBean.CommodityListBean> rxxpscommodityList) {

        mRxxpscommodityList = rxxpscommodityList;
    }

    @NonNull
    @Override
    public RxxpViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(parent.getContext(), R.layout.rxxp_item, null);
        return new RxxpViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RxxpViewHolder holder, int position) {
        ShouyeBean.ResultBean.RxxpBean.CommodityListBean commodityListBean = mRxxpscommodityList.get(position);
        holder.tv1.setText(commodityListBean.getCommodityName());
        holder.tv2.setText(commodityListBean.getPrice()+"");
        NetUtil.getInstance().getPhoto(commodityListBean.getMasterPic(),holder.img);

    }

    @Override
    public int getItemCount() {
        return mRxxpscommodityList.size();
    }

    class RxxpViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img)
        ImageView img;
        @BindView(R.id.tv1)
        TextView tv1;
        @BindView(R.id.tv2)
        TextView tv2;
        public RxxpViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }


}
