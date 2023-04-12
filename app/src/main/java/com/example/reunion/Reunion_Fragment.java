package com.example.reunion;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.reunion.databinding.ActivityMainBinding;
import com.example.reunion.databinding.FragmentReunionBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Reunion_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Reunion_Fragment extends Fragment {

    private FragmentReunionBinding mFragmentReunionBinding;
    private ActivityMainBinding mActivityMainBinding;
    private MyReunionAdapter adapter;
    private RecyclerView mRecyclerView;


    public static Reunion_Fragment newInstance() {
        Reunion_Fragment fragment = new Reunion_Fragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //mFragmentReunionBinding = FragmentReunionBinding.inflate(inflater, container, false);
        //View view = mFragmentReunionBinding.getRoot();
        View view = inflater.inflate(R.layout.fragment_reunion_, container, false);
        return view;
    }
    //private void initView() {
      //  adapter = new MyReunionAdapter();
        //mRecyclerView.setAdapter(adapter);
    //}

    @Override
    public void onResume() {
        super.onResume();
        //initView();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mFragmentReunionBinding = null;
    }
}