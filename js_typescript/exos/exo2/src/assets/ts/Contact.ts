class Contact {
    public static count = 0;

    private _id : number;
    private _firstName : string;
    private _lastName : string;
    private _birthdate : Date;
    private _mail : string;
    private _phone : string;

    constructor(firstName : string, lastName : string, birthdate : Date, mail : string, phone : string) {
        this._id = ++Contact.count;
        this._firstName = firstName;
        this._lastName = lastName,
        this._birthdate = birthdate;
        this._mail = mail;
        this._phone = phone;
    }

    
    public get id() : number {
        return this._id;
    }
    
    public get firstName() : string {
        return this._firstName
    }

    public get lastName() : string {
        return this._lastName;
    }
    
    public get birthdate() : Date {
        return this._birthdate;
    }

    public get mail() : string {
        return this._mail;
    }

    public get phone() : string {
        return this._phone;
    }
    
    public set firstName(firstName : string) {
        this._firstName = firstName;
    }
    
    public set lastName(lastName : string) {
        this._lastName = lastName;
    }

    public set birthdate(birthdate : Date) {
        this._birthdate = birthdate;
    }

    public set mail(mail : string) {
        this._mail = mail;
    }
    
    public set phone(phone : string) {
        this._phone = phone;
    }
}

export default Contact;