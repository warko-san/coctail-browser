package com.warko.coctailbrowser.common.di

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

@MapKey
annotation class ViewModelKey(val clazz: KClass<out ViewModel>)