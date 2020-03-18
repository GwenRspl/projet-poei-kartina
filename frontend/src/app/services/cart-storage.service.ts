import { Injectable } from '@angular/core';
import { Photo } from '../models/photo';


@Injectable({
  providedIn: 'root'
})
export class CartStorageService {
  private _photosInCart: number[];
  private _photosInCartMap: Map<Photo, number>;

  constructor() {
    this._photosInCart = [];
    this._photosInCartMap = new Map();
  }

  public clearCart() {
    this._photosInCart = [];
    this._photosInCartMap.clear();
  }

  public addToCart(photo: Photo) {
    // this._photosInCart.push(photoId);
    let quantity: number = 0;
    if (this._photosInCartMap.has(photo)) {
      quantity = this._photosInCartMap.get(photo);
    }
    quantity += 1;
    this._photosInCartMap.set(photo, quantity);
  }

  public deleteFromCart(photo: Photo) {
    // const index = this._photosInCart.indexOf(photoId);
    // this._photosInCart.splice(index, 1);

    this._photosInCartMap.delete(photo);
  }

  public getCart(): number[] {
    return this._photosInCart.slice(0);
  }

  public getCartMap(): Map<Photo, number> {
    return this._photosInCartMap;
  }
}
