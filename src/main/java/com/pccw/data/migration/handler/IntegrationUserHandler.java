package com.pccw.data.migration.handler;

import com.pccw.data.migration.model.result.BaseResponse;

/**
 * @author: Created by Jim@80992399 on 2020-08-06 16:05
 **/

public interface IntegrationUserHandler {

    BaseResponse<Object> insertArsUserInfoToAms();

    BaseResponse<Object> insertPasUserInfoToAms();
}
