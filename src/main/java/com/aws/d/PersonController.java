package com.aws.d;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    @GetMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Person getPerson(@PathVariable String id) {
        return personService.getPersonById(id);
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Person createPerson(@RequestBody PersonDto personDto) {
        return personService.create(personDto);
    }
}
