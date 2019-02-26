package com.android.navigationview.model;

/**
 * Created by Raul Guzman Condor <raul.guzman@mediabyte.com.pe> on 2/5/17.
 */

public class NavigationItemView {

    private int mTitle;
    private int mIcon;
    private int mResTitleColor;
    private int mBackground;

    public NavigationItemView(int title, int icon, int background, int resTitleColor){
        this.mTitle = title;
        this.mIcon = icon;
        this.mResTitleColor = resTitleColor;
        this.mBackground =  background;
    }

    public void setItemIcon(int mItemIcon) {this.mIcon = mItemIcon;}
    public void setResTitleColor(int mResTitleColor) {this.mResTitleColor = mResTitleColor;}
    public void setBackground(int mBackground) {
        this.mBackground = mBackground;
    }

    public int getTitle() {return mTitle;}
    public int getIcon() {return mIcon;}
    public int getResTitleColor() {return mResTitleColor;}
    public int getBackground() {return mBackground;}
}
