package com.antoinecampbell.advanceddatabinding.domain.recycler;

import android.databinding.Bindable;

import com.antoinecampbell.advanceddatabinding.BR;
import com.antoinecampbell.advanceddatabinding.R;
import com.antoinecampbell.advanceddatabinding.binding.BaseObservableLayoutItem;

/**
 * @author acampbell
 */
public class HeaderItem extends BaseObservableLayoutItem {

    @Bindable
    private String title;

    public HeaderItem(String title) {
        this.title = title;
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_header;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }
}
