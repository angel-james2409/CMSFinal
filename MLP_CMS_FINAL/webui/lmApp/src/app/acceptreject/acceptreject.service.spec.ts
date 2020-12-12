import { TestBed } from '@angular/core/testing';

import { AcceptrejectService } from './acceptreject.service';

describe('AcceptrejectService', () => {
  let service: AcceptrejectService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AcceptrejectService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
