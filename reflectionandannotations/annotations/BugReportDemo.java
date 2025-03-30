package reflectionandannotations.annotations;

import java.lang.annotation.*;
import java.lang.reflect.*;

// 1️⃣ Define the @BugReport annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)  // Allow multiple annotations
@interface BugReport {
    String description();
}

// 2️⃣ Container annotation to hold multiple @BugReport annotations
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}

// 3️⃣ Class with multiple bug reports applied
class Software {

    @BugReport(description = "Null pointer exception in login")
    @BugReport(description = "Memory leak in data processing")
    public void fixBugs() {
        System.out.println("Fixing bugs...");
    }
}

public class BugReportDemo {
    public static void main(String[] args) throws Exception {
        // 4️⃣ Retrieve and print all bug reports
        Method method = Software.class.getMethod("fixBugs");

        if (method.isAnnotationPresent(BugReports.class)) {
            BugReports reports = method.getAnnotation(BugReports.class);

            for (BugReport report : reports.value()) {
                System.out.println("Bug: " + report.description());
            }
        } else {
            System.out.println("No bug reports found.");
        }
    }
}

