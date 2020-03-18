import { Component, OnInit } from '@angular/core';
import { PhotosService } from '../services/photos.service';
import { ActivatedRoute } from '@angular/router';
import { Photo } from '../models/photo';
import { Artiste } from '../models/artiste';

@Component({
  selector: 'app-artiste',
  templateUrl: './artiste.component.html',
  styleUrls: ['./artiste.component.sass']
})
export class ArtisteComponent implements OnInit {
  photos: Photo[];
  artiste: Artiste[];


  constructor(private _photoService: PhotosService, private _route: ActivatedRoute) { }

  ngOnInit(): void {
    this._photoService.getArtistPhotosById(this._route.snapshot.params.id).subscribe((data: Photo[]) =>{
      this.photos = data;
      console.log(data);
      });
  }
  }


