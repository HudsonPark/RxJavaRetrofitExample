package com.example.rxjavaretrofitexample

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.jakewharton.rxbinding2.view.RxView
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.merge
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject
import kotlinx.android.synthetic.main.activity_naver_movie_search.*
import java.util.concurrent.TimeUnit

class NaverMovieSearchActivity : AppCompatActivity(R.layout.activity_naver_movie_search) {

    private val compositeDisposable = CompositeDisposable()

    private val vm by lazy { NaverMovieSearchViewModel() }

    private val naverMovieSearchAdapter = NaverMovieSearchAdapter()

    private val behaviorSubject = BehaviorSubject.createDefault(0L)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        initEvent()
    }

    private fun initView() {
        rv_content.adapter = naverMovieSearchAdapter
    }


    override fun onResume() {
        super.onResume()
        bindViewModel()
    }

    // vm의 각 BehaviorSubject 에 연결 후 각 데이터를 후처리
    private fun bindViewModel() {

        // Events
        val textChange = RxTextView.textChanges(et_input)
            .map { it.toString() }
            .debounce(3000L, TimeUnit.MILLISECONDS, Schedulers.computation())

        val searchClick = RxView.clicks(btn_search)
            .map { et_input.text.toString() }


        // 두 이벤트를 하나로 merge
        listOf(textChange, searchClick)
            .merge()
            .throttleFirst(1000L, TimeUnit.MILLISECONDS)
            .subscribe(vm::searchMovie)
            .addTo(compositeDisposable)

        // UI 관련 작업
        vm.errorSubject
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::showError)
            .addTo(compositeDisposable)

        vm.loadingSubject
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { pb_loading.isVisible = it }
            .addTo(compositeDisposable)

        vm.movieItemsSubject
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(naverMovieSearchAdapter::resetAll)
            .addTo(compositeDisposable)
    }

    override fun onPause() {
        unbindViewModel()
        super.onPause()
    }

    private fun unbindViewModel() {
        vm.unbindViewModel()
    }

    private fun showError(throwable: Throwable) {
        Toast.makeText(this, throwable.message, Toast.LENGTH_SHORT).show()
    }

    override fun onBackPressed() {
        behaviorSubject.onNext(System.currentTimeMillis())
    }

    private fun initEvent() {

        behaviorSubject.buffer(2, 1)
            .map { it[0] to it[1] }
            .subscribe {
                if (it.second - it.first < 2000L) {
                    super.onBackPressed()
                } else {
                    Toast.makeText(this, "앱을 종료하려면 한번 더 눌려주세요.", Toast.LENGTH_SHORT).show()
                }
            }
            .addTo(compositeDisposable)

    }
}
