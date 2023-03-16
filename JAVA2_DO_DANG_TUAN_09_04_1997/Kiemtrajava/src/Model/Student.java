package Model;

public class Student {
    private int stdCode;
    private String stdName;
    private int stdAge;
    private String stdClass;
    private Double stdGPA;
    private String stdGender;

    public Student(String stdName, int stdAge, String stdClass, Double stdGPA, String stdGender) {
        this.stdName = stdName;
        this.stdAge = stdAge;
        this.stdClass = stdClass;
        this.stdGPA = stdGPA;
        this.stdGender = stdGender;
    }

    public Student(int stdCode, String stdName, int stdAge, String stdClass, Double stdGPA, String stdGender) {
        this.stdCode = stdCode;
        this.stdName = stdName;
        this.stdAge = stdAge;
        this.stdClass = stdClass;
        this.stdGPA = stdGPA;
        this.stdGender = stdGender;
    }

    public int getStdCode() {
        return this.stdCode;
    }

    public void setStdCode(int stdCode) {
        this.stdCode = stdCode;
    }

    public String getStdName() {
        return this.stdName;
    }

    public void setStdName(String stdName) {
        this.stdName = stdName;
    }

    public int getStdAge() {
        return this.stdAge;
    }

    public void setStdAge(int stdAge) {
        this.stdAge = stdAge;
    }

    public String getStdClass() {
        return this.stdClass;
    }

    public void setStdClass(String stdClass) {
        this.stdClass = stdClass;
    }

    public Double getStdGPA() {
        return this.stdGPA;
    }

    public void setStdGPA(Double stdGPA) {
        this.stdGPA = stdGPA;
    }

    public String getStdGender() {
        return this.stdGender;
    }

    public void setStdGender(String stdGender) {
        this.stdGender = stdGender;
    }

    public String toString() {
        return "Student {stdCode=" + this.stdCode + ", stdName='" + this.stdName + "', stdAge=" + this.stdAge + ", stdClass='" + this.stdClass + "', stdGPA=" + this.stdGPA + ", stdGender='" + this.stdGender + "'}";
    }}
