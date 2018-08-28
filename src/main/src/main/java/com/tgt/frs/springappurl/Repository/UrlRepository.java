package com.tgt.frs.springappurl.Repository;

import com.tgt.frs.springappurl.Model.UrlClass;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UrlRepository extends MongoRepository<UrlClass,String> {
   //UrlClass findbyId(String id);
}
