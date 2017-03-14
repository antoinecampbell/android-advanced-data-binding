package com.antoinecampbell.advanceddatabinding.fragment;

import com.android.databinding.library.baseAdapters.BR;
import com.antoinecampbell.advanceddatabinding.binding.BaseObservableLayoutItem;
import com.antoinecampbell.advanceddatabinding.binding.DataBoundViewHolder;
import com.antoinecampbell.advanceddatabinding.binding.MultiTypeDataBoundAdapter;
import com.antoinecampbell.advanceddatabinding.domain.recycler.HeaderItem;
import com.antoinecampbell.advanceddatabinding.domain.recycler.NetowrkUser;
import com.antoinecampbell.advanceddatabinding.domain.recycler.UpdateItem;
import com.antoinecampbell.advanceddatabinding.domain.recycler.UserItem;

import java.util.List;

/**
 * @author acampbell
 */
public class RecyclerviewAdapter extends MultiTypeDataBoundAdapter {

    private ActionCallback callback;
    private UserItem updaatingUserItem;

    public RecyclerviewAdapter(ActionCallback callback) {
        super();
        this.callback = callback;
    }

    @Override
    public int getItemLayoutId(int position) {
        Object item = getItem(position);
        if (item instanceof BaseObservableLayoutItem) {
            return ((BaseObservableLayoutItem) item).getLayoutId();
        } else {
            throw new IllegalArgumentException("Item must be BaseObservableLayoutItem");
        }
    }

    @Override
    protected void bindItem(DataBoundViewHolder holder, int position, List payloads) {
        super.bindItem(holder, position, payloads);
        holder.binding.setVariable(BR.callback, callback);
    }

    public void addHeader(String title) {
        addItem(new HeaderItem(title));
    }

    public void addUsers(List<NetowrkUser> users) {
        addItem(new HeaderItem("Users"));
        if (users != null) {
            for (NetowrkUser user : users) {
                addItem(new UserItem(user));
            }
        }
    }

    public void setUpdatingUserItem(NetowrkUser user) {
        if (updaatingUserItem == null) {
            addHeader("Updating Item");
            addItem(new UpdateItem());
            updaatingUserItem = new UserItem(user);
            addItem(updaatingUserItem);
        } else {
            updaatingUserItem.setUser(user);
        }
    }

    public interface ActionCallback {
        void onUpdateClicked();
    }
}
