package com.example.evaluadoreslistadocardviews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.evaluadoreslistadocardviews.Adapter.RecyclerAdapterEvaluadores;
import com.example.evaluadoreslistadocardviews.Model.Evaluador;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewRevista;
    private RecyclerAdapterEvaluadores adapterRevista;


    private ImageView imgFind;
    private RequestQueue requestQue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewRevista=(RecyclerView) findViewById(R.id.reclyclerRevistas);
        recyclerViewRevista.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewRevista.setItemAnimator(new DefaultItemAnimator());
        searchCover();

    }
    private void searchCover(){

        String url="https://www.uealecpeterson.net/ws/listadoevaluadores.php";
        JsonObjectRequest requestJson=new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        JSONArray jsonArray= null;
                        try {
                            jsonArray = response.getJSONArray("listaaevaluador");
                            showCoverText(jsonArray);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(),"Error al conectarse:"+error.getMessage(),Toast.LENGTH_LONG).show();
                    }
                }

        );
        requestQue= Volley.newRequestQueue(this);
        requestQue.add(requestJson);
    };

    private void showCoverText(JSONArray jArray){
        List<Evaluador> evaluadors = new ArrayList<>();
        for(int i=0;i<jArray.length();i++){
            try{
                JSONObject objectJson=new JSONObject(jArray.get(i).toString());

                evaluadors.add(new Evaluador(objectJson.getString("idevaluador"),objectJson.getString("nombres"),objectJson.getString("area"),objectJson.getString("imgJPG"),objectJson.getString("imgjpg")));

            }
            catch (JSONException e){
                Toast.makeText(this,"Error al cargar lista: "+e.getMessage(),Toast.LENGTH_LONG).show();
            }
        }
        adapterRevista=new RecyclerAdapterEvaluadores(MainActivity.this, evaluadors);

        int id = R.anim.layout_animation_down_up;
        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(getApplicationContext(),
                id);
        recyclerViewRevista.setLayoutAnimation(animation);

        recyclerViewRevista.setAdapter(adapterRevista);
    };


}