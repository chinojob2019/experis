package christian.loayza.retoexperis.ui.activitys

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import christian.loayza.retoexperis.databinding.ActivityDetailsBinding
import christian.loayza.retoexperis.ui.adapters.PlaceAdapter
import christian.loayza.retoexperis.ui.helpers.load
import christian.loayza.retoexperis.ui.viewmodel.DetailsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding
    private var coordenadasx = ""
    private var coordenadasy = ""
    private val detailsViewModel: DetailsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val parametros = this.intent.extras
        if (parametros != null) {
            val datos = parametros.getString("id")
            detailsViewModel.inicializar(datos!!)
        }
        detailsViewModel.detailsModel.observe(this, Observer {
            binding.tvTitle.text = it.title
            binding.tvDescription.text = it.description
            binding.tvInfo.text = it.info
            binding.imgPlace.load(it.photo)
            binding.tvAddress.text = it.place
            coordenadasx = it.coordenadax!!
            coordenadasy = it.coordenaday!!
        })

        binding.btnMapa.setOnClickListener {
            val intent = Intent(this, MapActivity::class.java)
            intent.putExtra("coordenadasx", coordenadasx)
            intent.putExtra("coordenadasy", coordenadasy)
            startActivity(intent)
        }
    }
}