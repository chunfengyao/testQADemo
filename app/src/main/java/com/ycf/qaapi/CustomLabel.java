package com.ycf.qaapi;
/* * *
 * created by:   cf.yao
 * on:           2019.一月.14   14:34
 * Des:
 *
 * * */

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.databinding.BindingAdapter;
import android.net.Uri;
import android.view.View;
import android.widget.Toast;

import com.ycf.qaapi.common.ComValue;
import com.ycf.qaapi.tools.DialogUtil;
import com.ycf.qaapi.tools.LogUtil;
import com.ycf.qaapi.viewModel.dataBean.StartQADataBean;

/**
 * layout中的自定义标签
 */
public class CustomLabel {
    private static final String LOG_TAG = "自定义标签类：";

    @BindingAdapter("android:addStartQAListener")
    public static void addStartQAListener(View v, final StartQADataBean queryInfo){
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (queryInfo.getUserInput() != null
                        && queryInfo.getUserInput() != null
                        && !queryInfo.getUserInput().trim().equals("")){
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    queryInfo.setQAUri(Uri.parse(ComValue.QASchema
                            + ComValue.LinkModel
                            + ComValue.QAHost
                            + ComValue.QATestPagePath
                            + "?"
                            + queryInfo.getUserInput()));
                    intent.setData(queryInfo.getQAUri());
                    try{
                        v.getContext().startActivity(intent);
                    }catch (ActivityNotFoundException e){
                        LogUtil.w(LOG_TAG, "未成功跳转到指定链接：" + queryInfo.getQAUri().toString());
                        DialogUtil.showToast(v.getContext()
                            , v.getContext().getString(R.string.forwardFailed)
                            , Toast.LENGTH_LONG);
                        //3秒后跳转
                        v.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent failIntent = new Intent();
                                failIntent.setAction(Intent.ACTION_VIEW);
                                failIntent.setData(Uri.parse(ComValue.QAAppUrlInAppCenter));
                                try{
                                    v.getContext().startActivity(failIntent);
                                }catch (ActivityNotFoundException e){
                                    LogUtil.w(LOG_TAG, "未成功跳转到指定链接：" + ComValue.QAAppUrlInAppCenter);
                                }
                            }
                        }, 3);
                    }
                } else {
                    DialogUtil.showToast(v.getContext()
                            , v.getContext().getString(R.string.noUrlTips)
                            , Toast.LENGTH_SHORT);
                }
            }
        });
    }
    @BindingAdapter("android:addStartSelfListener")
    public static void addStartSelfListener(View v, final StartQADataBean queryInfo){
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (queryInfo.getUserInput() != null
                        && queryInfo.getUserInput() != null
                        && !queryInfo.getUserInput().trim().equals("")){
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    queryInfo.setQAUri(Uri.parse(ComValue.LASchema
                            + ComValue.LinkModel
                            + ComValue.LAHost
                            + "?"
                            + queryInfo.getUserInput()));
                    intent.setData(queryInfo.getQAUri());
                    try{
                        v.getContext().startActivity(intent);
                    }catch (ActivityNotFoundException e){
                        LogUtil.w(LOG_TAG, "未成功跳转到指定链接：" + queryInfo.getQAUri().toString());
                        DialogUtil.showToast(v.getContext()
                                , v.getContext().getString(R.string.forwardFailed)
                                , Toast.LENGTH_LONG);
                        //3秒后跳转
                        v.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent failIntent = new Intent();
                                failIntent.setAction(Intent.ACTION_VIEW);
                                failIntent.setData(Uri.parse(ComValue.QAAppUrlInAppCenter));
                                try{
                                    v.getContext().startActivity(failIntent);
                                }catch (ActivityNotFoundException e){
                                    LogUtil.w(LOG_TAG, "未成功跳转到指定链接：" + ComValue.QAAppUrlInAppCenter);
                                }
                            }
                        }, 3);
                    }
                } else {
                    DialogUtil.showToast(v.getContext()
                            , v.getContext().getString(R.string.noUrlTips)
                            , Toast.LENGTH_SHORT);
                }
            }
        });
    }

}
