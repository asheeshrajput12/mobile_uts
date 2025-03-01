package com.asheeshk.uts.common

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkInfo
import androidx.work.WorkManager

class CommonFunction {
    fun startLocationWorker(context: Context): LiveData<WorkInfo?> {
        val workRequest = OneTimeWorkRequestBuilder<LocationWorker>().build()
        val workManager = WorkManager.getInstance(context)
        WorkManager.getInstance(context).enqueueUniqueWork(
            "UniqueLocationWorker",  // 🔥 Unique Work Name
            ExistingWorkPolicy.KEEP, // ✅ Prevents duplicate requests
            workRequest
        )

        // Observe the worker's status and result
        return workManager.getWorkInfoByIdLiveData(workRequest.id)
    }
}