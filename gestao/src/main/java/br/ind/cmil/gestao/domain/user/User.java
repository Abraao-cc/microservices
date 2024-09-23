package br.ind.cmil.gestao.domain.user;

import br.ind.cmil.gestao.base.UserAndProfileID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Administrativo
 */
@Getter
@Setter
@Entity
@Table(name = "tbl_users", uniqueConstraints = {
    @UniqueConstraint(columnNames = "name"),
    @UniqueConstraint(columnNames = "email")
})
public class User extends UserAndProfileID {

    @Column(unique = true, nullable = false)
    private String name;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime registrationDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime updatedAt;
    //@Column(nullable = false, columnDefinition = "TINYINT(1)")
    //private boolean ativo;
    //@Column(length = 64)
    //private String verificador;

   /* @ManyToMany
    @JoinTable(name = "tbl_user_profiles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "profile_id", referencedColumnName = "id")
    )
    private List<Profile> profiles;*/

    public User() {
    }

    public User(String id) {
        super.setId(id);
    }

}
