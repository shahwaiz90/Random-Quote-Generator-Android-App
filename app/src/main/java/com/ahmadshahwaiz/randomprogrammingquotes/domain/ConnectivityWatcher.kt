package com.ahmadshahwaiz.randomprogrammingquotes.domain

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.Subject
import kotlin.properties.Delegates


class ConnectivityWatcher() : BroadcastReceiver() {

    private val publisher: Subject<Boolean> = BehaviorSubject.create()
    private var connectivityManager: ConnectivityManager by Delegates.notNull()

    fun connectivity(): Observable<Boolean> = publisher
            .distinctUntilChanged()
            .subscribeOn(Schedulers.io())

    fun start(context: Context) = with(context) {
        registerReceiver(this@ConnectivityWatcher, IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION))
        connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    }

    fun stop(context: Context) = context.unregisterReceiver(this)

    override fun onReceive(context: Context, intent: Intent) = publisher.onNext(isConnectionAvailable())

    private fun isConnectionAvailable() = connectivityManager.activeNetworkInfo?.isConnectedOrConnecting == true
}