package ir.ez4.fragmenttest

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import ir.ez4.ghazasaracenter.databinding.PopupSabtnamBinding

class MainDialog(private val mainDialogeven: MainDialogeven):BottomSheetDialogFragment() {

    lateinit var binding:PopupSabtnamBinding

    // این قسمت برای باتم شیت هستش که از پایین برای ما ویو باز می کنه

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //نیازی به این مورد نیست
//        val dialog = AlertDialog.Builder(requireContext())

        binding = PopupSabtnamBinding.inflate(layoutInflater, null, false)

        // نیازی به این مورد نیست
//        dialog.setView(binding.root)





        binding.btnTaidFragdialog.setOnClickListener {
            val esm = binding.edtVorodiNameInfrag1.text.toString()
            val familyname = binding.edtVorodiNamekhanevadegiInfrag1.text.toString()
            val etebar=binding.edtEtebar.text.toString()
            if (esm.isNotEmpty() && familyname.isNotEmpty()&&etebar.isNotEmpty()) {

                if (esm.isEmpty()){

                    binding.nameNamayeshi.isErrorEnabled=true
                    binding.nameNamayeshi.error="لطفا نام خود را وارد نمایید"

                }else if (esm.isNotEmpty()){

                    binding.nameNamayeshi.isErrorEnabled=false
                }
//s
                if (familyname.isEmpty()){

                    binding.lastnameNamayeshi.isErrorEnabled=true
                    binding.lastnameNamayeshi.error="لطفا نام خانوادگی خود را وارد نمایید"

                }else if (familyname.isNotEmpty()){

                    binding.lastnameNamayeshi.isErrorEnabled=false
                }
                if (etebar.isEmpty()){

                    binding.etebarNamayeshi.isErrorEnabled=true
                    binding.etebarNamayeshi.error="لطفا میزان اعتبار خود را به تومان وارد نمایید"

                }else if (etebar.isNotEmpty()){

                    binding.etebarNamayeshi.isErrorEnabled=false
                }

                dismiss()
                mainDialogeven.sent_text_data("$esm $familyname ")
                mainDialogeven.sent_etebar_mizan(etebar)

            } else {

                if (esm.isEmpty()){

                    binding.nameNamayeshi.isErrorEnabled=true
                    binding.nameNamayeshi.error="لطفا نام خود را وارد نمایید"

                }else if (esm.isNotEmpty()){

                    binding.nameNamayeshi.isErrorEnabled=false
                }

                if (familyname.isEmpty()){

                    binding.lastnameNamayeshi.isErrorEnabled=true
                    binding.lastnameNamayeshi.error="لطفا نام خانوادگی خود را وارد نمایید"

                }else if (familyname.isNotEmpty()){

                    binding.lastnameNamayeshi.isErrorEnabled=false
                }
                if (etebar.isEmpty()){

                    binding.etebarNamayeshi.isErrorEnabled=true
                    binding.etebarNamayeshi.error="لطفا میزان اعتبار خود را به تومان وارد نمایید"

                }else if (etebar.isNotEmpty()){

                    binding.etebarNamayeshi.isErrorEnabled=false
                }
                Toast.makeText(
                    context,
                    "لطفا موارد قرمز رنگ را وارد نمایید",
                    Toast.LENGTH_SHORT
                ).show()

            }
        }


        binding.btnCancelFragdialog.setOnClickListener {

            dismiss()

        }

//        val view = LayoutInflater(context).inflate(R.layout.dialog_frag1,null,false)


        return binding.root
    }

    //این قسمت برای پاپ آپ هستش

    //    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
//        val dialog = AlertDialog.Builder(requireContext())
//
//        binding = DialogFrag1Binding.inflate(layoutInflater, null, false)
//
//        dialog.setView(binding.root)
//
//
//
//
//
//        binding.btnTaidFragdialog.setOnClickListener {
//            val esm = binding.edtVorodiNameInfrag1.text.toString()
//            val familyname = binding.edtVorodiNamekhanevadegiInfrag1.text.toString()
//
//            if (esm.isNotEmpty() && familyname.isNotEmpty()) {
//
//                if (esm.isEmpty()){
//
//                    binding.nameNamayeshi.isErrorEnabled=true
//                    binding.nameNamayeshi.error="لطفا نام خود را وارد نمایید"
//
//                }else if (esm.isNotEmpty()){
//
//                    binding.nameNamayeshi.isErrorEnabled=false
//                }
//
//                if (familyname.isEmpty()){
//
//                    binding.lastnameNamayeshi.isErrorEnabled=true
//                    binding.lastnameNamayeshi.error="لطفا نام خانوادگی خود را وارد نمایید"
//
//                }else if (familyname.isNotEmpty()){
//
//                    binding.lastnameNamayeshi.isErrorEnabled=false
//                }
//
//                    dismiss()
//                mainDialogeven.sent_text_data("$esm $familyname")
//
//
//                } else {
//
//                    if (esm.isEmpty()){
//
//                        binding.nameNamayeshi.isErrorEnabled=true
//                        binding.nameNamayeshi.error="لطفا نام خود را وارد نمایید"
//
//                    }else if (esm.isNotEmpty()){
//
//                        binding.nameNamayeshi.isErrorEnabled=false
//                    }
//
//                if (familyname.isEmpty()){
//
//                    binding.lastnameNamayeshi.isErrorEnabled=true
//                    binding.lastnameNamayeshi.error="لطفا نام خانوادگی خود را وارد نمایید"
//
//                }else if (familyname.isNotEmpty()){
//
//                    binding.lastnameNamayeshi.isErrorEnabled=false
//                }
//                    Toast.makeText(
//                        context,
//                        "لطفا موارد قرمز رنگ را وارد نمایید",
//                        Toast.LENGTH_SHORT
//                    ).show()
//
//                }
//            }
//
//
//            binding.btnCancelFragdialog.setOnClickListener {
//
//                dismiss()
//
//            }
//
////        val view = LayoutInflater(context).inflate(R.layout.dialog_frag1,null,false)
//
//
//        return dialog.create()
//    }
    interface MainDialogeven {

        fun sent_text_data(data:String)
        fun sent_etebar_mizan(data: String)



    }
}