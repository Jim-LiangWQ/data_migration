package com.pccw.data.migration.service.pas;

import com.pccw.data.migration.entity.pas.PasUser;

import java.util.List;

/**
 * @author: Created by Jim@80992399 on 2020-08-07 10:38
 **/
public interface PasUserService {
    List<PasUser> findAll();
}
