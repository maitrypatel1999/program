package com.controller;


import com.entity.Person;
import com.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
@RequestMapping("/api/person")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping("")
    List<Person> person() {
        return personService.person();
    }

    @GetMapping("/findByLastName")
    List<Person> personByLastName(@RequestParam String lastName) {
        return personService.personByLastName(lastName);
    }

    @GetMapping("/{id}")
    Person getPersonById(@PathVariable Long id) {
        return personService.getPersonById(id);
    }

    @PostMapping("")
    Person createPerson(@Valid @RequestBody Person newPerson) {
        return personService.createPerson(newPerson);
    }

    @PutMapping("/{id}")
    Person updateOrCreatePerson(@PathVariable Long id, @RequestBody Person newPerson) {
        return personService.updateOrCreatePerson(id, newPerson);
    }

    @DeleteMapping("/{id}")
    void deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
    }
}
