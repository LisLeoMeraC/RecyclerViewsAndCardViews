package com.example.evaluadoreslistadocardviews.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.evaluadoreslistadocardviews.MainActivity2;
import com.example.evaluadoreslistadocardviews.R;
import com.android.volley.RequestQueue;
import com.bumptech.glide.Glide;
import com.example.evaluadoreslistadocardviews.Model.Evaluador;

import java.util.List;

public class RecyclerAdapterEvaluadores extends RecyclerView.Adapter<RecyclerAdapterEvaluadores.EvaluadoresViewHolder> {
    private Context ctx;
    public List<Evaluador> evaluadorLista;
    private RequestQueue request;
    public RecyclerAdapterEvaluadores(View.OnClickListener onClickListener, List<Evaluador> evaluadorLista) {
        this.evaluadorLista = evaluadorLista;
    }
    public static class EvaluadoresViewHolder extends RecyclerView.ViewHolder{

        private TextView txtidEva,txtNombres, txtAre;
        private ImageView urlFoto;
        private Button btn;





        public EvaluadoresViewHolder(View itemView) {
            super(itemView);

            txtidEva= (TextView)itemView.findViewById(R.id.txtidEva);
            txtNombres= (TextView)itemView.findViewById(R.id.txtNombres);
            txtAre= (TextView)itemView.findViewById(R.id.txtArea);
            urlFoto=(ImageView)itemView.findViewById(R.id.imgFoto);
            btn=(Button) itemView.findViewById(R.id.btnEvaluador);


        }

    }


    public RecyclerAdapterEvaluadores(Context mCtx, List<Evaluador> evaluadorLista) {
        this.ctx = mCtx;
        this.evaluadorLista = evaluadorLista;
    }




    @Override
    public EvaluadoresViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.evaluadores,parent,false);
        EvaluadoresViewHolder reViewHolder = new EvaluadoresViewHolder(view);
        return reViewHolder;
    }

    //Modificación del contenido para cada cardView

    @Override
    public void onBindViewHolder(EvaluadoresViewHolder holder, int position) {

        holder.txtidEva.setText(evaluadorLista.get(position).getIdeva());
        holder.txtNombres.setText(evaluadorLista.get(position).getNom());
        holder.txtAre.setText(evaluadorLista.get(position).getAre());
        Glide.with(ctx)
                .load(evaluadorLista.get(position).getUrlFotoPNG())
                .load(evaluadorLista.get(position).getUrlFotopng())
                .error(R.drawable.unknown)
                .into(holder.urlFoto);


     /*   Glide.with(ctx)
                    .load(evaluadorLista.get(position).getUrlFotoPNG())
                    .into(holder.urlFoto);
        if(evaluadorLista.get(position).getUrlFotoPNG().equals(null)){
            Glide.with(ctx)
            .load(evaluadorLista.get(position).getUrlFotopng())
                    .into(holder.urlFoto);
        }

      /*  else if(evaluadorLista.get(position).getUrlFotopng().equals(holder.urlFoto!=null)) {
            Glide.with(ctx)
                    .load(evaluadorLista.get(position).getUrlFotopng())
                    .into(holder.urlFoto);
        }*/

        /**/

        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent  intent= new Intent(ctx,MainActivity2.class);

                Bundle bundle=new Bundle();
                bundle.putString("ideva", holder.txtidEva.getText().toString());

                intent.putExtras(bundle);
                ctx.startActivity(intent);
            }
        });

    }



    @Override
    public int getItemCount() {
        return evaluadorLista.size();
    }

}


