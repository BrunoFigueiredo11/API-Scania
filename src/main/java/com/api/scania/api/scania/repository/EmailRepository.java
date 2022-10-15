package com.api.scania.api.scania.repository;

import com.api.scania.api.scania.model.EmailModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends MongoRepository<EmailModel, String>{

}
