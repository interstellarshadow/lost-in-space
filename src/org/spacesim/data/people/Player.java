package org.spacesim.data.people;

import java.util.HashMap;

import org.spacesim.data.ships.Flyable;
import org.spacesim.data.ships.Possesable;
import org.spacesim.misc.classes.Tuple;

public class Player implements IPerson, IPilot, ICrew {

    @Override
    public HashMap<Integer, Possesable> getPossessions() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void addPossession(Possesable... items) {
        // TODO Auto-generated method stub

    }

    @Override
    public void addPossession(Tuple<Integer, Possesable>... items) {
        // TODO Auto-generated method stub

    }

    @Override
    public void addPossession(HashMap<Integer, Possesable> items) {
        // TODO Auto-generated method stub

    }

    @Override
    public Flyable getShip() {
        // TODO Auto-generated method stub
        return null;
    }

}
