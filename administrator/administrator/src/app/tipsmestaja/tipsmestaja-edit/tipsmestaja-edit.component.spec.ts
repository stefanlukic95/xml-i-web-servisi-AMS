import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TipsmestajaEditComponent } from './tipsmestaja-edit.component';

describe('TipsmestajaEditComponent', () => {
  let component: TipsmestajaEditComponent;
  let fixture: ComponentFixture<TipsmestajaEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TipsmestajaEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TipsmestajaEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
