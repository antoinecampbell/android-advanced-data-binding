package com.antoinecampbell.advanceddatabinding.binding;

import android.databinding.BaseObservable;
import android.support.annotation.LayoutRes;

/**
 * @author acampbell
 */
public abstract class BaseObservableLayoutItem extends BaseObservable {

    abstract public @LayoutRes int getLayoutId();
}
