import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { AppuntamentoRequest } from '../models/appuntamento.model';
import { Tipologia } from '../models/tipologia.model';
import { Ufficio } from '../models/ufficio.model';
import { AppuntamentiServiceService } from '../services/appuntamenti-service.service';

@Component({
  selector: 'app-add-appuntamento',
  templateUrl: './add-appuntamento.component.html',
  styleUrls: ['./add-appuntamento.component.css']
})
export class AddAppuntamentoComponent implements OnInit {

  appuntamento: AppuntamentoRequest = new AppuntamentoRequest();

  listTipo: Tipologia[] = [];
  listUfficio: Ufficio[] = [];
  errorMessage = '';
  
  constructor(private appuntamentoService: AppuntamentiServiceService,
              private datePipe: DatePipe) { }

  ngOnInit(): void {
    this.getListTipo();
    this.getListUffici();
  }
 
   changeType(id: number) {
    this.appuntamento.tipologiaId = id;
  }

  changeOffice(id: number) {
    this.appuntamento.ufficioId = id;
  }

  getListTipo() {
    this.appuntamentoService.getTipologia().subscribe({
      next: data => {
        console.log(data);
        this.listTipo = data;
      },
      error: err => {
        console.log(err);
        throw new Error("list type not found")
      }
    })
  }

  getListUffici() {
    this.appuntamentoService.getUffici().subscribe({
      next: data => {
        console.log(data);
        this.listUfficio = data;
      },
      error: err => {
        console.log(err);
        throw new Error("list office not found")
      }
    })
  }

  onSubmit(): void {
    const data = {
      id: this.appuntamento.id,
      ora: this.appuntamento?.ora,
      descrizione: this.appuntamento?.descrizione,
      data: this.appuntamento.data,
      agendaId: 3,
      ufficioId: this.appuntamento?.ufficioId,
      tipologiaId: this.appuntamento?.tipologiaId
    }
    this.appuntamentoService.add(data).subscribe({
      next: data => {
        console.log(data);
      },
      error: err =>{
        console.log(err);
        this.errorMessage = err.error.message;
      }
    })
    window.location.href = '/list-appuntamenti';
  }
}
