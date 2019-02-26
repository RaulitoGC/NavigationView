package com.android.navigationview.view;

import android.app.Activity;
import com.android.navigationview.model.NavigationItem;

/**
 * Created by Raul Guzman Condor <raul.guzman@mediabyte.com.pe> on 2/5/17.
 */

public class NavigationBuilder {

    private NavigationItem[] mItems;
    private NavigationItem mCurrentItem;
    private int mResBackgroundSelect;
    private int mResBackgroundNoSelect;
    private int mResTextColorSelect;
    private int mResTextColorNoSelect;
    private Activity mActivity;

    public NavigationBuilder(){}

    public NavigationItem[] getItems() {
        return mItems;
    }
    public NavigationItem getCurrentItem(){return mCurrentItem;}
    public Activity getActivity(){return mActivity;}
    public int getResBackgroundNoSelect() {return mResBackgroundNoSelect;}
    public int getResBackgroundSelect() {return mResBackgroundSelect;}
    public int getResTextColorNoSelect() {return mResTextColorNoSelect;}
    public int getResTextColorSelect() {return mResTextColorSelect;}

    public NavigationBuilder withItems(NavigationItem... items){
        mItems = items;
        return this;
    }

    public NavigationBuilder withCurrentItem(NavigationItem currentItem){
        mCurrentItem =  currentItem;
        return this;
    }

    public NavigationBuilder withActivity(Activity activity){
        mActivity = activity;
        return this;
    }

    public NavigationBuilder withBackgroundSelect(int resBackgroundSelect){
        mResBackgroundSelect =  resBackgroundSelect;
        return this;
    }

    public NavigationBuilder withTextColorSelect(int resTextColorSelect){
        mResTextColorSelect = resTextColorSelect;
        return this;
    }

    public NavigationBuilder withTextColorNoSelect(int resTextColorNoSelect){
        mResTextColorNoSelect =  resTextColorNoSelect;
        return this;
    }

    public NavigationBuilder withBackgroundNoSelect(int resBackgroundNoSelect){
        mResBackgroundSelect =  resBackgroundNoSelect;
        return this;
    }

    public NavigationDrawer builder(){
        return new NavigationDrawer(this);
    }


}
