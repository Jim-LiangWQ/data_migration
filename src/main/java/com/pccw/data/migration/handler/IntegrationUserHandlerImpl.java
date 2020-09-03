package com.pccw.data.migration.handler;

import com.pccw.data.migration.entity.ams.AmsUser;
import com.pccw.data.migration.entity.ars.ArsUser;
import com.pccw.data.migration.entity.pas.PasUser;
import com.pccw.data.migration.model.result.BaseResponse;
import com.pccw.data.migration.service.ams.AmsUserService;
import com.pccw.data.migration.service.ars.ArsUserService;
import com.pccw.data.migration.service.pas.PasUserService;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static com.pccw.data.migration.constants.ResultCodeAndMessageEnumeration.RESULT_FAILED_QUERY_RECORD_IN_DB;
import static com.pccw.data.migration.constants.ResultCodeAndMessageEnumeration.RESULT_OK;

/**
 * @author: Created by Jim@80992399 on 2020-08-06 16:05
 **/
@Component
public class IntegrationUserHandlerImpl implements IntegrationUserHandler {
    private static final Logger logger = LoggerFactory.getLogger(IntegrationUserHandlerImpl.class);

    @Resource
    private ArsUserService arsUserService;
    @Resource
    private AmsUserService amsUserService;
    @Resource
    private PasUserService pasUserService;

    @Override
    public BaseResponse<Object> insertArsUserInfoToAms() {
        logger.info("Start get all ars user info");
        BaseResponse<Object> result = new BaseResponse<Object>();
        try {
            List<ArsUser> arsUserList = arsUserService.findAll();
            if (arsUserList!=null && arsUserList.size()>0) {
                logger.info("End get all ars user info. get {} user info", arsUserList.size());
                logger.info("Start get all ams username list");
                List<AmsUser> amsUserListDB = amsUserService.getUserList("ALL");
                logger.info("End get all ams list. get {} user info", amsUserListDB.size());
                logger.info("Start put ars user info into ams user list.");
                List<AmsUser> amsUserList = new ArrayList<>();
                for (ArsUser arsUser : arsUserList) {
                    AmsUser amsUser = null;
                    long id = arsUser.getId();
                    //String displayName = arsUser.getDisplayName();
                    String userName = arsUser.getUsername();
                    String hashPassword = arsUser.getHashedPassword();
                    String status = arsUser.getStatus();
                    Timestamp currentTime = new Timestamp(System.currentTimeMillis());
                    if (amsUserListDB!=null && amsUserListDB.size()>0) {
                        for (AmsUser temp : amsUserListDB) {
                            if (temp.getUsername().equals(userName)) {
                                amsUser = temp;
                                break;
                            }
                        }
                    }
                    if (amsUser==null) {
                        // create new user in ams db
                        amsUser = new AmsUser();
                        amsUser.setExternalId(id);
                        amsUser.setCount(0);
                        amsUser.setCreateTimestamp(currentTime);
                        amsUser.setEnabled("1");
                        amsUser.setId(RandomStringUtils.randomAlphanumeric(AmsUser.ID_GENERATION_LENGTH));
                        amsUser.setUsername(userName);
                    }
                    amsUser.setHashPassword(hashPassword);
                    if (status==null || status.isEmpty() || status.equals(ArsUser.STATUS_DISABLED)) {
                        status = AmsUser.STATUS_DELETE;
                    }
                    amsUser.setStatus(status);
                    amsUser.setUpdateTimestamp(currentTime);
                    amsUserList.add(amsUser);
                }
                logger.info("End put ars user info into ams user list.");
                logger.info("Start insert ars user list into ams db, insert {} user", amsUserList.size());
                boolean success = amsUserService.saveUserList(amsUserList);
                logger.info("End insert ars user list into ams db, insert result is {}", success);
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            result.setResultCode(RESULT_FAILED_QUERY_RECORD_IN_DB.getResultCode());
            result.setResultMessage(RESULT_FAILED_QUERY_RECORD_IN_DB.getResultMessage());
            return result;
        }
        result.setResultCode(RESULT_OK.getResultCode());
        result.setResultMessage(RESULT_OK.getResultMessage());
        logger.info("Successful to insert ars user list into ams db.");
        return result;
    }

    @Override
    public BaseResponse<Object> insertPasUserInfoToAms() {
        BaseResponse<Object> result = new BaseResponse<Object>();
        logger.info("Start get all pas user info");
        try {
            List<PasUser> pasUserList = pasUserService.findAll();
            if (pasUserList!=null && pasUserList.size()>0) {
                logger.info("End get all pas user info. get {} user info", pasUserList.size());
                logger.info("Start get all ams username list");
                List<AmsUser> amsUserListDB = amsUserService.getUserList("ALL");
                logger.info("End get all ams list. get {} user info", amsUserListDB.size());
                logger.info("Start put pas user info into ams user list.");
                List<AmsUser> amsUserList = new ArrayList<>();
                for (PasUser pasUser : pasUserList) {
                    AmsUser amsUser = null;
                    long id = pasUser.getId();
                    //String displayName = pasUser.getDisplayName();
                    String userName = pasUser.getUsername();
                    String hashPassword = pasUser.getHashedPassword();
                    String status = pasUser.getStatus();
                    Timestamp currentTime = new Timestamp(System.currentTimeMillis());
                    if (amsUserListDB!=null && amsUserListDB.size()>0) {
                        for (AmsUser temp : amsUserListDB) {
                            if (temp.getUsername().equals(userName)) {
                                amsUser = temp;
                                break;
                            }
                        }
                    }
                    if (amsUser==null) {
                        // create new user in ams db
                        amsUser = new AmsUser();
                        amsUser.setExternalId(id);
                        amsUser.setCount(0);
                        amsUser.setCreateTimestamp(currentTime);
                        amsUser.setEnabled("1");
                        amsUser.setId(RandomStringUtils.randomAlphanumeric(AmsUser.ID_GENERATION_LENGTH));
                        amsUser.setUsername(userName);
                    }
                    amsUser.setHashPassword(hashPassword);
                    if (status==null || status.isEmpty() || status.equals(PasUser.STATUS_DISABLED)) {
                        status = AmsUser.STATUS_DELETE;
                    }
                    amsUser.setStatus(status);
                    amsUser.setUpdateTimestamp(currentTime);
                    amsUserList.add(amsUser);
                }
                logger.info("End put pas user info into ams user list.");
                logger.info("Start insert pas user list into ams db, insert {} user", amsUserList.size());
                boolean success = amsUserService.saveUserList(amsUserList);
                logger.info("End insert pas user list into ams db, insert result is {}", success);
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            result.setResultCode(RESULT_FAILED_QUERY_RECORD_IN_DB.getResultCode());
            result.setResultMessage(RESULT_FAILED_QUERY_RECORD_IN_DB.getResultMessage());
            return result;
        }
        result.setResultCode(RESULT_OK.getResultCode());
        result.setResultMessage(RESULT_OK.getResultMessage());
        logger.info("Successful to insert pas user list into ams db.");
        return result;
    }
}
