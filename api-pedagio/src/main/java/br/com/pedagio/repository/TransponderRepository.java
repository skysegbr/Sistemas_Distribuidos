package br.com.pedagio.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import br.com.pedagio.model.TransponderEntity;

@Repository
public interface TransponderRepository extends MongoRepository<TransponderEntity, String> {
}
