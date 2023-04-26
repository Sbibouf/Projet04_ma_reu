package com.example.reunion.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reunion.databinding.FragmentReunionBinding;
import com.example.reunion.model.Reunion;
import com.example.reunion.service.FakeReunionApiService;

import java.util.ArrayList;
import java.util.List;

public class MyReunionAdapter extends RecyclerView.Adapter<MyReunionAdapter.ViewHolder> {

    private FragmentReunionBinding mFragmentReunionBinding;
    private FakeReunionApiService apiservice;
    private List<Reunion> mReunions;

    public MyReunionAdapter(List<Reunion> items){

        mReunions = items;

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
        holder.tv_nom_reunion.setText(reunion.getNom_reunion());
        //holder.tv_participants.setText(reunion.getParticipants().toString());
    }

    @Override
    public int getItemCount() {
        return mReunions.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView iv_icone_reunion;
        private TextView tv_participants, tv_nom_reunion;



        public ViewHolder(@NonNull FragmentReunionBinding itemBinding) {
            super(itemBinding.getRoot());
            mFragmentReunionBinding = itemBinding;
            iv_icone_reunion = itemBinding.iconeReunion;
            tv_participants = itemBinding.participants;
            tv_nom_reunion = itemBinding.nomReunion;


        }
    }
    public void updateList(List<Reunion> newList) {

        this.mReunions = new ArrayList<>(newList);
    }
}
