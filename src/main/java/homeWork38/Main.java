package homeWork38;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

    SaveAndReadDAO dao = new SaveAndReadDAO();
    Students students1 = new Students( 1, "John", 20, "j@j3.com");
    Students students2 = new Students( 2, "Iren", 34, "j@j2.com");
    Students students3 = new Students( 3, "Piknik", 16, "j@3j.com");
    Students students4 = new Students( 4, "Olga", 17, "j@44j.com");

    dao.saveStudents(students1);
    dao.saveStudents(students2);
    dao.saveStudents(students3);
    dao.saveStudents(students4);

    Students savedStudents = dao.getStudents(1);
    Students savedStudents1 = dao.getStudents(2);
    Students savedStudents2 = dao.getStudents(3);
    Students savedStudents3 = dao.getStudents(4);

    System.out.println(savedStudents.getName() + " " + savedStudents.getAge() + " " + savedStudents.getEmail());
    System.out.println(savedStudents1.getName() + " " + savedStudents1.getAge() + " " + savedStudents1.getEmail());
    System.out.println(savedStudents2.getName() + " " + savedStudents2.getAge() + " " + savedStudents2.getEmail());
    System.out.println(savedStudents3.getName() + " " + savedStudents3.getAge() + " " + savedStudents3.getEmail());

    }

}
