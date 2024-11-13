package ca.gbc.personalrestaurantguide;

public class Restaurant {

    private String name;
    private String address;
    private String phone;
    private String description;
    private String tags;
    private float rating;
    private double latitude;
    private double longitude;

    // Constructor with all fields
    public Restaurant(String name, String address, String phone, String description, String tags, float rating, double latitude, double longitude) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.description = description;
        this.tags = tags;
        this.rating = rating;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // Constructor with default latitude and longitude (can be 0 if not available)
    public Restaurant(String name, String address, String phone, String description, String tags, float rating) {
        this(name, address, phone, description, tags, rating, 0.0, 0.0);  // Default latitude and longitude
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
