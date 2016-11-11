package crud;

import entity.Country;

import java.util.List;

/**
 * Created by Андрей on 11.11.2016.
 */
public class CountryController {

    private List<Country> getAllCountries(){

        List<Country> cap = null;
        cap.add(new Country("Belarus","Беларусь", 112));

        return cap;
    }
}
