package ca.gbc.personalrestaurantguide;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface RestaurantDao {
    @Insert
    void insert(Restaurant restaurant);

    @Update
    void update(Restaurant restaurant);

    @Delete
    void delete(Restaurant restaurant);

    @Query("SELECT * FROM restaurants WHERE name LIKE :name OR tags LIKE :tags")
    List<Restaurant> search(String name, String tags);

    @Query("SELECT * FROM restaurants")
    LiveData<List<Restaurant>> getAllRestaurants();
}
