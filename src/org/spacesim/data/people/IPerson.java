package org.spacesim.data.people;

import java.util.HashMap;

import org.spacesim.data.ships.Possesable;
import org.spacesim.misc.classes.Tuple;

public interface IPerson {
    HashMap<Integer, Possesable> getPossessions();

    void addPossession(Possesable... items);

    void addPossession(Tuple<Integer, Possesable>... items);

    void addPossession(HashMap<Integer, Possesable> items);

}
