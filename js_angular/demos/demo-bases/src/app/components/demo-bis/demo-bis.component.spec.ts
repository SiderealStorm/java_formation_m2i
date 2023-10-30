import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DemoBisComponent } from './demo-bis.component';

describe('DemoBisComponent', () => {
  let component: DemoBisComponent;
  let fixture: ComponentFixture<DemoBisComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DemoBisComponent]
    });
    fixture = TestBed.createComponent(DemoBisComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
