package assigment_day2_day10.bean;

import java.time.LocalDate;

public class Intern extends Candidate {
    private String Majors;
    private int Semester;
    private String University_name;

    public Intern() {

    }

    public Intern(String fullName, LocalDate birthDay, String phone, String email, int candidate_type, int candidate_count, String majors, int semester, String university_name) {
        super(fullName, birthDay, phone, email, candidate_type, candidate_count);
        Majors = majors;
        Semester = semester;
        University_name = university_name;
    }


    public String getMajors() {
        return Majors;
    }

    public void setMajors(String majors) {
        Majors = majors;
    }

    public int getSemester() {
        return Semester;
    }

    public void setSemester(int semester) {
        Semester = semester;
    }

    public String getUniversity_name() {
        return University_name;
    }

    public void setUniversity_name(String university_name) {
        University_name = university_name;
    }


    @Override
    public void ShowInfo() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return super.toString() + " ||Intern{" +
                "Majors='" + Majors + '\'' +
                ", Semester=" + Semester +
                ", University_name='" + University_name + '\'' +
                '}';
    }
}
