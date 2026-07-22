import { noCourseCode } from '../../validators/course-validator';

import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';

import {
  FormBuilder,
  FormGroup,
  Validators,
  ReactiveFormsModule,
  FormArray,
  FormControl,
  AbstractControl,
  ValidationErrors
} from '@angular/forms';

@Component({
  selector: 'app-reactive-enrollment-form',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule
  ],
  templateUrl: './reactive-enrollment-form.html',
  styleUrl: './reactive-enrollment-form.css'
})

export class ReactiveEnrollmentForm implements OnInit {

  enrollForm!: FormGroup;

  constructor(private fb: FormBuilder) {}

  ngOnInit(): void {

    this.enrollForm = this.fb.group({

      studentName: [
        '',
        [
          Validators.required,
          Validators.minLength(3)
        ]
      ],

      studentEmail: [
        '',
        [
          Validators.required,
          Validators.email
        ],
        [
          this.simulateEmailCheck.bind(this)
        ]
      ],

      courseId: [
        '',
        [
          Validators.required,
          noCourseCode
        ]
      ],

      preferredSemester: [
        'Odd',
        Validators.required
      ],

      agreeToTerms: [
        false,
        Validators.requiredTrue
      ],

      additionalCourses: this.fb.array([])

    });

  }

  simulateEmailCheck(
    control: AbstractControl
  ): Promise<ValidationErrors | null> {

    return new Promise(resolve => {

      setTimeout(() => {

        if (control.value?.includes('test@')) {
          resolve({ emailTaken: true });
        } else {
          resolve(null);
        }

      }, 800);

    });

  }

  onSubmit() {

    console.log('Form Value:', this.enrollForm.value);

    console.log(
      'Raw Value:',
      this.enrollForm.getRawValue()
    );

  }

  get additionalCourses(): FormArray {

    return this.enrollForm.get(
      'additionalCourses'
    ) as FormArray;

  }

  addCourse() {

    this.additionalCourses.push(
      new FormControl(
        '',
        Validators.required
      )
    );

  }

  removeCourse(index: number) {

    this.additionalCourses.removeAt(index);

  }

}
