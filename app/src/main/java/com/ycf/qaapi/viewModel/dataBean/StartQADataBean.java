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
    //跳转链接
    private Uri QAUri;
    //参数列表
    private Map<String, String> paramsMap;
    //用户输入的参数信息
    private String userInput;
    //自定义的链接前缀
    private String schemaStr;
    //用户输入的链接前缀
    private String customSchema;

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

    public String getSchemaStr() {
        return schemaStr;
    }

    public void setSchemaStr(String schemaStr) {
        this.schemaStr = schemaStr;
    }

    public String getCustomSchema() {
        return customSchema;
    }

    public void setCustomSchema(String customSchema) {
        this.customSchema = customSchema;
    }
}
