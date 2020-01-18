import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@ Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  products: Product[];

  constructor(private http: HttpClient) {
    this.getDataFromJSON();
  }

  getDataFromJSON() {
    this.http.get< Product[]>('../../assets/products.json').subscribe(response => {
        console.log(response);
        this.products = response;
    });
  }

  ngOnInit() {
  }
}

interface Product {
    name: string;
    image: string;
    price: number;
  }


