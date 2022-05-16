package springflux.entities;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import springflux.enums.TransactionStatus;
import springflux.enums.PaymentType;

import java.util.List;
import java.util.UUID;

@Document
@Data
@ToString
public class Transaction {
    @Id
    private UUID idTransaction;
    private double montant;
    private PaymentType typeMoyenPaiement;
    private TransactionStatus status;
    List<OrderLine> command;
    public Transaction(){
        idTransaction=UUID.randomUUID();
        status=TransactionStatus.NEW;
    }
    public Transaction(final double montant, final PaymentType typeMoyenPaiement, final List<OrderLine> commands){
        idTransaction=UUID.randomUUID();
        status=TransactionStatus.NEW;
        this.montant=montant;
        this.command=commands;
        this.typeMoyenPaiement=typeMoyenPaiement;
    }
}
