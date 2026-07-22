import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CourseService } from '../../services/course';

@Component({
  selector: 'app-course-summary-widget',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './course-summary-widget.html',
  styleUrl: './course-summary-widget.css'
})
export class CourseSummaryWidget {

  constructor(
    public courseService: CourseService
  ) {}

}
