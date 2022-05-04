package mx.pensare.jamie.demo.persistance;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="transfer")
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "destination_account")
    private String destinationAccount;
    @ManyToOne
    @JoinColumn(name = "source_account", nullable = false)
    private Account sourceAccount;
    @Column(name = "concept")
    private String concept;
    @Column(name = "amount")
    private Double amount;

}
