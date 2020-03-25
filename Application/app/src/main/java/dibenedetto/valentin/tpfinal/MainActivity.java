package dibenedetto.valentin.tpfinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import dibenedetto.valentin.tpfinal.adapter.CountryAdapter;
import dibenedetto.valentin.tpfinal.adapter.MyService;
import dibenedetto.valentin.tpfinal.model.Country;
import dibenedetto.valentin.tpfinal.model.CountryRepository;
import dibenedetto.valentin.tpfinal.model.OnCountryClickListener;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private String API_BASE_URL = "https://restcountries.eu/";
    //private CountryRepository countryRepository = new CountryRepository();
    private ArrayList<Country> countries = new ArrayList<>();
    private int cpt;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        TextView textView = findViewById(R.id.text);

        /** on ajoute la référence du recyclerView **/
        RecyclerView recyclerView = findViewById(R.id.recycler);

        /** On crée un layout **/
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        /** On crée l'adapter **/
        CountryAdapter adapter = new CountryAdapter();
        recyclerView.setAdapter(adapter);

        callWithRetrofit();

        if (countries.isEmpty()) {
            Toast.makeText(MainActivity.this, "C'est vide", Toast.LENGTH_LONG).show();
        }
        
        adapter.setCountryList(countries);

        adapter.setOnCountryClickListener(new OnCountryClickListener() {
            @Override
            public void onFlagClicked(Country country) {
            }

            @Override
            public void onNameRegionClicked(Country country) {
            }
        });
    }

    private void callWithRetrofit(){
        /**On créé le retrofit **/
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        /** On initialise le service **/
        MyService service = retrofit.create(MyService.class);

        /** On fait appel à la méthode getCountriesFromFlag() pour récupérer les drapeaux des pays **/
        Call<List<Country>> listCountriesFromFLag = service.getCountriesFromFlag();
        listCountriesFromFLag.enqueue(new Callback<List<Country>>() {
            @Override
            public void onResponse(Call<List<Country>> call, Response<List<Country>>
                    response) {
                countries.addAll(response.body());
            }
            @Override
            public void onFailure(Call<List<Country>> call, Throwable t) {
            }
        });

        /** On fait appel à la méthode getCountriesFromName() pour récupérer les noms des pays **/
        Call<List<Country>> listCountriesFromName = service.getCountriesFromName();
        listCountriesFromName.enqueue(new Callback<List<Country>>() {
            @Override
            public void onResponse(Call<List<Country>> call, Response<List<Country>>
                    response) {

                countries.addAll(response.body());
                Log.d("NAME","on a retrouvé " + countries.size());
            }
            @Override
            public void onFailure(Call<List<Country>> call, Throwable t) {
                Log.e("FAIL","Error");
            }
        });

        /** On fait appel à la méthode getCountriesFromRegion() pour récupérer les continents des pays **/
        Call<List<Country>> listCountriesFromRegion = service.getCountriesFromRegion();
        listCountriesFromRegion.enqueue(new Callback<List<Country>>() {
            @Override
            public void onResponse(Call<List<Country>> call, Response<List<Country>>
                    response) {
                countries.addAll(response.body());
            }
            @Override
            public void onFailure(Call<List<Country>> call, Throwable t) {
            }
        });


    }

}
