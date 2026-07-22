import { Injectable } from '@angular/core';
import { Course } from '../models/course.model';

@Injectable({
  providedIn: 'root'
})
export class CourseService {

  private courses: Course[] = [

    {
      id: 1,
      name: 'Angular',
      code: 'ANG101',
      credits: 4,
      gradeStatus: 'passed'
    },

    {
      id: 2,
      name: 'Java',
      code: 'JAVA201',
      credits: 3,
      gradeStatus: 'failed'
    },

    {
      id: 3,
      name: 'Python',
      code: 'PY301',
      credits: 4,
      gradeStatus: 'pending'
    },

    {
      id: 4,
      name: 'DBMS',
      code: 'DB401',
      credits: 3,
      gradeStatus: 'passed'
    },

    {
      id: 5,
      name: 'AI',
      code: 'AI501',
      credits: 5,
      gradeStatus: 'pending'
    }

  ];

  getCourses(): Course[] {
    return this.courses;
  }
getCourseById(id: number): Course | undefined {

  console.log('SEARCHING FOR ID:', id);

  return this.courses.find(
    course => course.id === id
  );

}

  addCourse(course: Course): void {
    this.courses.push(course);
  }

}
