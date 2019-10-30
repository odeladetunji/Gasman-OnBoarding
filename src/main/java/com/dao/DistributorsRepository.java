package com.dao;

import com.entity.Distributors;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistributorsRepository  extends CrudRepository<Distributors, Long> {

}
