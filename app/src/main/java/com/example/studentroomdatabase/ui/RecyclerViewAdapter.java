package com.example.studentroomdatabase.ui;
import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.example.studentroomdatabase.R;
import com.example.studentroomdatabase.model.Student;
import com.example.studentroomdatabase.model.ViewModel;
import com.google.android.material.snackbar.Snackbar;

import java.text.MessageFormat;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<Student> studentList;
    private LayoutInflater inflater;
    private Context context;
    AlertDialog dialog;

    public RecyclerViewAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_row, parent, false);
        return new ViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Student student = studentList.get(position);

        holder.studentName.setText(MessageFormat.format("NAME:  {0} ", student.getStudentName()));
        holder.studentId.setText(MessageFormat.format("ID:  {0} ", String.valueOf(student.getStudentId())));
        holder.studentFaculty.setText(MessageFormat.format("FACULTY:  {0} ", student.getStudentFaculty()));
        holder.studentYear.setText(MessageFormat.format("YEAR:  {0} ", String.valueOf(student.getStudentYear())));
        holder.studentCourses.setText(MessageFormat.format("COURSES:  {0} ", student.getStudentCourses()));
    }

    @Override
    public int getItemCount() {
        if(studentList != null) return studentList.size();
        else return 0;
    }

    public void setStudents(List<Student> students) {
        studentList = students;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView studentName;
        public TextView studentId;
        public TextView studentFaculty;
        public TextView studentYear;
        public TextView studentCourses;
        private ViewModel viewModel;

        public ViewHolder(@NonNull View itemView, Context ctx) {
            super(itemView);
            context = ctx;

            Button editButton;
            Button deleteButton;

            studentName = itemView.findViewById(R.id.student_name_row);
            studentId = itemView.findViewById(R.id.student_id_row);
            studentFaculty = itemView.findViewById(R.id.student_faculty_row);
            studentYear = itemView.findViewById(R.id.student_year_row);
            studentCourses = itemView.findViewById(R.id.student_courses_row);

            editButton = itemView.findViewById(R.id.edit_button);
            deleteButton = itemView.findViewById(R.id.delete_button);

            editButton.setOnClickListener(this);
            deleteButton.setOnClickListener(this);

        }


        @Override
        public void onClick(View view) {

            Student student = studentList.get(getAdapterPosition());

            switch(view.getId()) {
                case R.id.edit_button:
                    editButton(student, view);
                    break;
                case R.id.delete_button:
                    deleteButton(student.getStudentId());
                    break;
            }
        }

        private void deleteButton(final int id) {


            AlertDialog.Builder builder;
            Button yesButton;
            Button noButton;
            View view = inflater.inflate(R.layout.confirmation, null);
            viewModel = new ViewModelProvider((ViewModelStoreOwner) context).get(ViewModel.class);

            builder = new AlertDialog.Builder(context);

            yesButton = view.findViewById(R.id.yes_button);
            noButton = view.findViewById(R.id.no_button);

            yesButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    viewModel.delete(id);
                    studentList.remove(getAdapterPosition());
                    notifyItemRemoved(getAdapterPosition());
                    dialog.dismiss();
                }
            });

            noButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });


            builder.setView(view);
            dialog = builder.create();
            dialog.show();

        }

        private void editButton(Student student, View view) {
            PopupDialog popupDialog = new PopupDialog(context, student, RecyclerViewAdapter.this);
            popupDialog.createPopupDialog();
            notifyDataSetChanged();
            Snackbar.make(view, "Student Updated", Snackbar.LENGTH_SHORT).show();
        }
    }
}
