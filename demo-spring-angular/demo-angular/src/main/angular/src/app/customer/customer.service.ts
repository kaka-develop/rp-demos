import { Injectable } from '@angular/core';

import { Http } from '@angular/http';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/catch';

@Injectable()
export class CustomerService {

  private url: string = "/api/customers";

  constructor(private http: Http) {

  }

  public getCustomers() {
    return this.http.get(this.url)
      .map(res => res.json());
  }

  public getCustomer(id) {
    return this.http.get(this.getCustomerUrl(id))
      .map(res => res.json());
  }

  public updateCustomer(customer) {
    return this.http.put(this.url, customer)
      .map(res => res.json());
  }

  public addCustomer(customer) {
    return this.http.post(this.url, customer)
      .map(res => res.json());
  }

  public deleteCustomer(id) {
    return this.http.delete(this.getCustomerUrl(id))
      .map(res => res.json());
  }

  private getCustomerUrl(id){
    return this.url + "/" + id;
  }
}
