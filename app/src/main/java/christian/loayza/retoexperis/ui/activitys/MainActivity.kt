package christian.loayza.retoexperis.ui.activitys

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import christian.loayza.retoexperis.databinding.ActivityMainBinding
import christian.loayza.retoexperis.domain.model.Place
import christian.loayza.retoexperis.ui.adapters.PlaceAdapter
import christian.loayza.retoexperis.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val placesViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        placesViewModel.inicializar()

        placesViewModel.placeModel.observe(this, Observer {

            val recipeAdapter = PlaceAdapter(it) { itemClick(it) }
            with(binding.rvPlaces) {
                layoutManager = LinearLayoutManager(context)
                adapter = recipeAdapter
            }

        })
        placesViewModel.isLoading.observe(this, Observer {
        })

    }
    private fun itemClick(place: Place?) {
        val extras = Bundle()
        extras.putString("id", place?.id.toString()) // se obtiene el valor mediante getString(...)
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtras(extras)
        startActivity(intent)
       //navegar a detalles
    }
}