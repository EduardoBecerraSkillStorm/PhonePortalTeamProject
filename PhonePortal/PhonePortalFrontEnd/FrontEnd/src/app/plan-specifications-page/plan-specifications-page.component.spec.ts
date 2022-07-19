import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PlanSpecificationsPageComponent } from './plan-specifications-page.component';

describe('PlanSpecificationsPageComponent', () => {
  let component: PlanSpecificationsPageComponent;
  let fixture: ComponentFixture<PlanSpecificationsPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PlanSpecificationsPageComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PlanSpecificationsPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
