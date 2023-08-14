package org.example.exos.tp.classes;

public class Guest {

    private final int id;
    // Utilisation d'une énum pour la civilité
    private Title title;
    private String firstName;
    private String lastName;
    private String phone;
    private static int guestCount;

    public Guest(Title title, String firstName, String lastName, String phone) {
        this.id = ++guestCount;
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public Title getTitle() {
        return title;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public static int getGuestCount() {
        return guestCount;
    }

    @Override
    public String toString() {
        return "Client n°" + id  + " : " + title.getValue() + " " + firstName + " " + lastName + " - téléphone : " + phone;
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
                && this.title == guest.title
                && this.firstName.equals(guest.firstName)
                && this.lastName.equals(guest.lastName)
                && this.phone.equals(guest.phone);
    }

}
