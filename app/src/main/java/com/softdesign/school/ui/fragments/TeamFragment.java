package com.softdesign.school.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by RomanAkimenko on 14.02.2016.
 */

public class TeamFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View convertView = inflater.inflate(R.layout.fragment_team, null, false);
        getActivity().setTitle(getResources().getString(R.string.drawer_team));

        return convertView;
    }
}
