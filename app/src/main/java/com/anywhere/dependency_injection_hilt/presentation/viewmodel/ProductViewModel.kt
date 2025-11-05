package com.anywhere.dependency_injection_hilt.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anywhere.dependency_injection_hilt.domain.usecase.GetProductsUseCase
import com.anywhere.dependency_injection_hilt.domain.usecase.RefreshProductsUseCase
import com.anywhere.dependency_injection_hilt.presentation.model.ProductState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel // integrates Hilt with the ViewModel lifecycle, Connects Hilt’s DI with ViewModel’s lifecycle automatically
class ProductViewModel @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase,
    private val refreshProductsUseCase: RefreshProductsUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(ProductState())
    val state: StateFlow<ProductState> = _state.asStateFlow()

    init {
        loadProducts()
        refreshProducts()
    }

    private fun loadProducts() {
        viewModelScope.launch {
            getProductsUseCase.execute()
                .catch { e ->
                    _state.value = _state.value.copy(
                        error = e.message,
                        isLoading = false
                    )
                }
                .collect { products ->
                    _state.value = _state.value.copy(
                        products = products,
                        isLoading = false,
                        error = null
                    )
                }
        }
    }

    fun refreshProducts() {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true)
            try {
                refreshProductsUseCase.execute()
            } catch (e: Exception) {
                _state.value = _state.value.copy(
                    error = e.message,
                    isLoading = false
                )
            }
        }
    }
}