import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddAppuntamentoComponent } from './add-appuntamento.component';

describe('AddAppuntamentoComponent', () => {
  let component: AddAppuntamentoComponent;
  let fixture: ComponentFixture<AddAppuntamentoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddAppuntamentoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddAppuntamentoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
