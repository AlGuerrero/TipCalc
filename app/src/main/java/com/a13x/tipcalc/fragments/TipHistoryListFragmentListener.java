package com.a13x.tipcalc.fragments;

import com.a13x.tipcalc.models.TipRecord;

/**
 * Created by Alejandro on 10/10/2016.
 */
public interface TipHistoryListFragmentListener {
    void addToList(TipRecord record);
    void clearList();
}
