package com.example.application.views.helloworld;

import org.vaadin.elmot.flow.sensors.GeoLocation;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("GeoLocation Example")
@Route(value = "", layout = MainLayout.class)
public class HelloWorldView extends HorizontalLayout {

    public HelloWorldView() {
        // Display for showing location updates
        Span locationDisplay = new Span("Waiting for location...");

        // Setup GeoLocation component
        GeoLocation geoLocation = new GeoLocation();
        geoLocation.setWatch(true);
        geoLocation.setHighAccuracy(true);
        geoLocation.setTimeout(100000);
        geoLocation.setMaxAge(200000);
        
        // Handle successful location retrieval
        geoLocation.addValueChangeListener(e -> {
            locationDisplay.setText("Location: " + e.getValue());
        });
        
        // Handle location errors
        geoLocation.addErrorListener(e -> {
            locationDisplay.setText("Location: Error retrieving location");
        });

        // Add components to layout
        add(locationDisplay, geoLocation);

        // Optional: Styling
        setMargin(true);
        setSpacing(true);
    }
}
