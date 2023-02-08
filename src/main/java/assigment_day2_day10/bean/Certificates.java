package assigment_day2_day10.bean;

import java.time.LocalDate;

public class Certificates {
    private int CertificatedID;
    private String CertificateName;
    private String CertificateRank;
    private LocalDate CertificatedDate;
    private int CandidateID;

    public Certificates() {

    }

    public Certificates(String certificateName, String certificateRank, LocalDate certificatedDate, int candidateID) {
        CertificateName = certificateName;
        CertificateRank = certificateRank;
        CertificatedDate = certificatedDate;
        CandidateID = candidateID;
    }

    public Certificates(int certificatedID, String certificateName, String certificateRank, LocalDate certificatedDate, int candidateID) {
        CertificatedID = certificatedID;
        CertificateName = certificateName;
        CertificateRank = certificateRank;
        CertificatedDate = certificatedDate;
        CandidateID = candidateID;
    }

    public int getCertificatedID() {
        return CertificatedID;
    }

    public void setCertificatedID(int certificatedID) {
        CertificatedID = certificatedID;
    }

    public String getCertificateName() {
        return CertificateName;
    }

    public void setCertificateName(String certificateName) {
        CertificateName = certificateName;
    }

    public String getCertificateRank() {
        return CertificateRank;
    }

    public void setCertificateRank(String certificateRank) {
        CertificateRank = certificateRank;
    }

    public LocalDate getCertificatedDate() {
        return CertificatedDate;
    }

    public void setCertificatedDate(LocalDate certificatedDate) {
        CertificatedDate = certificatedDate;
    }

    public int getCandidateID() {
        return CandidateID;
    }

    public void setCandidateID(int candidateID) {
        CandidateID = candidateID;
    }

    @Override
    public String toString() {
        return "Certificates{" +
                "CertificatedID=" + CertificatedID +
                ", CertificateName='" + CertificateName + '\'' +
                ", CertificateRank='" + CertificateRank + '\'' +
                ", CertificatedDate=" + CertificatedDate +
                ", CandidateID=" + CandidateID +
                '}';
    }
}
