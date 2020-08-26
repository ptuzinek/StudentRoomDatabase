package com.example.studentroomdatabase.ui;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AlertDialog;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

import com.example.studentroomdatabase.ListActivity;
import com.example.studentroomdatabase.R;
import com.example.studentroomdatabase.model.Student;
import com.example.studentroomdatabase.model.ViewModel;
import com.google.android.material.snackbar.Snackbar;

public class PopupDialog implements View.OnClickListener {

    private AlertDialog.Builder builder;
    private AlertDialog dialog;
    private LayoutInflater inflater;
    private EditText studentName, studentFaculty, studentYear, studentID;
    private Button mathButton,histButton,physButton,engButton,econButton,progButton,saveButton;
    private int color1=0,color2=0,color3=0,color4=0,color5=0,color6=0;

    private Context context;
    private Student student;
    private RecyclerViewAdapter recyclerViewAdapter;
    private ViewModel viewModel;

    public PopupDialog(Context context) {
        this.context = context;
    }

    public PopupDialog(Context context, ViewModel viewModel) {
        this.context = context;
        this.viewModel = viewModel;
    }

    public PopupDialog(Context context, RecyclerViewAdapter recyclerViewAdapter) {
        this.context = context;
        this.student = student;

    }

    // EDIT BUTTON call
    public PopupDialog(Context context, Student student, RecyclerViewAdapter recyclerViewAdapter) {
        this.context = context;
        this.student = student;
        this.recyclerViewAdapter = recyclerViewAdapter;
        viewModel = new ViewModelProvider((ViewModelStoreOwner) context).get(ViewModel.class);
    }

    public void createPopupDialog() {

        builder = new AlertDialog.Builder(context);
        inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.popup, null);

        studentName = view.findViewById(R.id.name_popup);
        studentFaculty = view.findViewById(R.id.faculty_popup);
        studentYear = view.findViewById(R.id.year_popup);

        engButton = view.findViewById(R.id.eng_popup);
        mathButton = view.findViewById(R.id.math_popup);
        histButton = view.findViewById(R.id.hist_popup);
        physButton = view.findViewById(R.id.phys_popup);
        econButton = view.findViewById(R.id.economy_popup);
        progButton = view.findViewById(R.id.programming_popup);
        saveButton = view.findViewById(R.id.save_popup);

        if(student != null) {
            studentName.setText(student.getStudentName().toString());
            studentFaculty.setText(student.getStudentFaculty().toString());
            studentYear.setText(String.valueOf(student.getStudentYear()));

            // Pobrać String COURSES i pociąć go na słowa.
            // Dla każdego słowa sprawdzic czy zgadza sie z nazwa przedmiotu i wtedy zapisac color=1

            String courses = student.getStudentCourses().trim();
            courses = courses.replaceAll(", ", "");
            String[] courseList = courses.split(" ");

            for(String course : courseList) {
                if(course.equals("English")) {
                    color1 = 1;
                    engButton.setBackgroundColor(Color.BLUE);
                    engButton.setTextColor(Color.WHITE);
                }
                if(course.equals("Math")) {
                    color2 = 1;
                    mathButton.setBackgroundColor(Color.BLUE);
                    mathButton.setTextColor(Color.WHITE);
                }
                if(course.equals("History")) {
                    color3 = 1;
                    histButton.setBackgroundColor(Color.BLUE);
                    histButton.setTextColor(Color.WHITE);
                }
                if(course.equals("Physics")) {
                    physButton.setBackgroundColor(Color.BLUE);
                    physButton.setTextColor(Color.WHITE);
                    color4 = 1;
                }
                if(course.equals("Economy")) {
                    econButton.setBackgroundColor(Color.BLUE);
                    econButton.setTextColor(Color.WHITE);
                    color5 = 1;
                }
                if(course.equals("Programming")) {
                    progButton.setBackgroundColor(Color.BLUE);
                    progButton.setTextColor(Color.WHITE);
                    color6 = 1;
                }
            }
        }

        engButton.setOnClickListener(this);
        mathButton.setOnClickListener(this);
        histButton.setOnClickListener(this);
        physButton.setOnClickListener(this);
        econButton.setOnClickListener(this);
        progButton.setOnClickListener(this);
        saveButton.setOnClickListener(this);

