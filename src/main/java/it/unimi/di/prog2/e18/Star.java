package it.unimi.di.prog2.e18;

import java.util.Objects;

import javax.naming.OperationNotSupportedException;
/**
 * a planet extends celestialBody removing the possibility to
 * update his position and velocity. a star is an immutable object
 * it's velocity is always 0 because stars cannot change position
 */
public class Star extends CelestialBody {

    // AF: AF() = super
    //
    // IR: super IR

    // constructor

    /**
     * create a default star
     * 
     * @param name     the name of the star
     * @param position the position of the planet at the current time
     * @throws NullPointerException if {@code name} or {@code position} or
     *                              {@code velocity} is null
     */
    public Star(final String name, final Point position) throws NullPointerException {
        // non faccio controllo tanto lo fa la superclasse ? secondo me andrebbe fatto
        // comunque non possiamo affidarci
        // agli altri metodi per il controllo se non è strettamente necessario
        super(name, position, new Point(0, 0, 0));
        // assert repOk(); inutile è già chiamato da super
    }

    // methods

    /**
     * operation not supported
     * 
     * @throws OperationNotSupportedException
     */
    @Override
    public void setPosition(Point newPos) throws NullPointerException {
        throw new UnsupportedOperationException();
    }

    /**
     * operation not supported
     * 
     * @throws OperationNotSupportedException
     */
    @Override
    public void setVelocity(Point newVel) throws NullPointerException {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("Star, name: " + getName() + ", pos: ");
        Point tempPoint = this.getPosition();
        str.append(tempPoint.toString());
        return str.toString();
    }

    @Override
    public CelestialBody copy() {
        return new Star(getName(), getPosition());
    }

}
