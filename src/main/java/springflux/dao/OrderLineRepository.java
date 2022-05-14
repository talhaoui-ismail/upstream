package springflux.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import springflux.entities.OrderLine;

import java.util.UUID;

@Repository
public interface OrderLineRepository extends ReactiveMongoRepository<OrderLine, UUID> {
}
