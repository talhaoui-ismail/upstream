package springflux.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import springflux.dao.OrderLineRepository;
import springflux.entities.OrderLine;

import java.util.UUID;

@Service
public class OrderLineService {
    @Autowired
    OrderLineRepository orderLineRepository;

    public Flux<OrderLine> getAllCommands(){
        return orderLineRepository.findAll();
    }
    public Mono<OrderLine> findCommandById( String id){
        return orderLineRepository.findById(UUID.fromString(id));
    }
}
