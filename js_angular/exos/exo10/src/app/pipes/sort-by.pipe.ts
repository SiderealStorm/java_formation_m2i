import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'sortBy'
})
export class SortByPipe implements PipeTransform {

  transform<T>(list: T[], value: keyof T): T[] {
    if (value === "rate") {
      return list.sort((a, b) => a[value] < b[value] ? 1 : -1);
    } else {
      return list.sort((a, b) => a[value] < b[value] ? -1 : 1);
    }
  }

}
