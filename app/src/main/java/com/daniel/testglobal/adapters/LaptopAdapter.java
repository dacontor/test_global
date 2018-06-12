package com.daniel.testglobal.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daniel.testglobal.R;
import com.daniel.testglobal.adapters.viewholder.LaptopViewHolder;
import com.daniel.testglobal.core.models.HomeObject;

import java.util.List;

public class LaptopAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<HomeObject> mItems;
    private Context mContext;
    private OnItemClickListener listener;

    public LaptopAdapter(Context context, List<HomeObject> list, OnItemClickListener listener) {
        mContext = context;
        mItems = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_laptop, viewGroup, false);
        return LaptopViewHolder.newInstance(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int position) {

        HomeObject object = getItem(position);
        LaptopViewHolder holder = (LaptopViewHolder) viewHolder;

        createViewAdapter(holder, object);

    }

    private void createViewAdapter(LaptopViewHolder holder, HomeObject item) {
        holder.createViewAdapter(holder, item, mContext, listener);
    }

    private HomeObject getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public interface OnItemClickListener {
        void onItemClick(HomeObject item, View view);
    }

}
