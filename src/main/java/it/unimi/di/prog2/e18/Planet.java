package it.unimi.di.prog2.e18;

import java.util.Objects;

/**
 * a planet extends celestialBody implementing the possibility to
 * update his position and velocity according to other planet's gravitational
 * attraction
 * a planet is a mutable object
 */
public class Planet extends CelestialBody {

    // AF: AF() = super
    //
    // IR: super IR

    // constructor

    /**
     * create a default planet
     * 
     * @param name     the name of the planet
     * @param position the position of the planet at the current time
     * @param velocity the velocity of the planet at the current time
     * @throws NullPointerException if {@code name} or {@code position} or
     *                              {@code velocity} is null
     */
    public Planet(final String name, final Point position, final Point velocity) throws NullPointerException {
        // non faccio controllo tanto lo fa la superclasse ? secondo me andrebbe fatto
        // comunque non possiamo affidarci
        // agli altri metodi per il controllo se non è strettamente necessario
        super(name, position, velocity);
        // assert repOk(); inutile è già chiamato da super
    }

    // methods

    /**
     * update the velocity of this based on the mutual gravitational attraction
     * 
     * <p>
     * update the velocity based on the position of {@code this} and the position of {@code other}.
     * Modifies the {@code velocity} of {@code this}
     * 
     * @throws NullPointerException if {@code other} is null
     */
    public void recalculateVelocity(CelestialBody other) throws NullPointerException {
        Objects.requireNonNull(other);
        Point thisPosition = this.getPosition();
        Point otherPosition = other.getPosition();
        Point thisVelocity = this.getVelocity();
        int[] newVelocity = new int[3];

        // x-coordinate
        if (thisPosition.getX() < otherPosition.getX()) {
            newVelocity[0] = thisVelocity.getX() + 1;
        } else if (thisPosition.getX() > otherPosition.getX()) {
            newVelocity[0] = thisVelocity.getX() - 1;
        } else {
            newVelocity[0] = thisVelocity.getX();
        }

        // y-coordinate
        if (thisPosition.getY() < otherPosition.getY()) {
            newVelocity[1] = thisVelocity.getY() + 1;
        } else if (thisPosition.getY() > otherPosition.getY()) {
            newVelocity[1] = thisVelocity.getY() - 1;
        } else {
            newVelocity[1] = thisVelocity.getY();
        }

        // z-coordinate
        if (thisPosition.getZ() < otherPosition.getZ()) {
            newVelocity[2] = thisVelocity.getZ() + 1;
        } else if (thisPosition.getZ() > otherPosition.getZ()) {
            newVelocity[2] = thisVelocity.getZ() - 1;
        } else {
            newVelocity[2] = thisVelocity.getZ();
        }

        this.setVelocity(new Point(newVelocity[0], newVelocity[1], newVelocity[2]));
    }

    public void recalculatePosition() {
        Point currentVelocity = this.getVelocity();
        Point currentPosition = this.getPosition();
        Point newPosition = new Point(currentVelocity.getX() + currentPosition.getX(),
                currentVelocity.getY() + currentPosition.getY(), currentVelocity.getZ() + currentPosition.getZ());
        this.setPosition(newPosition);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("Planet, name: " + getName() + ", pos: ");
        Point tempPoint = this.getPosition();
        str.append(tempPoint.toString() + ", vel: ");
        tempPoint = getVelocity();
        str.append(tempPoint.toString());
        return str.toString();
    }

    @Override
    public CelestialBody copy() {
        return new Planet(getName(), getPosition(), getVelocity());
    }

}
