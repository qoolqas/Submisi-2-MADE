package com.example.moviecatalogue;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class FragmentMovies extends Fragment implements RecyclerViewAdapter.OnItemClickListener {
    private String[] dataName;
    private String[] dataDescription;
    private TypedArray dataPhoto;

    View v;
    private RecyclerView myrecyclerview;
    private ArrayList<Res> films;

    public FragmentMovies() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.movies_fragment, container, false);
        myrecyclerview = v.findViewById(R.id.movies_recyclerview);
        myrecyclerview.setHasFixedSize(true);

        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(), films);
        myrecyclerview.setAdapter(recyclerViewAdapter);
        recyclerViewAdapter.setOnItemClickListener(FragmentMovies.this);

        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        prepare();
        addItem();

    }

    private void prepare() {
        dataName = getResources().getStringArray(R.array.data_name);
        dataDescription = getResources().getStringArray(R.array.data_description);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
    }

    private void addItem() {
        films = new ArrayList<>();

        for (int i = 0; i < dataName.length; i++) {
            Res res = new Res();
            res.setPhoto(dataPhoto.getResourceId(i, -1));
            res.setName(dataName[i]);
            res.setDescription(dataDescription[i]);
            films.add(res);
        }

    }

    @Override
    public void onItemClick(int position) {
        Res res = new Res();

        res.setName(dataName[position]);
        res.setDescription(dataDescription[position]);
        res.setPhoto(dataPhoto.getResourceId(position, -1));
        Intent intent = new Intent(getContext(), SecondActivity.class);
        intent.putExtra(SecondActivity.EXTRA_NAME, res);
        startActivity(intent);
    }
}
