package org.spacesim.data.ships.systems;

/**
 * Created by Andrew on 4/26/2015.
 */
public enum Size {
        MICRO("Micro"), TINY("Tiny"), MINI("Mini"), SMALL("Small"), MEDIUM("Medium") , LARGE("Large"),
            BIG("Big"), HUGE("Huge"), ENORMOUS("Enormous"), HUMONGOUS("Humongous"), GARGANTUAN("Gargantuan");
    private final String name;

    Size(String name){
       this.name = name;
    }

        @Override
        public String toString() {
            return this.name;
        }
    }
