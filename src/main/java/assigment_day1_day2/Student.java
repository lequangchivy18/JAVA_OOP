package assigment_day1_day2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Câu 10
 */
public class Student implements Serializable {
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    public static final Pattern VALID_PHONE_REGEX = Pattern.compile("(84|0[3|5|7|8|9])+([0-9]{8})\\b");
    private String StdNo;
    private String StdName;
    private String StdPhone;
    private String StdEmail;
    private int GradePoint;

    public Student() {
    }

    public Student(String stdNo, String stdName, String stdPhone, String stdEmail, int gradePoint) {
        StdNo = stdNo;
        StdName = stdName;
        StdPhone = stdPhone;
        StdEmail = stdEmail;
        GradePoint = gradePoint;
    }


    public static void WriteObjectToFile(Object serObj) {

        FileOutputStream fout = null;
        ObjectOutputStream oos = null;
        try {

            if (!hasObject("std.csv")) {
                fout = new FileOutputStream("std.csv");
                oos = new ObjectOutputStream(fout);
            } else {
                fout = new FileOutputStream("std.csv", true);
                oos = new ObjectOutputStream(fout) {
                    @Override
                    protected void writeStreamHeader() throws IOException {
                        reset();
                    }
                };
            }

            oos.writeObject(serObj);
            System.out.println("Xong!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public static boolean hasObject(String filePath) {
        FileInputStream fi;
        boolean check = true;
        try {
            fi = new FileInputStream(filePath);
            ObjectInputStream inStream = new ObjectInputStream(fi);
            if (inStream.readObject() == null) {
                check = false;
            }
            inStream.close();
        } catch (FileNotFoundException e) {
            check = false;
        } catch (IOException e) {
            check = false;
        } catch (ClassNotFoundException e) {
            check = false;
            e.printStackTrace();
        }
        return check;
    }


    public static void ReadObjectFromFile(String filepath) {

        FileInputStream fis = null;
        ObjectInputStream inStream = null;
        try {
            fis = new FileInputStream(filepath);
            inStream = new ObjectInputStream(fis);
            Object s;
            int i = 0;
            while (true) {
                s = inStream.readObject();
                System.out.println(++i + ": " + s.toString());
            }
        } catch (ClassNotFoundException e) {
        } catch (IOException e) {
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (inStream != null) {
                try {
                    inStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }


    public static boolean validateEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }


    public static boolean validatePhone(String phoneNumber) {
        Matcher matcher = VALID_PHONE_REGEX.matcher(phoneNumber);
        return matcher.find();
    }

    public static void inError(String messageError) throws IOException {
        FileWriter writer = new FileWriter("error.txt", true);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);

        bufferedWriter.write(messageError);
        bufferedWriter.newLine();
        bufferedWriter.close();
    }

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String filePath = "std.csv";
        List<Student> students = new ArrayList<>();
        System.out.print("Nhap so sinh vien: ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            Student s = new Student();
            System.out.print("Sinh vien " + (i + 1) + ": ");
            System.out.print("\nstdNo: ");
            sc.nextLine();
            s.StdNo = sc.nextLine();
            System.out.print("StdName: ");
            s.StdName = sc.nextLine();
            System.out.print("StdPhone: ");
            s.StdPhone = sc.nextLine();
            System.out.print("StdEmail: ");
            s.StdEmail = sc.nextLine();
            System.out.print("GradePoint: ");
            s.GradePoint = sc.nextInt();
            students.add(s);
        }

        students.forEach(item -> {
            WriteObjectToFile(item);
        });
        ReadObjectFromFile(filePath);
        AtomicInteger i = new AtomicInteger(1);
        students.forEach(item -> {
            if (validateEmail(item.StdEmail) != true && validatePhone(item.StdPhone) != true) {
                try {
                    inError("Line StdNo" + item.StdNo + " Co loi sai dinh dang email, phone");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
//                System.out.println("Line StdNo" + item.StdNo + " Co loi sai dinh dang email, phone");
            } else if (validatePhone(item.StdPhone) != true) {
                try {
                    inError("Line StdNo" + item.StdNo + " Co loi sai dinh dang phone");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else if (validateEmail(item.StdEmail) != true) {
                try {
                    inError("Line StdNo" + item.StdNo + " Co loi sai dinh dang email");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            i.getAndIncrement();
        });
    }

    @Override
    public String toString() {
        return "Student{" +
                "StdNo='" + StdNo + '\'' +
                ", StdName='" + StdName + '\'' +
                ", StdPhone='" + StdPhone + '\'' +
                ", StdEmail='" + StdEmail + '\'' +
                ", GradePoint=" + GradePoint +
                '}';
    }


}

