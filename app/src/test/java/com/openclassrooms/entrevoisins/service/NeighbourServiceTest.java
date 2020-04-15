package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

/**
 * Unit test on Neighbour service
 */
@RunWith(JUnit4.class)
public class NeighbourServiceTest {

    private NeighbourApiService service;

    @Before
    public void setup() {
        service = DI.getNewInstanceApiService();
    }

    @Test
    public void getNeighboursWithSuccess() {
        List<Neighbour> neighbours = service.getNeighbours();
        List<Neighbour> expectedNeighbours = DummyNeighbourGenerator.DUMMY_NEIGHBOURS;
        assertThat(neighbours, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedNeighbours.toArray()));
    }

    @Test
    public void deleteNeighbourWithSuccess() {
        Neighbour neighbourToDelete = service.getNeighbours().get(0);
        service.deleteNeighbour(neighbourToDelete);
        assertFalse(service.getNeighbours().contains(neighbourToDelete));
    }

@Test
    public void  deleteFavNeibour(){
        Neighbour favNeibour = new Neighbour(777, "le casino", "http://i.pravatar.cc/150?u=a042581f4e29026704d");
       service.getFavoriteNeibours().add(favNeibour);
        service.deleteFavNeibour(favNeibour);
    assertFalse(service.getFavoriteNeibours().contains(favNeibour));
    }

    @Test
    public void addFavNeibour(){
        Neighbour favNeibour = new Neighbour(943, "jacline", "http://i.pravatar.cc/150?u=a042581f4e29026704d");
        service.addFavNeibour(favNeibour);
    assert(service.getFavoriteNeibours().contains(favNeibour));
    }

@Test
    public void getFavoriteNeibours(){
    List<Neighbour>favoriteNeibours = service.getFavoriteNeibours();
    List<Neighbour> expectedNeighbours = DummyNeighbourGenerator.DUMMY_NEIGHBOURS;
  //la diference entre les favoris et les non favoris
   favoriteNeibours.addAll(expectedNeighbours);
    assertThat(favoriteNeibours, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedNeighbours.toArray()));
}
}
