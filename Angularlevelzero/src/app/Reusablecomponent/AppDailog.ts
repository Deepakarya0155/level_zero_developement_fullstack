import { Injectable } from "@angular/core";
import { MatDialog } from "@angular/material/dialog";

@Injectable({providedIn:"root"})
export class AppDialog{
  constructor(public dialog: MatDialog) {}

  openDialog(componentrefe,data1) {
    const dialogRef = this.dialog.open(componentrefe,{
      data: data1,
    });

    return dialogRef.afterClosed();
  }


}
