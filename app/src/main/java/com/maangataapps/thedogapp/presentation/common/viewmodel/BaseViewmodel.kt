package com.maangataapps.thedogapp.presentation.common.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import arrow.core.Either
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

abstract class BaseViewmodel : ViewModel() {

    private val _onError = MutableLiveData<String?>()
    val onError: LiveData<String?>
        get() = _onError

    private var coroutineContext: CoroutineDispatcher = Dispatchers.IO
    private var coroutineContextReturn: CoroutineDispatcher = Dispatchers.Main
    private val job = SupervisorJob()

    fun setErrorMessage(message: String) {
        _onError.value = message
    }

    fun <T> launch(
        success: (T) -> Unit,
        error: ((Throwable) -> Unit)? = null,
        block: suspend () -> Either<Throwable, T>
    ) {
        CoroutineScope(coroutineContext + job).launch(coroutineContext) {
            block().fold({
                launch(coroutineContextReturn) {
                    error?.invoke(it)
                }
            }) {
                launch(coroutineContextReturn) {
                    success(it)
                }
            }
        }
    }

}