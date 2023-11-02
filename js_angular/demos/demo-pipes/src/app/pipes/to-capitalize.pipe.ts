import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'toCapitalize'
})
export class ToCapitalizePipe implements PipeTransform {

  // Méthode du pipe à modifier
  transform(value: string): string {
    return value.substring(0,1).toUpperCase() + value.substring(1).toLowerCase();
  }
}
