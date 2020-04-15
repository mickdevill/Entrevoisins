package com.openclassrooms.entrevoisins.service;
import com.openclassrooms.entrevoisins.model.Neighbour;
import java.util.ArrayList;
import java.util.List;

/**
 * Dummy mock for the Api
 */
public class DummyNeighbourApiService implements  NeighbourApiService {

    private List<Neighbour> neighbours = DummyNeighbourGenerator.generateNeighbours();

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Neighbour> getNeighbours() {
        return neighbours;
    }

    @Override
    public void deleteNeighbour(Neighbour neighbour) {
        neighbours.remove(neighbour);
    }

//les méthode que j'ai ajouté

    List<Neighbour> favoriteNeibours = new ArrayList<>();

    public List<Neighbour> getFavoriteNeibours() {
        return favoriteNeibours;
    }

    public void deleteFavNeibour(Neighbour neighbour) {
        favoriteNeibours.remove(neighbour);
    }

    public void addFavNeibour(Neighbour neighbour) {
        favoriteNeibours.add(neighbour);
    }





    /**
     * {@inheritDoc}
     */
}