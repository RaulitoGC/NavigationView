package com.android.navigationview.model;

import com.android.navigationview.FirstActivity;
import com.android.navigationview.R;
import com.android.navigationview.SecondActivity;

/**
 * Created by Raul Guzman Condor <raul.guzman@mediabyte.com.pe> on 2/5/17.
 */

public enum NavigationItem {

    FIRST(1,R.string.first,R.drawable.ic_home_select,R.drawable.ic_home, FirstActivity.class),
    SECOND(2,R.string.second, R.drawable.ic_menu_recipe_select, R.drawable.ic_menu_recipe, SecondActivity.class);

    private int mId;
    private int mTitle;
    private int mIconNoSelected;
    private int mIconSelected;
    private Class mActivityToLaunch;

    NavigationItem(int id,int title, int iconSelected,int itemNoSelected,Class activityToLaunch){
        this.mId = id;
        this.mTitle = title;
        this.mIconSelected = iconSelected;
        this.mIconNoSelected =  itemNoSelected;
        this.mActivityToLaunch = activityToLaunch;
    }

    public int getId() {
        return mId;
    }

    public int getItemTitle() {
        return mTitle;
    }

    public int getItemIconNoSelected() {
        return mIconNoSelected;
    }

    public int getItemIconSelected() {
        return mIconSelected;
    }

    public Class getActivityToLaunch() {
        return mActivityToLaunch;
    }

}
