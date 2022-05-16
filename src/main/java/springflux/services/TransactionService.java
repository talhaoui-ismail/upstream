package springflux.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import springflux.dao.TransactionRepo;
import springflux.entities.Transaction;
import springflux.enums.TransactionStatus;

import java.util.UUID;

@Service
public class TransactionService {
    @Autowired
    TransactionRepo transactionRepo;

    public void editTransactionStatus(final String idTransaction,final Transaction transaction){
        transactionRepo.findById(UUID.fromString(idTransaction)).subscribe(tr->{
            if(TransactionStatus.CAPTURED.equals(tr.getStatus())){
                return;
            }
            if(TransactionStatus.CAPTURED.equals(transaction.getStatus())&&TransactionStatus.AUTHORIZED.equals(tr.getStatus())){
                tr.setStatus(TransactionStatus.CAPTURED);
                    transactionRepo.save(tr).subscribe();

            }
        });
    }
    public Flux<Transaction> getAllTransactions(){
        return transactionRepo.findAll();
    }
    public Mono<Transaction> findTransactionById( String id){
        return transactionRepo.findById(UUID.fromString(id));
    }

    public Mono<Void> delete( String id){
        return transactionRepo.deleteById(UUID.fromString(id));
    }

    public Mono<Transaction> addTransaction( Transaction transaction){
        return transactionRepo.save(transaction);
    }
}
