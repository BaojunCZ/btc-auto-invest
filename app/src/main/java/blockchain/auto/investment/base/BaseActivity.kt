package blockchain.auto.investment.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import blockchain.auto.investment.dialog.LoadingDialog

abstract class BaseActivity<B : ViewDataBinding> : AppCompatActivity(), LoadingImpl {
    override val loadingDialog by lazy { LoadingDialog(this) }

    private lateinit var binding: B

    protected abstract val contentLayout: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, contentLayout)
        binding.lifecycleOwner = this
        initData()
        initObserver()
        initAction()
    }

    open fun initData() {}

    open fun initAction() {}

    open fun initObserver() {}

    override fun onDestroy() {
        hideLoading()
        super.onDestroy()
    }
}