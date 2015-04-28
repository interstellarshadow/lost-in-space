package org.spacesim.data.ships.systems;

import com.sun.javafx.geom.Vec2d;
import com.sun.javafx.geom.Vec3d;
import org.spacesim.data.ships.Attackable;
import org.spacesim.data.ships.Ship;
import org.spacesim.data.world.Technology;

import java.util.Collection;
import java.util.HashMap;
import java.util.Random;

/**
 * @author Andrew
 * This class is the framework for turret objects in-game. They have a size, and are specified by the technologies
 * used in the turret. For example a turret will have damage types and accuracy depending if it has certain techs.
 */
public class Turret extends ShipSystem implements Aimable {
    private final Size size;
    private Collection<Technology> usedTechs;
    /**
     * Aim Angle is represented as a 2d vector &lt;theta,phi&gt;, in radians.
     */
    private Vec2d aimAngle;

    /**
     * The Constructor for a turret object.
     *
     * @param usedTechs This is a list of the technologies used in the creation of the turret. For example, a certain
     *                  technology might give it an accuracy of +- 1 degree of arc. Another might give it a range of
     *                  5000 km/size category. Another might add more barrels, and a final tech would determine that
     *                  it fires High Explosive rounds.
     * @param size      The size of the Turret. This is an Enumeration from Tiny to Gargantuan. This determines the size and
     *                  shape of the turret.
     */
    public Turret(Collection<Technology> usedTechs, Size size){
        this.size = size;
        this.usedTechs = usedTechs;
        connectionMap = new HashMap<>();
        connectionMap.put(new Vec3d(0.5,0.5,0), null);
        aimAngle = new Vec2d(0,0);//Order is theta, phi and Units are radians.
    }

    /**
     * This is a constructor for a turret, using only techs. It will default to a size of Medium.
     *
     * @param usedTechs This is a list of the technologies used in the creation of the turret. For example, a certain
     *                  technology might give it an accuracy of +- 1 degree of arc. Another might give it a range of
     *                  5000 km/size category. Another might add more barrels, and a final tech would determine that
     *                  it fires High Explosive rounds.
     */
    public Turret(Collection<Technology> usedTechs){
        this(usedTechs, Size.MEDIUM);
    }

    /**
     * This is a function for accessing the technologies used in the Turret.
     *
     * @return This function returns a list of all the technologies used in the Turret. However, it transfers whatever
     * type was used in the definition of the Turret. Therefore, only assume that the list is a <ref>Collection</ref>.
     */
    public Collection<Technology> getTechs(){ return usedTechs;}
    public Size getSize(){return size;}

    @Override
    public Vec3d getDimensions() {
        Vec3d dimensions = null;
        switch (getSize()){
            case MICRO: dimensions = new Vec3d(1,.8,1);break;
            case TINY:
                dimensions = new Vec3d(1.5,1.5,1);
                break;
            case MINI:
                dimensions = new Vec3d(1.5,2,1);
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
        Collection<Technology> techs = getTechs();
        return 0;
    }

    @Override
    public Vec2d getAngle() {
        return aimAngle;
    }

    @Override
    public void aimAt(Vec2d angle) {
        Random random = new Random();
        double aimError = getAimError();
        double errorAngle = random.nextDouble() * Math.PI;
        double errorMag = random.nextGaussian() * aimError;
        double theta = angle.x + errorMag * Math.cos(errorAngle);
        double phi = angle.y + errorMag * Math.sin(errorAngle);
        aimAngle = new Vec2d(theta, phi);
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
