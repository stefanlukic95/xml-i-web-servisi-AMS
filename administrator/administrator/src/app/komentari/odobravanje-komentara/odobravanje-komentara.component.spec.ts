import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OdobravanjeKomentaraComponent } from './odobravanje-komentara.component';

describe('OdobravanjeKomentaraComponent', () => {
  let component: OdobravanjeKomentaraComponent;
  let fixture: ComponentFixture<OdobravanjeKomentaraComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OdobravanjeKomentaraComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OdobravanjeKomentaraComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
