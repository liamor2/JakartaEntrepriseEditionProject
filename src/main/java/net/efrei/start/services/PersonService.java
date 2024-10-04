package net.efrei.start.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import net.efrei.start.models.Person;
import net.efrei.start.repositories.PersonRepository;
import net.efrei.start.dto.CreatePerson;
import net.efrei.start.global.Country;

public abstract class PersonService<P extends Person> {
  private final PersonRepository<P> personRepository;

  @Autowired
  public PersonService(PersonRepository<P> personRepository) {
    this.personRepository = personRepository;
  }

  public List<P> findAll() {
    return (List<P>) personRepository.findAll();
  }

  public P findById(String id) {
    return personRepository.findById(id).orElse(null);
  }

  public void create(CreatePerson createPerson) {
    P person = mapCreatePersonToPerson(createPerson);// Associate movies with the person
    try {
      personRepository.save(person);
    } catch (Exception e) {
      throw new IllegalArgumentException(getPersonType() + " with id " + person.getId() + " already exists");
    }
  }

  public void update(String id, CreatePerson createPerson) {
    P existing = personRepository.findById(id).orElse(null);
    if (existing != null) {
      updateExistingPerson(existing, createPerson);// Associate movies with the person
      personRepository.save(existing);
    } else {
      throw new IllegalArgumentException(getPersonType() + " with id " + id + " not found");
    }
  }

  private void updateExistingPerson(P existing, CreatePerson updates) {
    if (updates.getName() != null) {
      existing.setName(updates.getName());
    }
    if (updates.getFirstname() != null) {
      existing.setFirstname(updates.getFirstname());
    }
    if (updates.getAge() != 0) {
      existing.setAge(updates.getAge());
    }
    if (updates.getCountry() != null) {
      existing.setCountry(Country.valueOf(updates.getCountry().toUpperCase()));
    }
  }

  private P mapCreatePersonToPerson(CreatePerson createPerson) {
    P person = createNewPersonInstance();
    person.setName(createPerson.getName());
    person.setFirstname(createPerson.getFirstname());
    person.setAge(createPerson.getAge());
    if (createPerson.getCountry() != null) {
      person.setCountry(Country.valueOf(createPerson.getCountry().toUpperCase()));
    }
    return person;
  }

  protected abstract P createNewPersonInstance();

  public void delete(String id) {
    P person = personRepository.findById(id).orElse(null);
    if (person != null) {
      personRepository.delete(person);
    } else {
      throw new IllegalArgumentException(getPersonType() + " with id " + id + " not found");
    }
  }

  protected abstract String getPersonType();
}