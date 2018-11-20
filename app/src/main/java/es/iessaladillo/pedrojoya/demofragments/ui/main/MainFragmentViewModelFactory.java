package es.iessaladillo.pedrojoya.demofragments.ui.main;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class MainFragmentViewModelFactory implements ViewModelProvider.Factory {

    private final String message;

    public MainFragmentViewModelFactory(String message) {
        this.message = message;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        //noinspection unchecked
        return (T) new MainFragmentViewModel(message);
    }

}
