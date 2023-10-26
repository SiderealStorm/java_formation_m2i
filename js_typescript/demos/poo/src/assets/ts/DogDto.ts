import Mammal from "./Mammal";

class DogDto {
    // Syntaxe raccourcie :
    constructor(public name: string, public breed: string, public age: number) { }
}

export default DogDto;