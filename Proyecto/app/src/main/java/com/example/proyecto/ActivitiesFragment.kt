package com.example.proyecto

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.airbnb.lottie.LottieAnimationView


class ActivitiesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_activities, container, false)

        var like = false
        val likeImageView = listOf(
            view.findViewById<LottieAnimationView>(R.id.likeImageView),
            view.findViewById<LottieAnimationView>(R.id.likeImageView2),
            view.findViewById<LottieAnimationView>(R.id.likeImageView3),
            view.findViewById<LottieAnimationView>(R.id.likeImageView4),
            //view.findViewById<LottieAnimationView>(R.id.likeImageView6)
        )

        likeImageView.forEach { likeImageView ->
            likeImageView.setOnClickListener {
                likeAnimation(likeImageView, R.raw.bandai_dokkan, like)
            }
        }


//        likeImageView.setOnClickListener {
//             likeAnimation(likeImageView, R.raw.bandai_dokkan, like)
//        }

        return view
    }

    private fun likeAnimation(
        imageView: LottieAnimationView,
        animation: Int,
        like: Boolean
    ): Boolean {
        if (!like) {
            imageView.setAnimation(animation)
            imageView.playAnimation()
        } else {
            imageView.setImageResource(R.drawable.twitter_like)
        }
        return !like
    }
}
