package com.jdawidowska.service.data.repos;

import com.jdawidowska.service.model.Logowanie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogowanieRepo extends CrudRepository<Logowanie, Long>{

}
