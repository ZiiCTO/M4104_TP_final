package dibenedetto.valentin.tpfinal.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import dibenedetto.valentin.tpfinal.R;
import dibenedetto.valentin.tpfinal.model.Country;
import dibenedetto.valentin.tpfinal.model.OnCountryClickListener;

public class CountryViewHolder extends RecyclerView.ViewHolder {
    private Country country;
    private final ImageView countryFlag;
    private final TextView countryName;
    private final TextView countryContinent;


    public CountryViewHolder(@NonNull View itemView, final OnCountryClickListener onCountryClickListener) {
        super(itemView);

        countryFlag = itemView.findViewById(R.id.country_flag);
        countryName = itemView.findViewById(R.id.country_name);
        countryContinent = itemView.findViewById(R.id.country_continent);

        /** Event sur le drapeau **/
        countryFlag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCountryClickListener.onFlagClicked(country);
            }
        });

        /** Event sur le nom **/
        countryName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCountryClickListener.onNameRegionClicked(country);
            }
        });

        /** Event sur le continent **/
        countryContinent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCountryClickListener.onNameRegionClicked(country);
            }
        });

    }

    public void bind(Country c) {
        country = c;

        //countryFlag.setText(country.getCountryFlag());
        countryName.setText(c.getCountryName());
        countryContinent.setText(c.getCountryContinent());
    }

    public static CountryViewHolder newInstance(ViewGroup parent, final OnCountryClickListener onCountryClickListener) {
        return new CountryViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.country_list_item, parent, false), onCountryClickListener);
    }
}
