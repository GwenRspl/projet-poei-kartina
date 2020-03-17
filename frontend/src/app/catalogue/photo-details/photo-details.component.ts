import { Component, OnInit } from '@angular/core';
import { Photo } from 'src/app/models/photo';
import { PhotosService } from 'src/app/services/photos.service';
import { ActivatedRoute } from '@angular/router';
import { Subject } from 'rxjs';
import { debounceTime } from 'rxjs/operators';
import { CartStorageService } from 'src/app/services/cart-storage.service';

@Component({
  selector: 'app-photo-details',
  templateUrl: './photo-details.component.html',
  styleUrls: ['./photo-details.component.sass']
})
export class PhotoDetailsComponent implements OnInit {
  private _success = new Subject();
  photo: Photo;
  successMessage: boolean = false;
  staticAlertClosed: boolean = false;

  constructor(private _photoService: PhotosService, private _route: ActivatedRoute, private _cartService: CartStorageService) { }

  ngOnInit(): void {
    this._photoService.getOnePhoto(this._route.snapshot.params.id).subscribe((data: Photo) => {
      this.photo = data;
    });
    setTimeout(() => this.staticAlertClosed = true, 20000);

    this._success.pipe(
      debounceTime(2000)
    ).subscribe(() => this.successMessage = null);
  }

  addToCart() {
    this._cartService.addToCart(this.photo.id);
    this.successMessage = true;
    this._success.next();
  }

}
