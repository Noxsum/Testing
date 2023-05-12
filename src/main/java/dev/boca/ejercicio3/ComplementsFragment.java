package dev.boca.ejercicio3;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ComplementsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ComplementsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ComplementsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ComplementsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ComplementsFragment newInstance(String param1, String param2) {
        ComplementsFragment fragment = new ComplementsFragment();
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
        // Inflate the layout for this fragment
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_complements, container, false);
        root.findViewById(R.id.GoToCartComplements)
            .setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(getActivity(), CartActivity.class));
                    }
                }
            );

        root.findViewById(R.id.CardView_complements1)
                .setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Product.crearPregunta(getActivity(),"Ensalada Delight", 3.99f);
                            }
                        }
                );
        root.findViewById(R.id.CardView_complements2)
                .setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Product.crearPregunta(getActivity(),"Aros de cebolla", 2.99f);
                            }
                        }
                );
        root.findViewById(R.id.image_complements3)
                .setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Product.crearPregunta(getActivity(),"Cubo de alitas de pollo", 7.49f);
                            }
                        }
                );

        root.findViewById(R.id.CardView_complements4)
                .setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Product.crearPregunta(getActivity(),"Chicken Nuggets", 1.59f);
                            }
                        }
                );
        root.findViewById(R.id.CardView_complements5)
                .setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Product.crearPregunta(getActivity(),"Cubo de patatas", 4.99f);
                            }
                        }
                );
        root.findViewById(R.id.CardView_complements6)
                .setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Product.crearPregunta(getActivity(),"Tequeños", 2.99f);
                            }
                        }
                );

        return root;
    }
}