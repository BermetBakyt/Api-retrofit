package com.ber.testtaskattr

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.ber.testtaskattr.databinding.FragmentMainBinding
import com.bumptech.glide.Glide
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainFragment: Fragment(R.layout.fragment_main) {
private val api get() = Injector.personalDataApi
    private var _binding: FragmentMainBinding?= null
    private val binding get() = _binding!!
    private lateinit var listener: Navigation

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as Navigation
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMainBinding.bind(view)

        binding.apply {
            api.getAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSuccess {
                    val img = imageView
                    Glide.with(requireContext())
                        .load(it.user.photo)
                        .into(img)

                    name.text = "Name: ${it.user.first_name}"
                    lastname.text = "Last name : ${it.user.second_name}"
                    education.text = when( it.user.education) {
                        1 -> "high school"
                        2-> "bachelor"
                        3 ->  "master"
                        else -> {
                            "doctoral"
                        }
                    }
                    companyName.text = "Company : ${it.user.company.name}"
                    companyPosition.text = "Position : ${it.user.company.position}"
                    }
                .doOnError {
                    Toast.makeText(requireContext(), "Error!", Toast.LENGTH_LONG).show()
                }
                .subscribe()

            openGallery.setOnClickListener {
                listener.onButtonClicked()
            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}