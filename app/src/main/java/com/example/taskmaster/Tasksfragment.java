package com.example.taskmaster;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Tasksfragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Tasksfragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "title";
    private static final String ARG_PARAM2 = "body";

    // TODO: Rename and change types of parameters
    private String mtitle;
    private String mbody;

    public Tasksfragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param mtitle Parameter 1.
     * @param mbody Parameter 2.
     * @return A new instance of fragment Tasksfragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Tasksfragment newInstance(String mtitle, String mbody) {
        Tasksfragment fragment = new Tasksfragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, mtitle);
        args.putString(ARG_PARAM2, mbody);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mtitle = getArguments().getString(ARG_PARAM1);
            mbody = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tasksfragment, container, false);
    }
}
