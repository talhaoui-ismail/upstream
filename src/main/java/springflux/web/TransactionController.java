package springflux.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import springflux.dao.TransactionRepo;
import springflux.entities.Transaction;

import java.util.UUID;

@RestController
public class TransactionController {
    @Autowired
    private TransactionRepo transactionRepo;
    @GetMapping("/Transactions")
    public Flux<Transaction> findAll(){
        return transactionRepo.findAll();
    }
    @GetMapping("/Transactions/{id}")
    public Mono<Transaction> findTransactionById(@PathVariable String id){
        return transactionRepo.findById(UUID.fromString(id));
    }

    @PostMapping("/AddTransaction")
    public Mono<Transaction> save(@RequestBody Transaction transaction){
        return transactionRepo.save(transaction);
    }

    @DeleteMapping("/Transactions/{id}")
    public Mono<Void> delete(@PathVariable String id){
        return transactionRepo.deleteById(UUID.fromString(id));
    }

    @PutMapping("/AddTransaction/{id}")
    public Mono<Transaction> update(@RequestBody Transaction transaction,@PathVariable String id){
        transaction.setIdTransaction(UUID.fromString(id));
        return transactionRepo.save(transaction);
    }
}
