package ca.gbc.personalrestaurantguide;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import java.util.List;

public class RestaurantListFragment extends Fragment {

    private RestaurantViewModel restaurantViewModel;
    private RecyclerView recyclerView;
    private RestaurantListAdapter adapter;
    private Button addRestaurantButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_restaurant_list, container, false);

        // Set up RecyclerView
        recyclerView = view.findViewById(R.id.restaurantRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new RestaurantListAdapter();
        recyclerView.setAdapter(adapter);

        // Set up ViewModel and observe data
        restaurantViewModel = new ViewModelProvider(this).get(RestaurantViewModel.class);
        restaurantViewModel.getAllRestaurants().observe(getViewLifecycleOwner(), new Observer<List<Restaurant>>() {
            @Override
            public void onChanged(List<Restaurant> restaurants) {
                // Update the RecyclerView with the list of restaurants
                adapter.setRestaurants(restaurants);
            }
        });

        // Handle item clicks to navigate to details
        adapter.setOnItemClickListener(new RestaurantListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Restaurant restaurant) {
                // Navigate to RestaurantDetailsFragment with selected restaurant details
                // Add navigation logic here if using Navigation Component
            }
        });

        // Set up Add Restaurant button
        addRestaurantButton = view.findViewById(R.id.addRestaurantButton);
        addRestaurantButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to AddEditRestaurantFragment to add a new restaurant
                // Add navigation logic here if using Navigation Component
            }
        });

        return view;
    }
}
