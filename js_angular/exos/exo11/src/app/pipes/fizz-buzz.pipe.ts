import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'fizzBuzz'
})
export class FizzBuzzPipe implements PipeTransform {

  transform(value: number): string {
    let result = "";
    if (value !== 0) {
      if (value % 3 === 0) {
        result += "Fizz";
      }
      if (value % 5 === 0) {
        result += "Buzz";
      }
    }

    if (result) {
      return result;
    } else {
      return value.toString();
    }
  }

}
