package dev.boca.ejercicio3;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DessertsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DessertsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DessertsFragment() {
        // Required empty public constructor
    }
    public static DessertsFragment newInstance(String param1, String param2) {
        DessertsFragment fragment = new DessertsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_desserts, container, false);
        root.findViewById(R.id.GoToCartDesserts)
            .setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(getActivity(), CartActivity.class));
                    }
                }
            );
        root.findViewById(R.id.CardView_dessert1)
                .setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Product.crearPregunta(getActivity(), "King Fusion El Almendro", 3.59f);
                            }
                        }
                );
        root.findViewById(R.id.CardView_dessert2)
                .setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Product.crearPregunta(getActivity(), "Oreo Shake", 3.99f);
                            }
                        }
                );
        root.findViewById(R.id.CardView_dessert3)
                .setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Product.crearPregunta(getActivity(), "Tarta de Oreo", 3.49f);
                            }
                        }
                );
        return root;
    }

}