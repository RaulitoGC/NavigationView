package com.android.navigationview.presenter;

import com.android.navigationview.model.NavigationItem;
import com.android.navigationview.model.NavigationItemView;
import com.android.navigationview.view.NavigationBuilder;
import com.android.navigationview.view.View;

/**
 * Created by Raul Guzman Condor <raul.guzman@mediabyte.com.pe> on 2/5/17.
 */

public class NavigationPresenter implements Presenter {

    private View mNavigationView;
    private NavigationItem[] mItems;
    private NavigationItem mCurrrentItem;
    private int mResBackSelect;
    private int mResBackNoSelect;
    private int mResTextColorSelect;
    private int mResTextColorNoSelect;

    public NavigationPresenter(View view, NavigationBuilder navigationBuilder){
        mNavigationView = view;
        mItems = navigationBuilder.getItems();
        mCurrrentItem = navigationBuilder.getCurrentItem();
        mResBackSelect =  navigationBuilder.getResBackgroundSelect();
        mResBackNoSelect =  navigationBuilder.getResBackgroundNoSelect();
        mResTextColorSelect = navigationBuilder.getResTextColorSelect();
        mResTextColorNoSelect = navigationBuilder.getResTextColorNoSelect();
    }


    @Override
    public void filterItems() {

        NavigationItemView[] items = new NavigationItemView[mItems.length];
        for(int i=0; i<mItems.length;i++){
            NavigationItem item = mItems[i];
            NavigationItemView itemFilter = null;

            if(mCurrrentItem.getId() == mItems[i].getId())itemFilter = new NavigationItemView(item.getItemTitle(),item.getItemIconSelected(),mResBackSelect,mResTextColorSelect);
            else itemFilter = new NavigationItemView(item.getItemTitle(),item.getItemIconNoSelected(),mResBackNoSelect,mResTextColorNoSelect);

            items[i] = itemFilter;
        }
        mNavigationView.buildDrawer(items);
    }
}
