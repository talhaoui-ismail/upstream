package springflux.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import springflux.entities.Transaction;
import springflux.services.TransactionService;

@RestController
public class TransactionController {
    @Autowired
    private TransactionService transactionService;
    @GetMapping("/Transactions")
    public Flux<Transaction> getAllTransactions(){
        return transactionService.getAllTransactions();
    }
    @GetMapping("/Transactions/{id}")
    public Mono<Transaction> findTransactionById(@PathVariable("id") String id){
        return transactionService.findTransactionById(id);
    }

    @DeleteMapping("/Transactions/{id}")
    public Mono<Void> delete(@PathVariable("id") String id){
        return transactionService.delete(id);
    }

    @PostMapping("/AddTransaction/")
    public Mono<Transaction> addTransaction(@RequestBody Transaction transaction){
        return transactionService.addTransaction(transaction);
    }

    @PutMapping("/updateTransationStatus/{id}")
    public void editTransactionStatus(@PathVariable("id") final String id ,@RequestBody Transaction transaction){
         transactionService.editTransactionStatus(id,transaction);
    }
}
