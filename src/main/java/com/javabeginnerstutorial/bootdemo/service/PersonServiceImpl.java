package com.javabeginnerstutorial.bootdemo.service;

import com.javabeginnerstutorial.bootdemo.model.Person;
import com.javabeginnerstutorial.bootdemo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person getPerson(Long id) {
        return personRepository.findOne(id);
    }

    @Override
    public Person editPerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public void deletePerson(Person person) {
        personRepository.delete(person);
    }

    @Override
    public void deletePerson(Long id) {
        personRepository.delete(id);
    }

    @Override
    public List<Person> getAllPersons(int pageNumber, int pageSize) {
        return personRepository.findAll(new PageRequest(pageNumber, pageSize)).getContent();
    }

    @Override
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }
}
