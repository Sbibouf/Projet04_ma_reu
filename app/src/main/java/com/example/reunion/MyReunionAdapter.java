package com.example.reunion;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reunion.databinding.ActivityMainBinding;
import com.example.reunion.databinding.FragmentReunionBinding;

import java.util.ArrayList;
import java.util.List;

public class MyReunionAdapter extends RecyclerView.Adapter<MyReunionAdapter.ViewHolder> {

    private ActivityMainBinding mActivityMainBinding;
    private FragmentReunionBinding mFragmentReunionBinding;
    private final int nb_frag = 5;
    private List<Integer> reunions;

    public MyReunionAdapter(){


    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        FragmentReunionBinding itemBinding = FragmentReunionBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        //View view = LayoutInflater.from(parent.getContext())
                //.inflate(R.layout.fragment_reunion_, parent, false);
        return new ViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        //mFragmentReunionBinding.nomReunion.setText("Reunion Fr");
        holder.changer_texte();
    }

    @Override
    public int getItemCount() {
        return nb_frag;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView iv_icone_reunion;
        private TextView tv_participants, tv_nom_reunion;



        public ViewHolder(@NonNull FragmentReunionBinding itemBinding) {
            super(itemBinding.getRoot());
            iv_icone_reunion = itemBinding.iconeReunion;
            //iv_icone_reunion = view.findViewById(R.id.icone_reunion);
            //tv_nom_reunion = view.findViewById(R.id.nom_reunion);
            //tv_participants = view.findViewById(R.id.participants);
            tv_participants = itemBinding.participants;
            tv_nom_reunion = itemBinding.nomReunion;


        }
        public void changer_texte(){

            tv_nom_reunion.setText("Reunion FR");
        }
    }
}
