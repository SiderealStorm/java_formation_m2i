import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Product } from '../models/Products.model';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  testValue = "Default";
}
