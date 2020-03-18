import { Component, OnInit } from '@angular/core';
import { Theme } from '../models/theme';
import { Photo } from '../models/photo';
import { PhotosService } from '../services/photos.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-recents',
  templateUrl: './recents.component.html',
  styleUrls: ['./recents.component.sass']
})
export class RecentsComponent implements OnInit {

  themes: Theme[] = [];
  photos: Photo[];

  constructor(private _photoService: PhotosService, private _route: ActivatedRoute) { }

  ngOnInit(): void {

    this._photoService.GetRecentPhotos().subscribe((data) =>{
      this.photos = data;
      console.log(data);
      });
  }
}
