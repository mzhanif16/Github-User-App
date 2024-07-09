package com.mzhnf.users

import android.app.Dialog
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.mzhnf.core.utils.showToast
import com.mzhnf.users.databinding.ActivitySearchUserBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchUserActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySearchUserBinding
    private val viewModel: SearchUserViewModel by viewModels()
    private lateinit var progressDialog: Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        progressDialog = initView(this, this)
        val adapter = SearchUserAdapter()
        val rvSearch = binding.rvSearch
        rvSearch.layoutManager = LinearLayoutManager(this)
        rvSearch.adapter = adapter
        binding.edtSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val query = p0.toString()
                if (query.isNotEmpty()) {
                    viewModel.searchUser(query)
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })
        viewModel.searchUserData.observe(this){
            if (it!=null){
                if (it.isLoading){
//                    binding.loading.visibility = View.VISIBLE
                    binding.loadingLottie.visibility = View.VISIBLE
                    binding.rvSearch.visibility = View.GONE
                    binding.layoutEmpty.visibility = View.GONE
                }
                if (it.error.isNotEmpty()){
//                    binding.loading.visibility = View.GONE
                    binding.loadingLottie.visibility = View.GONE
                    binding.rvSearch.visibility = View.GONE
                    binding.layoutEmpty.visibility = View.GONE
                    showToast(this,it.error)
                }
                if (it.success!=null){
//                    binding.loading.visibility = View.GONE
                    binding.loadingLottie.visibility = View.GONE
                    binding.layoutEmpty.visibility = View.GONE
                    binding.rvSearch.visibility = View.VISIBLE
                    adapter.setData(it.success.data)
                    if (it.success.data.size == 0){
                        binding.layoutEmpty.visibility = View.VISIBLE
                    }else{
                        binding.layoutEmpty.visibility = View.GONE
                    }
                }
            }
        }
    }
}