import React from "react";

function CourseDetails() {

    const courses = [
        { id: 1, name: "React" },
        { id: 2, name: "Angular" },
        { id: 3, name: "Node JS" }
    ];

    return (

        <div>

            <h2>Course Details</h2>

            <ul>

                {
                    courses.map(course => (
                        <li key={course.id}>
                            {course.name}
                        </li>
                    ))
                }

            </ul>

        </div>

    );
}

export default CourseDetails;