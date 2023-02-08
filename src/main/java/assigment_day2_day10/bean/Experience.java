package assigment_day2_day10.bean;

import java.time.LocalDate;


public class Experience extends Candidate {

    private int ExpInYear;
    private String ProSkill;

    public Experience() {

    }

    public Experience(String fullName, LocalDate birthDay, String phone, String email, int candidate_type, int candidate_count, int expInYear, String proSkill) {
        super(fullName, birthDay, phone, email, candidate_type, candidate_count);
        ExpInYear = expInYear;
        ProSkill = proSkill;
    }

    public int getExpInYear() {
        return ExpInYear;
    }

    public void setExpInYear(int expInYear) {
        ExpInYear = expInYear;
    }

    public String getProSkill() {
        return ProSkill;
    }

    public void setProSkill(String proSkill) {
        ProSkill = proSkill;
    }

    @Override
    public void ShowInfo() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return super.toString() + " ||Experience{" +
                "ExpInYear=" + ExpInYear +
                ", ProSkill='" + ProSkill + '\'' +
                '}';
    }
}
