package com.android.navigationview.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.*;
import android.view.View;

import com.android.navigationview.R;
import com.android.navigationview.model.NavigationItemView;

/**
 * Created by Raul Guzman Condor <raul.guzman@mediabyte.com.pe> on 2/5/17.
 */

public class NavigationFragment extends Fragment implements NavigationAdapter.OnItemClickListener {

    private NavigationListener mListener;
    private NavigationItemView[] mItems;

    private RecyclerView mNavigationRecyclerView;
    private Context mContext;

    public static NavigationFragment newInstance(NavigationListener listener,NavigationItemView[] items){
        NavigationFragment fragment =  new NavigationFragment();
        fragment.setListener(listener);
        fragment.setItems(items);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext =  context;
    }

    public void setListener(NavigationListener mListener) {
        this.mListener = mListener;
    }

    public void setItems(NavigationItemView[] mItems) {
        this.mItems = mItems;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_navigation, container, false);
        if (view != null) {
            mNavigationRecyclerView = (RecyclerView) view.findViewById(R.id.navigation_item_recycler_view);
            return view;
        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mNavigationRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mNavigationRecyclerView.setAdapter(new NavigationAdapter(this,mItems));
    }

    @Override
    public void onItemClick(int position) {
        mListener.onReloadNavigation(position);
    }
}
