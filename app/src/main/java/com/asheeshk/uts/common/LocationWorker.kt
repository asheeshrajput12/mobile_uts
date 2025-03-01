package com.asheeshk.uts.common

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.provider.Settings
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import kotlinx.coroutines.tasks.await

class LocationWorker(
    private val context: Context,
    workerParams: WorkerParameters
) : CoroutineWorker(context, workerParams) {

    private val fusedLocationClient: FusedLocationProviderClient =
        LocationServices.getFusedLocationProviderClient(context)

    override suspend fun doWork(): Result {
         try {
            // ✅ 1️⃣ Check location permission
            if (!isLocationPermissionGranted()) {
                Log.e("LocationWorker", "Location permission NOT granted.")
                return Result.failure(workDataOf("error" to "Location permission not granted"))
            }

            // ✅ 2️⃣ Check if GPS/Location is enabled
            if (!isLocationEnabled()) {
                Log.e("LocationWorker", "GPS is disabled.")
                return Result.failure(workDataOf("error" to "GPS is disabled"))
            }

            // ✅ 3️⃣ Fetch Last Known Location
            val location = getLastKnownLocation()
            return if (location != null) {
                val outputData = workDataOf(
                    "latitude" to location.latitude,
                    "longitude" to location.longitude
                )
                Log.d("LocationWorker", "Lat: ${location.latitude}, Lng: ${location.longitude}")
                Result.success(outputData) // 🔥 Return location
            } else {
                Log.e("LocationWorker", "Failed to fetch location")
                Result.failure(workDataOf("error" to "Failed to get location"))
            }
        } catch (e: Exception) {
            Log.e("LocationWorker", "Error fetching location", e)
            return Result.failure(workDataOf("error" to "Exception: ${e.message}"))
        }
    }

    private fun isLocationPermissionGranted(): Boolean {
        return ContextCompat.checkSelfPermission(
            applicationContext, Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
    }

    private fun isLocationEnabled(): Boolean {
        val locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) ||
                locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
    }

    private suspend fun getLastKnownLocation(): Location? {
        return try {
            fusedLocationClient.lastLocation.await()
        } catch (e: SecurityException) {
            Log.e("LocationWorker", "Location permission missing", e)
            null
        } catch (e: Exception) {
            Log.e("LocationWorker", "Error getting location", e)
            null
        }
    }
}

