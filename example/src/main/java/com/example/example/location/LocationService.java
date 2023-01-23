package com.example.example.location;
import com.example.example.student.Student;
import com.example.example.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class LocationService {
    @Autowired
    private LocationRepository locationrepository;

//    Location location1=new Location("l1", "Lagos");
//    Location location2=new Location("l2", "Asaba");
//    Location location3=new Location("l3", "Budapest");
//    List<Location> locations=Arrays.asList(location1,location2,location3);
//
//    Location str[] = { location1,location2,location3 };
//    List<Location> list = Arrays.asList(str);
//    List<Location> locations = new ArrayList<>(list);

    public List<Location> getAllLocations(){
        List locations= new ArrayList<>();
       locationrepository.findAll().forEach(locations::add);
        return locations;
    }
    public Optional<Location> getLocation(Long id) {

        return locationrepository.findById(id);
    }
    public void addLocation(Location location){

        locationrepository.save(location);
    }
    public void updateLocation(Long id, Location location) {
        Location loc=locationrepository.findById(id).orElseThrow(()->new IllegalStateException("Location id not found"));
        loc.setName(location.getName());
        locationrepository.save(loc);
    }
    public void deleteLocation(Long id) {

        locationrepository.deleteById(id);
    }
}
