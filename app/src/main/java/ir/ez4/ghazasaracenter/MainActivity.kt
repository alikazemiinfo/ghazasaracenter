package ir.ez4.ghazasaracenter


import android.annotation.SuppressLint
import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Adapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.core.view.isNotEmpty
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import ir.ez4.fragmenttest.MainDialog
import ir.ez4.ghazasaracenter.databinding.ActivityMainBinding
import ir.ez4.ghazasaracenter.databinding.DeletingItemBinding
import ir.ez4.ghazasaracenter.databinding.LayoutEzafeFoodBinding
import ir.ez4.ghazasaracenter.databinding.LayoutUpdateFoodBinding
import java.lang.Exception
import kotlin.collections.ArrayList
import kotlin.random.Random

const val TAG="Main_Activity_called"

class MainActivity : AppCompatActivity(),Myadaptor.Karhayghaza,MainDialog.MainDialogeven {
    private lateinit var binding: ActivityMainBinding
    lateinit var myadaptor: Myadaptor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.v(TAG,"اجرا شد")

        if ( NetworkChecker(this).isInternetConnected ) {

        }else{
            Toast.makeText(this, "جهت استفاده از نرم افزار دسترسی به اینترنت لازم است لطفا اینترنت خود را مجدد بررسی نمایید", Toast.LENGTH_SHORT).show()

        }


        val listghaza= arrayListOf(







            khodghaza("باقالی پلو با گوشت","علی کاظمی","120 هزار","2",3.4f,"3.4","https://sv1.donateon.ir/uploads/layouts/bHfzPlKYazeSp95d7neQO8byfg62jHyFVkHYP3oB.jpg"),
            khodghaza("آش", "مهندس ای کی وی","1میلیون","180",0.1f,"0.4","https://sv1.donateon.ir/uploads/layouts/3mX2IrYlFDdIvPnC7OLFD6ejpXCvncVctXbYXaaY.jpg"),
            khodghaza("آبگوشت","نظام آباد","30 هزار","0.2",5f,"5","https://sv1.donateon.ir/uploads/layouts/62ns8XFQm6HZcbGxUXX3Ed5udabstqTC2SjGGp75.jpg"),
            khodghaza("کباب","نظام آباد سیتی","250 هزار","0.1",5f,"5","https://sv1.donateon.ir/uploads/layouts/RTbrqnxnGqtAQL8RLFMuA0RokIK88cyez37oyiot.jpg"),
            khodghaza("کتلت و شامی","تهران پارس","10 هزار","1",2.4f,"2.4","https://sv1.donateon.ir/uploads/layouts/SF2EUB7Sgo9yyzRrpBUPeBd7sRPaXZfj6WAdx6dT.jpg"),
            khodghaza("خورش قیمه","شوش","78هزار","4.5",4.4f,"4.4","https://sv1.donateon.ir/uploads/layouts/4DzuxeFekQk9qVa7EuqQ4OAvQCZLqE8P042Mv0lf.jpg"),
            khodghaza("خورش قرمه سبزی","سعادت آباد","2میلیارد","0",5f,"5","https://sv1.donateon.ir/uploads/layouts/0RvDTmLsUHDqiToSrtiPiarQiaS29FHZF5iLGEUq.jpg"),
            khodghaza("خورش فسنجون","احمد آباد موستوفی","1.4میلیارد","0.01",5f,"5","https://sv1.donateon.ir/uploads/layouts/8hPL14uoe8I9auoeHxakQaWQpOGqaOBcXYAE6I2Y.jpg"),
            khodghaza("املت","پونک","20 هزار","12",4.8f,"4.8","https://sv1.donateon.ir/uploads/layouts/e8n6B0B9tCHO4Gjll7EYBF7GPVQTLyBPGmekERir.jpg"),
            khodghaza("سوسیس تخم مرغ","حشمت سنتر","45هزار","1",4.5f,"4.5","https://sv1.donateon.ir/uploads/layouts/79T5YPNqG0bnLYArjXBhLwZbhHa0o1FL2uMvs5Og.jpg"),
            khodghaza("سبزی پلو با ماهی","شمال آباد","150هزار","14",4.9f,"4.9","https://sv1.donateon.ir/uploads/layouts/PUrIChXXdbc1DBrzOfCXFgkcphmYmNungeVhMrR2.jpg")

        )

