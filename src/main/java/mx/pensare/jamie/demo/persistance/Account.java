package mx.pensare.jamie.demo.persistance;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "account")
public class Account {
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String name;
    @Id
    private String number;
    @Column(name = "balance")
    private Double balance;
    @OneToMany(mappedBy = "sourceAccount")
    private List<Transfer> transfers;
}
