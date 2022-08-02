import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AppuntamentoRequest, AppuntamentoResponse } from '../models/appuntamento.model';

const baseUrl = 'http://localhost:8087/api/'

@Injectable({
  providedIn: 'root'
})
export class AppuntamentiServiceService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<AppuntamentoResponse[]> {
    return this.http.get<AppuntamentoResponse[]>(`${baseUrl}appuntamento/list`);
  }

  getTipologia(): Observable<any> {
    return this.http.get(`${baseUrl}tipologia/list`);
  }

  getUffici(): Observable<any> {
    return this.http.get(`${baseUrl}ufficio/list`);
  }

  add(appuntamento: AppuntamentoRequest): Observable<AppuntamentoRequest> {
    return this.http.post<AppuntamentoRequest>(`${baseUrl}appuntamento/add`, appuntamento);
  }

  getById(id: number): Observable<AppuntamentoResponse> {
    return this.http.get<AppuntamentoResponse>(`${baseUrl}appuntamento/` + id);
  }

  update(id: number, appuntamento: AppuntamentoRequest): Observable<AppuntamentoRequest> {
    return this.http.put<AppuntamentoRequest>(`${baseUrl}appuntamento/` + id, appuntamento);
  }

  delete(id: number): Observable<Object> {
    return this.http.delete(`${baseUrl}appuntamento/` + id);
  }
}
