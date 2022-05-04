package mx.pensare.jamie.demo.persistance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private String object;
    private String customer_id;
    private String name;
    private String email;
    private String phone;
}
