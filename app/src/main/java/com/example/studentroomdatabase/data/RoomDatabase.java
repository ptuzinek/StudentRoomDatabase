package com.example.studentroomdatabase.data;
import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import com.example.studentroomdatabase.model.Student;

@Database(entities = {Student.class}, version = 2)
public abstract class RoomDatabase extends androidx.room.RoomDatabase {

    private static volatile RoomDatabase INSTANCE;
    public abstract Dao dao();

    public static RoomDatabase getDatabase(final Context context){
        if(INSTANCE == null)  {
            synchronized (RoomDatabase.class){
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            RoomDatabase.class, "student_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
