package com.example.evaluadoreslistadocardviews.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.bumptech.glide.Glide;
import com.example.evaluadoreslistadocardviews.MainActivity2;
import com.example.evaluadoreslistadocardviews.Model.Evaluador;
import com.example.evaluadoreslistadocardviews.Model.Evaluados;
import com.example.evaluadoreslistadocardviews.R;

import java.util.List;

public class RecyclerAdapterEvaluados extends RecyclerView.Adapter<RecyclerAdapterEvaluados.EvaluadosViewHolder> {
    private Context ctx;
    public List<Evaluados> evaluadosLista;
    private RequestQueue request;
    public RecyclerAdapterEvaluados(View.OnClickListener onClickListener, List<Evaluados> evaluadosLista) {
        this.evaluadosLista = evaluadosLista;
    }
    public static class EvaluadosViewHolder extends RecyclerView.ViewHolder{

        private TextView txtid, txtidEvaluado,txtgenero,txtsituacion,txtcargo,txtfechainicio;
        private ImageView imgUrl;


        public EvaluadosViewHolder(View itemView) {
            super(itemView);
            txtid= (TextView)itemView.findViewById(R.id.txtid);
            txtidEvaluado= (TextView)itemView.findViewById(R.id.txtidevaluador);
            txtgenero= (TextView)itemView.findViewById(R.id.txtgenero);
            txtsituacion= (TextView)itemView.findViewById(R.id.txtsituacion);
            txtcargo= (TextView)itemView.findViewById(R.id.txtcargo);
            txtfechainicio= (TextView)itemView.findViewById(R.id.finicio);
            imgUrl=(ImageView)itemView.findViewById(R.id.imgFotoU);

        }
    }


    public RecyclerAdapterEvaluados(Context mCtx, List<Evaluados> evaluadorLista) {
        this.ctx = mCtx;
        this.evaluadosLista = evaluadorLista;
    }




    @Override
    public EvaluadosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.evaluadosadapter,parent,false);
        EvaluadosViewHolder reViewHolder = new EvaluadosViewHolder(view);
        return reViewHolder;
    }

    //Modificación del contenido para cada cardView

    @Override
    public void onBindViewHolder(EvaluadosViewHolder holder, int position) {

        holder.txtid.setText(evaluadosLista.get(position).getId()+". "+evaluadosLista.get(position).getNombres());
        holder.txtidEvaluado.setText(evaluadosLista.get(position).getIdEvaluado());
       // holder.txtnombres.setText(evaluadosLista.get(position).getNombres());
        holder.txtgenero.setText(evaluadosLista.get(position).getGenero());
        holder.txtsituacion.setText(evaluadosLista.get(position).getSituacion());
        holder.txtcargo.setText(evaluadosLista.get(position).getCargo());
        holder.txtfechainicio.setText(evaluadosLista.get(position).getFechainicio());
        //holder.txtfechafin.setText(evaluadosLista.get(position).getFechafin());


        Glide.with(ctx)
                .load(evaluadosLista.get(position).getImgjpg())
                .error(R.drawable.unknown)
                .load(evaluadosLista.get(position).getImgJPG())
                .error(R.drawable.unknown)
                .into(holder.imgUrl);

    }

    @Override
    public int getItemCount() {
        return evaluadosLista.size();
    }

}
