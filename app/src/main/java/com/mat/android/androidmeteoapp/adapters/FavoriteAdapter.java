package com.mat.android.androidmeteoapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.mat.android.androidmeteoapp.R;
import com.mat.android.androidmeteoapp.models.City;


import java.util.ArrayList;

public class FavoriteAdapter
        extends RecyclerView.Adapter<FavoriteAdapter.ViewHolder> {

    private ArrayList<City> mArrayListCities;
    private Context mContext;

    public FavoriteAdapter(Context context, ArrayList<City> cities) {
        this.mContext = context;
        this.mArrayListCities = cities;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mTextViewCity;
        public ImageView mImageViewWeather;
        public TextView mTextViewTemperature;
        public TextView mTextViewDescription;

        public int position;

        public ViewHolder(View view) {
            super(view);

            mTextViewCity = (TextView) view.findViewById(R.id.text_view_item_city);
            mImageViewWeather = (ImageView) view.findViewById(R.id.image_view_item_weather);
            mTextViewTemperature = (TextView) view.findViewById(R.id.text_view_item_temperature);
            mTextViewDescription = (TextView) view.findViewById(R.id.text_view_item_details);
        }
    }

    @Override
    public FavoriteAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_favorite_city, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        City city = mArrayListCities.get(position);

        holder.mTextViewCity.setText(city.mName);
        holder.mImageViewWeather.setImageResource(city.mWeatherIcon);
        holder.mTextViewTemperature.setText(city.mTemperature);
        holder.mTextViewDescription.setText(city.mDescription);

        holder.position = position;
    }

    @Override
    public int getItemCount() {
        return mArrayListCities.size();
    }



}
