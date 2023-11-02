import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'sliceArray',
  // // Si on veut un pipe "impur" (non recommandé) :
  // pure: false
})
export class SliceArrayPipe implements PipeTransform {

  // maxLength est assigné par défaut à 10
  transform(value: any[], maxLength = 10): any[] {
    if(value.length > maxLength) {
      return value.slice(0, maxLength);
    } else {
      return value;
    }
  }

}
