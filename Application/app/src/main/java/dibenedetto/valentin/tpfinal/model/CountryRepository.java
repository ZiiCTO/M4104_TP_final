package dibenedetto.valentin.tpfinal.model;

import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

public class CountryRepository {
    private List<Country> countryList;

    public CountryRepository() {
        this.countryList = new ArrayList<>();
    }

    public void setCountryList(List<Country> listC){
        countryList = listC;
    }

    public List<Country> getCountryList() {
        return countryList;
    }

}
