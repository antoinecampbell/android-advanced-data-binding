package com.antoinecampbell.advanceddatabinding.domain;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.TextUtils;

import com.android.databinding.library.baseAdapters.BR;

import org.parceler.Parcel;

import java.util.Objects;

/**
 * @author acampbell
 */
@Parcel
public class TwoWayBindingForm extends BaseObservable {

    @Bindable
    String firstName;
    @Bindable
    String lastName;
    @Bindable
    String password;
    @Bindable
    String confirmPassword;
    @Bindable
    boolean newsletter;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        notifyPropertyChanged(BR.firstName);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        notifyPropertyChanged(BR.lastName);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        notifyPropertyChanged(BR.confirmPassword);
    }

    public boolean isNewsletter() {
        return newsletter;
    }

    public void setNewsletter(boolean newsletter) {
        this.newsletter = newsletter;
        notifyPropertyChanged(BR.newsletter);
    }

    @Bindable({"password", "confirmPassword"})
    public boolean isPasswordsMatch() {
        return Objects.equals(password, confirmPassword);
    }

    @Bindable({"firstName", "lastName", "password", "confirmPassword"})
    public boolean isValid() {
        return !TextUtils.isEmpty(firstName)
                && !TextUtils.isEmpty(lastName)
                && !TextUtils.isEmpty(password)
                && !TextUtils.isEmpty(confirmPassword)
                && password.equals(confirmPassword);
    }
}
