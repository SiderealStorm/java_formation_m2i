class Contact {
    public id : number;
    public firstName : string;
    public lastName : string;
    public birthDate : Date;
    public age : number;
    public email : string;
    public phone : string;

    constructor(
        id : number,
        firstName : string,
        lastName : string,
        birthDate : Date,
        age : number,
        email : string,
        phone : string
    ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.age = age;
        this.email = email;
        this.phone = phone;
    }
}

export default Contact;