package com.ycf.qaapi;

import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.anupcowkur.reservoir.Reservoir;
import com.ycf.qaapi.common.ComValue;
import com.ycf.qaapi.databinding.PageFirstBinding;
import com.ycf.qaapi.viewModel.dataBean.StartQADataBean;

import java.io.IOException;

public class FirstPage extends AppCompatActivity {
    private PageFirstBinding viewBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewBinding = DataBindingUtil.setContentView(this, R.layout.page_first);
    }

    @Override
    protected void onResume() {
        super.onResume();
        {//清除退回栈中该页面的所有实例。


        }


        //获取存储的链接前缀
        String customSchema = null;
        //获取存储的上一次参数信息
        String userInput = null;
        try {
            if (Reservoir.contains(ComValue.customQASchemaName)
                    && !"".equals(Reservoir.get(ComValue.customQASchemaName, String.class).trim())){
                customSchema = Reservoir.get(ComValue.customQASchemaName, String.class);
            }else {
                Reservoir.put(ComValue.customQASchemaName, ComValue.defaultQASchema);
                customSchema = ComValue.defaultQASchema;
            }
            if (Reservoir.contains(ComValue.userInputName)
                    && !"".equals(Reservoir.get(ComValue.userInputName, String.class).trim())){
                userInput = Reservoir.get(ComValue.userInputName, String.class);
            }else {
                Reservoir.put(ComValue.userInputName, ComValue.defaultUserInput);
                userInput = ComValue.defaultUserInput;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        StartQADataBean startQADataBean = new StartQADataBean();
        startQADataBean.setCustomSchema(customSchema);
        startQADataBean.setUserInput(userInput);

        viewBinding.setStartQADataBean(startQADataBean);

        //待定，暂时没用上（TODO 主要用于验证auth，以及页面较多时做路由跳转的中转页面，此处不进行相关操作。）
        Uri data = getIntent().getData();
        //将链接的参数列表输出出来。
        String params = null;

        if (data != null){
            params = data.getQuery().replace("&", "\n").replace("=", " : ");
            viewBinding.paramsList.setText(params);
        }
    }
}


