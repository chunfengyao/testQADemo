package com.ycf.qaapi.base;
/* * *
 * created by:   cf.yao
 * on:           2019.一月.10   15:46
 * Des:
 *
 * * */

import com.alibaba.fastjson.JSON;
import com.ycf.qaapi.restriction.log.DataLogInfo;

import java.io.Serializable;

public abstract class BaseDateBean implements DataLogInfo,Serializable {
    @Override
    public String getDesc() {
        return JSON.toJSONString(this);
    }
}
