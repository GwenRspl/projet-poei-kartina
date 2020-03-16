import { Component, OnInit } from '@angular/core';
import { PhotosService } from '../services/photos.service';
import { Photo } from '../models/photo';

@Component({
  selector: 'app-accueil',
  templateUrl: './accueil.component.html',
  styleUrls: ['./accueil.component.sass']
})
export class AccueilComponent implements OnInit {

  photos : Array<Photo> = new Array<Photo>();
  filteredPhotos  : Photo[]=[];

  constructor(private _photoService : PhotosService) { }

  ngOnInit(): void {
    this._photoService.GetRecentPhotos().subscribe((data) =>{
      this.photos = data;
      this.filteredPhotos = data;
  });}

}
