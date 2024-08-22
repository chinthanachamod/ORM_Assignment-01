package org.example;

import org.example.embed.FullName;
import org.example.config.FactoryConfiguration;
import org.example.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        FullName fullName = new FullName("Chinthana", "Chamod");
        FullName fullName1 = new FullName("Theekshana", "Nirmal");

        Student student = new Student("S001", fullName, "Panadura");

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(student);

        student.setName(fullName);
        session.update(student);

        session.delete(student);

        student = new Student("S001", fullName1, "Kandy");
        session.save(student);

        Student student1= session.get(Student.class, "S001");
        System.out.println(student1);


        transaction.commit();

        session.close();
    }
}