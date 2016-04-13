package com.adeptimpulse.bucketdrops.app.extras;

import android.view.View;

import java.util.List;

/**
 * Created by Michael Van Dusen on 4/12/2016.
 */
public class Util {

    public  static void showViews(List<View> views) {
        for (View view : views) {
            view.setVisibility(View.VISIBLE);
        }
    }

    public static void hideViews(List<View> views) {
        for (View view :views) {
            view.setVisibility(View.GONE);
        }
    }


}
