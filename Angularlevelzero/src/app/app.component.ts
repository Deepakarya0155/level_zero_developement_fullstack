import { KeycloakService } from 'keycloak-angular';
import { Component } from '@angular/core';
import { Backend } from './Service/Backend';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Angularlevelzero';

  constructor(public backend:Backend,public key:KeycloakService){

  }

  f1(){
    this.key.getToken().then(R=>{
      console.log(R);
    })
    this.backend.get("/test").subscribe(R=>{
      console.log(R)
    })
  }
}
