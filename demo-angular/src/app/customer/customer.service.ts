import { Injectable } from '@angular/core';
import { Customer } from './model/customer';

@Injectable()
export class CustomerService {

  private customers: Customer[];

  constructor() {
    this.customers = this.initData();
  }

  private initData() {
    return [
      {
        id: 1,
        name: 'name 1',
        address: 'address 1',
        phone: 'phone 1',
        email: 'email 1'
      },
      {
        id: 2,
        name: 'name 2',
        address: 'address 2',
        phone: 'phone 2',
        email: 'email 2'
      },
      {
        id: 3,
        name: 'name 3',
        address: 'address 3',
        phone: 'phone 3',
        email: 'email 3'
      }
    ];
  }

  public getCustomers() {
    return this.customers;
  }

  public getCustomer(id) {
    let customer = null;
    this.customers.forEach(cus => {
      if (cus.id == id) {
        customer = cus;
      }
    });
    return customer;
  }

  public updateCustomer(customer) {
    let updateCustomer = this.getCustomer(customer.id);
    updateCustomer = customer;
    return updateCustomer;
  }

  public addCustomer(customer) {
    const count = this.customers.length;
    customer.id = count + 1;
    this.customers.push(customer);
    return customer;
  }

  public deleteCustomer(id) {
    const customer = this.getCustomer(id);
    const index = this.customers.indexOf(customer);
    this.customers.splice(index, 0);
  }
}
