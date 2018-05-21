import { TestBed, inject } from '@angular/core/testing';

import { KategorijaService } from './kategorija.service';

describe('KategorijaService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [KategorijaService]
    });
  });

  it('should be created', inject([KategorijaService], (service: KategorijaService) => {
    expect(service).toBeTruthy();
  }));
});
