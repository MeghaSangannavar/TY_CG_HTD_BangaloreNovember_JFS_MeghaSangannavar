import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http'

@ Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {
  customers: Customer[];

  constructor(private http: HttpClient) {
    this.getDataFromJSON();
  }

  getDataFromJSON() {
    this.http.get< Customer[]>('../../assets/customers.json').subscribe(response => {
        console.log(response);
        this.customers = response;
    });
  }

  ngOnInit() {
  }

}

interface Customer {
  name: string;
  email: string;
  phone: number;
}
