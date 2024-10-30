package com.acme.service;

import com.acme.model.Person;
import com.acme.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository repository;

    public Person createPerson(Person person) {
        return repository.save(person);
    }

    public Person findById(Long personId){
        return repository.findById(personId)
            .orElseThrow(() -> new RuntimeException("Membro não encontrado"));
    }

}