        builder.setView(view);
        dialog = builder.create();
        dialog.show();
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.eng_popup:
                if(color1 == 0) {
                    engButton.setBackgroundColor(Color.BLUE);
                    engButton.setTextColor(Color.WHITE);
                    color1++;
                } else {
                    engButton.setBackgroundResource(android.R.drawable.btn_default);
                    engButton.setTextColor(Color.BLACK);
                    color1--;
                }
                break;
            case R.id.math_popup:
                if(color2 == 0) {
                    mathButton.setBackgroundColor(Color.BLUE);
                    mathButton.setTextColor(Color.WHITE);
                    color2++;
                } else {
                    mathButton.setBackgroundResource(android.R.drawable.btn_default);
                    mathButton.setTextColor(Color.BLACK);
                    color2--;
                }
                break;
            case R.id.hist_popup:
                if(color3 == 0) {
                    histButton.setBackgroundColor(Color.BLUE);
                    histButton.setTextColor(Color.WHITE);
                    color3++;
                } else {
                    histButton.setBackgroundResource(android.R.drawable.btn_default);
                    histButton.setTextColor(Color.BLACK);
                    color3--;
                }
                break;
            case R.id.phys_popup:
                if(color4 == 0) {
                    physButton.setBackgroundColor(Color.BLUE);
                    physButton.setTextColor(Color.WHITE);
                    color4++;
                } else {
                    physButton.setBackgroundResource(android.R.drawable.btn_default);
                    physButton.setTextColor(Color.BLACK);
                    color4--;
                }
                break;
            case R.id.economy_popup:
                if(color5 == 0) {
                    econButton.setBackgroundColor(Color.BLUE);
                    econButton.setTextColor(Color.WHITE);
                    color5++;
                } else {
                    econButton.setBackgroundResource(android.R.drawable.btn_default);
                    econButton.setTextColor(Color.BLACK);
                    color5--;
                }
                break;
            case R.id.programming_popup:
                if(color6 == 0) {
                    progButton.setBackgroundColor(Color.BLUE);
                    progButton.setTextColor(Color.WHITE);
                    color6++;
                } else {
                    progButton.setBackgroundResource(android.R.drawable.btn_default);
                    progButton.setTextColor(Color.BLACK);
                    color6--;
                }
                break;
            case R.id.save_popup:
                if(studentName.getText().toString().isEmpty()
                        || studentYear.getText().toString().isEmpty()
                        || studentFaculty.getText().toString().isEmpty()) {
                    Snackbar.make(view, "Empty fields not allowed", Snackbar.LENGTH_SHORT).show();
                } else if(!(color1 == 1 || color2 == 1 || color3 == 1 || color4 == 1 || color5 == 1 || color6 == 1)) {
                    Snackbar.make(view, "Choose courses", Snackbar.LENGTH_SHORT).show();
                } else {
                    if(student != null) {
                        student.setStudentName(studentName.getText().toString());
                        student.setStudentFaculty(studentFaculty.getText().toString());
                        student.setStudentYear(Integer.parseInt(studentYear.getText().toString()));

                        String Courses = "";
                        if(color1 == 1) Courses += "  " + engButton.getText().toString();
                        if(color1==1 && color2==1) Courses += ",  " + mathButton.getText().toString(); else if(color2==1) Courses += "  " + mathButton.getText().toString();
                        if((color1==1 || color2==1) && color3==1) Courses += ",  " + histButton.getText().toString(); else if(color3==1) Courses += "  " + histButton.getText().toString();
                        if((color1==1 || color2==1 || color3==1) && color4 == 1) Courses += ",  " + physButton.getText().toString(); else if(color4==1) Courses += "  " + physButton.getText().toString();
                        if((color1==1 || color2==1 || color3==1 || color4==1) && color5 == 1) Courses += ",  " + econButton.getText().toString(); else if(color5==1) Courses += "  " + econButton.getText().toString();
                        if((color1==1 || color2==1 || color3==1 || color4==1 || color5==1) && color6==1) Courses += ",  " + progButton.getText().toString(); else if(color6==1) Courses += "  " + progButton.getText().toString();

                        student.setStudentCourses(Courses.trim());

                        viewModel.update(student);

                        recyclerViewAdapter.notifyDataSetChanged();
                        dialog.dismiss();

                    } else {
                        saveStudent(view);
                    }
                }
                break;
        }
    }

    private void saveStudent(View view) {

        Student student = new Student();

        student.setStudentName(studentName.getText().toString().trim());
        student.setStudentFaculty(studentFaculty.getText().toString().trim());
        student.setStudentYear(Integer.parseInt(studentYear.getText().toString().trim()));

        String Courses = "";
        if(color1 == 1) Courses += "  " + engButton.getText().toString();
        if(color1==1 && color2==1) Courses += ",  " + mathButton.getText().toString(); else if(color2==1) Courses += "  " + mathButton.getText().toString();
        if((color1==1 || color2==1) && color3==1) Courses += ",  " + histButton.getText().toString(); else if(color3==1) Courses += "  " + histButton.getText().toString();
        if((color1==1 || color2==1 || color3==1) && color4 == 1) Courses += ",  " + physButton.getText().toString(); else if(color4==1) Courses += "  " + physButton.getText().toString();
        if((color1==1 || color2==1 || color3==1 || color4==1) && color5 == 1) Courses += ",  " + econButton.getText().toString(); else if(color5==1) Courses += "  " + econButton.getText().toString();
        if((color1==1 || color2==1 || color3==1 || color4==1 || color5==1) && color6==1) Courses += ",  " + progButton.getText().toString(); else if(color6==1) Courses += "  " + progButton.getText().toString();

        student.setStudentCourses(Courses.trim());

        viewModel.insert(student);

        Snackbar.make(view, "Student Saved to the Database", Snackbar.LENGTH_SHORT).show();


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                dialog.dismiss();
                context.startActivity(new Intent(context, ListActivity.class));
                ((Activity)context).finish();
            }
        },1100);
    }


    public EditText getStudentName() {
        return studentName;
    }

    public void setStudentName(EditText studentName) {
        this.studentName = studentName;
    }

    public EditText getStudentFaculty() {
        return studentFaculty;
    }

    public void setStudentFaculty(EditText studentFaculty) {
        this.studentFaculty = studentFaculty;
    }

    public EditText getStudentYear() {
        return studentYear;
    }

    public void setStudentYear(EditText studentYear) {
        this.studentYear = studentYear;
    }

    public EditText getStudentID() {
        return studentID;
    }

    public void setStudentID(EditText studentID) {
        this.studentID = studentID;
    }

    public Button getMathButton() {
        return mathButton;
    }

    public void setMathButton(Button mathButton) {
        this.mathButton = mathButton;
    }

    public Button getHistButton() {
        return histButton;
    }

    public void setHistButton(Button histButton) {
        this.histButton = histButton;
    }

    public Button getPhysButton() {
        return physButton;
    }

    public void setPhysButton(Button physButton) {
        this.physButton = physButton;
    }

    public Button getEngButton() {
        return engButton;
    }

    public void setEngButton(Button engButton) {
        this.engButton = engButton;
    }

    public Button getEconButton() {
        return econButton;
    }

    public void setEconButton(Button econButton) {
        this.econButton = econButton;
    }

    public Button getProgButton() {
        return progButton;
    }

    public void setProgButton(Button progButton) {
        this.progButton = progButton;
    }

    public Button getSaveButton() {
        return saveButton;
    }

    public void setSaveButton(Button saveButton) {
        this.saveButton = saveButton;
    }

    public int getColor1() {
        return color1;
    }

    public void setColor1(int color1) {
        this.color1 = color1;
    }

    public int getColor2() {
        return color2;
    }

    public void setColor2(int color2) {
        this.color2 = color2;
    }

    public int getColor3() {
        return color3;
    }

    public void setColor3(int color3) {
        this.color3 = color3;
    }

    public int getColor4() {
        return color4;
    }

    public void setColor4(int color4) {
        this.color4 = color4;
    }

    public int getColor5() {
        return color5;
    }

    public void setColor5(int color5) {
        this.color5 = color5;
    }

    public int getColor6() {
        return color6;
    }

    public void setColor6(int color6) {
        this.color6 = color6;
    }

}
