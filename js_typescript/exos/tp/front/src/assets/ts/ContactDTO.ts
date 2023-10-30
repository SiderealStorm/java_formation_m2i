class ContactDTO {
    public firstName : string;
    public lastName : string;
    public birthDate : Date;
    public email : string;
    public phone : string;

    constructor(
        firstName : string,
        lastName : string,
        birthDate : Date,
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

export default ContactDTO;