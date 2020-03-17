import { Injectable } from '@angular/core';
import { Photo } from '../models/photo';


@Injectable({
  providedIn: 'root'
})
export class CartStorageService {
  private _photosInCart: number[];
  private _photosInCartMap: Map<number, number>;

  constructor() {
    this._photosInCart = [];
    this._photosInCartMap = new Map();
  }

  public clearCart() {
    this._photosInCart = [];
    this._photosInCartMap.clear();
  }

  public addToCart(photoId: number) {
    this._photosInCart.push(photoId);
    let quantity;
    if (this._photosInCartMap.has(photoId)) {
      quantity = this._photosInCartMap.get(photoId);
    }
    quantity += 1;
    this._photosInCartMap.set(photoId, quantity);
  }

  public deleteFromCart(photoId: number) {
    const index = this._photosInCart.indexOf(photoId);
    this._photosInCart.splice(index, 1);

    this._photosInCartMap.delete(photoId);
  }

  public getCart(): number[] {
    return this._photosInCart.slice(0);
  }
}
