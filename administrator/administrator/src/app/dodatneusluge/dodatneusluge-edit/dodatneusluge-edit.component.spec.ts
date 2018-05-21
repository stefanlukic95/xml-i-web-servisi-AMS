import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DodatneuslugeEditComponent } from './dodatneusluge-edit.component';

describe('DodatneuslugeEditComponent', () => {
  let component: DodatneuslugeEditComponent;
  let fixture: ComponentFixture<DodatneuslugeEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DodatneuslugeEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DodatneuslugeEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
