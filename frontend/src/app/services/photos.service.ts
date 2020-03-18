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
  private _allPhotoUrl = 'http://localhost:8080/api/photos';
  private _photosByTheme = 'http://localhost:8080/api/photos/theme/';
  private _photosLowStock= 'http://localhost:8080/api/photos/lowstock';
  private _photosById = 'http://localhost:8080/api/photos/artist/';

  constructor(private _httpClient: HttpClient) { }


  GetBestPhotos(): Observable<Photo[]> {
    return this._httpClient.get<Photo[]>(this._bestphotoUrl);
  }
  GetRecentPhotos(): Observable<Photo[]> {
    return this._httpClient.get<Photo[]>(this._recentphotoUrl);
  }

  getAllPhotos(): Observable<Photo[]> {
    return this._httpClient.get<Photo[]>(this._allPhotoUrl);
  }

  getPhotosByTheme(themeId: number): Observable<Photo[]> {
    const path = `${this._photosByTheme}${themeId}`;
    return this._httpClient.get<Photo[]>(path);
  }

  getOnePhoto(photoId: number): Observable<Photo> {
    const path = `${this._allPhotoUrl}/${photoId}`;
    return this._httpClient.get<Photo>(path);
  }

  getLowStockPhotos(): Observable<Photo[]> {
    return this._httpClient.get<Photo[]>(this._photosLowStock);
  }

  getArtistPhotosById(artisteId: number): Observable<Photo[]> {
    const path = `${this._photosById}${artisteId}`;
    return this._httpClient.get<Photo[]>(path);
  }

}
