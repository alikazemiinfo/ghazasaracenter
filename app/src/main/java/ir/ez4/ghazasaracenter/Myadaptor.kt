package ir.ez4.ghazasaracenter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ir.ez4.ghazasaracenter.databinding.ItemAjnasBinding
import jp.wasabeef.glide.transformations.RoundedCornersTransformation
import java.util.ArrayList

class Myadaptor(private val data: ArrayList<khodghaza>,private val karhayghaza: Karhayghaza) :
    RecyclerView.Adapter<Myadaptor.Foodadaptorholder>() {



    inner class Foodadaptorholder( val binding: ItemAjnasBinding) :
        RecyclerView.ViewHolder(binding.root) {



//s

        fun Putingdata(position: Int) {
            binding.itemTxtTitle.text = data[position].txttitlee
            binding.itemTxtForoshande.text = " رستوران/فروشنده  " + data[position].txtforoshande
            binding.itemTxtGheymat.text = data[position].txtgheymat + "  تومان "
            binding.itemTxtFasele.text = data[position].txtdistance + " کلیومتر "
            binding.itemRatingbarasli.rating = data[position].rating
            binding.itemTxtEmtiazrating.text = data[position].txtnumrating + " از 5 امتیاز "

            Glide.with(binding.root.context).load(data[position].Urlaks)
                .transform(RoundedCornersTransformation(16, 4)).into(binding.itemImgfoodMain)




            itemView.setOnClickListener {

                 karhayghaza.clickghaza(data[adapterPosition],adapterPosition)
            }

            itemView.setOnLongClickListener {

                karhayghaza.longclickghaza(data[adapterPosition],adapterPosition)
                true

            }

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Foodadaptorholder {

        val binding= ItemAjnasBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return Foodadaptorholder(binding)
    }

    override fun onBindViewHolder(holder: Foodadaptorholder, position: Int) {


        holder.Putingdata(position)

    }

    override fun getItemCount(): Int {

        return data.size
    }


    //اضافه کردن غذا
    fun addFood(newfood: khodghaza) {

        data.add(0, newfood)
        notifyItemInserted(0)

    }

    //حذف کردن غذا
    fun hazffood(oldfood: khodghaza, oldposition: Int) {

        data.remove(oldfood)
        notifyItemRemoved(oldposition)
    }


    //به روز رسانی غذا

    fun updatefood(newfood: khodghaza,position: Int){

        data.set(position,newfood)
        notifyItemChanged(position)


    }

    fun setdata(newlist:ArrayList<khodghaza>){



        val clonekardan=data.clone()
        data.clear()
        data.addAll(newlist)
        notifyDataSetChanged()

    }

    interface Karhayghaza{

        fun clickghaza(khodghaza: khodghaza,position: Int)
        fun longclickghaza(khodghaza: khodghaza,pos:Int)
    }
}