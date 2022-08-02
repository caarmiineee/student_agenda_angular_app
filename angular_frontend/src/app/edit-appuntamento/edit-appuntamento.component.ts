import { Component, DoCheck, Input, OnChanges, OnInit } from '@angular/core';
import { AppuntamentoRequest, AppuntamentoResponse } from '../models/appuntamento.model';
import { Tipologia } from '../models/tipologia.model';
import { Ufficio } from '../models/ufficio.model';
import { AppuntamentiServiceService } from '../services/appuntamenti-service.service';

@Component({
  selector: 'app-edit-appuntamento',
  templateUrl: './edit-appuntamento.component.html',
  styleUrls: ['./edit-appuntamento.component.css']
})
export class EditAppuntamentoComponent implements OnInit, DoCheck, OnChanges {

  isUpdate = false;
  appuntamento: AppuntamentoRequest = new AppuntamentoRequest();
  appuntamentoResponse: AppuntamentoResponse = new AppuntamentoResponse();
  listTipo: Tipologia[] = [];
  listUfficio: Ufficio[] = [];
  errorMessage = '';
  @Input() id = -1;

  constructor(private appuntamentoService: AppuntamentiServiceService) { }

  ngOnChanges(): void {
    debugger;
    console.log("i am ngOnChanges")
  }

  ngDoCheck(): void {
    debugger;
    if (this.appuntamento.id === -1) {
      this.appuntamentoService.getById(this.id).subscribe({
        next: data => {
          console.log(data);
          this.appuntamentoResponse = data;
        },
        error: err => {
          console.log(err);
          throw new Error("Appuntamento don't found");
        }
      })
      if (this.appuntamentoResponse.id !== -1) {

        this.appuntamento.id = this.appuntamentoResponse.id;
        this.appuntamento.agendaId = 3;
        this.appuntamento.ora = this.appuntamentoResponse.ora;
        this.appuntamento.descrizione = this.appuntamentoResponse.descrizione;
        this.appuntamento.data = this.appuntamentoResponse.data;

        this.listTipo.forEach(type => {
          if (type.tipologia === this.appuntamentoResponse.tipologiaNome) {
            this.appuntamento.tipologiaId = type.id;
          }
        });
        this.listUfficio.forEach(office => {
          if (office.nome === this.appuntamentoResponse.ufficioNome) {
            this.appuntamento.ufficioId = office.id
          }
        })
      }
    }
  }

  ngOnInit(): void {
    debugger;
    console.log("i am ngOnInit");
    this.getListTipo();
    this.getListUffici();
  }

  moveToList() {
    this.isUpdate = false;
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
    debugger;
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
    this.appuntamentoService.update(this.appuntamento.id, this.appuntamento).subscribe({
      next: data => {
        console.log(data);
      },
      error: err => {
        console.log(err);
        this.errorMessage = err.error.message;
        throw new Error("Appuntamento don't save")
      }
    })
    window.location.reload();
  }

}
