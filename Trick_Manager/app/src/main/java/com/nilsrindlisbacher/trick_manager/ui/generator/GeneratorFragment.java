package com.nilsrindlisbacher.trick_manager.ui.generator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.nilsrindlisbacher.trick_manager.databinding.FragmentGeneratorBinding;

public class GeneratorFragment extends Fragment {

    private FragmentGeneratorBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GeneratorViewModel generatorViewModel =
                new ViewModelProvider(this).get(GeneratorViewModel.class);

        binding = FragmentGeneratorBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.generatorTitle;
        generatorViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}