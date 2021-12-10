package com.example.justdoit.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.example.justdoit.R;
import com.example.justdoit.databinding.FragmentSlideshowBinding;

public class SlideshowFragment extends Fragment {
    ImageView iv15;
    TextView about;

    private SlideshowViewModel slideshowViewModel;
private FragmentSlideshowBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);

    binding = FragmentSlideshowBinding.inflate(inflater, container, false);
    View root = binding.getRoot();

        final TextView textView = binding.textSlideshow;
        slideshowViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        iv15=view.findViewById(R.id.iv15);
        iv15.setImageResource(R.drawable.logo2);
        about=view.findViewById(R.id.textView2);
        about.setText("developed by Ariful Islam");

    }

@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}