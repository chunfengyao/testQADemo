package com.ycf.qaapi;

import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ycf.qaapi.databinding.PageFirstBinding;
import com.ycf.qaapi.viewModel.dataBean.StartQADataBean;

public class FirstPage extends AppCompatActivity {
    private PageFirstBinding viewBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewBinding = DataBindingUtil.setContentView(this, R.layout.page_first);
        viewBinding.setStartQADataBean(new StartQADataBean());

        //待定，暂时没用上（TODO 主要用于验证auth，以及页面较多时做路由跳转的中转页面，此处不进行相关操作。）
        Uri data = getIntent().getData();
        //将链接的参数列表输出出来。
        String params = "";
        if (data != null){
            params = data.getQuery().replace("&", "\n").replace("=", " : ");
            viewBinding.paramsList.setText(params);
        }
    }
}


