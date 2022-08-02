import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditAppuntamentoComponent } from './edit-appuntamento.component';

describe('EditAppuntamentoComponent', () => {
  let component: EditAppuntamentoComponent;
  let fixture: ComponentFixture<EditAppuntamentoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditAppuntamentoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditAppuntamentoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
