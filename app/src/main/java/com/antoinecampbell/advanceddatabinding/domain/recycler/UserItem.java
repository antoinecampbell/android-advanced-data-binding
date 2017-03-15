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
    private NetworkUser user;

    public UserItem(NetworkUser user) {
        setUser(user);
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_user;
    }

    public NetworkUser getUser() {
        return user;
    }

    public void setUser(NetworkUser user) {
        this.user = user;
        notifyPropertyChanged(BR.user);
    }
}
