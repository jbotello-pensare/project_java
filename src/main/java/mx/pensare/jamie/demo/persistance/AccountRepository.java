package mx.pensare.jamie.demo.persistance;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
    List<Account> findAll();

    @Query(
            value = "SELECT * FROM account WHERE number = :number",
            nativeQuery = true)
    Account findByNumber(@Param("number") String number);

    @Transactional
    @Query(value = "UPDATE Account SET balance= :balance WHERE id= :id ",
            nativeQuery = true)
    @Modifying
    public void updateOne(Double balance,Long id);
}
