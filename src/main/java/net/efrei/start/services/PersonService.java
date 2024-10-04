package net.efrei.start.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import net.efrei.start.models.Person;
import net.efrei.start.repositories.PersonRepository;

public abstract class PersonService<T extends Person> {
    private final PersonRepository<T> personRepository;

    @Autowired
    public PersonService(PersonRepository<T> personRepository) {
        this.personRepository = personRepository;
    }

    public List<T> findAll() {
        return (List<T>) personRepository.findAll();
    }

    public T findById(String id) {
        return personRepository.findById(id).orElse(null);
    }

    public void create(T person) {
        try {
            personRepository.save(person);
        } catch (Exception e) {
            throw new IllegalArgumentException(getPersonType() + " with id " + person.getId() + " already exists");
        }
    }

    public void update(String id, T person) {
        T existingPerson = personRepository.findById(id).orElse(null);
        if (existingPerson != null) {
            updateExistingPerson(existingPerson, person);
            personRepository.save(existingPerson);
        } else {
            throw new IllegalArgumentException(getPersonType() + " with id " + id + " not found");
        }
    }

    private void updateExistingPerson(T existing, T updates) {
        if (updates.getName() != null) {
            existing.setName(updates.getName());
        }
        if (updates.getFirstname() != null) {
            existing.setFirstname(updates.getFirstname());
        }
        if (updates.getAge() != 0) {
            existing.setAge(updates.getAge());
        }
    }

    public void delete(String id) {
        T person = personRepository.findById(id).orElse(null);
        if (person != null) {
            personRepository.delete(person);
        } else {
            throw new IllegalArgumentException(getPersonType() + " with id " + id + " not found");
        }
    }

    protected abstract String getPersonType();
}