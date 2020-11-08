package com.example.alumnimobileapp;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private Context context;
    private List<Result> results;

    public RecyclerViewAdapter(Context context, List<Result> results) {
        this.context = context;
        this.results = results;
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view, parent, false);
        ViewHolder holder = new ViewHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ViewHolder holder, int position) {
        Result result = results.get(position);
        holder.textViewNama.setText(result.getNama());
        holder.textViewAngkatan.setText(result.getAngkatan());
        holder.textViewNomorHP.setText(result.getNo_hp());
        holder.textViewEmail.setText(result.getEmail());
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @BindView(R.id.textNama)
        TextView textViewNama;
        @BindView(R.id.textAngkatan)
        TextView textViewAngkatan;
        @BindView(R.id.textNomorHP)
        TextView textViewNomorHP;
        @BindView(R.id.textEmail)
        TextView textViewEmail;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            String nama = textViewNama.getText().toString();
            String angkatan = textViewNama.getText().toString();
            String no_hp = textViewNomorHP.getText().toString();
            String email = textViewEmail.getText().toString();

            Intent i = new Intent(context, UpdateActivity.class);
            i.putExtra("nama", nama);
            i.putExtra("angkatan", angkatan);
            i.putExtra("no_hp", no_hp);
            i.putExtra("email", email);
            context.startActivity(i);
        }

    }


}

