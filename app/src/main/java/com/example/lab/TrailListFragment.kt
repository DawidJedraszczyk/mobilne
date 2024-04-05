import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.example.lab.R
import com.example.lab.trails

class TrailListFragment : Fragment() {

    interface OnTrailSelectedListener {
        fun onTrailSelected(trailName: String)
    }

    private var listener: OnTrailSelectedListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as? OnTrailSelectedListener
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_trail_list, container, false)
        val listView: ListView = view.findViewById(R.id.list_view)

        val adapter = ArrayAdapter<String>(
            requireContext(),
            android.R.layout.simple_list_item_1,
            trails.map { it.name }
        )
        listView.adapter = adapter
        listView.setOnItemClickListener { _, _, position, _ ->
            listener?.onTrailSelected(trails[position].name)
        }

        return view
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }
}
