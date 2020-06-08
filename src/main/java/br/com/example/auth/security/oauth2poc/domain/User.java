package br.com.example.auth.security.oauth2poc.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString(of = "username")
@EqualsAndHashCode(exclude = "roles")
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    private boolean enable;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
    joinColumns = @JoinColumn(name = "id_user", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "id_role", referencedColumnName = "id"))
    private List<Role> roles;

}
