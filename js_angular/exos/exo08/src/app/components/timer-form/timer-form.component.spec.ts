import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TimerFormComponent } from './timer-form.component';

describe('TimerFormComponent', () => {
  let component: TimerFormComponent;
  let fixture: ComponentFixture<TimerFormComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TimerFormComponent]
    });
    fixture = TestBed.createComponent(TimerFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
