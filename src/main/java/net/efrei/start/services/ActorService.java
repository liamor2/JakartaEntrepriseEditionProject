package net.efrei.start.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.efrei.start.models.Actor;
import net.efrei.start.repositories.ActorRepository;

@Service
public class ActorService extends PersonService<Actor> {
    @Autowired
    public ActorService(ActorRepository actorRepository) {
        super(actorRepository);
    }

    @Override
    protected String getPersonType() {
        return "Actor";
    }
}