package com.example.reunion.adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reunion.R;
import com.example.reunion.Repository.ReunionRepository;
import com.example.reunion.databinding.FragmentReunionBinding;
import com.example.reunion.model.Reunion;
import com.example.reunion.service.FakeReunionApiService;
import com.example.reunion.service.ItemClickSupport;
import com.example.reunion.service.SupprimerReunionService;

import java.util.ArrayList;
import java.util.List;

public class MyReunionAdapter extends RecyclerView.Adapter<MyReunionAdapter.ViewHolder> {

    private FragmentReunionBinding mFragmentReunionBinding;
    private FakeReunionApiService apiservice;
    private List<Reunion> mReunions;
    ReunionRepository mReunionRepository;
    SupprimerReunionService mSupprimerReunionService;

    public MyReunionAdapter(List<Reunion> items, SupprimerReunionService supprimerReunionService){

        mReunions = items;
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

        mReunionRepository = ReunionRepository.getInstance();
        Reunion reunion = mReunions.get(position);
        holder.tv_nom_reunion.setText(reunion.getNom_reunion());
        holder.tv_heure.setText(reunion.getHeure_reu());
        holder.tv_salle.setText(reunion.getSalle_reu());
        holder.tv_participants.setText(reunion.getParticipants());
        if(reunion.getSalle_reu()=="Salle 1"){
            holder.iv_icone_reunion.setColorFilter(Color.argb(140,250,255,75));
        }
        holder.ib_supprimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSupprimerReunionService.supprimerReunion(reunion);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mReunions.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

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
