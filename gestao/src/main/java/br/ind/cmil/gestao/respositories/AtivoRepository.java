package br.ind.cmil.gestao.respositories;

import br.ind.cmil.gestao.domain.Ativo;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Administrativo
 */
@Repository
public interface AtivoRepository extends JpaRepository<Ativo, Long> {

   // @Query("select a from Ativo a join a.category c join a.local local where c.id  =:category_id and local.id =:local_id ")
   // Optional<Ativo> findByCategoryAndLocalization(Long category_id, Long local_id);

    @Query("select a from Ativo a where a.name = :name")
    Optional<Ativo> findByName(String name);
    
    @Query("select a from Ativo a where a.serie = :serie")
    Optional<Ativo> findBySerie(String serie);
    
    @Query("select a from Ativo a where a.datePay = :datePay")
    Optional<Ativo> findByDatePay(LocalDate datePay);
    
    @Query("select a from Ativo a where a.price = :price")
    Optional<Ativo> findByPrice(BigDecimal price);
    
    @Query("select a from Ativo a where a.status = :status")
    Optional<Ativo> findByStatus(String status);
    
    
   
    
    
    
}
