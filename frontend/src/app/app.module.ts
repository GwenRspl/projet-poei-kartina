import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { HomeComponent } from './home/home.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RegisterComponent } from './auth/register/register.component';
import { ConnectionComponent } from './auth/connection/connection.component';
import { CatalogueComponent } from './catalogue/catalogue.component';
import { PhotoListComponent } from './catalogue/photo-list/photo-list.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { PhotoDetailsComponent } from './catalogue/photo-details/photo-details.component';
import { FiltersPipe } from './pipes/filters.pipe';
import { ThemesComponent } from './themes/themes.component';
import { LowstockComponent } from './lowstock/lowstock.component';
import { RecentsComponent } from './recents/recents.component';
import { ArtistesComponent } from './artistes/artistes.component';
import { ArtisteComponent } from './artiste/artiste.component';



@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    HomeComponent,
    RegisterComponent,
    ConnectionComponent,
    CatalogueComponent,
    PhotoListComponent,
    PageNotFoundComponent,
    PhotoDetailsComponent,
    FiltersPipe,
    ThemesComponent,
    LowstockComponent,
    RecentsComponent,
    ArtistesComponent,
    ArtisteComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    FontAwesomeModule,
    NgbModule,
    AppRoutingModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
