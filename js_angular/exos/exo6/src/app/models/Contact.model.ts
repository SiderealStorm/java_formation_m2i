export class Contact {
    public static count = 0;

    public id: number;
    public age: number;

    constructor(
        public firstName: string,
        public lastName: string,
        public birthDate: Date,
        public mail: string,
        public phone: string,
    ) {
        this.id = ++Contact.count;
        this.age =  Math.floor((Date.now() - birthDate.getTime()) / (1000 * 3600 * 24)/365.25);
    }
}