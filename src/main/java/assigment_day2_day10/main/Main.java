package assigment_day2_day10.main;

import assigment_day2_day10.bean.Candidate;
import assigment_day2_day10.bean.Certificates;
import assigment_day2_day10.bean.Experience;
import assigment_day2_day10.bean.Fresher;
import assigment_day2_day10.bean.Intern;
import assigment_day2_day10.bo.CandidateBo;
import assigment_day2_day10.exception.OtherException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class Main {
  /**
   * Nhap thong tin của Certificates
   */
  public static void nhapCertificate(CandidateBo candidateBo, Scanner sc)
      throws Exception {
    //insert Certificates
    System.out.println("Nhap so luong Certificate:");
    int n = sc.nextInt();
    sc.nextLine();
    for (int i = 0; i < n; i++) {
      System.out.println("Certificate " + (i + 1) + ": ");
      System.out.println("Nhap CertificateName");
      String CertificateName = sc.nextLine();
      System.out.println("Nhap CertificateRank");
      String CertificateRank = sc.nextLine();
      System.out.println("Nhap CertificatedDate");
      String dateAsString2 = sc.nextLine();
      LocalDate CertificatedDate = LocalDate.parse(dateAsString2,
          DateTimeFormatter.ofPattern("yyyy-MM-dd"));
      int canID = candidateBo.getCandidateID();
      Certificates certificates =
          new Certificates(CertificateName, CertificateRank, CertificatedDate,
              canID);
      candidateBo.insertCertificates(certificates);
    }
  }

  public static void updateCertificate(CandidateBo candidateBo, int CandidateID,
                                       Scanner sc) throws Exception {
    System.out.println("Nhap CertificatedID can cap nhat:");
    int CertificatedID = sc.nextInt();
    sc.nextLine();
    System.out.println("Nhap CertificateName:");
    String CertificateName = sc.nextLine();
    System.out.println("Nhap CertificateRank:");
    String CertificateRank = sc.nextLine();
    System.out.println("Nhap CertificatedDate:");
    String dateAsString2 = sc.nextLine();
    LocalDate CertificatedDate = LocalDate.parse(dateAsString2,
        DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    Certificates certificates =
        new Certificates(CertificateName, CertificateRank, CertificatedDate,
            CandidateID);
    candidateBo.updateCertificates(certificates, CandidateID, CertificatedID);

  }

  public static void main(String[] args) throws Exception {
    CandidateBo candidateBo = new CandidateBo();
    Scanner sc = new Scanner(System.in);
    while (true) {
      System.out.println("======================MENU====================");
      System.out.println("1.Nhap thong tin");
      System.out.println("2.Hien Thi Thong Tin");
      System.out.println("3.Sap Xep Ung Vien");
      System.out.println("4.Cap Nhat Thong Tin Ung Vien");
      System.out.println("5.Thoat");
      System.out.print("Ban chon chuc nang so: ");
      String choose = sc.nextLine();
      switch (choose) {
        case "1": {
          try {

            System.out.println("Nhap so luong candidate:");
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
              System.out.print("Nhap candidate " + (i + 1) + ":");
              sc.nextLine();
              System.out.print("\nNhap FullName:");
              String FullName = sc.nextLine();
              LocalDate BirthDay;
              System.out.println("Nhap BirthDay:");
              String dateAsString = sc.nextLine();
              BirthDay =
                  LocalDate.parse(candidateBo.checkBirthDay(dateAsString));
              System.out.println("Nhap Phone:");
              String Phone = sc.nextLine();
              System.out.println("Nhap Email:");
              String Email = sc.nextLine();
              candidateBo.checkEmail(Email);
              System.out.println("Nhap Candidate_type:");
              int Candidate_type = sc.nextInt();

              if (Candidate_type == 0) {
                sc.nextLine();
                System.out.print("Nhap Majors: ");
                String Majors = sc.nextLine();
                System.out.println("Nhap semester: ");
                int Semester = sc.nextInt();
                sc.nextLine();
                System.out.println("Nhap University_name: ");
                String University_name = sc.nextLine();
                Intern intern =
                    new Intern(FullName, BirthDay, Phone, Email, Candidate_type,
                        n, Majors, Semester, University_name);
                Candidate candidate =
                    new Intern(FullName, BirthDay, Phone, Email, Candidate_type,
                        n, Majors, Semester, University_name);
                candidateBo.insertCandidate(intern, null, null, candidate);
                nhapCertificate(candidateBo, sc);
              } else if (Candidate_type == 1) {
                sc.nextLine();
                System.out.println("Nhap Graduation_date:");
                String dateAsString1 = sc.nextLine();
                LocalDate Graduation_date = LocalDate.parse(dateAsString1,
                    DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                System.out.println("Nhap Graduation_rank:");
                String Graduation_rank = sc.nextLine();
                System.out.println("Nhap Education:");
                String Education = sc.nextLine();
                Fresher fresher = new Fresher(FullName, BirthDay, Phone, Email,
                    Candidate_type, n, Graduation_date, Graduation_rank,
                    Education);
                Candidate candidate =
                    new Fresher(FullName, BirthDay, Phone, Email,
                        Candidate_type, n, Graduation_date, Graduation_rank,
                        Education);
                candidateBo.insertCandidate(null, fresher, null, candidate);

                nhapCertificate(candidateBo, sc);
              } else if (Candidate_type == 2) {
                sc.nextLine();
                System.out.print("Nhap ExpInYear:");
                int ExpInYear = sc.nextInt();
                sc.nextLine();
                System.out.print("Nhap ProSkill:");
                String ProSkill = sc.nextLine();
                Experience experience =
                    new Experience(FullName, BirthDay, Phone, Email,
                        Candidate_type, n, ExpInYear, ProSkill);
                Candidate candidate =
                    new Experience(FullName, BirthDay, Phone, Email,
                        Candidate_type, n, ExpInYear, ProSkill);
                candidateBo.insertCandidate(null, null, experience, candidate);
                nhapCertificate(candidateBo, sc);
              }
            }
            System.out.println(n + " Candidate da duoc them vao CSDL");
          } catch (OtherException e) {
            e.printStackTrace();
          }
          break;
        }
        case "2": {
          ArrayList<Candidate> candidates = new ArrayList<>();
          ArrayList<Certificates> certificates = new ArrayList<>();
          certificates = candidateBo.getCertificates();
          candidates = candidateBo.getCandidates();
          System.out.println("Show thong tin:");
          System.out.println("Thong tin ung vien:");
          candidates.forEach(o -> {
            o.ShowInfo();
          });
          System.out.println("Thong tin cac chung chi cua ung vien:");
          certificates.forEach(o -> {
            System.out.println(o.toString());
          });
          break;
        }
        case "3": {
          ArrayList<Candidate> candidates = new ArrayList<>();
          candidates = candidateBo.getCandidates();
          Collections.sort(candidates, new Comparator<Candidate>() {
            @Override
            public int compare(Candidate o1, Candidate o2) {
              if (o1.getCandidate_type() != o2.getCandidate_type()) {
                return o1.getCandidate_count() - o2.getCandidate_type();
              } else {
                return o1.getBirthDay().compareTo(o2.getBirthDay());
              }
            }
          });
          System.out.println("Danh sach ung vien sau khi sap xep:");
          candidates.forEach(o -> {
            o.ShowInfo();
          });
          break;
        }
        case "4": {
          System.out.println("Nhap ID ung vien can cap nhat: ");
          int CandidateID = sc.nextInt();
          sc.nextLine();
          System.out.print("\nNhap FullName:");
          String FullName = sc.nextLine();
          LocalDate BirthDay;
          System.out.println("Nhap BirthDay:");
          String dateAsString = sc.nextLine();
          candidateBo.checkBirthDay(dateAsString);
          BirthDay = LocalDate.parse(candidateBo.checkBirthDay(dateAsString));
          System.out.println("Nhap Phone:");
          String Phone = sc.nextLine();
          System.out.println("Nhap Email:");
          String Email = sc.nextLine();
          candidateBo.checkEmail(Email);
          System.out.println("Nhap Candidate_type:");
          int Candidate_type = sc.nextInt();

          if (Candidate_type == 0) {
            sc.nextLine();
            System.out.print("Nhap Majors: ");
            String Majors = sc.nextLine();
            System.out.println("Nhap semester: ");
            int Semester = sc.nextInt();
            sc.nextLine();
            System.out.println("Nhap University_name: ");
            String University_name = sc.nextLine();
            Intern intern =
                new Intern(FullName, BirthDay, Phone, Email, Candidate_type, 0,
                    Majors, Semester, University_name);
            Candidate candidate = candidateBo.getCandidateByID(CandidateID);
            candidateBo.updateCandidate(intern, null, null, candidate,
                CandidateID);
            System.out.println("Danh sach Certificated cua ID: " + CandidateID);
            candidateBo.getCertificatesByCandidateID(CandidateID).forEach(o -> {
              System.out.println(o.toString());
            });
            updateCertificate(candidateBo, CandidateID, sc);

          } else if (Candidate_type == 1) {
            sc.nextLine();
            System.out.println("Nhap Graduation_date:");
            String dateAsString1 = sc.nextLine();
            LocalDate Graduation_date = LocalDate.parse(dateAsString1,
                DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            System.out.println("Nhap Graduation_rank:");
            String Graduation_rank = sc.nextLine();
            System.out.println("Nhap Education:");
            String Education = sc.nextLine();
            Fresher fresher =
                new Fresher(FullName, BirthDay, Phone, Email, Candidate_type, 0,
                    Graduation_date, Graduation_rank, Education);
            Candidate candidate = candidateBo.getCandidateByID(CandidateID);
            candidateBo.updateCandidate(null, fresher, null, candidate,
                CandidateID);
            System.out.println("Danh sach Certificated cua ID: " + CandidateID);
            candidateBo.getCertificatesByCandidateID(CandidateID).forEach(o -> {
              System.out.println(o.toString());
            });
            updateCertificate(candidateBo, CandidateID, sc);
          } else if (Candidate_type == 2) {
            sc.nextLine();
            System.out.print("Nhap ExpInYear:");
            int ExpInYear = sc.nextInt();
            sc.nextLine();
            System.out.print("Nhap ProSkill:");
            String ProSkill = sc.nextLine();
            Experience experience =
                new Experience(FullName, BirthDay, Phone, Email, Candidate_type,
                    0, ExpInYear, ProSkill);
            Candidate candidate = candidateBo.getCandidateByID(CandidateID);
            candidateBo.updateCandidate(null, null, experience, candidate,
                CandidateID);
            System.out.println("Danh sach Certificated cua ID: " + CandidateID);
            candidateBo.getCertificatesByCandidateID(CandidateID).forEach(o -> {
              System.out.println(o.toString());
            });
            updateCertificate(candidateBo, CandidateID, sc);
          }
          break;
        }
        default:
          return;
      }
    }
  }
}
//import java.io.*;
//        import java.util.Scanner;
//public class ReadCSVExample1
//{
//    public static void main(String[] args) throws Exception
//    {
////parsing a CSV file into Scanner class constructor
//        Scanner sc = new Scanner(new File("F:\\CSVDemo.csv"));
//        sc.useDelimiter(",");   //sets the delimiter pattern
//        while (sc.hasNext())  //returns a boolean value
//        {
//            System.out.print(sc.next());  //find and returns the next complete token from this scanner
//        }
//        sc.close();  //closes the scanner
//    }
//}
//import java.io.BufferedReader;
//        import java.io.FileReader;
//        import java.io.IOException;
//public class ReadCSVExample2
//{
//    public static void main(String[] args)
//    {
//        String line = "";
//        String splitBy = ",";
//        try
//        {
////parsing a CSV file into BufferedReader class constructor
//            BufferedReader br = new BufferedReader(new FileReader("CSVDemo.csv"));
//            while ((line = br.readLine()) != null)   //returns a Boolean value
//            {
//                String[] employee = line.split(splitBy);    // use comma as separator
//                System.out.println("Employee [First Name=" + employee[0] + ", Last Name=" + employee[1] + ", Designation=" + employee[2] + ", Contact=" + employee[3] + ", Salary= " + employee[4] + ", City= " + employee[5] +"]");
//            }
//        }
//        catch (IOException e)
//        {
//            e.printStackTrace();
//        }
//    }
//}
//import java.io.FileReader;
//        import java.io.IOException;
//        import com.opencsv.CSVReader;
//public class ReadCSVExample4
//{
//    public static void main(String[] args)
//    {
//        CSVReader reader = null;
//        try
//        {
//            reader = new CSVReader(new FileReader("F:\\CSVDemo.csv"));
//            String [] nextLine;
////read one line at a time
//            while ((nextLine = reader.readNext()) != null)
//            {
//                for(String token : nextLine)
//                {
//                    System.out.println(token);
//                }
//                System.out.print("\n");
//            }
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//    }
//}