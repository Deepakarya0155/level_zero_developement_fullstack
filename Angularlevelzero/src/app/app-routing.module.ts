import { PasswordMangerComponent } from './password-manger/password-manger.component';
import { HomeComponent } from './home/home.component';
import { AppComponent } from './app.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthGuard } from './Service/AuthGuard';


const routes: Routes = [
  {path:"",component:HomeComponent,canActivate:[AuthGuard],
  children:[
    {path:"passwordManager",component:PasswordMangerComponent}
  ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
