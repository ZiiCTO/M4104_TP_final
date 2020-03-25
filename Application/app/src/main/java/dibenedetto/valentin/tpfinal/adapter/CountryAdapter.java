package dibenedetto.valentin.tpfinal.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import dibenedetto.valentin.tpfinal.model.Country;
import dibenedetto.valentin.tpfinal.model.OnCountryClickListener;
import dibenedetto.valentin.tpfinal.view.CountryViewHolder;

public class CountryAdapter extends RecyclerView.Adapter<CountryViewHolder> {
    private List<Country> countryList;
    private OnCountryClickListener mOnCountryClickListener;


    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return CountryViewHolder.newInstance(parent, mOnCountryClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        holder.bind(countryList.get(position));
    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }

    public void setOnCountryClickListener(OnCountryClickListener onCountryClickListener) {
        mOnCountryClickListener = onCountryClickListener;
    }

    public void setCountryList(List<Country> cList) {
        countryList = cList;
        notifyDataSetChanged();
    }
}
