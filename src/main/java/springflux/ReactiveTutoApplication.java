package springflux;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springflux.dao.OrderLineRepository;
import springflux.dao.TransactionRepo;
import springflux.entities.OrderLine;
import springflux.entities.Transaction;
import springflux.enums.PaymentType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class ReactiveTutoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactiveTutoApplication.class, args);
    }

    @Bean
    CommandLineRunner start(final TransactionRepo transactionRepo, final OrderLineRepository orderLineRepository){
        List<OrderLine> commands=new ArrayList<>();
        commands.add(new OrderLine("paires de gants",4,10l));
        commands.add(new OrderLine(" bonnet en laine",1,14.80));
      return args -> {
          orderLineRepository.deleteAll().subscribe(null,null,()->{
                orderLineRepository.saveAll(commands).subscribe(ol->{
                    System.out.println(ol.toString());
                });
          });
          transactionRepo.deleteAll().subscribe(null,null,()->{
              Stream.of(new Transaction(54.80, PaymentType.BANK_CARD,commands)).forEach(tran->
                      transactionRepo.save(tran)
                              .subscribe(tr->{System.out.println(tr.toString());
                              }));
          });
      };

    }

}
