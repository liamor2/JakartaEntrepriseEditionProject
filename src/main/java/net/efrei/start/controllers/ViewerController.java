package net.efrei.start.controllers;

import net.efrei.start.models.Viewer;
import net.efrei.start.services.ViewerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/viewers")
public class ViewerController extends PersonController<Viewer> {

  public ViewerController(ViewerService viewerService) {
    super(viewerService);
  }
}
