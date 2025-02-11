package com.week4.day1;
import java.util.*;

// Abstract JobRole class
abstract class JobRole {
    private String candidateName;
    private int experience;

    public JobRole(String candidateName, int experience) {
        this.candidateName = candidateName;
        this.experience = experience;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public int getExperience() {
        return experience;
    }

    public abstract void displayRole();
}

// class Software Engineer extending JobRole
class SoftwareEngineer extends JobRole {
    public SoftwareEngineer(String candidateName, int experience) {
        super(candidateName, experience);
    }

    @Override
    public void displayRole() {
        System.out.println("Software Engineer Role for: " + getCandidateName() + " with " + getExperience() + " years experience.");
    }
}

//class dataScientist extending JobRole
class DataScientist extends JobRole {
    public DataScientist(String candidateName, int experience) {
        super(candidateName, experience);
    }

    @Override
    public void displayRole() {
        System.out.println("Data Scientist Role for: " + getCandidateName() + " with " + getExperience() + " years experience.");
    }
}

//class ProductManager extending JobRole
class ProductManager extends JobRole {
    public ProductManager(String candidateName, int experience) {
        super(candidateName, experience);
    }

    @Override
    public void displayRole() {
        System.out.println("Product Manager Role for: " + getCandidateName() + " with " + getExperience() + " years experience.");
    }
}

// Generic Resume processor class
class Resume<T extends JobRole> {
    private T jobRole;

    public Resume(T jobRole) {
        this.jobRole = jobRole;
    }

    public void processResume() {
        System.out.println("\nProcessing resume for: " + jobRole.getCandidateName());
        jobRole.displayRole();
    }
}

// Screening Pipeline using Wildcards
class ScreeningPipeline {
    public static void screenCandidates(List<? extends JobRole> candidates) {
        for (JobRole candidate : candidates) {
            candidate.displayRole();
        }
    }
}

public class ResumeScreeningSystem {
    public static void main(String[] args) {
        // Creating job role instances
        SoftwareEngineer softwareEngineer = new SoftwareEngineer("Sarowar", 5);
        DataScientist dataScientist = new DataScientist("Suru", 3);
        ProductManager productManager = new ProductManager("Sarowar Gupta", 7);


        // Processing resumes using generics
        Resume<SoftwareEngineer> resume1 = new Resume<>(softwareEngineer);
        Resume<DataScientist> resume2 = new Resume<>(dataScientist);
        Resume<ProductManager> resume3 = new Resume<>(productManager);

        resume1.processResume();
        resume2.processResume();
        resume3.processResume();

        // Screening pipeline using wildcards
        List<JobRole> candidates = Arrays.asList(softwareEngineer, dataScientist, productManager);
        System.out.println("\nScreening candidates:");
        ScreeningPipeline.screenCandidates(candidates);
    }
}