import { Pipe, PipeTransform } from '@angular/core';
import { Contact } from '../models/Contact.model';

@Pipe({
  name: 'contactSort'
})
export class ContactSortPipe implements PipeTransform {

  transform(contactList : Contact[], attribute: keyof Contact = "id"): Contact[] {
    // if (attribute === "id" || attribute === "age") {
    //   return contactList = contactList.sort((a, b) => a[attribute] - b[attribute]);
    // } else if (attribute === "birthDate") {
    //   return contactList = contactList.sort((a, b) => b[attribute].getTime() - a[attribute].getTime())
    // } else {
    //   return contactList = contactList.sort((a, b) => a[attribute].localeCompare(b[attribute]));
    // }
    
    // Simplification :
    return contactList.sort((a, b) => a[attribute] < b[attribute] ? -1 : 1);
  }
}
