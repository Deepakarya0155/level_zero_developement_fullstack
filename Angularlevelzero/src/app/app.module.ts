import { BrowserModule } from '@angular/platform-browser';
import { APP_INITIALIZER, NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import {HttpClientModule} from '@angular/common/http'
import { AppMatModule } from './AngularMatrial/app.material.module';
import { Backend } from './Service/Backend';
import { KeycloakAngularModule, KeycloakService } from 'keycloak-angular';
import { initializeKeycloak } from './Service/Keyclockconfig';
import { AuthGuard } from './Service/AuthGuard';
import { HomeComponent } from './home/home.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,FormsModule,
    ReactiveFormsModule,HttpClientModule,
    AppMatModule,KeycloakAngularModule
  ],
  providers: [Backend,
    {
      provide: APP_INITIALIZER,
      useFactory: initializeKeycloak,
      multi: true,
      deps: [KeycloakService],
   }
     ,AuthGuard ],
  bootstrap: [AppComponent]
})
export class AppModule { }
