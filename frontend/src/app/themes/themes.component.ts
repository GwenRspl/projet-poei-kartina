import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Photo } from '../models/photo';
import { PhotosService } from 'src/app/services/photos.service';
import { Theme } from '../models/theme';

@Component({
  selector: 'app-themes',
  templateUrl: './themes.component.html',
  styleUrls: ['./themes.component.sass']
})
export class ThemesComponent implements OnInit {
  themes: Theme[] = [];
  photos: Photo[];

  constructor(private _photoService: PhotosService, private _route: ActivatedRoute) { }

  ngOnInit(): void {

    this._photoService.getPhotosByTheme(this._route.snapshot.params.id).subscribe((data: Photo[]) =>{
      this.photos = data;
      console.log(data);
      });
  }

}