        Log.v(TAG,"تعداد ایتم ها برابر ${listghaza.size}")


        myadaptor=Myadaptor(listghaza.clone() as ArrayList<khodghaza>,this)

        binding.rc1.adapter=myadaptor
        binding.rc1.layoutManager=LinearLayoutManager(this,RecyclerView.VERTICAL,false)

        binding.btnAddFood.setOnClickListener {



            val vorodiha=AlertDialog.Builder(this).create()
            val viewbinding=LayoutEzafeFoodBinding.inflate(layoutInflater)




            vorodiha.setView(viewbinding.root)
            vorodiha.setCancelable(true)


            vorodiha.show()


            viewbinding.btnDoneAddfood.setOnClickListener {


                if (viewbinding.txtNameghazaError.editText!!.text.isEmpty()){
                    viewbinding.txtNameghazaError.isErrorEnabled=true
                    viewbinding.txtNameghazaError.error="لطفا نام غذا را وارد نمایید"
                }else if(viewbinding.txtNameghazaError.editText!!.text.isNotEmpty()){

                    viewbinding.txtNameghazaError.isErrorEnabled=false
                }



                if (viewbinding.txtNamforoshandeError.editText!!.text.isEmpty()){
                    viewbinding.txtNamforoshandeError.isErrorEnabled=true
                    viewbinding.txtNamforoshandeError.error="لطفا نام رستوران / فروشنده را وارد نمایید"
                }else if(viewbinding.txtNamforoshandeError.editText!!.text.isNotEmpty()){

                    viewbinding.txtNamforoshandeError.isErrorEnabled=false
                }


                if (viewbinding.txtGheymatghazaError.editText!!.text.isEmpty()){
                    viewbinding.txtGheymatghazaError.isErrorEnabled=true
                    viewbinding.txtGheymatghazaError.error="لطفا قیمت غذا را وارد نمایید"
                }else if(viewbinding.txtGheymatghazaError.editText!!.text.isNotEmpty()){

                    viewbinding.txtGheymatghazaError.isErrorEnabled=false
                }


                if (viewbinding.txtFaseleError.editText!!.text.isEmpty()){
                    viewbinding.txtFaseleError.isErrorEnabled=true
                    viewbinding.txtFaseleError.error="لطفا فاصله پیک تا مشتری را وارد نمایید"
                }else if(viewbinding.txtFaseleError.editText!!.text.isNotEmpty()){

                    viewbinding.txtFaseleError.isErrorEnabled=false
                }


                if (viewbinding.txtEmtiazError.editText!!.text.isEmpty()){
                    viewbinding.txtEmtiazError.isErrorEnabled=true
                    viewbinding.txtEmtiazError.error="لطفا امتیاز غذای خود را وارد نمایید"
                }else if(viewbinding.txtEmtiazError.editText!!.text.isNotEmpty()){

                    viewbinding.txtEmtiazError.isErrorEnabled=false
                }


                if(
                    viewbinding.voroidEdtNameghaza.length()>0
                    &&
                            viewbinding.voroidEdtNameforoshande.length()>0
                    &&

                    viewbinding.voroidEdtGheymatghaza.length()>0
                    &&
                            viewbinding.voroidEdtFasele.length()>0
                    &&
                            viewbinding.voroidEdtEmtizharf.length()>0

                ){


                    val txtnameghaza=viewbinding.voroidEdtNameghaza.text.toString()
                    val txtforoshande=viewbinding.voroidEdtNameforoshande.text.toString()
                    val txtgheymat=viewbinding.voroidEdtGheymatghaza.text.toString()
                    val txtfasele=viewbinding.voroidEdtFasele.text.toString()

                    val min =0f
                    val max=5f





                        val randomurl=(0..5).random()
                        val urlpicker=listghaza[randomurl].Urlaks

                    val txtemtiazadd:Float=min+ java.util.Random().nextFloat()*(max-min)

                    val txtemtiazharf=viewbinding.voroidEdtEmtizharf.text.toString()





                    val ghazayjadid=khodghaza(txtnameghaza,txtforoshande,txtgheymat,txtfasele,txtemtiazadd,txtemtiazharf,urlpicker)

                    myadaptor.addFood(ghazayjadid)



                    vorodiha.dismiss()
                    binding.rc1.smoothScrollToPosition(0)

                }else{

                    if (viewbinding.txtNameghazaError.editText!!.text.isEmpty()){
                    viewbinding.txtNameghazaError.isErrorEnabled=true
                        viewbinding.txtNameghazaError.error="لطفا نام غذا را وارد نمایید"
                    }else if(viewbinding.txtNameghazaError.editText!!.text.isNotEmpty()){

                        viewbinding.txtNameghazaError.isErrorEnabled=false
                    }



                    if (viewbinding.txtNamforoshandeError.editText!!.text.isEmpty()){
                        viewbinding.txtNamforoshandeError.isErrorEnabled=true
                        viewbinding.txtNamforoshandeError.error="لطفا نام رستوران / فروشنده را وارد نمایید"
                    }else if(viewbinding.txtNamforoshandeError.editText!!.text.isNotEmpty()){

                        viewbinding.txtNamforoshandeError.isErrorEnabled=false
                    }


                    if (viewbinding.txtGheymatghazaError.editText!!.text.isEmpty()){
                        viewbinding.txtGheymatghazaError.isErrorEnabled=true
                        viewbinding.txtGheymatghazaError.error="لطفا قیمت غذا را وارد نمایید"
                    }else if(viewbinding.txtGheymatghazaError.editText!!.text.isNotEmpty()){

                        viewbinding.txtGheymatghazaError.isErrorEnabled=false
                    }


                    if (viewbinding.txtFaseleError.editText!!.text.isEmpty()){
                        viewbinding.txtFaseleError.isErrorEnabled=true
                        viewbinding.txtFaseleError.error="لطفا فاصله پیک تا مشتری را وارد نمایید"
                    }else if(viewbinding.txtFaseleError.editText!!.text.isNotEmpty()){

                        viewbinding.txtFaseleError.isErrorEnabled=false
                    }


                    if (viewbinding.txtEmtiazError.editText!!.text.isEmpty()){
                        viewbinding.txtEmtiazError.isErrorEnabled=true
                        viewbinding.txtEmtiazError.error="لطفا امتیاز غذای خود را وارد نمایید"
                    }else if(viewbinding.txtEmtiazError.editText!!.text.isNotEmpty()){

                        viewbinding.txtEmtiazError.isErrorEnabled=false
                    }




                    Toast.makeText(this, "لطفا موارد قرمز رنگ را بررسی و مجدد تلاش نمایید", Toast.LENGTH_SHORT).show()
                }




            }





        }

