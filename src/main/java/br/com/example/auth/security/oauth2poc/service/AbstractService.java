package br.com.example.auth.security.oauth2poc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;
import java.util.List;

public abstract class AbstractService<E, I extends Serializable, R extends CrudRepository<E, I>> {

    @Autowired
    private R repository;

    public E save(E entity) {
        return this.repository.save(entity);
    }

    public E findById(I id) {
        return this.repository.findById(id).orElseThrow(() -> new RuntimeException("Data not found"));
    }

    public List<E> findAll() {
        return (List<E>) this.repository.findAll();
    }

    public void delete(I id) {
        this.repository.deleteById(id);
    }

    public R getRepository() {
        return repository;
    }

}
