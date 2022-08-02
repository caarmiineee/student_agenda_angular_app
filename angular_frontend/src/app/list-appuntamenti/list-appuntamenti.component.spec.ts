import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListAppuntamentiComponent } from './list-appuntamenti.component';

describe('ListAppuntamentiComponent', () => {
  let component: ListAppuntamentiComponent;
  let fixture: ComponentFixture<ListAppuntamentiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListAppuntamentiComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListAppuntamentiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
