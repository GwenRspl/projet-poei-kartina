import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Photo } from '../models/photo';


@Injectable({
  providedIn: 'root'
})
export class PhotosService {

  private _bestphotoUrl = 'http://localhost:8080/api/photos/best';
  private _recentphotoUrl = 'http://localhost:8080/api/photos/recent';

  constructor(private _httpClient : HttpClient) { }

  GetBestPhotos() : Observable<Photo[]> {
    return this._httpClient.get<Photo[]>(this._bestphotoUrl);
  }
  GetRecentPhotos() : Observable<Photo[]> {
    return this._httpClient.get<Photo[]>(this._recentphotoUrl);
  }

}
