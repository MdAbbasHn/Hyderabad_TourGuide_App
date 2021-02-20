package com.examples.tourguideapp;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HotelFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HotelFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HotelFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HotelFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HotelFragment newInstance(String param1, String param2) {
        HotelFragment fragment = new HotelFragment();
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
        View rootView = inflater.inflate(R.layout.list_view, container, false);
        Context context = getContext();
        TypedArray img =  context.getResources().obtainTypedArray(R.array.hotel_img);
        String[] names = context.getResources().getStringArray(R.array.hotel_places);
        String[] des = context.getResources().getStringArray(R.array.hotel_description);
        String[] num = context.getResources().getStringArray(R.array.hotel_number);
        String[] link = context.getResources().getStringArray(R.array.hotel_link);
        String[] loc = context.getResources().getStringArray(R.array.hotel_location);
        String[] tim = context.getResources().getStringArray(R.array.hotel_timing);
        ArrayList<Category> his = new ArrayList<Category>();
        for(int i=0;i<names.length;i++){
            his.add(new Category(img.getResourceId(i,i),names[i],des[i],num[i],link[i],loc[i],tim[i]));
        }
        CategoryAdapter categoryAdapter = new CategoryAdapter(getContext(),his,R.color.purple_500);
        GridView listView = (GridView) rootView.findViewById(R.id.main);
        listView.setAdapter(categoryAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Category cat = his.get(i);
                Intent mIntent = new Intent(getActivity(), Attraction.class);
                mIntent.putExtra("UniqueKey", cat);
                startActivity(mIntent);
            }
        });
        // Inflate the layout for this fragment
        return rootView;
    }
}