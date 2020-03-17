import { Component, OnInit, Input } from '@angular/core';
import { Photo } from '../models/photo';
import { Router } from '@angular/router';

@Component({
  selector: 'app-photo-list',
  templateUrl: './photo-list.component.html',
  styleUrls: ['./photo-list.component.sass']
})
export class PhotoListComponent implements OnInit {
  @Input() photos: Photo[] = [];

  constructor(private _router: Router) { }

  ngOnInit(): void { }

  seeDetails(id: number) {
    this._router.navigate(['photographies', id]);
  }


}
