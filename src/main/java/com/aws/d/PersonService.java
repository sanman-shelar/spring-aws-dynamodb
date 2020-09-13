package com.aws.d;

import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public Person getPersonById(String id) {
        Optional<Person> person = personRepository.findById(id);
        return person.orElseThrow(() -> new PersonNotFoundExecption("Person not found"));
    }

    public Person create(PersonDto personDto) {
        Person person = dtoToEntity(personDto);
        return personRepository.save(person);
    }

    private Person dtoToEntity(PersonDto personDto) {
        Person person = new Person();
        person.setName(personDto.getName());
        person.setAge(personDto.getAge());
        return person;
    }
}
