package com.antoinecampbell.advanceddatabinding.domain;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.android.databinding.library.baseAdapters.BR;

/**
 * @author acampbell
 */
public class RecyclerviewFragmentViewModel extends BaseObservable {

    @Bindable
    private boolean loading;

    public boolean isLoading() {
        return loading;
    }

    public void setLoading(boolean loading) {
        this.loading = loading;
        notifyPropertyChanged(BR.loading);
    }
}
