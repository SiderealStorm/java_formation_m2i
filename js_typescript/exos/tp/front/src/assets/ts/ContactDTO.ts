class Contact {
    public firstName : string;
    public lastName : string;
    public birthDate : string;
    public email : string;
    public phone : string;

    constructor(
        firstName : string,
        lastName : string,
        birthDate : string,
        email : string,
        phone : string
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
        this.phone = phone;
    }
}

export default Contact;