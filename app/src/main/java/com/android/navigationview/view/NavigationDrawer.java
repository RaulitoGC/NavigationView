package com.android.navigationview.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;

import com.android.navigationview.R;
import com.android.navigationview.model.NavigationItemView;
import com.android.navigationview.presenter.NavigationPresenter;
import com.android.navigationview.presenter.Presenter;

/**
 * Created by Raul Guzman Condor <raul.guzman@mediabyte.com.pe> on 2/5/17.
 */

public class NavigationDrawer implements View,NavigationListener {

    private final NavigationBuilder mNavigationBuilder;
    private Presenter mNavigationPresenter;

    public NavigationDrawer(NavigationBuilder navigationBuilder){
        mNavigationBuilder = navigationBuilder;
    }

    @Override
    public Presenter getPresenter() {
        if(mNavigationPresenter == null){
            mNavigationPresenter =  new NavigationPresenter(this,mNavigationBuilder);
        }
        return mNavigationPresenter;
    }

    @Override
    public void start() {
        getPresenter().filterItems();
    }

    @Override
    public void buildDrawer(NavigationItemView[] items) {
        Activity activity =  mNavigationBuilder.getActivity();

        if(activity != null){
            FragmentTransaction transaction = ((AppCompatActivity)activity).getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.navigation_view,NavigationFragment.newInstance(this,items));
            transaction.commit();
        }
    }

    @Override
    public void onReloadNavigation(int position) {
        Activity activity = mNavigationBuilder.getActivity();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            TaskStackBuilder builder = TaskStackBuilder.create(activity);
            builder.addNextIntentWithParentStack(new Intent(activity,mNavigationBuilder.getItems()[position].getActivityToLaunch()));
            builder.startActivities();
        } else {
            activity.startActivity(new Intent(activity,mNavigationBuilder.getItems()[position].getActivityToLaunch()));
        }
        activity.finish();
    }
}
