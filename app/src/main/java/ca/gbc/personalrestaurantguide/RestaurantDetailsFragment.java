package ca.gbc.personalrestaurantguide;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class RestaurantDetailsFragment extends Fragment {

    private TextView nameTextView;
    private TextView addressTextView;
    private TextView phoneTextView;
    private TextView descriptionTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_restaurant_details, container, false);

        // Find the TextViews to display restaurant details
        nameTextView = rootView.findViewById(R.id.restaurantNameTextView);
        addressTextView = rootView.findViewById(R.id.restaurantAddressTextView);
        phoneTextView = rootView.findViewById(R.id.restaurantPhoneTextView);
        descriptionTextView = rootView.findViewById(R.id.restaurantDescriptionTextView);

        // Get data from the arguments (Bundle)
        Bundle bundle = getArguments();
        if (bundle != null) {
            // Safely set text or use default values if the Bundle keys do not exist
            String name = bundle.getString("restaurantName", "No name provided");
            String address = bundle.getString("restaurantAddress", "No address provided");
            String phone = bundle.getString("restaurantPhone", "No phone number provided");
            String description = bundle.getString("restaurantDescription", "No description provided");

            // Set the data to the respective TextViews
            nameTextView.setText(name);
            addressTextView.setText(address);
            phoneTextView.setText(phone);
            descriptionTextView.setText(description);
        }

        return rootView;
    }
}
