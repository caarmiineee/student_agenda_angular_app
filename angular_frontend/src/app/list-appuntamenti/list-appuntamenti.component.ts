import { Component, DoCheck, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { Router } from '@angular/router';
import { AppuntamentoRequest, AppuntamentoResponse } from '../models/appuntamento.model';
import { Tipologia } from '../models/tipologia.model';
import { Ufficio } from '../models/ufficio.model';
import { AppuntamentiServiceService } from '../services/appuntamenti-service.service';

@Component({
  selector: 'app-list-appuntamenti',
  templateUrl: './list-appuntamenti.component.html',
  styleUrls: ['./list-appuntamenti.component.css']
})
export class ListAppuntamentiComponent implements OnInit, DoCheck, OnChanges {

  list: AppuntamentoResponse[] = [];
  isUpdate = false;
  currentId = -1;

  constructor(private appuntamentoService: AppuntamentiServiceService) { }
  
  ngDoCheck(): void {
    debugger;
    console.log("i am ngDoCheck");
  }
  
  ngOnChanges(changes: SimpleChanges): void {
    debugger;
    console.log("i am ngOnChanges");
  }

  ngOnInit(): void {
    debugger;
    this.appuntamentoService.getAll().subscribe({
      next: data => {
        this.list = data;
      },
      error: err => {
        console.log(err);
      }
    });
  }

  updateAppuntamento(id: number) {
    this.currentId = id;
    this.isUpdate = true;
  }

  deleteAppuntamento(id: number) {
    return this.appuntamentoService.delete(id).subscribe({
      next: data => {
        console.log(data);
        this.list = this.list.filter(app => app.id !== id);
      },
      error: err => {
        throw new Error(err);
      }
    })
  }
}
