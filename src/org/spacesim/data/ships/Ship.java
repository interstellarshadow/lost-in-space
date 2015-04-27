/**
 *
 */
package org.spacesim.data.ships;

import com.sun.javafx.geom.Vec3d;
import org.spacesim.data.ships.systems.ShipSystem;
import org.spacesim.data.world.Faction;

import java.util.HashMap;

/**
 * <h1>Overview</h1> The ship class has methods for generations of new ships,
 * procedurally, as well as being the container for ships in the game world. All
 * the data for the ship is contained within the class.
 * <p>
 * The interfaces implemented in the Ship class...
 *
 * @author Andrew Schade
 */
public class Ship implements Crewable, Flyable, Orbitable, Possesable, Damageable, Attackable, Autopilotable, Landable,
        Dockable {
    /**
     * This enum includes all different types of ship roles. These will include
     * everything from probes and drones to capital ships and stations. Of
     * course a capital ship for a low-tech society won't be nearly as big as a
     * capital ship for a high tech faction.
     *
     * @author Andrew
     */
    public enum ShipRole {
        PROBE, DRONE, FIGHTER, EXPLORER, MINER, HAULER, FREIGHTER, STRIKESHIP, INTERCEPTOR, MISSILECRUISER

        // TODO: More to come. Also TODO: Probably make this an abstract class,
        // with ship classes and ship roles being child objects
    }

    /**
     * Constructor for the ship. This is for direct creation, either through a
     * design page, or by mod scripts, etc. It is, of course, called by the
     * generateShip method
     *
     * @param root This parameter is the root system of the ship, which will be implemented either as a Hull, or as a
     *             Spine type.
     * @see org.spacesim.data.Generation
     */
    public Ship(ShipSystem root){
    }

    /**
     * This is the generator function for procedurally generating a ship using a
     * base faction. In this generation method, the ship also has a specified
     * role, as defined by the ShipRole Enum.
     *
     * @param faction Ship generation requires a parent faction to use as a base for
     *                component designs, technologies wealth and more.
     * @return Returns a generated ship.
     */
    public static Ship generateShip(Faction faction, ShipRole role) {
        return null;
    }

    public void setCrew(HashMap<?, ?> crew) {
    }

    @Override
    public Vec3d getDims() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void fireAt() {
        // TODO Auto-generated method stub

    }

    @Override
    public Damageable getDamageable() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Vec3d getVelocity() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Vec3d getAcceleration() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Vec3d getPosition() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Vec3d getHeading() {
        return null;
    }

    @Override
    public float getMaxThrust() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public float getMass() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean isUnderThrust() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isInGravity() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isLandable() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Landable getLandable() throws Exception {
        // TODO Auto-generated method stub
        return null;
    }
}
