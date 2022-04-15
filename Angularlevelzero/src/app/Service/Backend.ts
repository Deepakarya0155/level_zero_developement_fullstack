import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { environment } from "src/environments/environment";


@Injectable()
export class Backend{

  baseUrl=environment.backendBaseUrl;

  constructor(private http:HttpClient){

  }

  get(serviceUrl){
    return this.http.get(this.baseUrl+serviceUrl)
  }
}
