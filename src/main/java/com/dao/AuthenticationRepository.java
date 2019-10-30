package com.dao;

import com.entity.Authentication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthenticationRepository extends CrudRepository<Authentication, Long> {
    @Override
    Optional<Authentication> findById(Long aLong);
}
