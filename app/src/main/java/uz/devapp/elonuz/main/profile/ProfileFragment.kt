package uz.devapp.elonuz.main.profile

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uz.devapp.elonuz.R
import uz.devapp.elonuz.databinding.FragmentProfileBinding
import uz.devapp.elonuz.main.MainActivity
import uz.devapp.elonuz.splash.SplashActivity
import uz.devapp.elonuz.utils.PrefUtils

class ProfileFragment : Fragment() {
    lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentProfileBinding.inflate(inflater,container,false)
        binding.apply {
            lyLogout.setOnClickListener {
                PrefUtils.clear()
                val i = Intent(requireActivity(), SplashActivity::class.java)
                i.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(i)
            }
        }
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = ProfileFragment()
    }
}