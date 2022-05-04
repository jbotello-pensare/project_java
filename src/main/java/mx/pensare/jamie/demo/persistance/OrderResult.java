package mx.pensare.jamie.demo.persistance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResult {
    private String id;
    private String object;
    private Boolean livemode;
    private Double amount;
    private Double amount_refunded;
    private String payment_status;
    private String currency;
    private Customer customer_info;
    private Date created_at;
    private Date updated_at;
    private LineItems line_items;
    private Charges charges;
    private Object metadata;

}

