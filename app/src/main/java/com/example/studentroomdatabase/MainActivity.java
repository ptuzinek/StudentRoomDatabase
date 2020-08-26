package com.example.studentroomdatabase;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.studentroomdatabase.model.Student;
import com.example.studentroomdatabase.model.ViewModel;
import com.example.studentroomdatabase.ui.PopupDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    PopupDialog popupDialog;
    ViewModel viewModel;
    List<Student> students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(ViewModel.class);

        popupDialog = new PopupDialog(this, viewModel);

        // JAK POLICZYC ELEMENTY W BAZIE DANYCH???
        byPassActivity();

        FloatingActionButton fab = findViewById(R.id.floatingActionButton_MAIN);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupDialog.createPopupDialog();
            }
        });
        /*
        add_student_button = findViewById(R.id.add_student_button);
        add_student_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupDialog.createPopupDialog(MainActivity.this);
            }
        });*/
    }

    private void byPassActivity() {

        //if(.getStudentsCount() > 0) {
            startActivity(new Intent(MainActivity.this, ListActivity.class));
            MainActivity.this.finish();
       // }
    }




}
