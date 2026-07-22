import { Router, ActivatedRoute } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CourseCard } from '../../components/course-card/course-card';
import { Highlight } from '../../directives/highlight';

import { CourseService } from '../../services/course';
import { Course } from '../../models/course.model';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-course-list',
  standalone: true,
  imports: [
  CommonModule,
  FormsModule,
  CourseCard,
  Highlight
],
  templateUrl: './course-list.html',
  styleUrl: './course-list.css',
})
export class CourseList implements OnInit {

  constructor(
  private courseService: CourseService,
  private router: Router,
  private route: ActivatedRoute
) {}

  isLoading = true;

  courses: Course[] = [];

  selectedCourseId = 0;
  searchTerm = '';

  onEnroll(courseId: number) {
    console.log('Enrolling in course: ' + courseId);
    this.selectedCourseId = courseId;
  }
  openCourse(course: Course) {
  this.router.navigate(['/courses', course.id]);
}

  trackByCourseId(index: number, course: Course) {
    return course.id;
  }
  searchCourses() {
  this.router.navigate(
    ['/courses'],
    {
      queryParams: {
        search: this.searchTerm
      }
    }
  );
}
 ngOnInit(): void {

  this.courses = this.courseService.getCourses();

  this.searchTerm =
    this.route.snapshot.queryParamMap.get('search') || '';

  this.isLoading = false;

}

}
