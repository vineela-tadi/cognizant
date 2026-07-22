import { Component, Input, Output, EventEmitter, OnChanges, SimpleChanges } from '@angular/core';
import { CommonModule, NgSwitch, NgSwitchCase, NgSwitchDefault } from '@angular/common';
import { Router } from '@angular/router';

import { EnrollmentService } from '../../services/enrollment';
import { CreditLabelPipe } from '../../pipes/credit-label-pipe';

@Component({
  selector: 'app-course-card',
  standalone: true,
  imports: [
    CommonModule,
    NgSwitch,
    NgSwitchCase,
    NgSwitchDefault,
    CreditLabelPipe
  ],
  templateUrl: './course-card.html',
  styleUrl: './course-card.css',
})
export class CourseCard implements OnChanges {

  @Input() course: any;

  @Output() enrollRequested = new EventEmitter<number>();

  isExpanded = false;

  constructor(
    private enrollmentService: EnrollmentService,
    private router: Router
  ) {}

  toggleDetails() {
    this.isExpanded = !this.isExpanded;
  }

  showDetails() {
    console.log('Course ID:', this.course.id);
    this.router.navigate(['/courses', this.course.id]);
  }

  onEnroll() {

    if (this.isEnrolled) {
      this.enrollmentService.unenroll(this.course.id);
    } else {
      this.enrollmentService.enroll(this.course.id);
    }

    this.enrollRequested.emit(this.course.id);

    console.log(
      'Enrolled Courses:',
      this.enrollmentService.getEnrolledCourses()
    );
  }

  get isEnrolled(): boolean {
    return this.enrollmentService.isEnrolled(this.course.id);
  }

  get cardClasses() {
    return {
      'card--enrolled': this.isEnrolled,
      'card--full': this.course.credits >= 4,
      'expanded': this.isExpanded
    };
  }

  ngOnChanges(changes: SimpleChanges): void {
    console.log('Previous Value:', changes['course']?.previousValue);
    console.log('Current Value:', changes['course']?.currentValue);
  }
}
