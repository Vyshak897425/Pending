package com.example.simpleproject1.fragments

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import com.example.simpleproject1.R
import kotlinx.android.synthetic.main.fragment_second.*
import kotlinx.android.synthetic.main.fragment_second.view.*


class SecondFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val myview = inflater.inflate(R.layout.fragment_first, container, false)
        val mediaController = MediaController(myview.context)
        mediaController.setAnchorView(videoview)

        val onlineuri = Uri.parse("http://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4")

        myview.videoview.setMediaController(mediaController)
        myview.videoview.setVideoURI(onlineuri)
        myview.videoview.requestFocus()
        myview.videoview.start()

        return myview
    }


}