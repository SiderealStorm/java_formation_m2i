export class Album {
    private static _count = 0;

    public id: number;

    constructor(
        public title: string,
        public artist: string,
        public releaseYear: number
    ) {
        this.id = ++Album._count;
    }
}