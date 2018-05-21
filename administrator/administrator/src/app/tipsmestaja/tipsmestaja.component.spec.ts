import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TipsmestajaComponent } from './tipsmestaja.component';

describe('TipsmestajaComponent', () => {
  let component: TipsmestajaComponent;
  let fixture: ComponentFixture<TipsmestajaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TipsmestajaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TipsmestajaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
