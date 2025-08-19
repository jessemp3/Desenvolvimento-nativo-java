package com.nativo.mvvm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    //livedata
    private MutableLiveData<String> _login = new MutableLiveData<>();

    // com o login message e o _login eu tiro a possilidade de alteração do _login message fora da viewModel
    public LiveData<String> loginMessage(){
        return _login;
    }

    public void login(String name) {

        if(name == null || name.isEmpty()) {
            _login.setValue("falha");
        } else{
            _login.setValue("sucesso");
        }
    }
}
