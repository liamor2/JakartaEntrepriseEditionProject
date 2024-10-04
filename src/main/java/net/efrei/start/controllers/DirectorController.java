package net.efrei.start.controllers;

import net.efrei.start.models.Director;
import net.efrei.start.services.DirectorService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/directors")
public class DirectorController extends PersonController<Director> {

    public DirectorController(DirectorService directorService) {
        super(directorService);
    }
}
