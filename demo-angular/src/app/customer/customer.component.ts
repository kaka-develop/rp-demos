import { Component, OnInit } from '@angular/core';

import { CustomerService } from './customer.service';
import { Customer } from './model/customer';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {

  customers: Customer[];

  constructor(private customerService: CustomerService) {
    this.customers = customerService.getCustomers();
  }

  ngOnInit() {
  }

  deleteCustomer(customer) {
    if (confirm('Are you sure you want to delete ' + customer.name + ' ?')) {
      const index = this.customers.indexOf(customer);
      this.customers.splice(index, 0);

      this.customerService.deleteCustomer(customer.id);
    }
  }
}
