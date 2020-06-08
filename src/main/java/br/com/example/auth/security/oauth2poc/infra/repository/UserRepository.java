package br.com.example.auth.security.oauth2poc.infra.repository;

import br.com.example.auth.security.oauth2poc.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsername(String username);
}