        binding.btnAccount.setOnClickListener {

            val maindialog = MainDialog(this)
            maindialog.show(supportFragmentManager, null)

        }

        binding.edtSearch.addTextChangedListener {


            if (it!!.isNotEmpty()){
                val clonelist=listghaza.clone() as ArrayList<khodghaza>
                val filter=clonelist.filter {
                    khodghaza ->
                    khodghaza.txttitlee.contains(it)||khodghaza.txtforoshande.contains(it)||khodghaza.txtnumrating.contains(it)
                }
                myadaptor.setdata(ArrayList(filter))

            }else{
                //show all daata

myadaptor.setdata(listghaza.clone() as ArrayList<khodghaza>)

            }
        }

    }


    override fun clickghaza(khodghaza: khodghaza,position:Int) {

        val Updating=AlertDialog.Builder(this).create()
        val updateitemha=LayoutUpdateFoodBinding.inflate(layoutInflater)



        Updating.setView(updateitemha.root)

        Updating.setCancelable(true)
        Updating.show()

        updateitemha.voroidEdtNameghaza.setText(khodghaza.txttitlee)
        updateitemha.voroidEdtNameforoshande.setText(khodghaza.txtforoshande)
        updateitemha.voroidEdtGheymatghaza.setText(khodghaza.txtgheymat)
        updateitemha.voroidEdtFasele.setText(khodghaza.txtdistance)
        updateitemha.voroidEdtEmtizharf.setText(khodghaza.txtnumrating)

        updateitemha.btnLaghvUpdate.setOnClickListener {

            Updating.dismiss()
        }


        updateitemha.btnSabtAddfood.setOnClickListener {



            if (updateitemha.txtNameghazaError.editText!!.text.isEmpty()){
                updateitemha.txtNameghazaError.isErrorEnabled=true
                updateitemha.txtNameghazaError.error="لطفا نام غذا را وارد نمایید"
            }else if(updateitemha.txtNameghazaError.editText!!.text.isNotEmpty()){

                updateitemha.txtNameghazaError.isErrorEnabled=false
            }



            if (updateitemha.txtNamforoshandeError.editText!!.text.isEmpty()){
                updateitemha.txtNamforoshandeError.isErrorEnabled=true
                updateitemha.txtNamforoshandeError.error="لطفا نام رستوران / فروشنده را وارد نمایید"
            }else if(updateitemha.txtNamforoshandeError.editText!!.text.isNotEmpty()){

                updateitemha.txtNamforoshandeError.isErrorEnabled=false
            }


            if (updateitemha.txtGheymatghazaError.editText!!.text.isEmpty()){
                updateitemha.txtGheymatghazaError.isErrorEnabled=true
                updateitemha.txtGheymatghazaError.error="لطفا قیمت غذا را وارد نمایید"
            }else if(updateitemha.txtGheymatghazaError.editText!!.text.isNotEmpty()){

                updateitemha.txtGheymatghazaError.isErrorEnabled=false
            }


            if (updateitemha.txtFaseleError.editText!!.text.isEmpty()){
                updateitemha.txtFaseleError.isErrorEnabled=true
                updateitemha.txtFaseleError.error="لطفا فاصله پیک تا مشتری را وارد نمایید"
            }else if(updateitemha.txtFaseleError.editText!!.text.isNotEmpty()){

                updateitemha.txtFaseleError.isErrorEnabled=false
            }


            if (updateitemha.txtEmtiazError.editText!!.text.isEmpty()){
                updateitemha.txtEmtiazError.isErrorEnabled=true
                updateitemha.txtEmtiazError.error="لطفا امتیاز غذای خود را وارد نمایید"
            }else if(updateitemha.txtEmtiazError.editText!!.text.isNotEmpty()){

                updateitemha.txtEmtiazError.isErrorEnabled=false
            }

            if(
                updateitemha.voroidEdtNameghaza.length()>0
                &&
                updateitemha.voroidEdtNameforoshande.length()>0
                &&

                updateitemha.voroidEdtGheymatghaza.length()>0
                &&
                updateitemha.voroidEdtFasele.length()>0
                &&
                updateitemha.voroidEdtEmtizharf.length()>0

            ){

            val txtnameghaza=updateitemha.voroidEdtNameghaza.text.toString()
            val txtforoshande=updateitemha.voroidEdtNameforoshande.text.toString()
            val txtgheymat=updateitemha.voroidEdtGheymatghaza.text.toString()
            val txtfasele=updateitemha.voroidEdtFasele.text.toString()
            val txtemtiazharf=updateitemha.voroidEdtEmtizharf.text.toString()


                //creatnewfoodtoaddrecycleview
            val newfood=khodghaza(txtnameghaza,txtforoshande,txtgheymat,txtfasele,khodghaza.rating,txtemtiazharf,khodghaza.Urlaks)

        myadaptor.updatefood(newfood,position )


                Updating.dismiss()
                binding.rc1.smoothScrollToPosition(position)
                Toast.makeText(this, "اطلاعات غذا با موفقیت تغییر کرد", Toast.LENGTH_SHORT).show()


        }else{
                Toast.makeText(this, "لطفا مقادیر قرمز رنگ را اضافه نمایید", Toast.LENGTH_SHORT).show()
                if (updateitemha.txtNameghazaError.editText!!.text.isEmpty()){
                    updateitemha.txtNameghazaError.isErrorEnabled=true
                    updateitemha.txtNameghazaError.error="لطفا نام غذا را وارد نمایید"
                }else if(updateitemha.txtNameghazaError.editText!!.text.isNotEmpty()){

                    updateitemha.txtNameghazaError.isErrorEnabled=false
                }



                if (updateitemha.txtNamforoshandeError.editText!!.text.isEmpty()){
                    updateitemha.txtNamforoshandeError.isErrorEnabled=true
                    updateitemha.txtNamforoshandeError.error="لطفا نام رستوران / فروشنده را وارد نمایید"
                }else if(updateitemha.txtNamforoshandeError.editText!!.text.isNotEmpty()){

                    updateitemha.txtNamforoshandeError.isErrorEnabled=false
                }


                if (updateitemha.txtGheymatghazaError.editText!!.text.isEmpty()){
                    updateitemha.txtGheymatghazaError.isErrorEnabled=true
                    updateitemha.txtGheymatghazaError.error="لطفا قیمت غذا را وارد نمایید"
                }else if(updateitemha.txtGheymatghazaError.editText!!.text.isNotEmpty()){

                    updateitemha.txtGheymatghazaError.isErrorEnabled=false
                }


                if (updateitemha.txtFaseleError.editText!!.text.isEmpty()){
                    updateitemha.txtFaseleError.isErrorEnabled=true
                    updateitemha.txtFaseleError.error="لطفا فاصله پیک تا مشتری را وارد نمایید"
                }else if(updateitemha.txtFaseleError.editText!!.text.isNotEmpty()){

                    updateitemha.txtFaseleError.isErrorEnabled=false
                }


                if (updateitemha.txtEmtiazError.editText!!.text.isEmpty()){
                    updateitemha.txtEmtiazError.isErrorEnabled=true
                    updateitemha.txtEmtiazError.error="لطفا امتیاز غذای خود را وارد نمایید"
                }else if(updateitemha.txtEmtiazError.editText!!.text.isNotEmpty()){

                    updateitemha.txtEmtiazError.isErrorEnabled=false
                }
        }

            }


    }

    @SuppressLint("SetTextI18n")
    override fun longclickghaza(khodghaza: khodghaza, pos: Int) {
        val Hazfiat=AlertDialog.Builder(this).create()
        val dialogdelet=DeletingItemBinding.inflate(layoutInflater)






        dialogdelet.itemTxtTitle.setText("نام غذا : "+khodghaza.txttitlee)
        dialogdelet.itemTxtForoshande.setText("نام رستوران/فروشنده : "+khodghaza.txtforoshande)
        dialogdelet.itemTxtGheymat.setText("قیمت غذا : "+khodghaza.txtgheymat+" تومان ")
        dialogdelet.itemTxtFasele.setText("فاصله پیک تا مشتری : "+khodghaza.txtdistance+"کیلومتر ")
        dialogdelet.itemTxtEmtiazrating.setText("امتیاز غذا : "+khodghaza.txtnumrating+" از 5")


        Hazfiat.setView(dialogdelet.root)
        Hazfiat.setCancelable(true)
        Hazfiat.show()


        dialogdelet.btnKheir.setOnClickListener {

            Hazfiat.dismiss()
        }

        dialogdelet.btnBale.setOnClickListener {


            myadaptor.hazffood(khodghaza,pos)
            Hazfiat.dismiss()
            try {
                binding.rc1.smoothScrollToPosition(pos-1 )
            }catch (e:Exception){

                binding.rc1.scrollToPosition(pos+1)
            }

    }

//s


}

    override fun sent_text_data(data: String) {
        binding.txtNamnamayeshi.text=data



    }

    override fun sent_etebar_mizan(data: String) {
        binding.txtEtebar.text="میزان اعتبار شما برابر :"+data
    }
}
