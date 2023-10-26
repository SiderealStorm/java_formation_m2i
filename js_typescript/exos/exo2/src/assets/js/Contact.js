class Contact {
    constructor(firstName, lastName, birthdate, mail, phone) {
        this._id = ++Contact.count;
        this._firstName = firstName;
        this._lastName = lastName,
            this._birthdate = birthdate;
        this._mail = mail;
        this._phone = phone;
    }
    get id() {
        return this._id;
    }
    get firstName() {
        return this._firstName;
    }
    get lastName() {
        return this._lastName;
    }
    get birthdate() {
        return this._birthdate;
    }
    get mail() {
        return this._mail;
    }
    get phone() {
        return this._phone;
    }
    set firstName(firstName) {
        this._firstName = firstName;
    }
    set lastName(lastName) {
        this._lastName = lastName;
    }
    set birthdate(birthdate) {
        this._birthdate = birthdate;
    }
    set mail(mail) {
        this._mail = mail;
    }
    set phone(phone) {
        this._phone = phone;
    }
}
Contact.count = 0;
export default Contact;
