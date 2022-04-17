import { Component, Inject, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { KeycloakService } from 'keycloak-angular';

@Component({
  selector: 'app-password-new',
  templateUrl: './password-new.component.html',
  styleUrls: ['./password-new.component.css']
})
export class PasswordNewComponent implements OnInit {

  addForm=new FormGroup({
    discription:new FormControl("",Validators.required),
    userID:new FormControl("",Validators.required),
    username:new FormControl("",Validators.required),
    password:new FormControl("",Validators.required)
  })

  constructor(@Inject(MAT_DIALOG_DATA) public data,public key:KeycloakService) {
    console.log(data,key.getUsername())
    this.addForm.controls["userID"].setValue(this.key.getUsername())
 }

  ngOnInit(): void {

  }

}
