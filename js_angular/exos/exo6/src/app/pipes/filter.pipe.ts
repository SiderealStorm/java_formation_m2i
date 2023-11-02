import { Pipe, PipeTransform } from '@angular/core';
import { Contact } from '../models/Contact.model';

@Pipe({
  name: 'filter'
})
export class FilterPipe implements PipeTransform {

  transform(contactList : Contact[], filter: keyof Contact = "id"): Contact[] {
    let sortedList : Contact[] = [];
    if (filter === "id" || filter === "age") {
      sortedList = contactList.sort((a, b) => a[filter] - b[filter]);
    } else if (filter === "birthDate") {
      sortedList = contactList.sort((a, b) => b[filter].getTime() - a[filter].getTime())
    } else {
      sortedList = contactList.sort((a, b) => a[filter].localeCompare(b[filter]));
    }
    return sortedList;
  }
}
