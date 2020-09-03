package com.pccw.data.migration.service.ams;

import com.pccw.data.migration.entity.ams.AmsUser;
import com.pccw.data.migration.exception.SqlException;
import com.pccw.data.migration.repository.ams.AmsUserRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.NoSuchElementException;
/**
 * @author: Created by Jim@80992399 on 2020-08-06 15:23
 **/
@Service
public class AmsUserServiceImpl implements AmsUserService {
	private static final Logger logger = LoggerFactory.getLogger(AmsUserServiceImpl.class);
	@Autowired
	private AmsUserRepository amsUserRepository;
	@Autowired
	private PasswordEncoder encoder;

	@Override
	public Boolean saveUserList(List<AmsUser> amsUserList) {
		logger.info("Start connecting DB to insert AMS user list record");
		Boolean success = false;
		try {
			success = amsUserRepository.saveAll(amsUserList) == null ? false : true;
		} catch (Exception e) {
			logger.error(e.getMessage());
			return success;
		}

		logger.info("End connecting DB to insert AMS user list record");
		return success;
	}

	@Override
	public Boolean createUser(String employeeId, String userName,String email, String password, String mobile, String remark,  String nickname) {
		logger.info("Start connecting DB to insert a common user record");
		AmsUser amsUser = new AmsUser();
		amsUser.setEmployeeId(employeeId);
		amsUser.setUsername(userName);
		amsUser.setEmail(email);
		amsUser.setStatus("P");
		amsUser.setMobile(mobile);
		amsUser.setNickName(nickname);
		amsUser.setRemark(remark);
		Timestamp current = new Timestamp(System.currentTimeMillis());
		amsUser.setCreateTimestamp(current);
		amsUser.setUpdateTimestamp(current);
		amsUser.setEnabled("1");
		String userId = RandomStringUtils.randomAlphanumeric(10);
		amsUser.setId(userId);
		amsUser.setHashPassword(encoder.encode(password));
		Boolean success = false;
		try {
			success = amsUserRepository.save(amsUser) == null ? false : true;
        } catch (Exception e) {
        	logger.error(e.getMessage());
        	return success;
        }
		
		logger.info("End connecting DB to insert a common user record");
		return success;
	}

	@Override
	public Boolean deleteUser(String userId) {
		logger.info("Start connecting DB to delete a common user record");
		try {
			amsUserRepository.deleteById(userId);
        } catch (Exception e) {
        	logger.error(e.getMessage());
        	return false;
        }
		
		logger.info("End connecting DB to delete a common user record");
		return true;
	}

	@Override
	public AmsUser getUser(String userId) throws SqlException {
		logger.info("Start connecting DB to get a common user record");
		AmsUser result = null;
		try {
			result = amsUserRepository.findById(userId).get();
        } catch (Exception e) {
        	logger.error(e.getMessage());
        	throw new SqlException("Failed to get user from DB.Please checking entity AmsUser");
        } 
		
		logger.info("End connecting DB to get a common user record");
		return result;
	}

	@Override
	public Boolean updateUser(String userId, String employeeId, String userName,String email, String password, String mobile, String remark,  String nickname) {
		logger.info("Start connecting DB to update a common user record");
		Boolean success = false;
		try {
			AmsUser amsUser = amsUserRepository.findById(userId).get();
			 
			if (employeeId != null) {
				amsUser.setEmployeeId(employeeId);
			} 
			if (userName != null) {
				amsUser.setUsername(userName);
			} 
			if (email != null) {
				amsUser.setEmail(email);
			} 
			if (mobile != null) {
				amsUser.setMobile(mobile);
			} 
			if (nickname != null) {
				amsUser.setNickName(nickname);
			} 
			if (remark != null) {
				amsUser.setRemark(remark);
			} 
			 
			Timestamp current = new Timestamp(System.currentTimeMillis());
			amsUser.setUpdateTimestamp(current);
			success = amsUserRepository.save(amsUser) == null?false:true;
			logger.info("End connecting DB to update a common user record");
        } catch (NoSuchElementException e) {
        	logger.error(e.getMessage());
        	logger.info("Failed to update common user record since doesn't exist user id = ",userId);
        	return success;
        } catch (Exception e) {
        	logger.error(e.getMessage());
        	return success;
        }
		
		return success;	
	}

	@Override
	public List<AmsUser> getUserList(String status) throws SqlException{
		logger.info("Start connecting DB to find all common user records");
		List<AmsUser> result = null;
		try {
			if (status.equals("ALL")) {
				result = amsUserRepository.findAll();
			} else {
				result = amsUserRepository.findAllByStatus(status);
			}
        } catch (Exception e) {
        	logger.error(e.getMessage());
        	throw new SqlException("Failed to get user list from DB.Please checking entity AmsUser");
        }
		
		logger.info("End connecting DB to find all common user records");
		return result;
	}

	@Override
	public Boolean updateUserStatus(String userId, String status) {
		logger.info("Start connecting DB to update a common user status record");
		Boolean success = false;
		try {
			AmsUser amsUser = amsUserRepository.findById(userId).get();

			if (amsUser == null) {
				logger.info("Failed to update common user status since doesn't exist user id = "+userId);
				return success;
			}

			if (status != null) {
				amsUser.setStatus(status);
			}

			Timestamp current = new Timestamp(System.currentTimeMillis());
			amsUser.setUpdateTimestamp(current);
			success = amsUserRepository.save(amsUser) == null?false:true;
			logger.info("End connecting DB to update a common user status record");
		} catch (NoSuchElementException e) {
			logger.error(e.getMessage());
			logger.info("Failed to update common user record since doesn't exist user id = ",userId);
			return success;
		} catch (Exception e) {
			logger.error(e.getMessage());
			return success;
		}

		return success;
	}

    @Override
    public AmsUser getUserByUserName(String userName) {
        logger.info("Start connecting DB to get a common user record");
        AmsUser result = null;
		result = amsUserRepository.findByUsername(userName);
        logger.info("End connecting DB to get a common user record");
        return result;
    }

	@Override
	public Boolean updateUser(AmsUser user) {
		logger.info("Start connecting DB to update a common user record");
		Boolean success = false;
		try {
			Timestamp current = new Timestamp(System.currentTimeMillis());
			user.setUpdateTimestamp(current);
			success = amsUserRepository.save(user) == null?false:true;
			logger.info("End connecting DB to update a common user record");
		} catch (NoSuchElementException e) {
			logger.error(e.getMessage());
			logger.info("Failed to update common user record since doesn't exist user id = ",user.getId());
			return success;
		} catch (Exception e) {
			logger.error(e.getMessage());
			return success;
		}

		return success;
	}


}
