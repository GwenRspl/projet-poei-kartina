import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { HomeComponent } from './home/home.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';

const routes: Routes = [
  { path : "home", component : HomeComponent },
  /* { path : "users", component : AdminPersonComponent },
  { path : "catalogue", component : CatalogueComponent, canActivate : [VerifyconnexionGuard] },
  { path : "catalogue/:id", component : ProductDetailComponent },
  { path : "inscription", component : PersonFormComponent, canDeactivate: [VerifySavedSignUpGuard] },
  { path : "" , redirectTo : "home", pathMatch: "full" },
  { path : "**", component : PageNotFoundComponent } */
];
@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule.forRoot(routes),
    HttpClientModule,
    ReactiveFormsModule,
    FontAwesomeModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
