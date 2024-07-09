package com.mzhnf.githubuser.fragment.home


import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.mzhnf.core.utils.showToast
import com.mzhnf.githubuser.R
import com.mzhnf.githubuser.adapter.ListRepositoryAdapter
import com.mzhnf.githubuser.databinding.FragmentHomeBinding
import com.mzhnf.githubuser.viewmodel.ViewModel
import com.mzhnf.users.SearchUserActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ViewModel by viewModels()
    private lateinit var loadingDialog: Dialog

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        initView()
        val root: View = binding.root
        val rvRepo = binding.rvRepos
        val adapter = ListRepositoryAdapter()
        rvRepo.layoutManager = LinearLayoutManager(requireContext())
        rvRepo.adapter = adapter
        viewModel.getListRepository()
        viewModel.listRepositoryData.observe(viewLifecycleOwner){listReposResponse->
            if (listReposResponse!=null){
                if (listReposResponse.isLoading){
                    loadingDialog.show()
                }
                if (listReposResponse.error.isNotEmpty()){
                    loadingDialog.dismiss()
                    showToast(requireContext(),listReposResponse.error)
                }
                if (listReposResponse.success!=null){
                    loadingDialog.dismiss()
                    adapter.setData(listReposResponse.success.data)
                }
            }
        }
        binding.ivSearch.setOnClickListener {
            startActivity(Intent(requireContext(),SearchUserActivity::class.java))
        }


        return root
    }
    private fun initView() {
        loadingDialog = Dialog(requireContext())
        val dialogLayout = layoutInflater.inflate(R.layout.dialog_loader, null)

        loadingDialog.let {
            it.setContentView(dialogLayout)
            it.setCancelable(false)
            it.window?.setBackgroundDrawableResource(android.R.color.transparent)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}