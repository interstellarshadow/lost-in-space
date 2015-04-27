package org.spacesim.data.world;

import java.util.HashMap;

import org.spacesim.data.people.IPerson;
import org.spacesim.data.ships.Ship;

public class World {
    private HashMap<Integer, Faction> factions;
    private HashMap<Integer, StarSystem> systems;
    private HashMap<Integer, IPerson> people;
    private HashMap<Integer, Ship> ships;

}
