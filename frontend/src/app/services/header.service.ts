import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HeaderService {

  private _updateNavBar = new Subject<boolean>();

  constructor() { }

  get updateNavBar(): Subject<boolean> {
    return this._updateNavBar;
  }

  refreshNavBar(bool: boolean) {
    this.updateNavBar.next(bool);
  }
}
