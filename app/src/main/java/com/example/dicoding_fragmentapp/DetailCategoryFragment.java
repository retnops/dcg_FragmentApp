package com.example.dicoding_fragmentapp;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailCategoryFragment extends Fragment implements View.OnClickListener{
TextView tvCategoryName;
TextView tvCategoryDescription;
Button btnProfile;
Button btnShowDialog;
public static String EXTRA_NAME = "extra_name";
public  static  String EXTRA_DESCRIPTION = "extra_description";
private String description;

public String getDescription () {
    return description;
}

public void setDescription(String description) {
    this.description = description;
}

    public DetailCategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_category, container, false);
    }

    @Override
    public  void onViewCreated (@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvCategoryName = view.findViewById(R.id.tv_category_name);
        tvCategoryDescription = view.findViewById(R.id.tv_category_description);
        btnProfile = view.findViewById(R.id.btn_profile);
        btnProfile.setOnClickListener(this);
        btnShowDialog = view.findViewById(R.id.btn_show_dialog);
        btnShowDialog.setOnClickListener(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    if (savedInstanceState != null) {
        String descFromBundle = savedInstanceState.getString(EXTRA_DESCRIPTION);
        setDescription(descFromBundle);
    }
    if (getArguments() != null) {
        String categoryName = getArguments().getString(EXTRA_NAME);
        tvCategoryName.setText(categoryName);
        tvCategoryDescription.setText(getDescription());
         }
    }

    @Override
    public void onSaveInstanceState (@NonNull Bundle outstate){
    super.onSaveInstanceState(outstate);
    outstate.putString(EXTRA_DESCRIPTION, getDescription());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId ()) {
            case R.id.btn_profile:
                break;
            case  R.id.btn_show_dialog:
                OptionDialogFragment mOptionDialogFragment = new OptionDialogFragment();
                FragmentManager mFragmentManager = getChildFragmentManager();
                mOptionDialogFragment.show(mFragmentManager, OptionDialogFragment.class.getSimpleName());
                break;
        }
    }
OptionDialogFragment.OnOptionDialogListener optionDialogListener = new OptionDialogFragment.OnOptionDialogListener(){
    @Override
    public  void onOptionChosen (String text) {Toast.makeText(getActivity(), text, Toast.LENGTH_SHORT).show();
    }
};
}
