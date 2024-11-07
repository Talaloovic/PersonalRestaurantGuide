package ca.gbc.personalrestaurantguide;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import java.util.List;

public class RestaurantViewModel extends AndroidViewModel {

    private RestaurantRepository repository;
    private LiveData<List<Restaurant>> allRestaurants;

    public RestaurantViewModel(@NonNull Application application) {
        super(application);
        repository = new RestaurantRepository(application);
        allRestaurants = repository.getAllRestaurants();
    }

    // Expose LiveData of all restaurants so UI can observe it
    public LiveData<List<Restaurant>> getAllRestaurants() {
        return allRestaurants;
    }

    // Insert a new restaurant
    public void insert(Restaurant restaurant) {
        repository.insert(restaurant);
    }

    // Update an existing restaurant
    public void update(Restaurant restaurant) {
        repository.update(restaurant);
    }

    // Delete a restaurant
    public void delete(Restaurant restaurant) {
        repository.delete(restaurant);
    }

    // Search for restaurants by name or tags (not LiveData because it’s a one-time operation)
    public List<Restaurant> search(String name, String tags) {
        return repository.search(name, tags);
    }
}
