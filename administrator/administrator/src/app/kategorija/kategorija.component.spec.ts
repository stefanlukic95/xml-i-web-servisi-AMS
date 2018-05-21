import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { KategorijaComponent } from './kategorija.component';

describe('KategorijaComponent', () => {
  let component: KategorijaComponent;
  let fixture: ComponentFixture<KategorijaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ KategorijaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(KategorijaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
