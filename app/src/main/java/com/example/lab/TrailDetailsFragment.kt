import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.lab.R

class TrailDetailsFragment : Fragment() {

    companion object {
        private const val ARG_TRAIL_NAME = "trailName"

        fun newInstance(trailName: String): TrailDetailsFragment {
            val fragment = TrailDetailsFragment()
            val args = Bundle()
            args.putString(ARG_TRAIL_NAME, trailName)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_trail_details, container, false)
        val trailName = arguments?.getString(ARG_TRAIL_NAME)
        view.findViewById<TextView>(R.id.trail_name).text = trailName
        // Ustaw inne szczegóły szlaku używając trailName do wyszukania ich w twojej liście `trails`
        return view
    }
}
