package com.example.evaluadoreslistadocardviews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.evaluadoreslistadocardviews.Adapter.RecyclerAdapterEvaluadores;
import com.example.evaluadoreslistadocardviews.Adapter.RecyclerAdapterEvaluados;
import com.example.evaluadoreslistadocardviews.Model.Evaluador;
import com.example.evaluadoreslistadocardviews.Model.Evaluados;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    private RecyclerView recyclerEval;
    private RecyclerAdapterEvaluados adapterEvaluados;

    private ImageView imgFind;
    private RequestQueue requestQue;
    private Bundle bundle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_evaluados);
        bundle=this.getIntent().getExtras();

        TextView titulo;
        titulo= (TextView)findViewById(R.id.txtMainName);
        titulo.setText("Listado de evaluados del evaluador con Id:  "+bundle.getString("ideva"));

        recyclerEval=(RecyclerView) findViewById(R.id.reclyclerEvaluados);
        recyclerEval.setLayoutManager(new LinearLayoutManager(this));
        recyclerEval.setItemAnimator(new DefaultItemAnimator());
        searchCover();






    }
    private void searchCover(){
        bundle=this.getIntent().getExtras();
        String url="https://uealecpeterson.net/ws/listadoaevaluar.php?e=" + bundle.getString("ideva");
        JsonObjectRequest requestJson=new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        JSONArray jsonArray= null;
                        try {
                            jsonArray = response.getJSONArray("listaaevaluar");
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
        List<Evaluados> evaluados = new ArrayList<Evaluados>();
        for(int i=0;i<jArray.length();i++){
            try{
                JSONObject objectJson=new JSONObject(jArray.get(i).toString());

                evaluados.add(new Evaluados(objectJson.getString("id"),objectJson.getString("idevaluado"),objectJson.getString("Nombres"),objectJson.getString("genero"),
                        objectJson.getString("situacion"),objectJson.getString("cargo"),objectJson.getString("fechainicio"),objectJson.getString("fechafin"),objectJson.getString("imgJPG"),objectJson.getString("imgjpg")));

            }
            catch (JSONException e){
                Toast.makeText(this,"Error al cargar lista: "+e.getMessage(),Toast.LENGTH_LONG).show();
            }
        }
        adapterEvaluados= new RecyclerAdapterEvaluados(MainActivity2.this, evaluados);

       int id = R.anim.layout_animation_down_up;
        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(getApplicationContext(),
                id);
        recyclerEval.setLayoutAnimation(animation);

        recyclerEval.setAdapter(adapterEvaluados);
    };
}