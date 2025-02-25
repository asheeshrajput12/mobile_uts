package com.asheeshk.uts.databse.ui.theme

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.net.Uri

class DbHelper(context:Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "uts_database_01.db"
        private const val DATABASE_VERSION = 1
    }

    override fun onCreate(p0: SQLiteDatabase?) {
        // Tables will be created dynamically based on user input
    }
    private fun createTable(db: SQLiteDatabase, tableName: String, columns: Array<String>) {
        val formattedColumns = columns.joinToString(", ")
        val createTableSQL = "CREATE TABLE IF NOT EXISTS $tableName ($formattedColumns);"
        db.execSQL(createTableSQL)
    }
    fun createTableFromUserInput(db: SQLiteDatabase, tableName: String, columns: Array<String>) {
        createTable(db, tableName, columns)
    }
    fun safeInsert(context: Context, uri: Uri, values: ContentValues): Uri? {
        return context.contentResolver.insert(uri, values)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL("DROP TABLE IF EXISTS users")
        db?.execSQL("DROP TABLE IF EXISTS products")
        onCreate(db)
    }
    fun safeQuery(context: Context, uri: Uri, projection: Array<String>?, selection: String?, selectionArgs: Array<String>?, sortOrder: String?): Cursor? {
        return context.contentResolver.query(uri, projection, selection, selectionArgs, sortOrder)
    }

}