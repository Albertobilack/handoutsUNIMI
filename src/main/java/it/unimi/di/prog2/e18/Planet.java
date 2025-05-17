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
     * update the velocity based on the position of {@code this} and {@code null}
     * modifies the {@code velocity} of {@code this}
     * 
     * @throws NullPointerException if {@code other} is null
     */
    public void recalculateVelocity(CelestialBody other) throws NullPointerException {
        Objects.requireNonNull(other);
        Point thisPosition = this.getPosition();
        Point otherPosition = other.getPosition();
        Point thisVelocity = this.getVelocity();
        int[] whatToUpdate = new int[2];
        if (thisPosition.getX() > otherPosition.getX()) {
            whatToUpdate[0] = 1;
        } else if (thisPosition.getX() < otherPosition.getX()) {
            whatToUpdate[0] = -1;
        }
        whatToUpdate[0] += thisVelocity.getX();
        if (thisPosition.getY() > otherPosition.getY()) {
            whatToUpdate[1] = 1;
        } else if (thisPosition.getY() < otherPosition.getY()) {
            whatToUpdate[1] = -1;
        }
        whatToUpdate[1] += thisVelocity.getY();
        if (thisPosition.getZ() > otherPosition.getZ()) {
            whatToUpdate[2] = 1;
        } else if (thisPosition.getZ() < otherPosition.getZ()) {
            whatToUpdate[2] = -1;
        }
        whatToUpdate[2] += thisVelocity.getZ();
        this.setVelocity(new Point(whatToUpdate[0], whatToUpdate[1], whatToUpdate[2]));
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
        str.append(tempPoint.toString() + " vel: ");
        tempPoint = getVelocity();
        str.append(tempPoint.toString());
        return str.toString();
    }

    @Override
    public CelestialBody copy() {
        return new Planet(getName(), getPosition(), getVelocity());
    }

}
