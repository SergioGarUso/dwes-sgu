package org.example.harrypotter.repositories;

import org.example.harrypotter.entities.House;

import java.util.ArrayList;
import java.util.List;

public class HouseRepository {
    private List<House> houses = new ArrayList<>();

    public HouseRepository() {
        houses.add(new House("Gryffindor", "Lion", "Godric Gryffindor"));
        houses.add(new House("Hufflepuff", "Badger", "Helga Hufflepuff"));
        houses.add(new House("Ravenclaw", "Eagle", "Rowena Ravenclaw"));
        houses.add(new House("Slytherin", "Serpent", "Salazar Slytherin"));
    }

    public List<House> getHouses() {
        return houses;
    }

    public House getHouse(String name) {
        for (House house : houses) {
            if (house.getName().equals(name)) {
                return house;
            }
        }
        return null;
    }
    public void addHouse(House house) {
        houses.add(house);
    }
    public void updateHouse(String name, House house) {
        for (int i = 0; i < houses.size(); i++) {
            if (houses.get(i).getName().equals(name)) {
                houses.set(i, house);
                break;
            }
        }
    }
    public void deleteHouse(String name) {
        houses.removeIf(house -> house.getName().equals(name));
    }
}
