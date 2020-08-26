package com.example.studentroomdatabase.model;
import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.studentroomdatabase.utils.Repository;
import java.util.List;

public class ViewModel extends AndroidViewModel {

    private LiveData<List<Student>> allStudents;
    private Repository repository;

    public ViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
        allStudents = repository.getAllStudents();
    }

    public LiveData<List<Student>> getAllStudents() {
        return allStudents;
    }

    public void insert(Student student) {
        repository.insert(student);
    }

    public void update(Student student) {
        repository.update(student);
    }

    public void delete(int id) {
        repository.delete(id);
    }
}
