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
  post(serviceUrl,data){
    return this.http.post(this.baseUrl+serviceUrl,data);
  }
  delete(serviceUrl,appendBaseUrlFlag=true){
    if(appendBaseUrlFlag){
      return this.http.delete(this.baseUrl+serviceUrl);
    }else{
      return this.http.delete(serviceUrl);
    }
  }

}
