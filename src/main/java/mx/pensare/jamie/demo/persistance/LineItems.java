package mx.pensare.jamie.demo.persistance;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LineItems {
    private String object;
    private Boolean has_more;
    private Integer total;
    private ArrayList<DataOrder> data;

}
