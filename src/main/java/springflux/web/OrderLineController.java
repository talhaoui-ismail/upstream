package springflux.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import springflux.entities.OrderLine;
import springflux.services.OrderLineService;

@RestController
public class OrderLineController {

    @Autowired
    private OrderLineService orderLineService;
    @GetMapping("/commands")
    public Flux<OrderLine> getAllCommands(){
        return orderLineService.getAllCommands();
    }
    @GetMapping("/command/{id}")
    public Mono<OrderLine> findTCommandById(@PathVariable("id") String id){
        return orderLineService.findCommandById(id);
    }
}
