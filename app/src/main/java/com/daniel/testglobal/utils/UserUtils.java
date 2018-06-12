package com.daniel.testglobal.utils;

import android.content.Context;
import android.widget.ImageView;

import com.daniel.testglobal.R;
import com.squareup.picasso.Picasso;

public class UserUtils {

    public static void loadImage(ImageView image, String url_imagen, Context mContext) {

        if (url_imagen != null)
            if (!url_imagen.isEmpty())
                Picasso.with(mContext).load(url_imagen).placeholder(R.mipmap.ic_launcher).into(image);
            else
                Picasso.with(mContext).load(R.mipmap.ic_launcher).into(image);
        else
            Picasso.with(mContext).load(R.mipmap.ic_launcher).into(image);

    }

}
