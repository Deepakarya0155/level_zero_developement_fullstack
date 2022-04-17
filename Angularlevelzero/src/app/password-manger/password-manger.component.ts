import { PasswordNewComponent } from './password-new/password-new.component';
import { Component, OnInit } from '@angular/core';
import { KeycloakService } from 'keycloak-angular';
import { AppDialog } from '../Reusablecomponent/AppDailog';
import { Backend } from '../Service/Backend';
import { MatTableDataSource } from '@angular/material/table';



@Component({
  selector: 'app-password-manger',
  templateUrl: './password-manger.component.html',
  styleUrls: ['./password-manger.component.css']
})
export class PasswordMangerComponent implements OnInit {



  displayedColumns: string[] = ['discription','username', 'password','Delete'];
  dataSource = new MatTableDataSource();




  ngOnInit(): void {
  }


  constructor(public backend:Backend,public key:KeycloakService,private appdailog:AppDialog){
    this.fetchAll()
  }






  f1(){
    this.key.getToken().then(R=>{
      console.log(R);
    })
    this.backend.get("/test").subscribe(R=>{
      console.log(R)
    })
  }

  addOpen(){
    this.f1()
    this.appdailog.openDialog(PasswordNewComponent,{"name":"deepak"}).subscribe(res=>{
      if(res!==""){
        this.backend.post("/password",res).subscribe(res=>{
          console.log(res)
          this.fetchAll();
        })
      }
    })
  }

  fetchAll(){
    this.backend.get("/password").subscribe((res:any)=>{
      console.log(res._embedded.passwordEntities)
      this.dataSource.data=res._embedded.passwordEntities
    })
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  alertPassword(msg){
    alert(msg)
  }

  delete(url){
    this.backend.delete(url,false).subscribe(res=>{
      console.log(res)
      this.fetchAll()
    })
  }

}
