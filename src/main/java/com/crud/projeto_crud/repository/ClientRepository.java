package com.crud.projeto_crud.repository;

import com.crud.projeto_crud.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
