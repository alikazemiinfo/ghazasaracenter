package ir.ez4.ghazasaracenter
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.widget.Toast
class NetworkChecker (private val context: Context){





//    val isInterNetConnected:Boolean
//    get() {
//
//        var result = false
//
//        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
//
//        if(Build.VERSION.SDK_INT >=Build.VERSION_CODES.M){
//
//            val chkkardan=connectivityManager.activeNetwork ?:return false
//
//            val internetman=connectivityManager.getNetworkCapabilities(chkkardan)?:return false
//
//            result=when{
//                internetman.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
//
//                internetman.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
//
//                internetman.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
//
//                else -> false
//
//
//
//            }
//
//
//        }
//        else{
//
//            result=when(connectivityManager.activeNetworkInfo?.type) {
//                ConnectivityManager.TYPE_WIFI ->true
//                ConnectivityManager.TYPE_MOBILE ->true
//                ConnectivityManager.TYPE_ETHERNET ->true
//
//                else->false
//
//
//            }
//
//
//        }
//
//
//return result
//}



    val isInternetConnected :Boolean
        get() {


            var result = false
            val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

                val networkCapabilities = connectivityManager.activeNetwork ?: return false
                val myNetwork = connectivityManager.getNetworkCapabilities( networkCapabilities ) ?: return false

                result = when {

                    myNetwork.hasTransport( NetworkCapabilities.TRANSPORT_WIFI ) -> {
                        Toast.makeText(context, "شما به وای فای وصل هستید", Toast.LENGTH_SHORT).show()
                        true
                    }
//s

                    myNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                        Toast.makeText(context, "شما به اینترنت سیم کارت وصل هستید", Toast.LENGTH_SHORT).show()
                        true
                    }

                    myNetwork.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> {
                        Toast.makeText(context, "شما به اینترنت کابل گوشی وصل هستید", Toast.LENGTH_SHORT).show()
                        true
                    }

                    else -> false

                }

            }

            else {


                result = when (connectivityManager.activeNetworkInfo?.type) {

                    ConnectivityManager.TYPE_WIFI -> {
                        Toast.makeText(context, "شما به وای فای وصل هستید", Toast.LENGTH_SHORT).show()
                        true
                    }

                    ConnectivityManager.TYPE_MOBILE -> {
                        Toast.makeText(context, "شما به اینترنت سیم کارت وصل هستید", Toast.LENGTH_SHORT).show()
                        true
                    }



                    ConnectivityManager.TYPE_ETHERNET -> {
                        Toast.makeText(context, "شما به اینترنت کابل گوشی وصل هستید", Toast.LENGTH_SHORT).show()
                        true
                    }

                    else -> false

                }

            }


            return result

        }


    val isWifiConnected :Boolean
        get() {


            var result = false
            val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

                val networkCapabilities = connectivityManager.activeNetwork ?: return false
                val myNetwork = connectivityManager.getNetworkCapabilities( networkCapabilities ) ?: return false

                result = when {

                    myNetwork.hasTransport( NetworkCapabilities.TRANSPORT_WIFI ) -> true

                    myNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> false

                    myNetwork.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> false

                    else -> false

                }

            }

            else {


                result = when (connectivityManager.activeNetworkInfo?.type) {

                    ConnectivityManager.TYPE_WIFI -> true

                    ConnectivityManager.TYPE_MOBILE -> false

                    ConnectivityManager.TYPE_ETHERNET -> false

                    else -> false

                }

            }


            return result

        }


    val isMobileDataConnected :Boolean
        get() {


            var result = false
            val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

                val networkCapabilities = connectivityManager.activeNetwork ?: return false
                val myNetwork = connectivityManager.getNetworkCapabilities( networkCapabilities ) ?: return false

                result = when {

                    myNetwork.hasTransport( NetworkCapabilities.TRANSPORT_WIFI ) -> false

                    myNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true

                    myNetwork.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> false

                    else -> false

                }

            }

            else {


                result = when (connectivityManager.activeNetworkInfo?.type) {

                    ConnectivityManager.TYPE_WIFI -> false

                    ConnectivityManager.TYPE_MOBILE -> true

                    ConnectivityManager.TYPE_ETHERNET -> false

                    else -> false

                }

            }


            return result

        }


    val isEthernetConnected :Boolean
        get() {


            var result = false
            val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

                val networkCapabilities = connectivityManager.activeNetwork ?: return false
                val myNetwork = connectivityManager.getNetworkCapabilities( networkCapabilities ) ?: return false

                result = when {

                    myNetwork.hasTransport( NetworkCapabilities.TRANSPORT_WIFI ) -> false

                    myNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> false

                    myNetwork.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true

                    else -> false

                }

            }

            else {


                result = when (connectivityManager.activeNetworkInfo?.type) {

                    ConnectivityManager.TYPE_WIFI -> false

                    ConnectivityManager.TYPE_MOBILE -> false

                    ConnectivityManager.TYPE_ETHERNET -> true

                    else -> false

                }

            }


            return result

        }


}
