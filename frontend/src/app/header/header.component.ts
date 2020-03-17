import { HeaderService } from './../services/header.service';
import { TokenStorageService } from './../services/token-storage.service';
import { Component, OnInit } from '@angular/core';
import { faSearch } from '@fortawesome/free-solid-svg-icons';
import { faShoppingCart } from '@fortawesome/free-solid-svg-icons';
import { faSignOutAlt } from '@fortawesome/free-solid-svg-icons';
import { faUserCircle } from '@fortawesome/free-solid-svg-icons';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.sass']
})
export class HeaderComponent implements OnInit {
  faSearch = faSearch;
  faShoppingCart = faShoppingCart;
  faSignOutAlt = faSignOutAlt;
  faUserCircle = faUserCircle;
  isLogged: boolean;

  constructor(private _token: TokenStorageService, private _header: HeaderService, private _router: Router) { }

  ngOnInit(): void {
    this.isLogged = this._token.isAuthenticated();
    this._header.updateNavBar.subscribe(
      data => this.isLogged = data
    )
  }

  logout() {
    this._token.signOut();
    this._header.refreshNavBar(false);
    this._router.navigate(['/home/']);
  }

}
