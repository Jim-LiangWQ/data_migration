package com.pccw.data.migration.service.ars;

import com.pccw.data.migration.entity.ars.ArsUser;
import com.pccw.data.migration.repository.ars.ArsUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
 * @author: Created by Jim@80992399 on 2020-08-06 15:24
 **/
@Service
public class ArsUserServiceImpl implements ArsUserService {

    @Autowired
	private ArsUserRepository arsUserRepository;

	@Transactional
    @Override
    public ArsUser save(ArsUser arsUser) {
        return arsUserRepository.save(arsUser);
    }

	@Transactional
	@Override
	public List<ArsUser> saveAll(List<ArsUser> arsUsers) {
		return arsUserRepository.saveAll(arsUsers);
	}

    @Override
    public ArsUser findById(Long id) {
        return arsUserRepository.getOne(id);
    }

    @Override
    public ArsUser findByUsername(String username) {
        return arsUserRepository.findByUsername(username);
    }

    @Override
    public List<ArsUser> findAll() {
        return arsUserRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        //systemUserRepository.delete(id);
    }
}
