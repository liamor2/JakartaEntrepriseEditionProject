package net.efrei.start.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.efrei.start.models.Viewer;
import net.efrei.start.repositories.ViewerRepository;

@Service
public class ViewerService extends PersonService<Viewer> {
  @Autowired
  public ViewerService(ViewerRepository viewerRepository) {
    super(viewerRepository);
  }

  @Override
  protected String getPersonType() {
    return "Viewer";
  }

  @Override
  protected Viewer createNewPersonInstance() {
    return new Viewer();
  }
  
}
