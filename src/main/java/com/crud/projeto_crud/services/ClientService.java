package com.crud.projeto_crud.services;

import com.crud.projeto_crud.dto.ClientDTO;
import com.crud.projeto_crud.entities.Client;
import com.crud.projeto_crud.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable page){
        Page<Client> result = repository.findAll(page);
        return result.map(x-> new ClientDTO(x));
    }

    @Transactional(readOnly = true)
    public ClientDTO findByID(Long id){
        Optional<Client> result = repository.findById(id);
        Client client = result.orElseThrow(()-> new ResourceExceptionNotFound("Cliente inexistente"));
        return new ClientDTO(client);
    }

    @Transactional
    public ClientDTO insert(ClientDTO dto){
        Client client = new Client();
        copyEntityToDTO(dto, client);
        return new ClientDTO(client);
    }

    @Transactional
    public ClientDTO update(ClientDTO dto, Long id){

            Optional<Client> result = repository.findById(id);
            Client client = result.orElseThrow(()-> new ResourceExceptionNotFound("Cliente inexistente"));
            copyEntityToDTO(dto, client);
            return new ClientDTO(client);

    }

    @Transactional
    public void delete(Long id){
        Optional<Client> result = repository.findById(id);
        Client client = result.orElseThrow(()-> new ResourceExceptionNotFound("Cliente inexistente"));
        repository.deleteById(id);
    }

    public void copyEntityToDTO(ClientDTO dto, Client client){
        client.setName(dto.getName());
        client.setCpf(dto.getCpf());
        client.setIncome(dto.getIncome());
        client.setBirthDate(dto.getBirthDate());
        client.setChildren(dto.getChildren());
        repository.save(client);
    }

}
