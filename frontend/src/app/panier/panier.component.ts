import { Component, OnInit } from '@angular/core';
import { faTrash } from '@fortawesome/free-solid-svg-icons';
import { Photo } from '../models/photo';
import { CartStorageService } from '../services/cart-storage.service';
import { PhotosService } from '../services/photos.service';

@Component({
  selector: 'app-panier',
  templateUrl: './panier.component.html',
  styleUrls: ['./panier.component.sass']
})
export class PanierComponent implements OnInit {
  faTrash = faTrash;
  cartMap: Map<Photo, number>;
  totalPrice: number = 0;
  tva: number = 0;

  constructor(private _cartService: CartStorageService, private _photoService: PhotosService) { }

  ngOnInit(): void {
    this.cartMap = this._cartService.getCartMap();
    console.log(this.cartMap);

    this.cartMap.forEach((value: number, key: Photo) => {
      this.totalPrice += key.prix;
      this.tva += key.prix - (key.prix / 1.2);
    });
  }

  removeFromCart(photo: Photo) {
    this._cartService.deleteFromCart(photo);
  }

  checkout() {
    console.log('commande passée');
  }

}
