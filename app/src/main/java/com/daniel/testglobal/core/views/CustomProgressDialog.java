package com.daniel.testglobal.core.views;

import android.app.Dialog;
import android.content.Context;

import com.daniel.testglobal.R;

public class CustomProgressDialog extends Dialog {

    public CustomProgressDialog(Context mContext) {

        super(mContext, R.style.FullScreenDialogProgress);

        setCanceledOnTouchOutside(true);
        setCancelable(true);
        setContentView(R.layout.progress_dialog);

    }

}
