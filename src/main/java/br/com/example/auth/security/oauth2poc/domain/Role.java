package br.com.example.auth.security.oauth2poc.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString(of = "name")
@EqualsAndHashCode(exclude = "users")
@NoArgsConstructor
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;
}
