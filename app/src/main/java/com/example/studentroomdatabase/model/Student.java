package com.example.studentroomdatabase.model;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "student_table")
public class Student {

    @PrimaryKey(autoGenerate = true)
    private int studentId;

    @ColumnInfo(name = "name")
    private String studentName;

    @ColumnInfo(name = "faculty")
    private String studentFaculty;

    @ColumnInfo(name = "year")
    private int studentYear;

    @ColumnInfo(name = "courses")
    private String studentCourses;

    @ColumnInfo(name = "add_date")
    private String dateStudentAdded;

    public Student() {
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentFaculty() {
        return studentFaculty;
    }

    public void setStudentFaculty(String studentFaculty) {
        this.studentFaculty = studentFaculty;
    }

    public int getStudentYear() {
        return studentYear;
    }

    public void setStudentYear(int studentYear) {
        this.studentYear = studentYear;
    }

    public String getStudentCourses() {
        return studentCourses;
    }

    public void setStudentCourses(String studentCourses) {
        this.studentCourses = studentCourses;
    }

    public String getDateStudentAdded() {
        return dateStudentAdded;
    }

    public void setDateStudentAdded(String dateStudentAdded) {
        this.dateStudentAdded = dateStudentAdded;
    }
}