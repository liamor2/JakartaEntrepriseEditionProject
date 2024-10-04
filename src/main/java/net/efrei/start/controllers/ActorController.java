package net.efrei.start.controllers;

import net.efrei.start.models.Actor;
import net.efrei.start.services.ActorService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/actors")
public class ActorController extends PersonController<Actor> {

    public ActorController(ActorService actorService) {
        super(actorService);
    }
}
