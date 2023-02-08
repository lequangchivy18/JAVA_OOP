package assigment_day2_day10.bean;

import java.time.LocalDate;

public class Fresher extends Candidate {
    private LocalDate Graduation_date;
    private String Graduation_rank;
    private String Education;

    public Fresher() {

    }

    public Fresher(String fullName, LocalDate birthDay, String phone, String email, int candidate_type, int candidate_count, LocalDate graduation_date, String graduation_rank, String education) {
        super(fullName, birthDay, phone, email, candidate_type, candidate_count);
        Graduation_date = graduation_date;
        Graduation_rank = graduation_rank;
        Education = education;
    }

    public LocalDate getGraduation_date() {
        return Graduation_date;
    }

    public void setGraduation_date(LocalDate graduation_date) {
        Graduation_date = graduation_date;
    }

    public String getGraduation_rank() {
        return Graduation_rank;
    }

    public void setGraduation_rank(String graduation_rank) {
        Graduation_rank = graduation_rank;
    }

    public String getEducation() {
        return Education;
    }

    public void setEducation(String education) {
        Education = education;
    }


    @Override
    public void ShowInfo() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return super.toString() + " ||Fresher{" +
                "Graduation_date=" + Graduation_date +
                ", Graduation_rank='" + Graduation_rank + '\'' +
                ", Education='" + Education + '\'' +
                '}';
    }
}
