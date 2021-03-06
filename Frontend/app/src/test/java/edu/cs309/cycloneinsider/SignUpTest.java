package edu.cs309.cycloneinsider;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

import edu.cs309.cycloneinsider.api.CycloneInsiderService;
import edu.cs309.cycloneinsider.api.models.SignUpRequestModel;
import edu.cs309.cycloneinsider.viewmodels.SignUpViewModel;
import io.reactivex.Observable;
import retrofit2.Response;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SignUpTest {
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Rule
    public TestRule rule = new InstantTaskExecutorRule();


    /**
     * Mocks a successful sign by a user passing in the correct credentials
     */
    @Test
    public void successfulSignUp() {
        CycloneInsiderService service = mock(CycloneInsiderService.class);
        Response<Void> success = Response.success(null);
        SignUpRequestModel signUpRequestModel = new SignUpRequestModel("Ethan", "Evans", "edevans", "Password1", false);
        when(service.signUp(signUpRequestModel)).thenReturn(Observable.just(success));
        SignUpViewModel signUpViewModel = new SignUpViewModel(service);
        signUpViewModel.signUp(signUpRequestModel);
        assertFalse(signUpViewModel.getSignUpResponse().getValue().isError());
        assertEquals(signUpViewModel.getSignUpResponse().getValue().getRawResponse(), success);
    }

    /**
     * Showing what happens when a invalid first name is entered and being sure that the right
     * error is being displayed
     */
    @Test
    public void incorrectFirstName() {
        CycloneInsiderService service = mock(CycloneInsiderService.class);
        SignUpViewModel signUpViewModel = new SignUpViewModel(service);
        SignUpRequestModel signUpRequestModel = new SignUpRequestModel("Ethan ", "Evans", "edevans", "Password1", false);
        signUpViewModel.signUp(signUpRequestModel);
        assertTrue(signUpViewModel.getSignUpResponse().getValue().isError());
        assertEquals(signUpViewModel.getSignUpResponse().getValue().getStringError(), R.string.error_sign_up_only_one_name);
    }

    /**
     * Showing what happens when a first name is not entered and being sure that the right
     * error is being displayed
     */
    @Test
    public void errorFirstNameLength() {
        CycloneInsiderService service = mock(CycloneInsiderService.class);
        SignUpViewModel signUpViewModel = new SignUpViewModel(service);
        SignUpRequestModel signUpRequestModel = new SignUpRequestModel("", "Evans", "edevans", "Password1", false);
        signUpViewModel.signUp(signUpRequestModel);
        assertTrue(signUpViewModel.getSignUpResponse().getValue().isError());
        assertEquals(signUpViewModel.getSignUpResponse().getValue().getStringError(), R.string.error_name_length);
    }

    /**
     * Showing what happens when a invalid last name is entered and being sure that the right
     * error is being displayed
     */
    @Test
    public void incorrectLastName() {
        CycloneInsiderService service = mock(CycloneInsiderService.class);
        SignUpViewModel signUpViewModel = new SignUpViewModel(service);
        SignUpRequestModel signUpRequestModel = new SignUpRequestModel("Ethan", "Evans ", "edevans", "Password1", false);
        signUpViewModel.signUp(signUpRequestModel);
        assertTrue(signUpViewModel.getSignUpResponse().getValue().isError());
        assertEquals(signUpViewModel.getSignUpResponse().getValue().getStringError(), R.string.error_sign_up_only_one_name);
    }

    /**
     * Showing what happens when a last name is not entered and being sure that the right
     * error is being displayed
     */
    @Test
    public void errorLastNameLength() {
        CycloneInsiderService service = mock(CycloneInsiderService.class);
        SignUpViewModel signUpViewModel = new SignUpViewModel(service);
        SignUpRequestModel signUpRequestModel = new SignUpRequestModel("Ethan", "", "edevans", "Password1", false);
        signUpViewModel.signUp(signUpRequestModel);
        assertTrue(signUpViewModel.getSignUpResponse().getValue().isError());
        assertEquals(signUpViewModel.getSignUpResponse().getValue().getStringError(), R.string.error_name_length);
    }

    /**
     * Showing what happens when a username is not entered and being sure that the right
     * error is being displayed
     */
    @Test
    public void errorUserNameLength() {
        CycloneInsiderService service = mock(CycloneInsiderService.class);
        SignUpViewModel signUpViewModel = new SignUpViewModel(service);
        SignUpRequestModel signUpRequestModel = new SignUpRequestModel("Ethan", "Evans", "", "Password1", false);
        signUpViewModel.signUp(signUpRequestModel);
        assertTrue(signUpViewModel.getSignUpResponse().getValue().isError());
        assertEquals(signUpViewModel.getSignUpResponse().getValue().getStringError(), R.string.error_username_length);
    }

    /**
     * Showing what happens when an incorrect password is entered and being sure that the right
     * error is being displayed
     */
    @Test
    public void incorrectPassword() {
        CycloneInsiderService service = mock(CycloneInsiderService.class);
        SignUpViewModel signUpViewModel = new SignUpViewModel(service);
        SignUpRequestModel signUpRequestModel = new SignUpRequestModel("Ethan", "Evans", "edevans", "pass", false);
        signUpViewModel.signUp(signUpRequestModel);
        assertTrue(signUpViewModel.getSignUpResponse().getValue().isError());
    }
}
