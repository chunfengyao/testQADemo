package com.ycf.qaapi.viewModel.dataBean;
/* * *
 * created by:   cf.yao
 * on:           2019.一月.10   11:33
 * Des:
 *
 * * */

import android.net.Uri;
import android.support.annotation.NonNull;
import android.util.ArrayMap;

import com.ycf.qaapi.base.BaseDateBean;
import com.ycf.qaapi.common.AppConfigs;

import java.util.Map;

public class StartQADataBean extends BaseDateBean {
    private Uri QAUri;
    private Map<String, String> paramsMap;
    private String userInput;
    public final static String EncryptKey = AppConfigs.QAEncryptKey;

    public Uri getQAUri() {
        return QAUri;
    }

    public void setQAUri(Uri QAUri) {
        this.QAUri = QAUri;
    }

    @NonNull
    public Map<String, String> getParamsMap() {
        if (paramsMap == null){
            this.setParamsMap(new ArrayMap<String, String>());
        }
        return paramsMap;
    }

    public void setParamsMap(Map<String, String> paramsMap) {
        this.paramsMap = paramsMap;
    }

    @Override
    public String getDesc() {
        return super.getDesc();
    }

    public String getUserInput() {
        return userInput;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }
}
