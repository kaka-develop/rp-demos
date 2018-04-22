import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Customer } from '../model/customer';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-customer-form',
  templateUrl: './customer-form.component.html',
  styleUrls: ['./customer-form.component.css']
})
export class CustomerFormComponent implements OnInit {

  title: string;
  form: FormGroup;
  customer: Customer = new Customer();

  constructor(
    formBuilder: FormBuilder,
    private router: Router,
    private route: ActivatedRoute,
    private customerService: CustomerService
  ) {
    this.form = formBuilder.group({
      name: ['', [
        Validators.required,
        Validators.minLength(3)
      ]],
      email: ['', [
        Validators.required,
        Validators.minLength(3)
      ]],
      phone: [],
      address: ['', [
        Validators.required,
        Validators.minLength(3)
      ]],
    });
  }

  ngOnInit() {
    const id = this.route.params.subscribe(params => {
      let id = params['id'];

      this.title = id ? 'Edit Customer' : 'New Customer';

      if (!id) {
        return;
      }

      this.customerService.getCustomer(id)
        .subscribe(
          customer => this.customer = customer,
          response => {
            if (response.status == 404) {
              this.router.navigate(['customer']);
            }
          });

    });
  }

  save() {
    let result = null;
    const customerValue = this.customer;
    if (customerValue.id) {
      result = this.customerService.updateCustomer(customerValue);
    } else {
      result = this.customerService.addCustomer(customerValue);
    }

    result.subscribe(data => this.router.navigate(['customer']));

  }
}
