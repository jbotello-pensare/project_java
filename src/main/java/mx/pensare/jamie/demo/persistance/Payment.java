package mx.pensare.jamie.demo.persistance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    private String object;
    private String type;
    private String name;
    private String exp_month;
    private String exp_year;
    private String auth_code;
    private String last4;
    private String brand;
    private String issuer;
    private String account_type;
    private String country;
    private Integer fraud_score;
    private ArrayList<Object> fraud_indicators;
}
