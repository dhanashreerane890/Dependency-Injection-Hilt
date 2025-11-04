package com.anywhere.dependency_injection_hilt.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.anywhere.dependency_injection_hilt.data.local.dao.ProductDao
import com.anywhere.dependency_injection_hilt.data.local.entity.ProductEntity

@Database(entities = [ProductEntity::class], version = 1)
abstract class ProductDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao
}