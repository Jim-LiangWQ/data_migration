package com.pccw.data.migration.service.ars;


import com.pccw.data.migration.entity.ars.ArsUser;

import java.util.List;
/**
 * @author: Created by Jim@80992399 on 2020-08-06 15:24
 **/
public interface ArsUserService {

    ArsUser save(ArsUser arsUser);

	List<ArsUser> saveAll(List<ArsUser> arsUsers);

    ArsUser findById(Long id);

    ArsUser findByUsername(String username);

    List<ArsUser> findAll();

    void delete(Long id);
}
