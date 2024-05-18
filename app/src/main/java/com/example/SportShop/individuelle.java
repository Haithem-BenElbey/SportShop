package com.example.SportShop;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SecondFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class individuelle extends Fragment {


    private static final String ARG_PARAM1 = null;
    private static final String ARG_PARAM2 =null ;
    private GridView gridView;
    private GridAdapter2 gridAdapter;
    private ArrayList<String> imageDescriptions = new ArrayList<>();

    private int[] imageResources = {
            R.drawable.ping_pong,
            R.drawable.tennis,
            R.drawable.golf,
            R.drawable.boxe,

    };

    public individuelle() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SecondFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static collectif newInstance(String param1, String param2) {
        collectif fragment = new collectif();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Ne faites pas setContentView ici
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_collectif, container, false);
        gridView = view.findViewById(R.id.gridView);

        // Ajouter les descriptions des images (vérifiez si imageDescriptions est initialisé)
        if (imageDescriptions != null) {
            imageDescriptions.add("Ping Pong");
            imageDescriptions.add("Tennis");
            imageDescriptions.add("Golf");
            imageDescriptions.add("Boxe");

        }

        // Initialiser l'adaptateur et le configurer
        gridAdapter = new GridAdapter2(getContext(), imageDescriptions, imageResources);
        gridView.setAdapter(gridAdapter);

        return view;
    }
}
