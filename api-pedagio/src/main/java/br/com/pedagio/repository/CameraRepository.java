package br.com.pedagio.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import br.com.pedagio.model.CameraEntity;

@Repository
public interface CameraRepository extends MongoRepository<CameraEntity, Integer>{
}