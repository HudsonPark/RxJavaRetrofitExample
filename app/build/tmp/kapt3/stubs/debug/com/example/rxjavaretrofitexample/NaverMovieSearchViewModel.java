package com.example.rxjavaretrofitexample;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0013R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001f\u0010\u0005\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001f\u0010\u000b\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\f0\f0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR+\u0010\u000e\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0010 \b*\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f0\u000f0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\n\u00a8\u0006\u0017"}, d2 = {"Lcom/example/rxjavaretrofitexample/NaverMovieSearchViewModel;", "", "()V", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "errorSubject", "Lio/reactivex/subjects/BehaviorSubject;", "", "kotlin.jvm.PlatformType", "getErrorSubject", "()Lio/reactivex/subjects/BehaviorSubject;", "loadingSubject", "", "getLoadingSubject", "movieItemsSubject", "", "Lcom/example/rxjavaretrofitexample/NaverMovieResponse$Item;", "getMovieItemsSubject", "searchMovie", "", "query", "", "unbindViewModel", "app_debug"})
public final class NaverMovieSearchViewModel {
    private final io.reactivex.disposables.CompositeDisposable compositeDisposable = null;
    @org.jetbrains.annotations.NotNull()
    private final io.reactivex.subjects.BehaviorSubject<java.lang.Throwable> errorSubject = null;
    @org.jetbrains.annotations.NotNull()
    private final io.reactivex.subjects.BehaviorSubject<java.lang.Boolean> loadingSubject = null;
    @org.jetbrains.annotations.NotNull()
    private final io.reactivex.subjects.BehaviorSubject<java.util.List<com.example.rxjavaretrofitexample.NaverMovieResponse.Item>> movieItemsSubject = null;
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.subjects.BehaviorSubject<java.lang.Throwable> getErrorSubject() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.subjects.BehaviorSubject<java.lang.Boolean> getLoadingSubject() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.subjects.BehaviorSubject<java.util.List<com.example.rxjavaretrofitexample.NaverMovieResponse.Item>> getMovieItemsSubject() {
        return null;
    }
    
    public final void unbindViewModel() {
    }
    
    public final void searchMovie(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
    }
    
    public NaverMovieSearchViewModel() {
        super();
    }
}