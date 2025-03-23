import java.util.ArrayList;
import java.util.List;

// Abstract class for JobRole
abstract class JobRole {
    private String candidateName;
    private String skills;

    public JobRole(String candidateName, String skills) {
        this.candidateName = candidateName;
        this.skills = skills;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public String getSkills() {
        return skills;
    }

    public abstract void displayResume();
}

// Software Engineer role
class SoftwareEngineer extends JobRole {
    private String programmingLanguages;

    public SoftwareEngineer(String candidateName, String skills, String programmingLanguages) {
        super(candidateName, skills);
        this.programmingLanguages = programmingLanguages;
    }

    @Override
    public void displayResume() {
        System.out.println("Software Engineer: " + getCandidateName() +
                ", Skills: " + getSkills() +
                ", Programming Languages: " + programmingLanguages);
    }
}

// Data Scientist role
class DataScientist extends JobRole {
    private String tools;

    public DataScientist(String candidateName, String skills, String tools) {
        super(candidateName, skills);
        this.tools = tools;
    }

    @Override
    public void displayResume() {
        System.out.println("Data Scientist: " + getCandidateName() +
                ", Skills: " + getSkills() +
                ", Tools: " + tools);
    }
}

// Product Manager role
class ProductManager extends JobRole {
    private int yearsOfExperience;

    public ProductManager(String candidateName, String skills, int yearsOfExperience) {
        super(candidateName, skills);
        this.yearsOfExperience = yearsOfExperience;
    }

    @Override
    public void displayResume() {
        System.out.println("Product Manager: " + getCandidateName() +
                ", Skills: " + getSkills() +
                ", Experience: " + yearsOfExperience + " years");
    }
}

// Generic class for Resume with bounded type parameter
class Resume<T extends JobRole> {
    private List<T> resumes = new ArrayList<>();

    public void addResume(T resume) {
        resumes.add(resume);
    }

    public List<T> getResumes() {
        return resumes;
    }

    public void displayResumes() {
        for (T resume : resumes) {
            resume.displayResume();
        }
    }
}

// Utility class with wildcard method for screening resumes
class ResumeScreening {

    // Wildcard method to process resumes for multiple job roles dynamically
    public static void screenResumes(List<? extends JobRole> resumes) {
        System.out.println("\n--- Screening Resumes ---");
        for (JobRole resume : resumes) {
            resume.displayResume();
        }
    }
}

// Main class
public class ResumeScreeningSystem {
    public static void main(String[] args) {

        // Creating separate resume categories
        Resume<SoftwareEngineer> seResumes = new Resume<>();
        Resume<DataScientist> dsResumes = new Resume<>();
        Resume<ProductManager> pmResumes = new Resume<>();

        // Adding Software Engineer resumes
        seResumes.addResume(new SoftwareEngineer("Alice Johnson", "Java, Spring, SQL", "Java, Python"));
        seResumes.addResume(new SoftwareEngineer("Bob Williams", "C++, Cloud, Microservices", "C++, Go"));

        // Adding Data Scientist resumes
        dsResumes.addResume(new DataScientist("Charlie Brown", "ML, Python, Data Analysis", "TensorFlow, Pandas"));
        dsResumes.addResume(new DataScientist("Diana Ross", "AI, NLP, Data Engineering", "SciKit, PyTorch"));

        // Adding Product Manager resumes
        pmResumes.addResume(new ProductManager("Edward King", "Leadership, Strategy, Agile", 8));
        pmResumes.addResume(new ProductManager("Fiona Smith", "Marketing, Roadmap, Analytics", 5));

        // Displaying resumes by category
        System.out.println("--- Software Engineer Resumes ---");
        seResumes.displayResumes();

        System.out.println("\n--- Data Scientist Resumes ---");
        dsResumes.displayResumes();

        System.out.println("\n--- Product Manager Resumes ---");
        pmResumes.displayResumes();

        // Merging all resumes into a single list for screening
        System.out.println("\n--- Screening All Resumes ---");

        List<JobRole> allResumes = new ArrayList<>();
        allResumes.addAll(seResumes.getResumes());
        allResumes.addAll(dsResumes.getResumes());
        allResumes.addAll(pmResumes.getResumes());

        // Screening all resumes dynamically using wildcard method
        ResumeScreening.screenResumes(allResumes);
    }
}
