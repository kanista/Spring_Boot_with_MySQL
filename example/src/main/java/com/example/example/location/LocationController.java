package com.example.example.location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class LocationController {
    @Autowired
    private LocationService locationservice;

    @RequestMapping(value = "/locations",method = RequestMethod.GET)
    public List<Location> getAllLocations(){
        return locationservice.getAllLocations();
    }
    @RequestMapping(value = "/locations/{id}",method = RequestMethod.GET)
    public Optional<Location> getLocation(@PathVariable Long id){
        return locationservice.getLocation(id);
    }
    @RequestMapping(value = "/locations",method = RequestMethod.POST)
    public void addLocation(@RequestBody Location location){
        locationservice.addLocation(location);
    }
    @RequestMapping(value = "/locations/{id}",method = RequestMethod.PUT)
    public void updateLocation(@PathVariable Long id, @RequestBody Location location){
        locationservice.updateLocation(id,location);
    }
    @RequestMapping(value = "/locations/{id}",method = RequestMethod.DELETE)
    public void deleteLocation(@PathVariable Long id){
        locationservice.deleteLocation(id);
    }

}
