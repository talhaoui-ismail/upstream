package springflux;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springflux.dao.OrderLineRepository;
import springflux.dao.TransactionRepo;
import springflux.entities.Transaction;

import java.util.stream.Stream;

@SpringBootApplication
public class ReactiveTutoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactiveTutoApplication.class, args);
    }

    @Bean
    CommandLineRunner start(final TransactionRepo transactionRepo, final OrderLineRepository orderLineRepository){
      return args -> {
          transactionRepo.deleteAll().subscribe(null,null,()->{
              Stream.of(new Transaction()).forEach(tran->
                      transactionRepo.save(tran)
                              .subscribe(tr->{System.out.println(tr.toString());
                              }));
          });
      };

    }

}
