import { Component, OnInit } from '@angular/core';
import { faTrash } from '@fortawesome/free-solid-svg-icons';
import { Photo } from '../models/photo';
import { CartStorageService } from '../services/cart-storage.service';
import { PhotosService } from '../services/photos.service';
import { TokenStorageService } from '../services/token-storage.service';

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
  notLoggedIn: boolean = false;

  constructor(private _cartService: CartStorageService, private _photoService: PhotosService, private _tokenStorage: TokenStorageService) { }

  ngOnInit(): void {
    this.cartMap = this._cartService.getCartMap();
    console.log(this.cartMap);

    this.cartMap.forEach((value: number, key: Photo) => {
      this.totalPrice += key.prix * value;
      this.tva += (key.prix * value) - ((key.prix * value) / 1.2);
    });
  }

  removeFromCart(photo: Photo, quantite: number) {
    this._cartService.deleteFromCart(photo);
    this.totalPrice -= photo.prix * quantite;
    this.tva -= (photo.prix * quantite) - ((photo.prix * quantite) / 1.2);
  }

  checkout() {
    if (this._tokenStorage.isAuthenticated) {
      console.log('commande passée');
    } else {
      this.notLoggedIn = true;
    }
  }

}
