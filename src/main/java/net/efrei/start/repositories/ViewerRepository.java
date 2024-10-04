package net.efrei.start.repositories;

import org.springframework.stereotype.Repository;

import net.efrei.start.models.Viewer;

@Repository
public interface ViewerRepository extends PersonRepository<Viewer> {
}
