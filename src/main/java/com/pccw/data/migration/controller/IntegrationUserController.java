package com.pccw.data.migration.controller;

import com.pccw.data.migration.constants.ApiRequestLogUtil;
import com.pccw.data.migration.handler.IntegrationUserHandler;
import com.pccw.data.migration.model.result.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Created by Jim@80992399 on 2020-08-10 17:13
 **/
@RestController
//@RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public class IntegrationUserController {
    @Autowired
    private IntegrationUserHandler handler;

    @GetMapping(value = "/integrateArsUser")
    public BaseResponse<Object> integrateArsUser() {
        ApiRequestLogUtil.beginRequestApiLog(IntegrationUserController.class, "integrateArsUser");
        BaseResponse<Object> result = new BaseResponse<Object>();
        result = handler.insertArsUserInfoToAms();
        ApiRequestLogUtil.responseLog(IntegrationUserController.class, result.getResultCode(), result.getResultMessage());
        ApiRequestLogUtil.endRequestApiLog(IntegrationUserController.class, "integrateArsUser");
        return result;
    }

    @GetMapping(value = "/integratePasUser")
    public BaseResponse<Object> integratePasUser() {
        ApiRequestLogUtil.beginRequestApiLog(IntegrationUserController.class, "integratePasUser");
        BaseResponse<Object> result = new BaseResponse<Object>();
        result = handler.insertPasUserInfoToAms();
        ApiRequestLogUtil.responseLog(IntegrationUserController.class, result.getResultCode(), result.getResultMessage());
        ApiRequestLogUtil.endRequestApiLog(IntegrationUserController.class, "integratePasUser");
        return result;
    }
}
