package springflux.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import springflux.entities.Transaction;

import java.util.UUID;

@Repository
public interface TransactionRepo extends ReactiveMongoRepository<Transaction, UUID> {
}
