package it.unimi.di.prog2.e18;

import java.util.Objects;

/** classe astratta che rappresenta un corpo celeste mutabile */
public abstract class CelestialBody {

    /** name of the celestial body */
    private final String name;
    /** postition of the celestial body */
    private Point position; // stars never change position
    /** the rate at which the body is moving for the respective axes */
    private Point velocity; // 3 dim point, stars = zero

    // AF: AF(name, position, velocity) = the corresponding celestial body named as
    // name, existing at the coordinates represented by position, moving on the
    // x,y,z axes at the velocity represented in velocity
    //
    // IR: name not null && position not null && velocity not null

    // constructors

    /**
     * create a new celestialBody
     * 
     * @param name     the name
     * @param position correspond to the position of the celestial body on x,y,z
     *                 axes
     * @param velocity correspond to the velocity at which the celestial body is
     *                 moving on the x,y,z axes
     * @throws NullPointerException if {@code name} or {@code position} or
     *                              {@code velocity} is null
     */
    // in realtà defensive copy non necessario perché sono tutti immutabili
    public CelestialBody(final String name, final Point position, final Point velocity) throws NullPointerException {
        Point safeCopy = new Point(position.getX(), position.getY(), position.getZ());
        Objects.requireNonNull(position);
        this.position = safeCopy;
        safeCopy = new Point(velocity.getX(), velocity.getY(), velocity.getZ());
        Objects.requireNonNull(velocity);
        this.velocity = safeCopy;
        String safeCopyS = new String(name);
        Objects.requireNonNull(safeCopyS);
        this.name = safeCopyS;
    };

    // methods

    /**
     * return the name of this
     * 
     * @return the name
     */
    public String getName() {
        return name;
    };

    /**
     * return the position of this
     * 
     * @return the position
     */
    public Point getPosition() {
        // non necessario tanto point è immutable
        // return new Point(position.getX(), position.getY(), position.getZ());
        return position;
    };

    /**
     * update the position of this
     * 
     * <p>
     * modifies this
     * 
     * @param newPos the new positoin
     * @throws NullPointerException if {@code newPos} is null
     */
    public void setPosition(Point newPos) throws NullPointerException {
        this.position = newPos;
    }

    /**
     * update the velocity of this
     * 
     * <p>
     * modifies this
     * 
     * @param newVel the new velocity
     * @throws NullPointerException if {@code newVel} is null
     */
    public void setVelocity(Point newVel) throws NullPointerException {
        this.velocity = newVel;
    }

    /**
     * return the velocity of this
     * 
     * @return the velocity
     */
    public Point getVelocity() {
        // non necessario tanto point è immutable
        // return new Point(velocity.getX(), velocity.getY(), velocity.getZ());
        return velocity;
    };

    /**
     * return the potential energy of this
     * 
     * @return the potential energy
     */
    public int getPotentialEnergy() {
        // non necessario tanto point è immutable
        // int energy = position.getNormValue();
        // return energy;
        return position.getNormValue();
    }

    /**
     * return the kinetic energy of this
     * 
     * @return the kinetic energy
     */
    public int getKineticEnergy() {
        // non necessario tanto point è immutable
        // int energy = velocity.getNormValue();
        // return energy;
        return velocity.getNormValue();
    }

    /**
     * An implementation of the RI.
     *
     * @return whether the RI is satisfied.
     */
    private boolean repOk() {
        return true;
    }

}