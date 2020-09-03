package com.pccw.data.migration.service.ams;


import com.pccw.data.migration.entity.ams.AmsUser;
import com.pccw.data.migration.exception.SqlException;

import java.util.List;

/**
 * @author: Created by Jim@80992399 on 2020-08-06 15:23
 **/
public interface AmsUserService {
	Boolean saveUserList(List<AmsUser> amsUserList);
	Boolean createUser(String employeeId, String userName, String email, String password, String mobile, String remark, String nickname);
	Boolean deleteUser(String userId);
	AmsUser getUser(String userId)throws SqlException;
	Boolean updateUser(String userId, String employeeId, String userName, String email, String password, String mobile, String remark, String nickname);
	List<AmsUser> getUserList(String status)throws SqlException;
	Boolean updateUserStatus(String userId, String status);
	AmsUser getUserByUserName(String userName);
	Boolean updateUser(AmsUser user);
}
