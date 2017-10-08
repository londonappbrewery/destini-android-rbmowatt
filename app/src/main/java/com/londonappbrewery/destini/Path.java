package com.londonappbrewery.destini;

/**
 * Created by rmowatt on 10/7/17.
 */

public class Path {

    private int mStory;
    private int mTopBtn =0;
    private int mBtmBtn=0;
    private int mIfTop=0;
    private int mIfBottom=0;

    final static int TOP_BTN_PRESSED = 1;
    final static int BTM_BTN_PRESSED = 2;

    public Path(int story, int topBtn, int btmBtn, int onTop, int onBottom) {
        mStory = story;
        mTopBtn = topBtn;
        mBtmBtn = btmBtn;
        mIfTop = onTop;
        mIfBottom = onBottom;
    }

    public Path(int story) {
        mStory = story;
    }

    public int nextArc( int btnPressed )
    {
        return ( btnPressed == TOP_BTN_PRESSED) ? mIfTop : mIfBottom;
    }

    public int getStory() {
        return mStory;
    }

    public void setStory(int story) {
        mStory = story;
    }

    public int getTopBtn() {
        return mTopBtn;
    }

    public void setTopBtn(int topBtn) {
        mTopBtn = topBtn;
    }

    public int getBtmBtn() {
        return mBtmBtn;
    }

    public void setBtmBtn(int btmBtn) {
        mBtmBtn = btmBtn;
    }
}
