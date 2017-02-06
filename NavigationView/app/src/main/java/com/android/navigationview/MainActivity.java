package com.android.navigationview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.android.navigationview.model.NavigationItem;
import com.android.navigationview.view.NavigationBuilder;
import com.android.navigationview.view.NavigationDrawer;

/**
 * Created by Raul Guzman Condor <raul.guzman@mediabyte.com.pe> on 2/5/17.
 */

public abstract class MainActivity extends AppCompatActivity {

    private NavigationDrawer mDrawer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawer =  new NavigationBuilder()
                        .withActivity(this)
                        .withItems(
                                NavigationItem.FIRST,
                                NavigationItem.SECOND
                        )
                        .withBackgroundSelect(R.drawable.back_drawer_select)
                        .withBackgroundNoSelect(R.drawable.back_drawer_no_select)
                        .withTextColorSelect(getResources().getColor(R.color.colorGreenLight))
                        .withTextColorNoSelect(getResources().getColor(R.color.colorBlackLight))
                        .withCurrentItem(getCurrentItem())
                        .builder();

        mDrawer.start();

    }

    protected abstract NavigationItem getCurrentItem();
}
