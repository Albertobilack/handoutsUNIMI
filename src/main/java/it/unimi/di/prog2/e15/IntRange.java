package it.unimi.di.prog2.e15;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * una collezione mutabile di integer distanti equamente uno dall'altro all'interno di un range
 * 
 * <p>una collezione ordinata in ordine crescente di integer definita sull'insieme dei numeri interi,
 * delimitata a un range che possiede un inizio (compreso) e una fine (non compreso),
 * dove ogni numero dista dal successivo e dal predente un certo numero di posizioni
 * a partire dal primo numero che corrisponde all'inizio del range (compreso)
 */
public class IntRange implements Iterable<Integer> {

    //instace variables
    private int from;
    private int to;
    private int step;

    //AF(from, to, step) = ogni numero intero, a partire da "from" incluso fino a "to" escluso,
    // tale che il numero sia ottenibile sommando a "from" N * "step", con N>=0
    // se from = to Range viene considerato vuoto
    //
    //IR = IntRange != null, se from < to -> step > 0, se from > to -> step < 0

    //constructor
    
    /**
     * create the "empty" set
     * 
     * <p> the empty set is a set with from = to = 0 and step = 1 
     */
    public IntRange() {
        from = 0;
        to = 0;
        step = 1;
    }

    /**
     * crea un IntRange ben formato
     * 
     * @param from l'inizio del range
     * @param to la fine del range
     * @param step la distanza tra i numeri del range
     * @throws IllegalArgumentException se {@code from} < {@code to} && step < 0
     * @throws IllegalArgumentExceptionm se {@code from} > {@code to} && step > 0
     */
    public IntRange(int from, int to, int step) throws IllegalArgumentException {
        //if (from < to && step < 0) throw new IllegalArgumentException("IntRange.IntRange"); 
        //if (from > to && step > 0) throw new IllegalArgumentException("IntRange.IntRange"); 
        this.from = from;
        this.to = to;
        this.step = step;
        //assert repOk();
    }

    // private IntRange(Builder builder) {
    //     this.from = builder.from;
    //     this.to = builder.to;
    //     this.step = builder.step;
    // }

    // public static class Builder {
    //     private int from;
    //     private int to;
    //     private int step;

    //     public Builder from(int from) {
    //         this.from = from;
    //         return this;
    //     }


    //     public Builder to(int to) {
    //         this.to = to;
    //         return this;
    //     }


    //     public Builder step(int step) {
    //         this.step = step;
    //         return this;
    //     }

    //     public IntRange build() {
    //         return new IntRange(this);
    //     }
    // }

    //methods

    /**
     * modifies {@code this} replacing {@code this.from}
     * 
     * @param fromNew the new {@code this.from} 
     * @throws IllegalArgumentException if {@code fromNew} > {@code this.to} && step > 0
     * @throws IllegalArgumentException se {@code fromNew} < {@code this.to} && step < 0
     * 
     */
    public void setFrom(int fromNew) throws IllegalArgumentException {
        //if (fromNew < to && step < 0) throw new IllegalArgumentException("IntRange.setFrom"); 
        //if (fromNew > to && step > 0) throw new IllegalArgumentException("IntRange.setFrom"); 
        this.from = fromNew;
        assert repOk(); 
    }

    /**
     * modifies {@code this} replacing {@code this.to}
     * 
     * @param toNew the new {@code this.to} 
     * @throws IllegalArgumentException if {@code this.from} > {@code newTo} && step > 0
     * @throws IllegalArgumentException se {@code this.from} < {@code newTo} && step < 0
     */
    public void setTo(int newTo) {
        //if (from < newTo && step < 0) throw new IllegalArgumentException("IntRange.setFrom"); 
        //if (from > newTo && step > 0) throw new IllegalArgumentException("IntRange.setFrom");         
        this.to = newTo;
        assert repOk();
    }

    /**
     * modifies {@code this} replacing {@code this.step}
     * 
     * @param newStep the new {@code this.step}
     * @throws IllegalArgumentException if {@code from} > {@code newTo} && newStep > 0
     * @throws IllegalArgumentException se {@code from} < {@code newTo} && newStep < 0     
     */
    public void setStep(int newStep) throws IllegalArgumentException {
        //if (from < to && newStep < 0) throw new IllegalArgumentException("IntRange.setFrom"); 
        //if (from > to && newStep > 0) throw new IllegalArgumentException("IntRange.setFrom");
        this.step = newStep;
        assert repOk();
    }

    // @Override
    // public boolean equals(Object other) {
    //     return false;
    // }

    // @Override
    // public String toString() {
    //     return null;
    // }

    // @Override
    // public int hashCode() {
    //     return 0;
    // } 

    @Override
    public Iterator<Integer> iterator() {
        return new intRangeGen();
    }

    /**
    * An implementation of the RI.
    *
    * @return whether the RI is satisfied.
    */
    private boolean repOk() {
        //if (from < to && step <= 0) return false;
        //if (from > to && step >= 0) return false;
        return true;
    } 

    /** a class to implement the generator
     * the object must not be modified while in use (?)
    */
    //probabilmente era meglio farla static tanto non gli serve riferimento oggetto copiamo i valori comunque perché li modifico?
    private class intRangeGen implements Iterator<Integer> {

        /** boh */
        private int start = from; 

        //liskov vorrebbe anche AF e IR

        /** . */
        private intRangeGen() {}

        @Override
        public boolean hasNext() {
            if (step > 0) {
                return start < to;
            } else {
                return start > to;
            }
        }

        @Override
        public Integer next() {
            if (!hasNext()) throw new NoSuchElementException();
            int current = start;
            start += step;
            return current;
        }

        // @Override
        // public boolean hasNext() {
        //  if (start == to) return false;
        //  if (step < 0 && start + step > to) return true;
        //  if (step > 0 && start + step < to) return true;
        //  return false;
        // }

        // @Override
        // public Integer next() {
        //     if (!hasNext()) throw new NoSuchElementException();
        //     if (start == from) {
        //         start+=step;
        //         return start;
        //     }
        //     start += step;
        //     return start;
        // }

    }
    

}
