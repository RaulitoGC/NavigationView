package com.android.navigationview.view;

import com.android.navigationview.model.NavigationItemView;
import com.android.navigationview.presenter.Presenter;

/**
 * Created by Raul Guzman Condor <raul.guzman@mediabyte.com.pe> on 2/5/17.
 */

public interface View {

    Presenter getPresenter();

    void start();
    void buildDrawer(NavigationItemView[] items);

}
