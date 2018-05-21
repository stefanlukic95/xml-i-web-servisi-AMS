import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DodatneuslugeComponent } from './dodatneusluge.component';

describe('DodatneuslugeComponent', () => {
  let component: DodatneuslugeComponent;
  let fixture: ComponentFixture<DodatneuslugeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DodatneuslugeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DodatneuslugeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
