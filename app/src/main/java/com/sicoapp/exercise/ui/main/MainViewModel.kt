package com.sicoapp.exercise.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sicoapp.model.ModelPrimjerList1
import com.sicoapp.util.ApiClientWithRxJavaMovieApp
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.android.schedulers.AndroidSchedulers



class MainViewModel : ViewModel() {
    private val _movies = MutableLiveData<ModelPrimjerList1>()
    private val disposable = CompositeDisposable()
    private val movieService = ApiClientWithRxJavaMovieApp()

    val movies1: LiveData<ModelPrimjerList1>
        get()= _movies

    fun fetchFromRemote() {
        disposable.add(
            movieService.getMovies()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<ModelPrimjerList1>(){
                    override fun onSuccess(t: ModelPrimjerList1) {
                        _movies.postValue(t)
                    }

                    override fun onError(e: Throwable) {
                        e.printStackTrace()//To change body of created functions use File | Settings | File Templates.
                    }
                })
        )
    }
}
