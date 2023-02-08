package assigment_day2_day10.dao;

import assigment_day2_day10.bean.Candidate;
import assigment_day2_day10.bean.Certificates;
import assigment_day2_day10.bean.Experience;
import assigment_day2_day10.bean.Fresher;
import assigment_day2_day10.bean.Intern;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class CandidateDao {
  /**
   * Lay tat ca thong tin cua Candidates
   *
   * @return ds
   * @throws Exception
   */
  public ArrayList<Candidate> getCandidates() throws Exception {
    ArrayList<Candidate> ds = new ArrayList<>();
    //b1: ket noi
    Shared dc = new Shared();
    dc.KetNoi();
    //B2: Lay du lieu ve
    String sql = "Select * from Candidate";
    PreparedStatement cmd = dc.cn.prepareStatement(sql);
    ResultSet rs = cmd.executeQuery();
    //b3: Duyet qua cac du lieu lay ve de luu vao 1 mang
    while (rs.next()) {
      if (rs.getInt("Candidate_type") == 0) {
        Intern intern = new Intern();
        intern.setCandidateID(rs.getInt("CandidateID"));
        intern.setFullName(rs.getString("FullName"));
        intern.setBirthDay(rs.getDate("BirthDay").toLocalDate());
        intern.setPhone(rs.getString("Phone"));
        intern.setEmail(rs.getString("Email"));
        intern.setCandidate_type(rs.getInt("Candidate_type"));
        intern.setMajors(rs.getString("Majors"));
        intern.setSemester(rs.getInt("Semester"));
        intern.setUniversity_name(rs.getString("University_name"));
        ds.add(intern);
      } else if (rs.getInt("Candidate_type") == 1) {
        Fresher fresher = new Fresher();
        fresher.setCandidateID(rs.getInt("CandidateID"));
        fresher.setFullName(rs.getString("FullName"));
        fresher.setBirthDay(rs.getDate("BirthDay").toLocalDate());
        fresher.setPhone(rs.getString("Phone"));
        fresher.setEmail(rs.getString("Email"));
        fresher.setCandidate_type(rs.getInt("Candidate_type"));
        fresher.setGraduation_date(rs.getDate("Graduation_date").toLocalDate());
        fresher.setGraduation_rank(rs.getString("Graduation_rank"));
        fresher.setEducation(rs.getString("Education"));
        ds.add(fresher);
      } else if (rs.getInt("Candidate_type") == 2) {
        Experience experience = new Experience();
        experience.setCandidateID(rs.getInt("CandidateID"));
        experience.setFullName(rs.getString("FullName"));
        experience.setBirthDay(rs.getDate("BirthDay").toLocalDate());
        experience.setPhone(rs.getString("Phone"));
        experience.setEmail(rs.getString("Email"));
        experience.setCandidate_type(rs.getInt("Candidate_type"));
        experience.setExpInYear(rs.getInt("ExpInYear"));
        experience.setProSkill(rs.getString("ProSkill"));
        ds.add(experience);
      }
    }
    //Dong ket noi
    rs.close();
    dc.cn.close();
    return ds;
  }

  /**
   * Lay tat ca thong tin cua Certificates
   *
   * @return ds
   * @throws Exception
   */
  public ArrayList<Certificates> getCertificates() throws Exception {
    ArrayList<Certificates> ds = new ArrayList<>();

    //b1: ket noi
    Shared dc = new Shared();
    dc.KetNoi();
    //B2: Lay du lieu ve
    String sql = "Select * from Certificates";
    PreparedStatement cmd = dc.cn.prepareStatement(sql);
    ResultSet rs = cmd.executeQuery();
    while (rs.next()) {
      Certificates certificate = new Certificates();
      certificate.setCertificatedID(rs.getInt("CertificatedID"));
      certificate.setCertificateName(rs.getString("CertificateName"));
      certificate.setCertificateRank(rs.getString("CertificateRank"));
      certificate.setCertificatedDate(
          rs.getDate("CertificatedDate").toLocalDate());
      certificate.setCandidateID(rs.getInt("CandidateID"));
      ds.add(certificate);
    }
    dc.cn.close();
    rs.close();
    return ds;
  }

  /**
   * Insert thong tin Candidate
   *
   * @param intern
   * @param fresher
   * @param experience
   * @param candidate
   * @throws Exception
   */
  public void insertCandidate(Intern intern, Fresher fresher,
                              Experience experience, Candidate candidate)
      throws Exception {
    DateTimeFormatter sm =
        DateTimeFormatter.ISO_LOCAL_DATE.ofPattern("yyyy-MM-dd");
    Shared dc = new Shared();
    dc.KetNoi();
    String sql = "SELECT*FROM Candidate";
    PreparedStatement cmd = dc.cn.prepareStatement(sql,
        ResultSet.TYPE_FORWARD_ONLY,
        ResultSet.CONCUR_UPDATABLE);
    ResultSet rs = cmd.executeQuery();
    rs.moveToInsertRow();
    if (candidate.getCandidate_type() == 0) {
      rs.updateString("FullName", intern.getFullName());
      String birthday = intern.getBirthDay().format(sm);
      rs.updateString("BirthDay", birthday);
      rs.updateString("Phone", intern.getPhone());
      rs.updateString("Email", intern.getEmail());
      rs.updateInt("Candidate_type", intern.getCandidate_type());
      rs.updateString("Majors", intern.getMajors());
      rs.updateInt("Semester", intern.getSemester());
      rs.updateString("University_name", intern.getUniversity_name());
//            String graduation_date = Graduation_date.format(sm);
      rs.updateString("Graduation_date", null);
      rs.updateString("Graduation_rank", null);
      rs.updateString("Education", null);
      rs.updateInt("ExpInYear", 0);
      rs.updateString("ProSkill", null);

      rs.insertRow();
    } else if (candidate.getCandidate_type() == 1) {
      rs.updateString("FullName", fresher.getFullName());
      String birthday = fresher.getBirthDay().format(sm);
      rs.updateString("BirthDay", birthday);
      rs.updateString("Phone", fresher.getPhone());
      rs.updateString("Email", fresher.getEmail());
      rs.updateInt("Candidate_type", fresher.getCandidate_type());
      rs.updateString("Majors", null);
      rs.updateInt("Semester", 0);
      rs.updateString("University_name", null);
      String graduation_date = fresher.getGraduation_date().format(sm);
      rs.updateString("Graduation_date", graduation_date);
      rs.updateString("Graduation_rank", fresher.getGraduation_rank());
      rs.updateString("Education", fresher.getEducation());
      rs.updateInt("ExpInYear", 0);
      rs.updateString("ProSkill", null);
      rs.insertRow();
    } else {
      rs.updateString("FullName", experience.getFullName());
      String birthday = experience.getBirthDay().format(sm);
      rs.updateString("BirthDay", birthday);
      rs.updateString("Phone", experience.getPhone());
      rs.updateString("Email", experience.getEmail());
      rs.updateInt("Candidate_type", experience.getCandidate_type());
      rs.updateString("Majors", null);
      rs.updateInt("Semester", 0);
      rs.updateString("University_name", null);
//            String graduation_date = Graduation_date.format(sm);
      rs.updateString("Graduation_date", null);
      rs.updateString("Graduation_rank", null);
      rs.updateString("Education", null);
      rs.updateInt("ExpInYear", experience.getExpInYear());
      rs.updateString("ProSkill", experience.getProSkill());

      rs.insertRow();
    }
    rs.moveToCurrentRow();
    rs.close();
    dc.cn.close();
  }

  /**
   * Get Id cua Candidate vua insert
   *
   * @return
   * @throws Exception
   */
  public int getCandidateID() throws Exception {
    // b1: kết nối
    Shared dc = new Shared();
    dc.KetNoi();

    String sql = "SELECT TOP 1 Candidate.CandidateID\n" +
        "FROM Candidate \n" +
        "ORDER BY Candidate.CandidateID DESC";
    PreparedStatement cmd = dc.cn.prepareStatement(sql);
    ResultSet rs = cmd.executeQuery();
      if (rs.next() == false) {
          return 0;
      } else {
          int CandidateID1 = rs.getInt("CandidateID");
          rs.close();
          dc.cn.close();
          return CandidateID1;
      }
  }

  /**
   * Get thong tin Candidate bang CandidateID
   *
   * @param CandidateID
   * @return
   * @throws Exception
   */
  public Candidate getCandidateByID(int CandidateID) throws Exception {
    Shared dc = new Shared();
    dc.KetNoi();

    String sql = "SELECT*\n" +
        "FROM Candidate \n" +
        "WHERE Candidate.CandidateID = ?";
    PreparedStatement cmd = dc.cn.prepareStatement(sql);
    cmd.setInt(1, CandidateID);
    ResultSet rs = cmd.executeQuery();
    rs = null;
    while (rs.next()) {
      return new Candidate(rs.getString("FullName")
          , rs.getDate("BirthDay").toLocalDate()
          , rs.getString("Phone")
          , rs.getString("Email")
          , rs.getInt("Candidate_type"), 0
      ) {
        @Override
        public void ShowInfo() {
        }
      };
    }
    dc.cn.close();
    rs.close();
    return null;
  }

  /**
   * Insert thong tin Certificate
   *
   * @param certificates
   * @throws Exception
   */
  public void insertCertificates(Certificates certificates) throws Exception {
    Shared dc = new Shared();
    dc.KetNoi();
    DateTimeFormatter sm =
        DateTimeFormatter.ISO_LOCAL_DATE.ofPattern("yyyy-MM-dd");
    String sql = "SELECT *FROM Certificates";
    PreparedStatement cmd = dc.cn.prepareStatement(sql,
        ResultSet.TYPE_FORWARD_ONLY,
        ResultSet.CONCUR_UPDATABLE);
    ResultSet rs = cmd.executeQuery();
    rs.moveToInsertRow();
    rs.updateString(2, certificates.getCertificateName());
    rs.updateString(3, certificates.getCertificateRank());
    String certificateDate = certificates.getCertificatedDate().format(sm);
    rs.updateString(4, certificateDate);
    rs.updateInt(5, certificates.getCandidateID());
    rs.insertRow();
    rs.moveToCurrentRow();
  }

  /**
   * Cap nhat thong tin cua Candidate
   *
   * @param intern
   * @param fresher
   * @param experience
   * @param candidate
   * @param CandidateID
   * @throws Exception
   */
  public void updateCandidate(Intern intern, Fresher fresher,
                              Experience experience, Candidate candidate,
                              int CandidateID) throws Exception {
    DateTimeFormatter sm =
        DateTimeFormatter.ISO_LOCAL_DATE.ofPattern("yyyy-MM-dd");
    Shared dc = new Shared();
    dc.KetNoi();
    String sql = "SELECT*FROM Candidate";
    Statement cmd = dc.cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
        ResultSet.CONCUR_UPDATABLE);
    ResultSet rs = cmd.executeQuery(sql);

    while (rs.next()) {
      if (rs.getInt("CandidateID") == CandidateID) {
        if (candidate.getCandidate_type() == 0 && intern != null) {
          rs.updateString("FullName", intern.getFullName());
          String birthday = intern.getBirthDay().format(sm);
          rs.updateString("BirthDay", birthday);
          rs.updateString("Phone", intern.getPhone());
          rs.updateString("Email", intern.getEmail());
          rs.updateInt("Candidate_type", intern.getCandidate_type());
          rs.updateString("Majors", intern.getMajors());
          rs.updateInt("Semester", intern.getSemester());
          rs.updateString("University_name", intern.getUniversity_name());
//            String graduation_date = Graduation_date.format(sm);
          rs.updateString("Graduation_date", null);
          rs.updateString("Graduation_rank", null);
          rs.updateString("Education", null);
          rs.updateInt("ExpInYear", 0);
          rs.updateString("ProSkill", null);

          rs.updateRow();
        } else if (candidate.getCandidate_type() == 1 && fresher != null) {
          rs.updateString("FullName", fresher.getFullName());
          String birthday = fresher.getBirthDay().format(sm);
          rs.updateString("BirthDay", birthday);
          rs.updateString("Phone", fresher.getPhone());
          rs.updateString("Email", fresher.getEmail());
          rs.updateInt("Candidate_type", fresher.getCandidate_type());
          rs.updateString("Majors", null);
          rs.updateInt("Semester", 0);
          rs.updateString("University_name", null);
          String graduation_date = fresher.getGraduation_date().format(sm);
          rs.updateString("Graduation_date", graduation_date);
          rs.updateString("Graduation_rank", fresher.getGraduation_rank());
          rs.updateString("Education", fresher.getEducation());
          rs.updateInt("ExpInYear", 0);
          rs.updateString("ProSkill", null);
          rs.updateRow();
        } else {
          rs.updateString("FullName", experience.getFullName());
          String birthday = experience.getBirthDay().format(sm);
          rs.updateString("BirthDay", birthday);
          rs.updateString("Phone", experience.getPhone());
          rs.updateString("Email", experience.getEmail());
          rs.updateInt("Candidate_type", experience.getCandidate_type());
          rs.updateString("Majors", null);
          rs.updateInt("Semester", 0);
          rs.updateString("University_name", null);
//            String graduation_date = Graduation_date.format(sm);
          rs.updateString("Graduation_date", null);
          rs.updateString("Graduation_rank", null);
          rs.updateString("Education", null);
          rs.updateInt("ExpInYear", experience.getExpInYear());
          rs.updateString("ProSkill", experience.getProSkill());

          rs.updateRow();
        }
      }
    }
    rs.close();
    dc.cn.close();
  }

  /**
   * Get list Certificate cua Candidate co id = CandidateID
   *
   * @param CandidateID
   * @return
   * @throws Exception
   */
  public ArrayList<Certificates> getCertificatesByCandidateID(int CandidateID)
      throws Exception {
    ArrayList<Certificates> certificates = new ArrayList<>();
    Shared dc = new Shared();
    dc.KetNoi();
    DateTimeFormatter sm =
        DateTimeFormatter.ISO_LOCAL_DATE.ofPattern("yyyy-MM-dd");
    String sql = "SELECT *FROM Certificates WHERE Certificates.CandidateID = ?";
    PreparedStatement cmd = dc.cn.prepareStatement(sql);
    cmd.setInt(1, CandidateID);
    ResultSet rs = cmd.executeQuery();
    //b3: Duyet qua cac du lieu lay ve de luu vao 1 mang
    while (rs.next()) {
      int certificatedID = rs.getInt("certificatedID");
      String certificateName = rs.getString("CertificateName");
      String certificateRank = rs.getString("CertificateRank");
      LocalDate certificatedDate = rs.getDate("CertificatedDate").toLocalDate();
      int candidateID = rs.getInt("CandidateID");
      certificates.add(
          new Certificates(certificatedID, certificateName, certificateRank,
              certificatedDate, candidateID));
    }
    return certificates;
  }

  /**
   * Cap nhat thong tin Certificate
   *
   * @param certificates
   * @param CandidateID
   * @param CertificatedID
   * @throws Exception
   */
  public void updateCertificates(Certificates certificates, int CandidateID,
                                 int CertificatedID) throws Exception {
    Shared dc = new Shared();
    dc.KetNoi();
    DateTimeFormatter sm =
        DateTimeFormatter.ISO_LOCAL_DATE.ofPattern("yyyy-MM-dd");
    String sql = "SELECT *FROM Certificates";
    PreparedStatement cmd = dc.cn.prepareStatement(sql,
        ResultSet.TYPE_SCROLL_SENSITIVE,
        ResultSet.CONCUR_UPDATABLE);
    ResultSet rs = cmd.executeQuery();
    while (rs.next()) {
      if (rs.getInt("CertificatedID") == CertificatedID) {
        rs.updateString(2, certificates.getCertificateName());
        rs.updateString(3, certificates.getCertificateRank());
        String certificateDate = certificates.getCertificatedDate().format(sm);
        rs.updateString(4, certificateDate);
        rs.updateInt(5, certificates.getCandidateID());
        rs.updateRow();
      }

    }
    rs.close();
    dc.cn.close();
  }
}
