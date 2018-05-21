import { TestBed, inject } from '@angular/core/testing';

import { DodatneuslugeService } from './dodatneusluge.service';

describe('DodatneuslugeService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [DodatneuslugeService]
    });
  });

  it('should be created', inject([DodatneuslugeService], (service: DodatneuslugeService) => {
    expect(service).toBeTruthy();
  }));
});
