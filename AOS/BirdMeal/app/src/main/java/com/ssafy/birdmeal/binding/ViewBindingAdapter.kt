package com.ssafy.birdmeal.binding

import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.ssafy.birdmeal.R
import com.ssafy.birdmeal.utils.TAG

object ViewBindingAdapter {

    @BindingAdapter("categoryImg")
    @JvmStatic
    fun AppCompatImageView.setCategoryImg(imgUrl: String) {
        Glide.with(this.context)
            .load(R.drawable.meal)
            .override(R.dimen.categoryImg * 2, R.dimen.categoryImg * 2)
            .placeholder(R.drawable.meal)
            .into(this)
        // this.clipToOutline = true 배경이 Drawable 파일이면 그걸 배경으로 인식
    }

    @BindingAdapter("productPrice")
    @JvmStatic
    fun TextView.setProductPrice(price: Int) {
        var t = String.format("%,2d", price)
        text = "$t ELN"
    }

    @BindingAdapter("productThumbnail")
    @JvmStatic
    fun ImageView.setProductThumbnail(url: String?) {
        if (url != null) {
            Glide.with(this.context)
                .load("$url")
                .placeholder(R.drawable.meal)
                .into(this)
        }
    }

    @BindingAdapter("totalAmount", "userELN")
    @JvmStatic
    fun TextView.setRemainAmount(totalAmount: Int, userELN: Int) {
        var value = (userELN - totalAmount)
        this.text = String.format("%,2d", value) + " ELN"
    }

    @BindingAdapter("orderName", "orderSize")
    @JvmStatic
    fun TextView.setOrderName(name: String, size: Int) {
        var text = "$name"
        if (size > 1) {
            text += " 외 ${size - 1}건"
        }
        this.text = text
    }

    // 직접기부, 간접기부 이미지 분기
    @BindingAdapter("donationImg")
    @JvmStatic
    fun ImageView.setDonationImg(donationType: Boolean?) {
        if (donationType != null) {
            when (donationType) {
                true -> {
                    Glide.with(this.context)
                        .load(R.drawable.ic_donation1)
                        .placeholder(R.drawable.meal)
                        .into(this)
                }
                false -> {
                    Glide.with(this.context)
                        .load(R.drawable.ic_donation2)
                        .placeholder(R.drawable.meal)
                        .into(this)
                }
            }
        }
    }

    // 장바구니 New 아이콘 표시 or 제거
    @BindingAdapter("cartNewIcon")
    @JvmStatic
    fun ImageView.setNewIcon(productCnt: Int) {
        Log.d(TAG, "setNewIcon: 들어왔나요 $productCnt")
        if(productCnt > 0){
            this.visibility = View.VISIBLE
        } else {
            this.visibility = View.INVISIBLE
        }
    }

    // 장바구니 비었습니다 텍스트 표시
    @BindingAdapter("textEmpty")
    @JvmStatic
    fun TextView.setTextEmpty(productCnt: Int) {
        if(productCnt > 0){
            this.visibility = View.GONE
        } else {
            this.visibility = View.VISIBLE
        }
    }
}