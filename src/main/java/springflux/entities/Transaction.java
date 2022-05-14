package springflux.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Document
@Data
@AllArgsConstructor
@ToString
public class Transaction {
    @Id
    private UUID idTransaction;
    private double montant;
    private TypeMoyenPaiement typeMoyenPaiement;
    private TransactionStatus status;
    List<OrderLine> command;
    public Transaction(){
        idTransaction=UUID.randomUUID();

    }
}
