package ca.gbc.personalrestaurantguide;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

public class AddEditRestaurantFragment extends Fragment {

    private RestaurantViewModel restaurantViewModel;
    private EditText nameEditText, addressEditText, phoneEditText, descriptionEditText, tagsEditText;
    private RatingBar ratingBar;
    private Button saveButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_edit_restaurant, container, false);

        // Initialize views
        nameEditText = view.findViewById(R.id.restaurantNameEditText);
        addressEditText = view.findViewById(R.id.addressEditText);
        phoneEditText = view.findViewById(R.id.phoneEditText);
        descriptionEditText = view.findViewById(R.id.descriptionEditText);
        tagsEditText = view.findViewById(R.id.tagsEditText);
        ratingBar = view.findViewById(R.id.ratingBar);
        saveButton = view.findViewById(R.id.saveButton);

        // Set up ViewModel
        restaurantViewModel = new ViewModelProvider(this).get(RestaurantViewModel.class);

        // Save button logic
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveRestaurant();
            }
        });

        return view;
    }

    private void saveRestaurant() {
        // Get data from input fields
        String name = nameEditText.getText().toString();
        String address = addressEditText.getText().toString();
        String phone = phoneEditText.getText().toString();
        String description = descriptionEditText.getText().toString();
        String tags = tagsEditText.getText().toString();
        float rating = ratingBar.getRating();

        // Validate input
        if (name.trim().isEmpty() || address.trim().isEmpty()) {
            Toast.makeText(getActivity(), "Please insert a name and address", Toast.LENGTH_SHORT).show();
            return;
        }

        // Create a new Restaurant object
        Restaurant restaurant = new Restaurant(name, address, phone, description, tags, rating);

        // Insert restaurant using ViewModel
        restaurantViewModel.insert(restaurant);

        // Confirmation message
        Toast.makeText(getActivity(), "Restaurant saved", Toast.LENGTH_SHORT).show();

        // Navigate back to the list (or previous fragment)
        getActivity().onBackPressed();
    }
}
