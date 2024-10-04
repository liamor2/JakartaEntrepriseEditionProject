package net.efrei.start.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.efrei.start.models.Person;

@Repository
public interface PersonRepository<T extends Person> extends CrudRepository<T, String> {
  
}
