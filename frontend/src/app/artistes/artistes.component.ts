import { Component, OnInit } from '@angular/core';
import { ArtistesService } from '../services/artistes.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Photo } from '../models/photo';
import { Artiste } from '../models/artiste';

@Component({
  selector: 'app-artistes',
  templateUrl: './artistes.component.html',
  styleUrls: ['./artistes.component.sass']
})
export class ArtistesComponent implements OnInit {

  photos: Photo[] = [];
  artistes: Artiste[] = [];

  constructor(private _artistesService: ArtistesService, private _route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this._artistesService.getAllArtists().subscribe((data : Artiste[]) =>{
      this.artistes = data;
      console.log(data);
      });
  }

  goToArtist(id : number){
    this.router.navigate(['artiste', id]);
  }

  }


