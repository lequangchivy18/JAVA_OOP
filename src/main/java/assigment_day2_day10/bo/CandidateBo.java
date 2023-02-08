package assigment_day2_day10.bo;

import assigment_day2_day10.bean.Candidate;
import assigment_day2_day10.bean.Certificates;
import assigment_day2_day10.bean.Experience;
import assigment_day2_day10.bean.Fresher;
import assigment_day2_day10.bean.Intern;
import assigment_day2_day10.dao.CandidateDao;
import assigment_day2_day10.exception.BirthDayException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class CandidateBo {

  public static final String DATE_CHECK =
      "^\\d{4}-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])$";
  public static final String EMAIL_CHECK =
      "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
  CandidateDao candidateDao = new CandidateDao();

  /**
   * Check date
   *
   * @param date date
   * @return date
   * @throws BirthDayException if date false
   */
  public String checkBirthDay(String date) throws BirthDayException {
    if (!date.matches(DATE_CHECK)) {
      throw new BirthDayException();
    }
    LocalDate BirthDay =
        LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    if (BirthDay.getYear() < 1900) {
      throw new BirthDayException();
    } else {
      return date;
    }

  }

  /**
   * Check email
   *
   * @param mail gmail of entity
   * @throws BirthDayException if BirthDay false
   */
  public void checkEmail(String mail) throws BirthDayException {
  }

  /**
   * Get Candidates
   *
   * @return Arraylist<Candidate>
   */
  public ArrayList<Candidate> getCandidates() throws Exception {
    return candidateDao.getCandidates();
  }

  /**
   * Get Certificates
   *
   * @return aaaaaa
   */
  public ArrayList<Certificates> getCertificates() throws Exception {
    return candidateDao.getCertificates();
  }

  /**
   * Get CandidateID
   */
  public int getCandidateID() throws Exception {
    return candidateDao.getCandidateID();
  }

  /**
   * Insert Candidate
   *
   * @param intern  object
   * @param fresher object
   */
  public void insertCandidate(Intern intern, Fresher fresher,
                              Experience experience, Candidate candidate)
      throws Exception {
    candidateDao.insertCandidate(intern, fresher, experience, candidate);
  }

  /**
   * Insert Certificate
   */
  public void insertCertificates(Certificates certificates) throws Exception {
    candidateDao.insertCertificates(certificates);
  }

  /**
   * Lay thong tin cua Candidate bang CandidateID
   *
   * @param CandidateID candidate Id
   * @return Candidate object
   */
  public Candidate getCandidateByID(int CandidateID) throws Exception {
    return candidateDao.getCandidateByID(CandidateID);
  }

  /**
   * Update Candidate
   */
  public void updateCandidate(Intern intern, Fresher fresher,
                              Experience experience, Candidate candidate,
                              int CandidateID) throws Exception {
    candidateDao.updateCandidate(intern, fresher, experience, candidate,
        CandidateID);
  }

  /**
   * Get list Certificate by CandidateID
   */
  public ArrayList<Certificates> getCertificatesByCandidateID(int CandidateID)
      throws Exception {
    return candidateDao.getCertificatesByCandidateID(CandidateID);
  }

  /**
   * Update Certificate
   */
  public void updateCertificates(Certificates certificates, int CandidateID,
                                 int certificateID) throws Exception {
    candidateDao.updateCertificates(certificates, CandidateID, certificateID);
  }

}
