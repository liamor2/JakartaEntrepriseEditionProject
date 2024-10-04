package net.efrei.start.repositories;

import org.springframework.stereotype.Repository;

import net.efrei.start.models.Actor;

@Repository
public interface ActorRepository extends PersonRepository<Actor> {
}
