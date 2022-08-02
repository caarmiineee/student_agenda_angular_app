import { TestBed } from '@angular/core/testing';

import { AppuntamentiServiceService } from './appuntamenti-service.service';

describe('AppuntamentiServiceService', () => {
  let service: AppuntamentiServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AppuntamentiServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
