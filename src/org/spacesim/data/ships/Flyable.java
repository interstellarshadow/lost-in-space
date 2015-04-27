package org.spacesim.data.ships;

import com.sun.javafx.geom.Vec3d;

public interface Flyable {
    Vec3d getVelocity();

    Vec3d getAcceleration();

    Vec3d getPosition();

    Vec3d getHeading();

    float getMaxThrust();

    float getMass();

    boolean isUnderThrust();

    boolean isInGravity();

    boolean isLandable();

    Landable getLandable() throws Exception; // TODO create Useful Exception

}
