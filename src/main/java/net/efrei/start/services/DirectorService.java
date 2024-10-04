package net.efrei.start.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.efrei.start.models.Director;
import net.efrei.start.repositories.DirectorRepository;

@Service
public class DirectorService extends PersonService<Director> {
    @Autowired
    public DirectorService(DirectorRepository directorRepository) {
        super(directorRepository);
    }

    @Override
    protected String getPersonType() {
        return "Director";
    }
}