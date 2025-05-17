package it.unimi.di.prog2.e18;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Objects;
import java.util.List;

/** collection of planets and fixed stars updating at a discrete time
 * time can never go backwards
 * mutable object 
*/
//nota: non presentiamo un metodo getState perché sarebbe difficile da rappresentare in modo corretto e differente
//da un banale toString. per questo implementiamo un iteratore
public class AstronomicalSystem implements Iterable<CelestialBody> {

    /** the planet and stars that populates the system */
    //possono variare perché stelle muoiono eccetera
    private List<CelestialBody> state;
    /** the discrete time that characterize the state of the system  */
    private int time;

    //AF: AF(state, time) = "state" contains the collection of all the celestial body found in the System at the 
    //    given "time", with their implied velocity and position at the moment "time" 
    //
    //IR: state not null && state's elements not null && state[i].name != state[j].name for each i!=j

    //domanda: tempo può andare indietro? può essere negativo? cosa succede se va indietro?

    /** build an empty astronomicalSystem */
    public AstronomicalSystem() {
        state = new ArrayList<>(0);
        time = 0;
    }

    // /**
    //  * build an astronomicalSystem from a given array of {@code celestialbody}
    //  * 
    //  * @param system the array containing the celestialbodies
    //  * @throws NullPointerException if {@code system} is null
    //  * @throws NullPointerException if {@code system} contains null objects
    //  * @throws IllegalArgumentException if {@code system} contains elements with the same name
    //  */
    // public AstronomicalSystem(CelestialBody[] system) {
    //     CelestialBody[] temp = new CelestialBody[system.length];
    //     int i = 0;
    //     for (CelestialBody body : system) {
    //         temp[i] = body;
    //     }
    //     Objects.requireNonNull(system); //una volta copiato verifico non sia nullo per sicurezza
    //     for (CelestialBody element : temp) { //controllo dopo il not null per evitare che possano diventare null dopo il controllo nel ciclo prima (defensive prog)
    //         Objects.requireNonNull(element);
    //     }
    //     if (!checkName(temp)) throw new IllegalArgumentException();
    //     state = temp;
    //     time = 0;
    // }

    // /**
    //  * check if {@code names} containes CelestialBody with the same name
    //  * 
    //  * @return true if no name of CelestialBody occurres twice, false otherwise
    //  */
    // private static boolean checkName(CelestialBody[] names) {
    //     for (int i = 0; i < names.length; i++) {
    //         for (int j = i + 1; j < names.length; j++) {
    //             if (names[i].getName().equals(names[j].getName())) {
    //                 return false;
    //             }
    //         }
    //     }
    //     return true;
    // }

    // /**
    //  * check if {@code this.state} already contains the given CelestialBody
    //  * 
    //  * @return true if no CelestialBody in {@code states} share the same name as {@code newName}
    //  */
    // private boolean checkName(CelestialBody newName) {
    //     for (CelestialBody cel : state) {
    //         if (cel.getName().equals(newName.getName())) return false;
    //     }
    //     return true;
    // }

    //MAGARI SAREBBE UTILE DARE LA POSSIBILTÀ DI CANCELLARLI ANCHE SOLO COL NOME

    /**
     * remove the given {@code CelestialBody} from the system
     * 
     * <p> modifies the {@code AstronomicalSystem}
     * @param toRemove the body to remove
     * @throws NullPointerException if toRemove is null
     */
    public void removeBody(CelestialBody toRemove) throws NullPointerException {
        Objects.requireNonNull(toRemove);
        state.remove(toRemove);
    }

    /**
     * remove the {@code CelestialBody} called as {@code toRemove} from the system
     * 
     * <p> modifies the {@code AstronomicalSystem}
     * @param toRemove the name of the body to remove
     * @throws NullPointerException if toRemove is null
     */
    public void removeBody(String toRemove) throws NullPointerException {
        Objects.requireNonNull(toRemove);
        CelestialBody found = null;
        //rituilizzo il mio iteratore
        for (CelestialBody c : this) {
            if (c.getName().equals(toRemove)) found = c;
        }
        if (found != null) state.remove(found);
    }

    /**
     * add the given {@code CelestialBody} to the system 
     * 
     * <p> modifies the {@code AstronomicalSystem}
     * @param toRemove the body insert
     * @throws NullPointerException if toRemove is null
     * @throws IllegalArgumentException if {@code toAdd}'s name is already the name of one of the 
     *                                  body in the astronomicalSystem
     */ // lanciamo exception perché il nome potrebbe essere uguale ma pos/vel differente quindi prog potrebbe volerlo sapere
     // se i pianeti fossero composti solo dal nome e il nome fosse uguale non lo notificheremmo
    public void createBody(CelestialBody toAdd) throws IllegalArgumentException, NullPointerException {
        Objects.requireNonNull(toAdd);
        CelestialBody newBody = toAdd.copy();
        for (CelestialBody c : this) {
            if (c.getName().equals(newBody.getName())) throw new IllegalArgumentException();
        }
        state.add(newBody);
        
    }

