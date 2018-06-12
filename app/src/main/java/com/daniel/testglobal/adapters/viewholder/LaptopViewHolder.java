package com.daniel.testglobal.adapters.viewholder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.daniel.testglobal.R;
import com.daniel.testglobal.adapters.LaptopAdapter;
import com.daniel.testglobal.core.models.HomeObject;
import com.daniel.testglobal.utils.UserUtils;

public class LaptopViewHolder extends RecyclerView.ViewHolder {

    private TextView txtTitle;
    private TextView txtDescription;
    private ImageView imgLaptop;
    private LinearLayout lyCard;

    private LaptopViewHolder(View parent, TextView txtTitle, TextView txtDescription, LinearLayout lyCard, ImageView imgLaptop) {
        super(parent);
        this.txtTitle = txtTitle;
        this.txtDescription = txtDescription;
        this.lyCard = lyCard;
        this.imgLaptop = imgLaptop;
    }

    public static LaptopViewHolder newInstance(View parent) {
        TextView txtTitle = parent.findViewById(R.id.txtTitle);
        TextView txtDescription = parent.findViewById(R.id.txtDescription);
        LinearLayout lyCard = parent.findViewById(R.id.lyCard);
        ImageView imgLaptop = parent.findViewById(R.id.imgLaptop);

        return new LaptopViewHolder(parent, txtTitle, txtDescription, lyCard, imgLaptop);
    }


    public void createViewAdapter(LaptopViewHolder mHolder, final HomeObject item, Context mContext, final LaptopAdapter.OnItemClickListener listener) {

        mHolder.txtTitle.setText(item.getTitle());
        mHolder.txtDescription.setText(item.getDescription());
        UserUtils.loadImage(mHolder.imgLaptop, item.getImage(), mContext);

        mHolder.lyCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(item, v);
            }
        });

    }
}
