package com.example.reunion;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyReunionAdapter {

    public class ViewHolder extends RecyclerView.ViewHolder{


        public TextView tv_nom_reunion, tv_participants;
        public ImageView iv_icone_reunion;
        public Button bt_suppr_reunion;
        public ViewHolder(@NonNull View itemView) {
            super();

            tv_nom_reunion = (TextView) itemView.findViewById(R.id.nom_reunion);
            tv_participants = (TextView) itemView.findViewById(R.id.participants);
            iv_icone_reunion = (ImageView) itemView.findViewById(R.id.icone_reunion);
            bt_suppr_reunion = (Button) itemView.findViewById(R.id.suppr_reunion);
        }
    }
}
