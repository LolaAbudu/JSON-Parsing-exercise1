package com.example.lolaabudu.jsonparsingexercse1;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.lolaabudu.jsonparsingexercse1.FruitViewHolder;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<FruitViewHolder>{

    private List<Fruits> fruitsList;

    public Adapter (List<Fruits> fruitsList){
        this.fruitsList = fruitsList;
    }

    @NonNull
    @Override
    public FruitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View childview = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruits_itemview,parent,false);
        return new FruitViewHolder(childview);
    }

    @Override
    public void onBindViewHolder(@NonNull FruitViewHolder fruitViewHolder, int position) {
        Fruits fruits = fruitsList.get(position);
        fruitViewHolder.onBind(fruits);
    }

    @Override
    public int getItemCount() {
        return fruitsList.size();
    }
}
