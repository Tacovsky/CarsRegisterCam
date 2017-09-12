package com.example.dckurty.carsregistercam.adapters;

import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.dckurty.carsregistercam.CarClickListener;
import com.example.dckurty.carsregistercam.R;
import com.example.dckurty.carsregistercam.data.Queries;
import com.example.dckurty.carsregistercam.models.Car;

import java.util.List;

public class CarsAdapter extends RecyclerView.Adapter<CarsAdapter.ViewHolder>{

    private List<Car> cars = new Queries().cars();
    private CarClickListener listener;

    public CarsAdapter(CarClickListener listener) {
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_car, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Car car = cars.get(position);
        holder.textView.setText(car.getPlate());
        holder.checkBox.setChecked(car.isDone());

        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            int auxPosition = holder.getAdapterPosition();
                            Car auxCar = cars.get(auxPosition);
                            auxCar.setDone(true);
                            auxCar.save();
                            cars.remove(auxPosition);
                            notifyItemRemoved(auxPosition);
                        }
                    }, 400);
                }
            }
        });

        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Car auxCar = cars.get(holder.getAdapterPosition());
                listener.clickedID(auxCar.getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }

    public void update(Car car){
        cars.add(car);
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        private CheckBox checkBox;
        private TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);

            checkBox = (CheckBox) itemView.findViewById(R.id.carCb);
            textView = (TextView) itemView.findViewById(R.id.carTv);

        }
    }
}
