package com.android.navigationview;

import com.android.navigationview.model.NavigationItem;

/**
 * Created by Raul Guzman Condor <raul.guzman@mediabyte.com.pe> on 2/5/17.
 */

public class FirstActivity extends MainActivity {

    @Override
    protected NavigationItem getCurrentItem() {
        return NavigationItem.FIRST;
    }
}
