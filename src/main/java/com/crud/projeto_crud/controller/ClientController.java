package com.crud.projeto_crud.controller;

import com.crud.projeto_crud.dto.ClientDTO;
import com.crud.projeto_crud.services.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping
    public Page<ClientDTO> findAll(Pageable pageable){
        return service.findAll(pageable);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClientDTO> findByID(@PathVariable Long id){
        ClientDTO dto = service.findByID(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ClientDTO insert(@Valid @RequestBody ClientDTO dto){
        return service.insert(dto);
    }

    @PutMapping(value = "/{id}")
    public ClientDTO update(@Valid @RequestBody ClientDTO dto, @PathVariable Long id){
        return service.update(dto, id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }


}
