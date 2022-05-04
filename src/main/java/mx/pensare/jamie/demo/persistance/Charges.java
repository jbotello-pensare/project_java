package mx.pensare.jamie.demo.persistance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Charges {
    private String object;
    private Boolean has_more;
    private Integer total;
    private ArrayList<DataCharges> data;

}
