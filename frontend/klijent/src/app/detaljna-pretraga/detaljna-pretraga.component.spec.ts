import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetaljnaPretragaComponent } from './detaljna-pretraga.component';

describe('DetaljnaPretragaComponent', () => {
  let component: DetaljnaPretragaComponent;
  let fixture: ComponentFixture<DetaljnaPretragaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetaljnaPretragaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetaljnaPretragaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
