package dibenedetto.valentin.tpfinal.model;

import androidx.annotation.NonNull;

public class Country {
    private String name;
    private String region;
    private String alpha3Code;

    public Country(String countryName, String countryContinent, String countryFlag) {
        this.name = countryName;
        this.region = countryContinent;
        this.alpha3Code = countryFlag;
    }

    public String getCountryName() {
        return name;
    }

    public void setCountryName(String countryName) {
        this.name = countryName;
    }

    public String getCountryContinent() {
        return region;
    }

    public void setCountryContinent(String countryContinent) {
        this.region = countryContinent;
    }

    public String getCountryFlag() {
        return alpha3Code;
    }

    public void setCountryFlag(String countryFlag) {
        this.alpha3Code = countryFlag;
    }

    @NonNull
    @Override
    public String toString() {
        return "Country{" + "countryName: " + name
                + "countryContinent: " + region;
    }
}
