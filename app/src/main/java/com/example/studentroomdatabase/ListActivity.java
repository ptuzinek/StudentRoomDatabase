package com.example.studentroomdatabase;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.studentroomdatabase.model.Student;
import com.example.studentroomdatabase.model.ViewModel;
import com.example.studentroomdatabase.ui.PopupDialog;
import com.example.studentroomdatabase.ui.RecyclerViewAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class ListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;
    FloatingActionButton fab;
    PopupDialog popupDialog;
    ViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        viewModel = new ViewModelProvider(this).get(ViewModel.class);

        fab = findViewById(R.id.floatingActionButton_LIST);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerViewAdapter = new RecyclerViewAdapter(ListActivity.this);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(ListActivity.this));

        viewModel.getAllStudents().observe(this, new Observer<List<Student>>() {
            @Override
            public void onChanged(List<Student> students) {
                recyclerViewAdapter.setStudents(students);
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupDialog = new PopupDialog(ListActivity.this, viewModel);
                popupDialog.createPopupDialog();
            }
        });




    }
}
