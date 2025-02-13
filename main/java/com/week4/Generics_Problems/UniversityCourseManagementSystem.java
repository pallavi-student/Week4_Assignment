package com.week4.day1;
import java.util.*;

// Abstract class representing different types of courses
abstract class CourseType {
    private String courseName;
    private String instructorName;

    public CourseType(String courseName, String instructorName) {
        this.courseName = courseName;
        this.instructorName = instructorName;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public abstract void displayCourseDetails();
}

// Exam-based course extending CourseType
class ExamCourse extends CourseType {
    private int examDuration;  // in minutes

    public ExamCourse(String courseName, String instructorName, int examDuration) {
        super(courseName, instructorName);
        this.examDuration = examDuration;
    }

    @Override
    public void displayCourseDetails() {
        System.out.println("Exam Course: " + getCourseName() + ", Instructor: " + getInstructorName() + ", Exam Duration: " + examDuration + " mins");
    }
}

// Assignment-based course extending CourseType
class AssignmentCourse extends CourseType {
    private int numberOfAssignments;

    public AssignmentCourse(String courseName, String instructorName, int numberOfAssignments) {
        super(courseName, instructorName);
        this.numberOfAssignments = numberOfAssignments;
    }

    @Override
    public void displayCourseDetails() {
        System.out.println("Assignment Course: " + getCourseName() + ", Instructor: " + getInstructorName() + ", Assignments: " + numberOfAssignments);
    }
}

// Research-based course extending CourseType
class ResearchCourse extends CourseType {
    private String researchTopic;

    public ResearchCourse(String courseName, String instructorName, String researchTopic) {
        super(courseName, instructorName);
        this.researchTopic = researchTopic;
    }

    @Override
    public void displayCourseDetails() {
        System.out.println("Research Course: " + getCourseName() + ", Instructor: " + getInstructorName() + ", Research Topic: " + researchTopic);
    }
}

// Generic class to manage courses
class Course<T extends CourseType> {
    private List<T> courseList = new ArrayList<>();

    public void addCourse(T course) {
        courseList.add(course);
    }

    public void displayAllCourses() {
        for (T course : courseList) {
            course.displayCourseDetails();
        }
    }

    // Method to display courses using wildcards
    public static void displayCourses(List<? extends CourseType> courses) {
        for (CourseType course : courses) {
            course.displayCourseDetails();
        }
    }
}

public class UniversityCourseManagementSystem {
    public static void main(String[] args) {
        // Create different types of courses
        ExamCourse examCourse = new ExamCourse("Mathematics", "Dr. Gupta", 120);
        AssignmentCourse assignmentCourse = new AssignmentCourse("Computer Science", "Prof. Sarowar Gupta", 5);
        ResearchCourse researchCourse = new ResearchCourse("Physics", "Dr. Sarowar", "Chemistry");

        // Manage courses using the generic class
        Course<ExamCourse> examCourseManager = new Course<>();
        examCourseManager.addCourse(examCourse);

        Course<AssignmentCourse> assignmentCourseManager = new Course<>();
        assignmentCourseManager.addCourse(assignmentCourse);

        Course<ResearchCourse> researchCourseManager = new Course<>();
        researchCourseManager.addCourse(researchCourse);

        // Display all courses
        System.out.println("Exam Courses:");
        examCourseManager.displayAllCourses();

        System.out.println("\nAssignment Courses:");
        assignmentCourseManager.displayAllCourses();

        System.out.println("\nResearch Courses:");
        researchCourseManager.displayAllCourses();

        // Using wildcard to display a list of courses dynamically
        System.out.println("\nDisplaying all courses using wildcard:");
        List<CourseType> allCourses = Arrays.asList(examCourse, assignmentCourse, researchCourse);
        Course.displayCourses(allCourses);
    }
}
