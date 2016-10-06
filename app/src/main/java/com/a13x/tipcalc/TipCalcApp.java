package com.a13x.tipcalc;

import android.app.Application;

/**
 * Created by Alejandro on 26/09/2016.
 */
public class TipCalcApp extends Application {
    private final static String ABOUT_URL = "https://github.com/AlGuerrero";

    public static String getAboutUrl() {
        return ABOUT_URL;
    }
}
