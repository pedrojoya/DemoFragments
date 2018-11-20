package es.iessaladillo.pedrojoya.demofragments.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import es.iessaladillo.pedrojoya.demofragments.R;

public class MainFragment extends Fragment {

    private static final String ARG_MESSAGE = "ARG_MESSAGE";

    private Button btnSaludar;
    private TextView lblMessage;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss", Locale
        .getDefault());
    private MainFragmentViewModel viewModel;

    public static MainFragment newInstance(String message) {
        MainFragment mainFragment = new MainFragment();
        Bundle arguments = new Bundle();
        arguments.putString(ARG_MESSAGE, message);
        mainFragment.setArguments(arguments);
        return mainFragment;
    }

    public MainFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
        @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Objects.requireNonNull(getView());
        Objects.requireNonNull(getArguments());
        Objects.requireNonNull(getArguments().getString(ARG_MESSAGE));
        viewModel = ViewModelProviders.of(this, new MainFragmentViewModelFactory(getArguments().getString(ARG_MESSAGE))).get
            (MainFragmentViewModel.class);
        setupViews(getView());
    }

    private void setupViews(View view) {
        lblMessage = ViewCompat.requireViewById(view, R.id.lblMessage);
        btnSaludar = ViewCompat.requireViewById(view, R.id.btnSaludar);
        lblMessage.setText(viewModel.getMessage());
        btnSaludar.setOnClickListener(
            v -> {
                viewModel.setMessage(simpleDateFormat.format(new Date()));
                lblMessage.setText(viewModel.getMessage());
            });
    }

}
