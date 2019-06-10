import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CapstoreHomeComponent } from './capstore-home.component';

describe('CapstoreHomeComponent', () => {
  let component: CapstoreHomeComponent;
  let fixture: ComponentFixture<CapstoreHomeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CapstoreHomeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CapstoreHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
