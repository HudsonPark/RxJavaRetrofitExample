package com.example.rxjavaretrofitexample

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.subjects.BehaviorSubject

class NaverMovieSearchViewModel {

    private val compositeDisposable = CompositeDisposable()
    val errorSubject = BehaviorSubject.create<Throwable>()
    val loadingSubject = BehaviorSubject.createDefault(false)
    val movieItemsSubject = BehaviorSubject.create<List<NaverMovieResponse.Item>>()

    fun unbindViewModel() {
        compositeDisposable.clear()
    }

    fun searchMovie(query : String){

        NetworkManager.naverApi.getMovies(query)
            .doOnSubscribe { loadingSubject.onNext(true) }
            .doAfterTerminate { loadingSubject.onNext(false) }
            .map {it.items}
            .subscribe(movieItemsSubject::onNext, errorSubject::onNext)
            .addTo(compositeDisposable)

    }
}