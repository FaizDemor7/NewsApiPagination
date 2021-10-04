package com.example.newslistactivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder as  LivePagedListBuilder
import androidx.paging.PagedList
import com.google.ar.core.Config
import io.reactivex.disposables.CompositeDisposable

class NewsListViewModel: ViewModel(){
    private val networkService = NetworkService.getService()
    lateinit var newsList: LiveData<PagedList<News>>
    private val compositeDisposable = CompositeDisposable()
    private val pageSize = 5
    private val newsDataSourceFactory: NewsDataSourceFactory


    init {
        newsDataSourceFactory = NewsDataSourceFactory(compositeDisposable, networkService)
    }

        fun getState(): LiveData<State> = Transformations.switchMap(
        newsDataSourceFactory.newsDataSourceLiveData,
        NewsDataSource::state
    )

    fun retry() {
        val config = PagedList.Config.Builder()
            .setPageSize(pageSize)
            .setInitialLoadSizeHint(pageSize * 2)
            .setEnablePlaceholders(false)
            .build()
       // newsList = LivePagedListBuilder(newsDataSourceFactory, config).build()
    }

    fun listIsEmpty(): Boolean {
        return newsList.value?.isEmpty() ?: true
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

}



