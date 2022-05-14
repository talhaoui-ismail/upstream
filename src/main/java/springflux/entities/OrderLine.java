package springflux.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
@ToString
public class OrderLine  {
    private String product_Name;
    private int quantity;
    private double prix;
    public OrderLine(){}
}
