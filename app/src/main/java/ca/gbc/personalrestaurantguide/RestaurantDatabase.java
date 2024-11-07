package ca.gbc.personalrestaurantguide;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Restaurant.class}, version = 1)
public abstract class RestaurantDatabase extends RoomDatabase {
    private static RestaurantDatabase instance;

    // Provides access to the DAO (Data Access Object)
    public abstract RestaurantDao restaurantDao();

    // Singleton pattern to ensure only one instance of the database exists
    public static synchronized RestaurantDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            RestaurantDatabase.class, "restaurant_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
