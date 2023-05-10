package com.example.reunion.adapters;

import android.content.DialogInterface;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reunion.databinding.FragmentReunionBinding;
import com.example.reunion.model.Reunion;
import com.example.reunion.service.SupprimerReunionService;

import java.util.Date;
import java.util.List;

public class MyReunionAdapter extends RecyclerView.Adapter<MyReunionAdapter.ViewHolder> {

    private FragmentReunionBinding mFragmentReunionBinding;
    private List<Reunion> mReunions;
    SupprimerReunionService mSupprimerReunionService;

    public MyReunionAdapter(List<Reunion> liste, SupprimerReunionService supprimerReunionService) {

        mReunions = liste;
        mSupprimerReunionService = supprimerReunionService;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        FragmentReunionBinding itemBinding = FragmentReunionBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Reunion reunion = mReunions.get(position);
        Date dateReunion = reunion.getFinReunion();
        holder.tv_nom_reunion.setText(reunion.getNomReunion());
        holder.tv_heure.setText(reunion.getHeureReu());
        holder.tv_salle.setText(reunion.getSalleReu());
        holder.tv_participants.setText(reunion.getParticipants());
        if (new Date().before(dateReunion)) {

            holder.iv_icone_reunion.setColorFilter(Color.argb(200, 94, 203, 32));
        } else {
            holder.iv_icone_reunion.setColorFilter(Color.argb(200, 203, 32, 32));
        }
        holder.ib_supprimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setCancelable(true);
                builder.setTitle("Supprimer la réunion " + reunion.getNomReunion());
                builder.setMessage("Êtes vous sûr?");
                builder.setPositiveButton("Ok",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                mSupprimerReunionService.supprimerReunion(reunion);
                            }
                        });
                builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return mReunions.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView iv_icone_reunion;
        private TextView tv_participants, tv_nom_reunion, tv_heure, tv_salle;
        private ImageButton ib_supprimer;


        public ViewHolder(@NonNull FragmentReunionBinding itemBinding) {
            super(itemBinding.getRoot());
            mFragmentReunionBinding = itemBinding;
            ib_supprimer = itemBinding.imageButton;
            iv_icone_reunion = itemBinding.iconeReunion;
            tv_participants = itemBinding.participants;
            tv_nom_reunion = itemBinding.nomReunion;
            tv_heure = itemBinding.tvHeureReunion;
            tv_salle = itemBinding.tvSalleReunion;


        }
    }

    public Reunion getReunions(int position) {
        return this.mReunions.get(position);
    }
}
