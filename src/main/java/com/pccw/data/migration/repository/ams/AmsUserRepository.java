package com.pccw.data.migration.repository.ams;

import com.pccw.data.migration.entity.ams.AmsUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * @author: Created by Jim@80992399 on 2020-08-06 15:23
 **/
@Repository
public interface AmsUserRepository extends JpaRepository<AmsUser, String> {


    List<AmsUser> findAllByStatus(String status);

    AmsUser findByUsername(String username);
}
