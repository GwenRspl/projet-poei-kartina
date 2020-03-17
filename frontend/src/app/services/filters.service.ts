import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Theme } from '../models/theme';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FiltersService {
  private _allThemes = 'http://localhost:8080/api/themes';

  constructor(private _httpClient: HttpClient) { }

  getThemes(): Observable<Theme[]> {
    return this._httpClient.get<Theme[]>(this._allThemes);
  }



}
