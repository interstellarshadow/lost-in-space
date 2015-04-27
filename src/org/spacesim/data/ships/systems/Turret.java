package org.spacesim.data.ships.systems;

import com.sun.javafx.geom.Vec2d;
import com.sun.javafx.geom.Vec3d;
import org.spacesim.data.ships.Attackable;
import org.spacesim.data.ships.Ship;
import org.spacesim.data.world.Technology;

import java.util.Collection;
import java.util.HashMap;

/**
 * @author Andrew
 */
public class Turret extends ShipSystem implements Aimable {
    private final Size size;
    private Collection<Technology> usedTechs;
    /**
     * Aim Angle is represented as a 2d vector &lt;theta,phi&gt;, in radians.
     */
    private Vec2d aimAngle;

    public Turret(Collection<Technology> usedTechs, Size size){
        this.size = size;
        this.usedTechs = usedTechs;
        connectionMap = new HashMap<>();
        connectionMap.put(new Vec3d(0.5,0.5,0), null);
        aimAngle = new Vec2d(0,0);//Order is theta, phi and Units are radians.
    }
    public Turret(Collection<Technology> usedTechs){
        this(usedTechs, Size.MEDIUM);
    }
    public Collection<Technology> getTechs(){ return usedTechs;}
    public Size getSize(){return size;}

    @Override
    public Vec3d getDimensions() {
        Vec3d dimensions = null;
        switch (size){
            case MICRO: dimensions = new Vec3d(1,.8,1);break;
            case TINY:
                dimensions = new Vec3d(1.5,1.5,1);
                break;
            case MINI:
                dimensions = new Vec3d(0,0,0);
                break;
            case SMALL:
                dimensions = new Vec3d(0,0,0);
                break;
            case MEDIUM:
                dimensions = new Vec3d(0,0,0);
                break;
            case LARGE:
                dimensions = new Vec3d(0,0,0);
                break;
            case BIG:
                dimensions = new Vec3d(0,0,0);
                break;
            case HUGE:
                dimensions = new Vec3d(0,0,0);
                break;
            case ENORMOUS:
                dimensions = new Vec3d(0,0,0);
                break;
            case HUMONGOUS:
                dimensions = new Vec3d(0,0,0);
                break;
            case GARGANTUAN:
                dimensions = new Vec3d(0,0,0);
                break;
        }
        return dimensions;
    }

    @Override
    public void aimAt(Attackable target) {
        Ship thisShip = connectionMap.get(new Vec3d(0.5,0.5,0)).getContainer();
        Vec3d pos = thisShip.getPosition();
        Vec3d targetPos = target.getPosition();
        aimAt(Aimable.getAngleBetween(pos, targetPos));


    }

    @Override
    public double getAimError() {
        //TODO use Technologies to find Aim Error. And Choose Units (i.e, arc or percent)
        return 0;
    }

    @Override
    public Vec2d getAngle() {
        return aimAngle;
    }

    @Override
    public void aimAt(Vec2d angle) {
        aimAngle = angle;
    }

    @Override
    public void aimAt(double theta, double phi) {
        aimAt(new Vec2d(theta, phi));
    }

    @Override
    public void applyDamage(DamageType type, float damage){
        //TODO implement generated method

    }
}
