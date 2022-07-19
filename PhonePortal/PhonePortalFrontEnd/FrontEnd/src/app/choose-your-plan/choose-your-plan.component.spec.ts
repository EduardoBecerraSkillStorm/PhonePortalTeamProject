import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChooseYourPlanComponent } from './choose-your-plan.component';

describe('ChooseYourPlanComponent', () => {
  let component: ChooseYourPlanComponent;
  let fixture: ComponentFixture<ChooseYourPlanComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ChooseYourPlanComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ChooseYourPlanComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
