import { NgModule } from '@angular/core';
import {MatButtonModule} from '@angular/material/button';
import {MatDialogModule} from '@angular/material/dialog';
import {MatFormFieldModule} from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import {MatTableModule} from '@angular/material/table';


const Mat_com_ls=[MatButtonModule,MatDialogModule,MatFormFieldModule,MatInputModule,MatTableModule]



@NgModule({
  imports:[Mat_com_ls],
  exports:[Mat_com_ls]
})
export class AppMatModule{}
