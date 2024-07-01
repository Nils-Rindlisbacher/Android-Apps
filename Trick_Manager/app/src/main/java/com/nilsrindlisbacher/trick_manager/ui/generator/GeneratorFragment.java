package com.nilsrindlisbacher.trick_manager.ui.generator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.nilsrindlisbacher.trick_manager.Connection;
import com.nilsrindlisbacher.trick_manager.R;
import com.nilsrindlisbacher.trick_manager.databinding.FragmentGeneratorBinding;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class GeneratorFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    private FragmentGeneratorBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GeneratorViewModel generatorViewModel =
                new ViewModelProvider(this).get(GeneratorViewModel.class);

        ArrayList<String> types;

        try {
            types = Connection.getTypes();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        binding = FragmentGeneratorBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.generatorTitle;
        generatorViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getContext(),
                android.R.layout.simple_spinner_item,
                types
        );

        Spinner typeSpinner = (Spinner) root.findViewById(R.id.type_spinner);
        typeSpinner.setAdapter(adapter);

        return root;
    }

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        Spinner typeSpinner = (Spinner) view.findViewById(R.id.type_spinner);
        typeSpinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);

    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback.
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}