package com.antoinecampbell.advanceddatabinding.domain.recycler;

import android.databinding.Bindable;

import com.android.databinding.library.baseAdapters.BR;
import com.antoinecampbell.advanceddatabinding.R;
import com.antoinecampbell.advanceddatabinding.binding.BaseObservableLayoutItem;

/**
 * @author acampbell
 */
public class UserItem extends BaseObservableLayoutItem {

    @Bindable
    private NetowrkUser user;

    public UserItem(NetowrkUser user) {
        setUser(user);
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_user;
    }

    public NetowrkUser getUser() {
        return user;
    }

    public void setUser(NetowrkUser user) {
        this.user = user;
        notifyPropertyChanged(BR.user);
    }
}
