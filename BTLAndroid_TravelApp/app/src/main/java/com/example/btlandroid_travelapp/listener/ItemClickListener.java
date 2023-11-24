package com.example.btlandroid_travelapp.listener;

import android.view.View;

import androidx.lifecycle.ViewTreeViewModelKt;

public interface ItemClickListener {

    void onClick(View view, int pos, boolean isClick);
}
