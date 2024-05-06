import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RpnComponent } from './rpn.component';

describe('RpnComponentComponent', () => {
  let component: RpnComponent;
  let fixture: ComponentFixture<RpnComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RpnComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(RpnComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
