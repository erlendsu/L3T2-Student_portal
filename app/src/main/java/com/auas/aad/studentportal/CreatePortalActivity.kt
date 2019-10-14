package com.auas.aad.studentportal

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_create_portal.*

const val EXTRA_PORTAL = "EXTRA_PORTAL"

class CreatePortalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_portal)
        initViews()
    }

    private fun initViews() {
        btnAddPortal.setOnClickListener { onAddPortalClick() }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.create_portal_title)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> return super.onOptionsItemSelected(item!!)
        }
    }

    private fun onAddPortalClick() {
        val portalTitle: String = etPortalTitle.text.toString()
        val portalUrl: String = etPortalUrl.text.toString()
        if(portalTitle.isBlank() || portalUrl.isBlank()) {
            return Toast.makeText(applicationContext, getString(R.string.invalid_form), Toast.LENGTH_SHORT).show()
        }
        val portal = Portal(portalTitle, portalUrl)
        val resultIntent = Intent()
        resultIntent.putExtra(EXTRA_PORTAL, portal)
        setResult(Activity.RESULT_OK, resultIntent)
        finish()
    }

}