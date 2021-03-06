package edu.cs309.cycloneinsider.viewmodels;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;
import io.reactivex.Observable;

import javax.inject.Inject;

import edu.cs309.cycloneinsider.api.CycloneInsiderService;
import edu.cs309.cycloneinsider.api.models.InsiderUserModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Predicate;
import retrofit2.Response;

/**
 * View model for the fragment for an admin to validate a professor
 */
public class AdminProfessorValidateViewModel extends ViewModel {
    private final MutableLiveData<Response<List<InsiderUserModel>>> professorResponse = new MutableLiveData<>();
    private final MutableLiveData<Response<InsiderUserModel>> userToProfessor = new MutableLiveData<>();
    private CycloneInsiderService cycloneInsiderService;

    @Inject
    public AdminProfessorValidateViewModel(CycloneInsiderService cycloneInsiderService) {
        this.cycloneInsiderService = cycloneInsiderService;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }

    public void refresh() {
        Observable<Response<List<InsiderUserModel>>> observable = null;

        observable = cycloneInsiderService.getAllPendingProfs();

        observable.subscribe(professorResponse::postValue);
    }

    /**
     * Method used to take a users uuid and set them to be a professor
     * @param user_uuid UUID of user being set to a professor
     */
    public void setProfessor(String user_uuid) {
        Observable<Response<InsiderUserModel>> observable = null;
        observable = cycloneInsiderService.setUserToProfessor(user_uuid);
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribe(userToProfessor::postValue);
    }

    public LiveData<Response<List<InsiderUserModel>>> getProfessorListResponse() {
        return professorResponse;
    }
}
