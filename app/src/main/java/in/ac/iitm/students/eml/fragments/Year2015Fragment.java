package in.ac.iitm.students.eml.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import in.ac.iitm.students.eml.R;
import in.ac.iitm.students.eml.adapters.LecturesAdapter;

/**
 * Created by Sathwik on 20-12-2016.
 */

public class Year2015Fragment extends Fragment {

    public void Year2015Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_year2016, container, false);

        ArrayList<String> lectureTitles = new ArrayList<>(), times = new ArrayList<>();

        lectureTitles.add("First Personality");
        lectureTitles.add("Second Personality");
        lectureTitles.add("Third Personality");
        lectureTitles.add("Forth Personality");

        times.add("20 December, 2015");
        times.add("20 December, 2015");
        times.add("20 December, 2015");
        times.add("20 December, 2015");


        Context context = view.getContext();
        RecyclerView recyclerView = (RecyclerView) view;
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(new LecturesAdapter(lectureTitles, times, context));
        return view;
    }

}
