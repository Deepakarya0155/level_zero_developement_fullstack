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
import { LayoutModule } from '@angular/cdk/layout';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { PasswordMangerComponent } from './password-manger/password-manger.component';
import { PasswordNewComponent } from './password-manger/password-new/password-new.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    PasswordMangerComponent,
    PasswordNewComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,FormsModule,
    ReactiveFormsModule,HttpClientModule,
    AppMatModule,KeycloakAngularModule, LayoutModule, MatToolbarModule, MatButtonModule, MatSidenavModule, MatIconModule, MatListModule
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
