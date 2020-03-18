import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Artiste } from '../models/artiste';
import { Photo } from '../models/photo';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ArtistesService {

  private _allartistsUrl = 'http://localhost:8080/api/artistes';
  
  constructor(private _httpClient: HttpClient) { }

  getAllArtists(): Observable<Artiste[]> {
    return this._httpClient.get<Artiste[]>(this._allartistsUrl);
  }




}