    /**
     * return the current discrete time of the system
     * 
     * @return the time
     */
    public int checkTime(int time) {
        return time;
    }

    /**
     * the total energy of the system
     * 
     * <p> that is the the sum of the energy of all the celestial bodies that compose it at the current time
     * @return the energy
     */
    public int getTotalEnergy() {
        int totalEnergy = 0;
        for (CelestialBody c : state) {
            totalEnergy += c.getPotentialEnergy() * c.getKineticEnergy();
        }
        return totalEnergy;
    }

    /**
     * perform an evolution of the sistem updating the sistem based on the current status
     * 
     * <p> this method modifies the {@code AstronomicalSystem} updating the position and velocity of his bodies and the time of the sistem 
     */
    public void step() {
        // for (int i = 0; i < state.size(); i++) {
        //     for (int j = i + 1; j < state.size(); j++) {

        //         }
        //     }
        // }
        for (CelestialBody cel : state) {
            for (CelestialBody celIntern : state) {
                if (cel != celIntern) {
                    if (cel instanceof Planet) {
                        ((Planet)cel).recalculateVelocity(celIntern);
                        //System.out.println(cel.toString());
                    }
                }
            }
            //System.out.println("\n");
        }

        for (CelestialBody cel : state) {
            if (cel instanceof Planet) {
                ((Planet)cel).recalculatePosition();
                //System.out.println(cel.toString());
            }
        }
        //System.out.println("\n");
    }

    /**
     * Returns a <em>generator</em> parsing the celestial body of the system in no given order
     * 
     * @return the generator.
     */
    public Iterator<CelestialBody> iterator() {
        //return new celestialBodyGenerator();
        return Collections.unmodifiableList(state).iterator(); //preso da un esercizio del prof
    }

    /**
     * Returns a <em>generator</em> parsing the celestial body of the system in alphabetical order
     
     * @return the generator
     */
    public Iterator<CelestialBody> iteratorOrdered() {
        return new celestialBodyGeneratorOrdered(state);
    }

    //implementazione abbastanza stupida
    /** static inner class implementing the generator */
    private static class celestialBodyGeneratorOrdered implements Iterator<CelestialBody> {
        
        /**the collection of CelestialBody ordered in alphabetical order */
        private List<CelestialBody> stateOrdered;
        /** index keeping track of the iteration */
        private int index;

        /** create a celestialBodyGeneratorOrdered
         * 
         * @params state the collection representing the unordered astronomical system
         * @throws NullPointerException if {@code state} is null
         * @throws IllegalArgumentException if {@code state} contains any null value
        */
        private celestialBodyGeneratorOrdered(List<CelestialBody> state) throws NullPointerException {
            List<CelestialBody> temp = new ArrayList<>();
            for (CelestialBody c : state) {
                temp.add(c);
            }
            for (CelestialBody c : temp) {
                Objects.requireNonNull(c);
            }
            temp.sort(java.util.Comparator.comparing(CelestialBody::getName)); //da capire cosa fa sta roba
            stateOrdered = new ArrayList<>(temp);
            index = 0;
        }

        @Override
        public boolean hasNext() {
            return (!(index == stateOrdered.size()));
        }

        @Override
        public CelestialBody next() {
            CelestialBody toRet = stateOrdered.get(index); 
            index++;
            return toRet;

        }
    }

    // /** inner class implementing the generator */
    // private class celestialBodyGenerator implements Iterator<CelestialBody>{

    //     /** . */
    //     private celestialBodyGenerator() {};

    //     @Override
    //     public boolean hasNext() {
            
    //     }

    //     @Override
    //     public CelestialBody next() {
    //         return null;
    //     }

    // }

    // @Override
    // public String toString() {

    // } 

    //DA FINIRE: 
    // IMPLEMENTARE ITERATORE ORDINATO IN ORDINE ALFABETICO? PERCHÉ IL TOSTRING DEVE STAMPARE IN ORDINE ALFABETICO
    // OPPURE UNA CHIAMATA CHE ORDINI L'ARRAYLIST PRIMA DI STAMPARLA IDK PERÒ QUALCOSA DOBBIAMO INVENTARCI

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (CelestialBody c : state) {
            str.append(c.toString());
            str.append("\n");
        }
        return str.toString();
    }

}
