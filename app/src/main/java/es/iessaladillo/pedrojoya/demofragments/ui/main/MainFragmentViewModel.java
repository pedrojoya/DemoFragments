package es.iessaladillo.pedrojoya.demofragments.ui.main;

import androidx.lifecycle.ViewModel;

public class MainFragmentViewModel extends ViewModel {

    private String message;

    public MainFragmentViewModel(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
