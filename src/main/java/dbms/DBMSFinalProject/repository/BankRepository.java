package dbms.DBMSFinalProject.repository;
import dbms.DBMSFinalProject.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {
    @Modifying
    @Query(value = "insert into Bank (bank_name, bank_poster) VALUES (:bank_name, :bank_poster)", nativeQuery = true)
    @Transactional
    void insertBank(@Param("bank_name") String bank_name, @Param( "bank_poster" ) String bank_poster);

    @Modifying
    @Query(value = "delete from Bank b where b.bank_id=(:bank_id)", nativeQuery = true)
    @Transactional
    void deleteBank(@Param( "bank_id") Long bank_id );

    @Modifying
    @Transactional
    @Query(value = "update Bank b set b.bank_name=(:bank_name), b.bank_poster=(:bank_poster) where b.bank_id=(:bank_id)", nativeQuery = true)
    void updateBank(@Param("bank_id") int bank_id, @Param("bank_name") String bank_name, @Param( "bank_poster" ) String bank_poster);
}