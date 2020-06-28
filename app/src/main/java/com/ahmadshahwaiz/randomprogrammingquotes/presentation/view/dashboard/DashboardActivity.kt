package com.ahmadshahwaiz.randomprogrammingquotes.presentation.view.dashboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.ahmadshahwaiz.randomprogrammingquotes.R
import com.ahmadshahwaiz.randomprogrammingquotes.domain.ConnectivityWatcher
import com.ahmadshahwaiz.randomprogrammingquotes.domain.dagger.Injectable
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import timber.log.Timber
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import javax.inject.Inject

class DashboardActivity : AppCompatActivity(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    @Inject
    lateinit var connectivityWatcher: ConnectivityWatcher

    private val dashboardViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(DashboardViewModel::class.java)
    }

    override fun onResume() {
        super.onResume()
        connectivityWatcher.start(this)
    }

    override fun onPause() {
        super.onPause()
        connectivityWatcher.stop(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startObserving()
        initialCall()
        dashboardViewModel.getRandomQuote()
    }

    private fun initialCall() {
        btnGetQuote.setOnClickListener(View.OnClickListener { view->
            textStatus.text = getString(R.string.label_getting_quotes)
            dashboardViewModel.getRandomQuote()
        })
    }

    private fun startObserving() {
        dashboardViewModel.getQuoteResponse()
            .observe(this, Observer {
                textQuote.text = it.quote
                textAuthor.text = it.author
                textDate.text = it.lastSeenDate
            })

        dashboardViewModel.getRetrievalStatus()
            .observe(this, Observer {
                textStatus.text = it
            })
    }
}