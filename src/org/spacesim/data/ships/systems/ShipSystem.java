package org.spacesim.data.ships.systems;

import com.sun.javafx.geom.Vec3d;
import org.spacesim.data.ships.Damageable;
import org.spacesim.data.ships.Ship;

import java.util.Map;

public abstract class ShipSystem implements Damageable {
    protected Map<Vec3d, Connection> connectionMap;
    public class Connection{
        private final ShipSystem parent;



        public Ship getContainer() {
            return container;
        }

        private final Ship container;
        private ShipSystem child;

        public Connection(Ship container, ShipSystem parent, ShipSystem child){
            this.parent = parent;
            this.child = child;
            this.container = container;
        }
        public void setChild(ShipSystem child){
            this.child = child;
        }
        public ShipSystem getParent()
        {
            return parent;
        }
        public ShipSystem getChild(){
            return child;
        }

    }

    public Map<Vec3d,Connection> getLinkages(){return connectionMap;}
    public abstract Vec3d getDimensions();

}
