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
  selectedFormats: number[] = [];
  selectedOrientations: number[] = [];
  selectedPriceRange: number[] = [1, 2, 3, 4, 5];

  constructor(private _photoService: PhotosService, private _filterService: FiltersService) { }

  ngOnInit(): void {
    this.getAllPhotos();

    this._filterService.getThemes().subscribe((data: Theme[]) => {
      this.themes = data;
    });

    this._filterService.getOrientations().subscribe((data: Orientation[]) => {
      this.orientations = data;
      this.orientations.forEach(element => {
        this.selectedOrientations.push(element.id)
      });
    });

    this._filterService.getFormats().subscribe((data: Format[]) => {
      this.formats = data;
      this.formats.forEach(element => {
        this.selectedFormats.push(element.id)
      });
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

  onOrientationsChanged(id: number, isChecked: boolean) {
    if (isChecked) {
      this.selectedOrientations.push(id);
    } else {
      const index = this.selectedOrientations.indexOf(id);
      this.selectedOrientations.splice(index, 1);
    }
  }

  onFormatsChanged(id: number, isChecked: boolean) {
    if (isChecked) {
      this.selectedFormats.push(id);
    } else {
      const index = this.selectedFormats.indexOf(id);
      this.selectedFormats.splice(index, 1);
    }
  }

  onPriceRangeChanged(id: number, isChecked: boolean) {
    if (isChecked) {
      this.selectedPriceRange.push(id);
    } else {
      const index = this.selectedPriceRange.indexOf(id);
      this.selectedPriceRange.splice(index, 1);
    }
  }

  getAllPhotos() {
    this._photoService.getAllPhotos().subscribe((data: Photo[]) => {
      this.photos = data;
    });
  }


}
