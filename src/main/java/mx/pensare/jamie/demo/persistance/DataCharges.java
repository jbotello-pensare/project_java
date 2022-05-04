package mx.pensare.jamie.demo.persistance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataCharges {
    private String id;
    private String object;
    private Boolean livemode;
    private Date created_at;
    private String status;
    private Double amount;
    private Date paid_at;
    private String currency;
    private Double fee;
    private String customer_id;
    private String order_id;
    private Payment payment_method;
}

