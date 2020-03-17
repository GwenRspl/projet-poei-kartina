import { Component, OnInit } from '@angular/core';
import { Photo } from '../models/photo';
import { PhotosService } from '../services/photos.service';

@Component({
  selector: 'app-catalogue',
  templateUrl: './catalogue.component.html',
  styleUrls: ['./catalogue.component.sass']
})
export class CatalogueComponent implements OnInit {
  photos: Photo[] = [];

  constructor(private _photoService: PhotosService) { }

  ngOnInit(): void {
    this._photoService.getAllPhotos().subscribe((data: Photo[]) => {
      this.photos = data;
      console.log(data);
    });
  }

}
