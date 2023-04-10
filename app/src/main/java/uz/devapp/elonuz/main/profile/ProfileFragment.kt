package uz.devapp.elonuz.main.profile

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import uz.devapp.elonuz.R
import uz.devapp.elonuz.databinding.FragmentProfileBinding
import uz.devapp.elonuz.main.MainActivity
import uz.devapp.elonuz.splash.SplashActivity
import uz.devapp.elonuz.utils.PrefUtils

class ProfileFragment : Fragment() {
    lateinit var binding: FragmentProfileBinding
    lateinit var viewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentProfileBinding.inflate(inflater,container,false)
        binding.apply {
            viewModel=ViewModelProvider(requireActivity())[ProfileViewModel::class.java]

            viewModel.errorLiveData.observe(requireActivity()){
                Toast.makeText(requireActivity(), it, Toast.LENGTH_SHORT).show()
            }

            viewModel.progressLiveData.observe(requireActivity()){
                flProgress.visibility = if (it) View.VISIBLE else View.GONE
            }

            viewModel.userListLiveData.observe(requireActivity()){
                tvName.text=it.fullname
                tvPhone.text=it.phone
            }

            lyLogout.setOnClickListener {
                PrefUtils.clear()
                val i = Intent(requireActivity(), SplashActivity::class.java)
                i.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(i)
            }
            viewModel.getUser()
        }
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = ProfileFragment()
    }
}