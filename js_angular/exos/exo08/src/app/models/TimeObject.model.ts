export class TimeObject {
    private static count = 0;

    private _index: number;
    
    constructor(private _time : number) {
        this._index = ++TimeObject.count;
    }

    
    public get time() : number {
        return this._time;
    }
    
    
    public get index() : number {
        return this._index;
    }
    
}