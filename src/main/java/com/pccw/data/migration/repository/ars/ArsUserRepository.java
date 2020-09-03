package com.pccw.data.migration.repository.ars;

import com.pccw.data.migration.entity.ars.ArsUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * @author: Created by Jim@80992399 on 2020-08-06 15:24
 **/
@Repository
public interface ArsUserRepository extends JpaRepository<ArsUser, Long> {

    ArsUser findByUsername(String username);

}
