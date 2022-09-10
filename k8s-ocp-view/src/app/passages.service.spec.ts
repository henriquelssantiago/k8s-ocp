import { TestBed } from '@angular/core/testing';

import { PassagesService } from './passages.service';

describe('PassagesService', () => {
  let service: PassagesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PassagesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
