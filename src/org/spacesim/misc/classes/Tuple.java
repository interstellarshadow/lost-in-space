package org.spacesim.misc.classes;


public class Tuple<Item1, Item2> {
    private Item1 i1;
    private Item2 i2;

    public Tuple(Item1 i1, Item2 i2) {
        this.i1 = i1;
        this.i2 = i2;
    }

    public void setPair(Item1 i1, Item2 i2) {
        this.i1 = i1;
        this.i2 = i2;
    }

    public Item1 getItem1() {
        return i1;
    }

    public Item1 getFirst() {
        return i1;
    }

    public Item2 getItem2() {
        return i2;
    }

    public Item2 getSecond() {
        return i2;
    }

}
