package org.example.exos.tp;

import java.util.Objects;

public class Guest {

    public int id;
    public String firstName;
    public String lastName;
    public String phone;
    public static int guestCount;

    public Guest(String firstName, String lastName, String phone) {
        this.id = ++guestCount;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Client n°" + id  + " : " + firstName + " " + lastName + " - téléphone : " + phone;
    }

    // Surcharge de la méthode .equals() de Object
    @Override
    public boolean equals(Object object) {

        // On vérifie d'abord si l'objet en argument est le même (= même emplacement mémoire)
        if (object == this) {
            return true;
        }

        // On vérifie que l'objet en arguement est du bon type
        // Remarque : si c'est le cas, l'objet est parsé sous forme de Guest dans la variable guest (refactor IntelliJ)
        if (!(object instanceof Guest guest)) {
            return false;
        }

        // Guest guest = (Guest) object;    // Inutile car le parsing est fait dans la condition du if

        // On compare ce qu'on a besoin de comparer pour que deux objets soient égaux
        return this.id == guest.id
                && this.firstName.equals(guest.firstName)
                && this.lastName.equals(guest.lastName)
                && this.phone.equals(guest.phone);
    }

}
