package com.antoinecampbell.advanceddatabinding.binding;

import android.databinding.BindingAdapter;
import android.databinding.BindingConversion;
import android.graphics.Typeface;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * @author acampbell
 */
public class BindingAdapters {

    @BindingAdapter("imageUrl")
    public static void loadImageUrl(ImageView imageView, String url) {
        Picasso.with(imageView.getContext()).load(url).into(imageView);
    }

    @BindingAdapter({"font"})
    public static void setFont(TextView textView, String font) {
        Typeface typeface = Typeface.createFromAsset(textView.getContext().getAssets(), font);
        textView.setTypeface(typeface);
    }

    @BindingConversion
    public static int booleanToVisibility(boolean visible) {
        return visible ? View.VISIBLE : View.GONE;
    }
}
