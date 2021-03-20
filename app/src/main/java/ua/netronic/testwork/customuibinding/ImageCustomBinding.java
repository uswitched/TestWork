package ua.netronic.testwork.customuibinding;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class ImageCustomBinding {

    @BindingAdapter(value = "setImageUrl")
    public static void bindImageURL(ImageView imageView, String url) {
        if(url!=null && url.length()!=0) {
            Glide.with(imageView.getContext())
                    .load(url)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .centerCrop()
                    .into(imageView);
        }
    }
}
