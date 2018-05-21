import { TestBed, inject } from '@angular/core/testing';

import { TipsmestajaService } from './tipsmestaja.service';

describe('TipsmestajaService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [TipsmestajaService]
    });
  });

  it('should be created', inject([TipsmestajaService], (service: TipsmestajaService) => {
    expect(service).toBeTruthy();
  }));
});
