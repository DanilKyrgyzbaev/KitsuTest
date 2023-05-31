package kg.geekstudio.kitsutest.main.signIn

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.navDeepLink
import base.BaseFragment
import kg.geekstudio.kitsutest.data.local.TokenPreferences
import kg.geekstudio.kitsutest.main.R
import kg.geekstudio.kitsutest.main.databinding.FragmentSigninBinding
import kotlinx.coroutines.ExperimentalCoroutinesApi
import model.auth.Auth
import org.koin.androidx.viewmodel.ext.android.viewModel
import state.UIState
import ui_helpers.showError

@ExperimentalCoroutinesApi
class SigninFragment : BaseFragment<SigninViewModel, FragmentSigninBinding>(FragmentSigninBinding::inflate) {
    override val viewModel by viewModel<SigninViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun initialize() {}

    override fun setupListeners() {
        signIn()
    }
////mlprtcvblender09
////erkanybekov@gmail.com

    private fun signIn() = with(binding) {
        signin.setOnClickListener {
            when {
                emailEditText.text.toString()
                    .isEmpty() -> emailLayout.showError(
                    getString(R.string.error_field_is_required)
                )

                passwordEditText.text.toString()
                    .isEmpty() -> passwordLayout.showError(
                    getString(R.string.error_field_is_required)
                )

                else -> {
                    viewModel.auth(
                        Auth(
                            "password",
                            binding.emailEditText.text.toString(),
                            binding.passwordEditText.text.toString()
                        )
                    )
                }
            }
        }
    }

    override fun setupObservers() {
        viewModel.token.observe(viewLifecycleOwner){ uiState ->
            when (uiState) {
                is UIState.Success ->{
                    findNavController().navigate(R.id.action_signinFragment_to_homeFragment)
                }
                is UIState.Error ->{
                    val errorMessage = uiState.error
                    Toast.makeText(activity,"$errorMessage",Toast.LENGTH_SHORT).show();
                }
                is UIState.Loading -> {
                    // Обработка состояния загрузки
                }
            }
        }
    }
}
