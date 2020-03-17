import { Component, OnInit } from '@angular/core';
import { Photo } from '../models/photo';
import { PhotosService } from '../services/photos.service';
import { Theme } from '../models/theme';
import { Format } from '../models/format';
import { Orientation } from '../models/orientation';
import { FiltersService } from '../services/filters.service';

@Component({
  selector: 'app-catalogue',
  templateUrl: './catalogue.component.html',
  styleUrls: ['./catalogue.component.sass']
})
export class CatalogueComponent implements OnInit {
  photos: Photo[] = [];
  themes: Theme[] = [];
  formats: Format[] = [];
  orientations: Orientation[] = [];

  constructor(private _photoService: PhotosService, private _filterService: FiltersService) { }

  ngOnInit(): void {
    this.getAllPhotos();

    this._filterService.getThemes().subscribe((data: Theme[]) => {
      this.themes = data;
    });

    this._filterService.getOrientations().subscribe((data: Orientation[]) => {
      this.orientations = data;
    });

    this._filterService.getFormats().subscribe((data: Format[]) => {
      this.formats = data;
    });
  }

  onThemeChanged(event) {
    let target = event.target;
    let value = target.value;
    if (value === 'all') {
      this.getAllPhotos();
    } else {
      const themeId = +value;
      this._photoService.getPhotosByTheme(themeId).subscribe((data: Photo[]) => {
        this.photos = data;
      });
    }

  }

  getAllPhotos() {
    this._photoService.getAllPhotos().subscribe((data: Photo[]) => {
      this.photos = data;
    });
  }


}
