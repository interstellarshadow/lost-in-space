package org.spacesim.data.ships.systems;

import com.sun.javafx.geom.Vec2d;
import com.sun.javafx.geom.Vec3d;
import org.spacesim.data.ships.Attackable;

/**
 * @author Andrew
 */
public interface Aimable {
    void aimAt(Attackable target);
    double getAimError();
    Vec2d getAngle();
    void aimAt(Vec2d angle);
    void aimAt(double theta, double phi);
    static Vec2d getAngleBetween(Vec3d from, Vec3d to){
        double delX = to.x - from.x;
        double delY = to.y-from.y;
        double delZ = to.z-from.z;
        double theta = Math.acos(delZ/(Math.sqrt(Math.pow(delX,2)+Math.pow(delY,2)+Math.pow(delZ,2))));
        double phi = Math.atan(delY/delX);

        return new Vec2d(theta, phi);

    }

}
