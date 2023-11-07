export class Contact {
    public static count = 0;

    public id : number;

    constructor(
        public firstName : string,
        public lastName : string,
        public age : number,
        public mail : string,
        public phone : string
    ) {
        this.id = ++Contact.count;
    }
}