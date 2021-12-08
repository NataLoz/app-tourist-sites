package com.jmarti.proyectosemtres.ui.main.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.jmarti.proyectosemtres.databinding.FragmentListBinding
import com.jmarti.proyectosemtres.model.Pointinterest
import com.jmarti.proyectosemtres.model.PointinterestItem
import com.jmarti.proyectosemtres.ui.main.MainActivity


class ListFragment : Fragment() {

    private lateinit var listBinding: FragmentListBinding
    private lateinit var listViewModel: ListViewModel
    private lateinit var pointInterestsAdapter: PointInterestsAdapter
    private var listPointInterests: ArrayList<PointinterestItem> = arrayListOf()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listBinding = FragmentListBinding.inflate(inflater, container, false)
        listViewModel = ViewModelProvider(this)[ListViewModel::class.java]
        return listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity?)?.hideIcon()

        //listPointInterests = loadMockPointInterestsFromJson()
        //pointInterestsAdapter = PointInterestsAdapter(listPointInterests, onItemClicked = {onPointInterestClicked(it)})
        //listViewModel.loadMockPointInterestsFromJson(context?.assets?.open("pointinterests.json"))

        listViewModel.getPointinterestsFromServer()

        listViewModel.onPointinterestsLoaded.observe(viewLifecycleOwner, { result ->
            onPointInterestsLoadedSubscribe(result)
        })

        pointInterestsAdapter = PointInterestsAdapter(listPointInterests, onItemClicked = {onPointInterestClicked(it)})

        listBinding.pointinterestsRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = pointInterestsAdapter
            setHasFixedSize(false)
        }
    }

    private fun onPointInterestsLoadedSubscribe(result: ArrayList<PointinterestItem>?){
        result?.let { listPointInterests ->
            pointInterestsAdapter.appendItems(listPointInterests)

        }
    }

    private fun onPointInterestClicked(pointinterest: PointinterestItem){
        findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(pointinterest = pointinterest))
        //findNavController().navigate(ListFragmentDirections.actionListFragmentToSettingsFragment())
    }

    private fun loadMockPointInterestsFromJson(): ArrayList<PointinterestItem>{
        val pointInterestsString: String = context?.assets?.open("pointinterests.json")?.bufferedReader().use { it!!.readText()} //TODO queda pendiente reparar esta linea en los dos !!
        val gson = Gson()
        val pointInterestsList = gson.fromJson(pointInterestsString, Pointinterest::class.java)
        return pointInterestsList
    }



}