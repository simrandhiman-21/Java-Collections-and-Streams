import java.util.ArrayList;
import java.util.List;

// Abstract CourseType class
abstract class CourseType {
    private String courseName;
    private String instructor;

    public CourseType(String courseName, String instructor) {
        this.courseName = courseName;
        this.instructor = instructor;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getInstructor() {
        return instructor;
    }

    public abstract void displayDetails();
}

// Exam-based course
class ExamCourse extends CourseType {
    private int examWeight;

    public ExamCourse(String courseName, String instructor, int examWeight) {
        super(courseName, instructor);
        this.examWeight = examWeight;
    }

    @Override
    public void displayDetails() {
        System.out.println("Exam Course: " + getCourseName() + 
                ", Instructor: " + getInstructor() + 
                ", Exam Weight: " + examWeight + "%");
    }
}

// Assignment-based course
class AssignmentCourse extends CourseType {
    private int assignmentCount;

    public AssignmentCourse(String courseName, String instructor, int assignmentCount) {
        super(courseName, instructor);
        this.assignmentCount = assignmentCount;
    }

    @Override
    public void displayDetails() {
        System.out.println("Assignment Course: " + getCourseName() + 
                ", Instructor: " + getInstructor() + 
                ", Assignments: " + assignmentCount);
    }
}

// Research-based course
class ResearchCourse extends CourseType {
    private String researchField;

    public ResearchCourse(String courseName, String instructor, String researchField) {
        super(courseName, instructor);
        this.researchField = researchField;
    }

    @Override
    public void displayDetails() {
        System.out.println("Research Course: " + getCourseName() + 
                ", Instructor: " + getInstructor() + 
                ", Research Field: " + researchField);
    }
}

// Generic class for managing courses
class Course<T extends CourseType> {
    private List<T> courses = new ArrayList<>();

    public void addCourse(T course) {
        courses.add(course);
    }

    public List<T> getCourses() {
        return courses;
    }

    public void displayCourses() {
        for (T course : courses) {
            course.displayDetails();
        }
    }
}

// Utility class for wildcard-based operations
class CourseManager {
    
    // Wildcard method to display all types of courses dynamically
    public static void displayAllCourses(List<? extends CourseType> courses) {
        for (CourseType course : courses) {
            course.displayDetails();
        }
    }
}

// Main class
public class UniversityCourseManagement {
    public static void main(String[] args) {

        // Creating course lists
        Course<ExamCourse> examCourses = new Course<>();
        Course<AssignmentCourse> assignmentCourses = new Course<>();
        Course<ResearchCourse> researchCourses = new Course<>();

        // Adding exam courses
        examCourses.addCourse(new ExamCourse("Math 101", "Dr. Smith", 70));
        examCourses.addCourse(new ExamCourse("Physics 201", "Dr. Brown", 60));

        // Adding assignment courses
        assignmentCourses.addCourse(new AssignmentCourse("Programming 101", "Prof. Wilson", 5));
        assignmentCourses.addCourse(new AssignmentCourse("Data Structures", "Dr. Johnson", 7));

        // Adding research courses
        researchCourses.addCourse(new ResearchCourse("AI Research", "Dr. Lee", "Artificial Intelligence"));
        researchCourses.addCourse(new ResearchCourse("Cybersecurity", "Dr. Patel", "Network Security"));

        // Displaying individual course categories
        System.out.println("----- Exam Courses -----");
        examCourses.displayCourses();

        System.out.println("\n----- Assignment Courses -----");
        assignmentCourses.displayCourses();

        System.out.println("\n----- Research Courses -----");
        researchCourses.displayCourses();

        // Merging courses into a single list using wildcard operations
        System.out.println("\n----- Displaying All Courses -----");

        List<CourseType> allCourses = new ArrayList<>();
        allCourses.addAll(examCourses.getCourses());
        allCourses.addAll(assignmentCourses.getCourses());
        allCourses.addAll(researchCourses.getCourses());

        // Displaying all courses dynamically using wildcard method
        CourseManager.displayAllCourses(allCourses);
    }
}
