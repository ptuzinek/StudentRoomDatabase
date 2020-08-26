package com.example.studentroomdatabase.data;
import androidx.lifecycle.LiveData;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.example.studentroomdatabase.model.Student;
import java.util.List;

@androidx.room.Dao
public interface Dao {

    @Insert
    void insert(Student student);

    @Query("DELETE FROM student_table WHERE studentId = :id")
    void deleteStudent(int id);

    @Update()
    void updateStudent(Student student);

    @Query("SELECT * FROM student_table")
    LiveData<List<Student>> getAllStudents();
}
