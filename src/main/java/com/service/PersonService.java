package com.service;


import com.entity.Person;
import com.errors.ItemNotFoundException;
import com.repo.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public List<Person> person() {
        return personRepository.findAll();
    }

    public List<Person> personByLastName(String lastName) {
        return personRepository.findByLastNameIgnoreCase(lastName);
    }

    public Person getPersonById(Long id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(id));
    }

    public Person createPerson(Person newPerson) {
        return personRepository.save(newPerson);
    }

    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

    public Person updateOrCreatePerson(Person newPerson) {
        return personRepository.findById(newPerson.getId())
                .map(person -> {
                    person.setFirstName(newPerson.getFirstName());
                    person.setLastName((newPerson.getLastName()));
                    person.setAddress(newPerson.getAddress());
                    person.setPhone(newPerson.getPhone());
                    return personRepository.save(person);
                })
                .orElseGet(() -> {
                    return personRepository.save(newPerson);
                });
    }
}
