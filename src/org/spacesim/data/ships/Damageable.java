package org.spacesim.data.ships;

public interface Damageable {
    void applyDamage(DamageType type, float value);

    enum DamageType{
        KENETIC, ENERGY, EXPLOSIVE, PLASMA, ION, EMP
    }
}
