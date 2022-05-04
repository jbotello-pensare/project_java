package mx.pensare.jamie.demo.persistance;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataOrder{
     private String id;
     private String object;
     private String name;
     private Double unit_price;
     private Integer quantity;
     private String parent_id;
     private Object antifraud_info;
     private Object metadata;

}
