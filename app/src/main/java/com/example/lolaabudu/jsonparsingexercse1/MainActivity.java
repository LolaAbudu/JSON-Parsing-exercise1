package com.example.lolaabudu.jsonparsingexercse1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView fruitRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fruitRecyclerView = (RecyclerView) findViewById(R.id.movie_recyclerView);

        JSONObject myJSONObject = new JSONObject();

        JSONArray myJSONArray = new JSONArray();

        try{
            myJSONObject.put("Fruits", myJSONArray
                    .put(new JSONObject()
                            .put("name", "orange")
                            .put("seed count", 10)
                            .put("color", "orange"))
                    .put(new JSONObject()
                            .put("name", "apple")
                            .put("seed count", 5)
                            .put("color", "red"))
                    .put(new JSONObject()
                            .put("name", "kiwi")
                            .put("seed count", 15)
                            .put("color", "green"))
                    .put(new JSONObject()
                            .put("name", "banana")
                            .put("seed count", 0)
                            .put("color", "yellow"))
            );
        }catch(JSONException e){
            e.printStackTrace();
        }

        String fruits = myJSONObject.toString();
        Log.d("Testing it out", "onCreate" + myJSONObject.toString());


        List<Fruits> fruitsList = new ArrayList<>();
        try{
            JSONObject toParseObject = new JSONObject();
            JSONArray toPArseArray = toParseObject.getJSONArray("Fruits");

            for(int i = 0; i < toPArseArray.length(); i++){
               Fruits allFruits = new Fruits();
               allFruits.setName((String)toPArseArray.getJSONObject(i).get("name"));
               allFruits.setSeedCount((int)toPArseArray.getJSONObject(i).get("age"));
               fruitsList.add(allFruits);
            }
        }catch(JSONException e){
            e.printStackTrace();
        }

        Adapter adapter = new Adapter(fruitsList);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        fruitRecyclerView.setAdapter(adapter);
        fruitRecyclerView.setLayoutManager(linearLayoutManager);


    }
}
