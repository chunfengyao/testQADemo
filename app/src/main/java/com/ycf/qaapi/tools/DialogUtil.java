package com.ycf.qaapi.tools;
/* * *
 * created by:   cf.yao
 * on:           2019.一月.14   14:20
 * Des:          弹框工具
 *
 * * */

import android.content.Context;
import android.widget.Toast;

public class DialogUtil {
    public static void showToast(Context context, String message, int duration){
        Toast.makeText(context, message, duration).show();
    }
}
