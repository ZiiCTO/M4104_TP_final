package dibenedetto.valentin.tpfinal.adapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import dibenedetto.valentin.tpfinal.model.Country;


public interface MyService {
    @GET("data/afg.svg")
    Call<List<Country>> getCountriesFromFlag();

    @GET("rest/v2/all?fields=name")
    Call<List<Country>> getCountriesFromName();

    @GET("rest/v2/allall?fields=region")
    Call<List<Country>> getCountriesFromRegion();



}
