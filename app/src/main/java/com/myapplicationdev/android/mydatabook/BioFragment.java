package com.myapplicationdev.android.mydatabook;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BioFragment#newInstance} factory method to
 * create an instance of this fragment.
 */


public class BioFragment extends Fragment {
Button b;
TextView tv1;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BioFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BioFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BioFragment newInstance(String param1, String param2) {
        BioFragment fragment = new BioFragment();
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
        View yes = inflater.inflate(R.layout.biofragment, container, false);
        b = (Button) yes.findViewById(R.id.button);
        tv1 = (TextView) yes.findViewById(R.id.tv1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View v1= inflater.inflate(R.layout.dialog_edit, null, false);
                final EditText et = (EditText) v1.findViewById(R.id.et1);
                et.setText(tv1.getText().toString());

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

                builder.setTitle("Edit Bio")
                .setView(v1)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialogInterface, int i) {
                                tv1.setText(et.getText().toString());
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialogInterface, int i) {
                            }
                        })
                        .create();
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });


        return yes;

    }
}