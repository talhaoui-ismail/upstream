package springflux.entities;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
@Data
@ToString
public class OrderLine  {
    @Id
    private UUID orderLineId;
    private String product_Name;
    private int quantity;
    private double prix;
    public OrderLine(){
        orderLineId=UUID.randomUUID();
    }

    public OrderLine(String product_Name, int quantity, double prix) {
        orderLineId=UUID.randomUUID();
        this.product_Name = product_Name;
        this.quantity = quantity;
        this.prix = prix;
    }
}
