package edu.cs309.cycloneinsider.di.modules;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import edu.cs309.cycloneinsider.di.ViewModelFactory;
import edu.cs309.cycloneinsider.di.ViewModelKey;
import edu.cs309.cycloneinsider.viewmodels.AdminProfessorValidateViewModel;
import edu.cs309.cycloneinsider.viewmodels.CreatePostViewModel;
import edu.cs309.cycloneinsider.viewmodels.CreateRoomViewModel;
import edu.cs309.cycloneinsider.viewmodels.EditPostViewModel;
import edu.cs309.cycloneinsider.viewmodels.FavoritePostViewModel;
import edu.cs309.cycloneinsider.viewmodels.InviteViewModel;
import edu.cs309.cycloneinsider.viewmodels.JoinRoomViewModel;
import edu.cs309.cycloneinsider.viewmodels.LoginViewModel;
import edu.cs309.cycloneinsider.viewmodels.MyPostListViewModel;
import edu.cs309.cycloneinsider.viewmodels.NewPasswordViewModel;
import edu.cs309.cycloneinsider.viewmodels.PostDetailViewModel;
import edu.cs309.cycloneinsider.viewmodels.PostListViewModel;
import edu.cs309.cycloneinsider.viewmodels.RoomInvitationViewModel;
import edu.cs309.cycloneinsider.viewmodels.SignUpViewModel;
import edu.cs309.cycloneinsider.viewmodels.UserListViewModel;

//import edu.cs309.cycloneinsider.activities.NewPasswordActivity;
//import edu.cs309.cycloneinsider.viewmodels.NewPasswordViewModel;

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(PostListViewModel.class)
    abstract ViewModel bindPostListViewModel(PostListViewModel postListViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(AdminProfessorValidateViewModel.class)
    abstract ViewModel bindAdminProfessorValidateViewModel(AdminProfessorValidateViewModel adminProfessorValidateViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(FavoritePostViewModel.class)
    abstract ViewModel bindFavoritePostViewModel(FavoritePostViewModel favoritePostViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(MyPostListViewModel.class)
    abstract ViewModel bindMyPostListViewModel(MyPostListViewModel myPostListViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel.class)
    abstract ViewModel bindLoginViewModel(LoginViewModel loginViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(CreateRoomViewModel.class)
    abstract ViewModel bindCreateRoomViewModel(CreateRoomViewModel createRoomViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(PostDetailViewModel.class)
    abstract ViewModel bindPostDetailViewModel(PostDetailViewModel postListViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(NewPasswordViewModel.class)
    abstract ViewModel bindNewPasswordViewModel(NewPasswordViewModel newPasswordViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(SignUpViewModel.class)
    abstract ViewModel bindSignUpUpViewModel(SignUpViewModel signUpViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(JoinRoomViewModel.class)
    abstract ViewModel bindJoinRoomViewModel(JoinRoomViewModel signUpViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(InviteViewModel.class)
    abstract ViewModel bindInviteViewModel(InviteViewModel inviteViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(RoomInvitationViewModel.class)
    abstract ViewModel bindRoomInvitationViewModel(RoomInvitationViewModel inviteViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(CreatePostViewModel.class)
    abstract ViewModel bindCreatePostViewModel(CreatePostViewModel createPostViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(EditPostViewModel.class)
    abstract ViewModel bindEditPostViewModel(EditPostViewModel editPostViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(UserListViewModel.class)
    abstract ViewModel bindUserListViewModel(UserListViewModel editPostViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);

}
