package com.sicoapp.exercise.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.sicoapp.exercise.R
import com.sicoapp.exercise.PrimjerImpl
import com.sicoapp.exercise.adapter.MainRecyclerView
import com.sicoapp.exercise.databinding.MainFragmentBinding
import kotlinx.android.synthetic.main.main_fragment.*


class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var dataBinding: MainFragmentBinding
    private  var movieListAdapter= MainRecyclerView(arrayListOf())

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false )
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        return dataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
       viewModel.fetchFromRemote()
        // TODO: Use the ViewModel
        ispis()
        observeViewModel()
   }

    private fun observeViewModel(){
        viewModel.movies1.observe(this ,androidx.lifecycle.Observer {movies->
            movies?.let {
            moviesList.visibility = View.VISIBLE
            movieListAdapter.updateMoviesList(movies)
        }
        })

    }

    private fun ispis(){


        dataBinding.name.text = PrimjerImpl.prvi().name
        dataBinding.nameDrugi.text = PrimjerImpl.drugi().name
        dataBinding.age.text = PrimjerImpl.prvi().age.toString()
        dataBinding.ageDrugi.text = PrimjerImpl.drugi().age.toString()


        //dataBinding.age.text = PrimjerImpl.prvi().age.toString()
       // dataBinding.ageDrugi.text = PrimjerImpl.prvi().age.toString()

        //var name :TextView = view1!!.findViewById(R.id.name)
       // var year :TextView = view1!!.findViewById(R.id.age)

        //var ime = PrimjerImpl.prvi().name
       // var godine = PrimjerImpl.prvi().age

       // name.text = ime
        //year.text = godine.toString()


    }
}
