import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DemoTerComponent } from './demo-ter.component';

describe('DemoTerComponent', () => {
  let component: DemoTerComponent;
  let fixture: ComponentFixture<DemoTerComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DemoTerComponent]
    });
    fixture = TestBed.createComponent(DemoTerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
