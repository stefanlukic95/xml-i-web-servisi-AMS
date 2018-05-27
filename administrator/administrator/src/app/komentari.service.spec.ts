import { TestBed, inject } from '@angular/core/testing';

import { KomentariService } from './komentari.service';

describe('KomentariService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [KomentariService]
    });
  });

  it('should be created', inject([KomentariService], (service: KomentariService) => {
    expect(service).toBeTruthy();
  }));
});
