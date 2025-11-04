package com.anywhere.dependency_injection_hilt.di

import android.content.Context
import androidx.room.Room
import com.anywhere.dependency_injection_hilt.data.local.dao.ProductDao
import com.anywhere.dependency_injection_hilt.data.local.database.ProductDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module //
@InstallIn(SingletonComponent::class) // module’s dependencies should live as long as the entire app
object DatabaseModule {

    @Provides
    @Singleton
    fun provideProductDatabase(
        @ApplicationContext context: Context
    ): ProductDatabase {
        return Room.databaseBuilder(
            context,
            ProductDatabase::class.java,
            "product_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideProductDao(database: ProductDatabase): ProductDao {
        return database.productDao()
    }
}