package org.example.entity_servicies;

import org.example.dao.ClientDao;
import org.example.dao.PlanetDao;
import org.example.hibernate_entities.Client;
import org.example.hibernate_entities.Planet;

public class PlanetCrudService {
    private PlanetDao planetDao = new PlanetDao();

    public void savePlanet(Planet planet) {
        planetDao.save(planet);
    }

    public Planet findPlanetById(String id) {
        return planetDao.findById(id);
    }

    public void updatePlanet(Planet planet) {
        planetDao.update(planet);
    }

    public void deletePlanet(Planet planet) {
        planetDao.delete(planet);
    }
}
