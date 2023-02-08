package assigment_day2_day10.bean;

import java.time.LocalDate;

public abstract class Candidate {
    private int CandidateID;
    private String FullName;
    private LocalDate BirthDay;
    private String Phone;
    private String Email;
    private int Candidate_type;
    private int Candidate_count;

    public Candidate() {
    }

    public Candidate(String fullName, LocalDate birthDay, String phone, String email, int candidate_type, int candidate_count) {
        FullName = fullName;
        BirthDay = birthDay;
        Phone = phone;
        Email = email;
        Candidate_type = candidate_type;
        Candidate_count = candidate_count;
    }

    public int getCandidateID() {
        return CandidateID;
    }

    public void setCandidateID(int candidateID) {
        CandidateID = candidateID;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public LocalDate getBirthDay() {
        return BirthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        BirthDay = birthDay;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getCandidate_type() {
        return Candidate_type;
    }

    public void setCandidate_type(int candidate_type) {
        Candidate_type = candidate_type;
    }

    public int getCandidate_count() {
        return Candidate_count;
    }

    public void setCandidate_count(int candidate_count) {
        Candidate_count = candidate_count;
    }

    //    public void insertCandidate(Scanner sc){
//        System.out.println("Nhap CandidateID:");
//        this.CandidateID = sc.nextLine();
//        System.out.println("Nhap FullName:");
//        this.FullName = sc.nextLine();
//        System.out.println("Nhap BirthDay:");
//        String dateAsString = sc.nextLine();
//        try {
//            this.BirthDay = new SimpleDateFormat("yyyy/MM/dd").parse(dateAsString);
//        } catch (ParseException e) {
//            throw new RuntimeException(e);
//        }
//
//        System.out.println("Nhap Phone:");
//        this.Phone = sc.nextLine();
//        System.out.println("Nhap Email:");
//        this.Email = sc.nextLine();
//        System.out.println("Nhap Candidate_type:");
//        this.Candidate_type = sc.nextInt();
//    }
    public abstract void ShowInfo();

//    public int compare(Candidate a, Candidate b) {
//        if (a.Candidate_type != b.Candidate_type) {
//            return a.Candidate_type - b.Candidate_type;
//        } else {
//            return a.BirthDay.compareTo(b.BirthDay);
//        }
//    }

    @Override
    public String toString() {
        return "Candidate{" +
                "CandidateID='" + CandidateID + '\'' +
                ", FullName='" + FullName + '\'' +
                ", BirthDay=" + BirthDay +
                ", Phone='" + Phone + '\'' +
                ", Email='" + Email + '\'' +
                ", Candidate_type=" + Candidate_type +
                ", Candidate_count=" + Candidate_count +
                '}';
    }
}
