package com.example.lolaabudu.jsonparsingexercse1;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.lolaabudu.jsonparsingexercse1.R;
import com.example.lolaabudu.jsonparsingexercse1.Fruits;

public class FruitViewHolder extends RecyclerView.ViewHolder {

    private TextView name;
    private TextView seedCount;
    private TextView color;

    public FruitViewHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.fruit_name_textview);
        seedCount = itemView.findViewById(R.id.fruit_seedCount_textview);
        color = itemView.findViewById(R.id.fruit_color_textview);
    }

    public void onBind(Fruits fruits){
        name.setText(fruits.getName());
        seedCount.setText(fruits.getSeedCount());
        color.setText(fruits.getColor());
    }
}
