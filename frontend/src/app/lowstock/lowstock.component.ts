import { Component, OnInit } from '@angular/core';
import { Theme } from '../models/theme';
import { Photo } from '../models/photo';
import { PhotosService } from '../services/photos.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-lowstock',
  templateUrl: './lowstock.component.html',
  styleUrls: ['./lowstock.component.sass']
})
export class LowstockComponent implements OnInit {

  themes: Theme[] = [];
  photos: Photo[];

  constructor(private _photoService: PhotosService, private _route: ActivatedRoute) { }

  ngOnInit(): void {

    this._photoService.getLowStockPhotos().subscribe((data) =>{
      this.photos = data;
      console.log(data);
      });
  }

}
