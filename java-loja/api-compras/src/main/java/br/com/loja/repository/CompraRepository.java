package br.com.loja.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import br.com.loja.model.Compra;

@Repository
public interface CompraRepository extends MongoRepository<Compra, Integer> {
}
