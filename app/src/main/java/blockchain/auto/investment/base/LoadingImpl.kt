package blockchain.auto.investment.base

import com.sparkpool.sparkhub.widget.LoadingDialog

interface LoadingImpl {
    val loadingDialog: LoadingDialog

    fun showLoading() {
        loadingDialog.show()
    }

    fun showUnCancelOutsideLoading() {
        loadingDialog.setCanceledOnTouchOutside(false)
        loadingDialog.show()
    }

    fun hideLoading() {
        loadingDialog.dismiss()
    }

    fun isShowing(): Boolean {
        return loadingDialog.isShowing
    }
}