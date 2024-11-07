package ca.gbc.personalrestaurantguide;

import android.app.Application;
import androidx.lifecycle.LiveData;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RestaurantRepository {
    private RestaurantDao restaurantDao;
    private LiveData<List<Restaurant>> allRestaurants;
    private ExecutorService executorService;

    public RestaurantRepository(Application application) {
        RestaurantDatabase database = RestaurantDatabase.getInstance(application);
        restaurantDao = database.restaurantDao();
        allRestaurants = restaurantDao.getAllRestaurants();
        executorService = Executors.newSingleThreadExecutor();
    }

    public LiveData<List<Restaurant>> getAllRestaurants() {
        return allRestaurants;
    }

    public void insert(Restaurant restaurant) {
        executorService.execute(() -> restaurantDao.insert(restaurant));
    }

    public void update(Restaurant restaurant) {
        executorService.execute(() -> restaurantDao.update(restaurant));
    }

    public void delete(Restaurant restaurant) {
        executorService.execute(() -> restaurantDao.delete(restaurant));
    }

    public List<Restaurant> search(String name, String tags) {
        return restaurantDao.search(name, tags);
    }
}
