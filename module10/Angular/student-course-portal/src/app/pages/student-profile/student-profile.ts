import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EnrollmentService } from '../../services/enrollment';

@Component({
  selector: 'app-student-profile',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './student-profile.html',
})
export class StudentProfile implements OnInit {

  constructor(
    public enrollmentService: EnrollmentService
  ) {}

  ngOnInit(): void {
    console.log('PROFILE SERVICE', this.enrollmentService);
  }
}
