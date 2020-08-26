package com.example.studentroomdatabase.utils;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.studentroomdatabase.data.Dao;
import com.example.studentroomdatabase.data.RoomDatabase;
import com.example.studentroomdatabase.model.Student;

import java.util.List;

public class Repository {

    private LiveData<List<Student>> allStudents;
    private Dao dao;

    public Repository(Application application) {
        RoomDatabase db = RoomDatabase.getDatabase(application);
        dao = db.dao();
        allStudents = dao.getAllStudents();
    }

    public LiveData<List<Student>> getAllStudents() {
        return allStudents;
    }

    public void insert(Student student) {
        new insertAsyncTask(dao).execute(student);
    }


    private class insertAsyncTask extends AsyncTask<Student, Void, Void> {
        private Dao asyncTaskDao;
        public insertAsyncTask(Dao dao) {
            asyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Student... params) {
            asyncTaskDao.insert(params[0]);
            return null;
        }
    }

    public void update(Student student) {
        new updateAsyncTask(dao).execute(student);
    }

    private class updateAsyncTask extends AsyncTask<Student, Void, Void> {
        private Dao asyncTaskDao;
        public updateAsyncTask(Dao dao) {
            asyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Student... params) {
            asyncTaskDao.updateStudent(params[0]);
            return null;
        }
    }


    public void delete(int id) {
        new deleteAsyncTask(dao).execute(id);
    }

    private class deleteAsyncTask extends AsyncTask<Integer, Void, Void> {
        private Dao asyncTaskDao;
        public deleteAsyncTask(Dao dao) {
            asyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Integer... params) {
            asyncTaskDao.deleteStudent(params[0]);
            return null;
        }
    }


}
