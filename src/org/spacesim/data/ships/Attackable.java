package org.spacesim.data.ships;

import com.sun.javafx.geom.Vec3d;

public interface Attackable {
    Vec3d getPosition();

    Vec3d getDims();

    void fireAt();

    Damageable getDamageable();
}
