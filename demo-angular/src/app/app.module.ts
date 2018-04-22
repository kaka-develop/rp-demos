import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule , ReactiveFormsModule} from '@angular/forms';

import { HomeComponent } from './home/home.component';
import { AppComponent } from './app.component';
import { CustomerComponent } from './customer/customer.component';

import { AppRoutingModule } from './app.routing';
import { CustomerRoutingModule } from './customer/customer.routing';

import { CustomerService } from './customer/customer.service';
import { CustomerFormComponent } from './customer/customer-form/customer-form.component';

@NgModule({
  declarations: [
    AppComponent,
    CustomerComponent,
    HomeComponent,
    CustomerFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    CustomerRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [
    CustomerService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
