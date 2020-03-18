import { ConnectionComponent } from './auth/connection/connection.component';
import { RegisterComponent } from './auth/register/register.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { CatalogueComponent } from './catalogue/catalogue.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { PhotoDetailsComponent } from './catalogue/photo-details/photo-details.component';
import { ThemesComponent } from './themes/themes.component';
import { LowstockComponent } from './lowstock/lowstock.component';
import { RecentsComponent } from './recents/recents.component';


const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'connection', component: ConnectionComponent },
  { path: 'photographies', component: CatalogueComponent },
  { path: 'theme/:id', component: ThemesComponent },
  { path: 'lowstock', component: LowstockComponent },
  { path: 'lastadds', component: RecentsComponent },
  { path: 'artistes', component: RecentsComponent },
  { path: 'photographies/:id', component: PhotoDetailsComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: '**', component: PageNotFoundComponent, pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
