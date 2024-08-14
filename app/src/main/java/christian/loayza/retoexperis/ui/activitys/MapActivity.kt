package christian.loayza.retoexperis.ui.activitys

import android.R
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ReportFragment.Companion.reportFragment

import christian.loayza.retoexperis.databinding.ActivityMapBinding
import com.google.android.gms.maps.CameraUpdate
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MapActivity : AppCompatActivity(), OnMapReadyCallback {
    var latitud: Double = 0.0
    var longitud: Double = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(christian.loayza.retoexperis.R.layout.activity_map)
        val parametros = this.intent.extras
        if (parametros != null) {
            val coordenadasx = parametros.getString("coordenadasx")
            val coordenadasy = parametros.getString("coordenadasy")
            if (coordenadasx != null) {
                latitud = coordenadasx.toDouble()
            }
            if (coordenadasy != null) {
                longitud = coordenadasy.toDouble()
            }

        }

        val mapFragment = SupportMapFragment.newInstance()
        supportFragmentManager
            .beginTransaction()
            .add(christian.loayza.retoexperis.R.id.fMap, mapFragment)
            .commit()
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(p0: GoogleMap) {
        val latLng = LatLng(latitud, longitud)
        p0.addMarker(MarkerOptions().position(latLng))
        val cameraUpdate: CameraUpdate = CameraUpdateFactory.newLatLngZoom(latLng, 15f)
        p0.moveCamera(cameraUpdate)
        p0.animateCamera(cameraUpdate)
    }
}