package br.com.loja.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import br.com.loja.model.Venda;

@Repository
public interface VendaRepository extends MongoRepository<Venda, Integer> {
}
