package me.sweetll.tucao.rxdownload2.entity

import com.raizlabs.android.dbflow.annotation.Column
import com.raizlabs.android.dbflow.annotation.PrimaryKey
import com.raizlabs.android.dbflow.annotation.Table
import me.sweetll.tucao.rxdownload2.db.TucaoDatabase
import java.io.File

@Table(database = TucaoDatabase::class)
data class DownloadBean(@PrimaryKey var url: String = "",
                        @Column var etag: String = "",
                        @Column var lastModified: String = "",
                        @Column var contentLength: Long = 0L,
                        @Column var downloadLength: Long = 0L,
                        @Column var saveName: String = "",
                        @Column var savePath: String = "") {
    fun getRange(): String {
        return "bytes=$downloadLength-"
    }

    fun getIfRange(): String {
        return lastModified
    }

    fun getFile(): File {
        return File(savePath, saveName)
    }
}