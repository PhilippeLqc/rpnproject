import { TestBed } from '@angular/core/testing';

import { Rpnservice } from './rpn.service';

describe('RpnserviceService', () => {
  let service: Rpnservice;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Rpnservice);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
