import { TestBed } from '@angular/core/testing';

import { ImeServiceService } from './ime-service.service';

describe('ImeServiceService', () => {
  let service: ImeServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ImeServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
