package com.android.navigationview.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.*;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.navigationview.R;
import com.android.navigationview.model.NavigationItemView;

/**
 * Created by Raul Guzman Condor <raul.guzman@mediabyte.com.pe> on 2/5/17.
 */

public class NavigationAdapter extends RecyclerView.Adapter<NavigationAdapter.ItemDrawerViewHolder> {

    private OnItemClickListener mListener;
    private NavigationItemView[] mItems;

    public NavigationAdapter(OnItemClickListener listener, NavigationItemView[] items){
        mListener = listener;
        mItems = items;
    }


    @Override
    public ItemDrawerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.drawer_item, parent, false);

        final ItemDrawerViewHolder holder = new ItemDrawerViewHolder(view);
        view.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                if (mListener != null) mListener.onItemClick(holder.getAdapterPosition());
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ItemDrawerViewHolder holder, int position) {
        if(holder != null){
            //holder.mContentLinearLayout.setBackgroundResource(mItems[position].getBackground());
            holder.mTitleTextView.setText(mItems[position].getTitle());
            holder.mTitleTextView.setTextColor(mItems[position].getResTitleColor());
            Log.i("dasda :", holder.mTitleTextView.getText().toString());
            holder.mIcoImageView.setImageResource(mItems[position].getIcon());
        }
    }


    @Override
    public int getItemCount() {
        return mItems.length;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public static class ItemDrawerViewHolder extends RecyclerView.ViewHolder{
        private ImageView mIcoImageView;
        private TextView mTitleTextView;
        private LinearLayout mContentLinearLayout;

        public ItemDrawerViewHolder(View view) {
            super(view);
            mContentLinearLayout = (LinearLayout) view.findViewById(R.id.drawer_item_content);
            mIcoImageView = (ImageView) view.findViewById(R.id.drawer_item_image_view);
            mTitleTextView = (TextView) view.findViewById(R.id.drawer_item_text_view);
        }
    }
}
