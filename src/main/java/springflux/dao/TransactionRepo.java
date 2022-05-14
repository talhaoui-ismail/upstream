package springflux.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import springflux.entities.Transaction;

import java.util.UUID;

public interface TransactionRepo extends ReactiveMongoRepository<Transaction, UUID> {
}
