package it.unimi.di.prog2.e18;

import java.util.Objects;

/**
 * represent a point in space
 * immutable
 */
// AVREBBE AVUTO SENSO ANCHE COME RECORD, MA SENZA NORMVALUE
public class Point {

    /** x axe position */
    private int x;
    /** y axe position */
    private int y;
    /** z axe position */
    private int z;
    /** |x| + |y| + |z| */
    private int normValue; // variabile cached ma non lo ricalcoliamo ogni volta?

    // AF: AF(x,y,z, normValue) = a point in space with coordinates x,y,z
    //
    // IR = normValue must be equal to |x| + |y| + |z|

    /**
     * construct a point
     * 
     * @param x x
     * @param y y
     * @param z z
     */
    public Point(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
        normValue = Math.abs(x) + Math.abs(y) + Math.abs(z);
        assert repOk();
    }

    /**
     * return x's value of this
     * 
     * @return x
     */
    public int getX() {
        return x;
    };

    /**
     * return y's value of this
     * 
     * @return y
     */
    public int getY() {
        return y;
    };

    /**
     * return z's value of this
     * 
     * @return z
     */
    public int getZ() {
        return z;
    };

    /**
     * return the norm value of the point
     * 
     * <p>
     * that is the result of |{@code x}| + |{@code y}| + |{@code z}|
     * 
     * @return the norm's value of {@code this}
     */
    public int getNormValue() {
        return normValue;
    }

    /**
     * return a new {@code Point} pointing to the sum the sum of {@code this} and
     * {@code other}
     * 
     * @param other the {@code Point} to sum to {@code this}
     * @return the {@code Point} representing the new values
     * @throws NullPointerException if {@code other} is null
     */
    public Point sum(final Point other) throws NullPointerException {
        Objects.requireNonNull(other);
        Point summed = new Point(x + other.x, y + other.y, z + other.z);
        assert summed.repOk();
        return summed;
    }

    /**
     * return a new {@code Point} pointing to the difference between this point and
     * {@code other}
     * 
     * @param other the point so sub to {@code this}
     * @return the point representing the new values
     * @throws NullPointerException if {@code other} is null
     */
    public Point subtract(final Point other) throws NullPointerException {
        Objects.requireNonNull(other);
        Point subbed = new Point(x - other.x, y - other.y, z - other.z);
        assert subbed.repOk();
        return null;
    }

    /**
     * An implementation of the RI.
     *
     * @return whether the RI is satisfied.
     */
    private boolean repOk() {
        return (normValue == Math.abs(x) + Math.abs(y) + Math.abs(z));
    }

    @Override
    public boolean equals(Object other) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return "(" + Integer.toString(x) + ", " + Integer.toString(y) + ", " + Integer.toString(z) + ")";
    }

}
