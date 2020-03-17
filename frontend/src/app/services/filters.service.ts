import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Theme } from '../models/theme';
import { Observable } from 'rxjs';
import { Orientation } from '../models/orientation';
import { Format } from '../models/format';

@Injectable({
  providedIn: 'root'
})
export class FiltersService {
  private _allThemes = 'http://localhost:8080/api/themes';
  private _allOrientations = 'http://localhost:8080/api/orientations';
  private _allFormats = 'http://localhost:8080/api/formats';

  constructor(private _httpClient: HttpClient) { }

  getThemes(): Observable<Theme[]> {
    return this._httpClient.get<Theme[]>(this._allThemes);
  }

  getOrientations(): Observable<Orientation[]> {
    return this._httpClient.get<Orientation[]>(this._allOrientations);
  }

  getFormats(): Observable<Format[]> {
    return this._httpClient.get<Format[]>(this._allFormats);
  }



}
