package br.ind.cmil.api.persistence.model;

import br.ind.cmil.api.base.EntityID;
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
    @UniqueConstraint(columnNames = "firstName"),
    @UniqueConstraint(columnNames = "lastName"),
    @UniqueConstraint(columnNames = "email")
})
public class User extends EntityID {

    @Column(unique = true, nullable = false)
    private String firstName;
    @Column(unique = true, nullable = false)
    private String lastName;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime registrationDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime updatedAt;
    private boolean enabled;
    private boolean tokenExpired;
    //@Column(nullable = false, columnDefinition = "TINYINT(1)")
    //private boolean ativo;
    //@Column(length = 64)
    //private String verificador;

    @ManyToMany
    @JoinTable(name = "tbl_users_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private List<Role> roles;

    public User() {
    }

    public User(String id) {
        super.setId(id);
    }

}
