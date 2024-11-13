package ca.gbc.personalrestaurantguide;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RestaurantListFragment extends Fragment {

    private RestaurantViewModel restaurantViewModel;
    private RecyclerView recyclerView;
    private RestaurantListAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_restaurant_list, container, false);

        // Initialize RecyclerView
        recyclerView = rootView.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Initialize adapter and pass the item click listener
        adapter = new RestaurantListAdapter(new RestaurantListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Restaurant restaurant) {
                // Create a bundle to pass the data to RestaurantDetailsFragment
                Bundle bundle = new Bundle();
                bundle.putString("restaurantName", restaurant.getName());
                bundle.putString("restaurantAddress", restaurant.getAddress());
                bundle.putString("restaurantPhone", restaurant.getPhone());
                bundle.putString("restaurantDescription", restaurant.getDescription());
                bundle.putDouble("restaurantLatitude", restaurant.getLatitude());
                bundle.putDouble("restaurantLongitude", restaurant.getLongitude());

                // Use NavController to navigate to RestaurantDetailsFragment
                Navigation.findNavController(rootView).navigate(R.id.action_restaurantListFragment_to_restaurantDetailsFragment, bundle);
            }
        });

        // Set the adapter to the RecyclerView
        recyclerView.setAdapter(adapter);

        // Initialize ViewModel
        restaurantViewModel = new ViewModelProvider(this).get(RestaurantViewModel.class);

        // Observe the data in the ViewModel and update the RecyclerView when the data changes
        restaurantViewModel.getAllRestaurants().observe(getViewLifecycleOwner(), new Observer<List<Restaurant>>() {
            @Override
            public void onChanged(List<Restaurant> restaurants) {
                // Update the RecyclerView with the new data
                adapter.setRestaurants(restaurants);
            }
        });

        return rootView;
    }
}
