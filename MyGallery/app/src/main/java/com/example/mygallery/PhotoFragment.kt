package com.example.mygallery

import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_photo.*

private const val ARG_URI = "uri"  // 클래스 밖에서 상수를 정의하면 컴파일 시 상수가 초기화됨
// 컴파일 시 상수 초기화는 프리미티브형(Int, Long, Double등 기본형)만 가능

class PhotoFragment : Fragment() {
    private lateinit var uri:Uri


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.getParcelable<Uri>(ARG_URI)?.let {
            uri=it
        }

        /*
        arguments?.let {
            uri = it.getString(ARG_URI)   // 프래그먼트가 생성되고 onCreate() 호출되면
            // ARG_URI키에 저장된 uri값을 얻어서 변수에 저장
        }
        */
    }

    // 프래그먼트에 표시될 뷰를 생성함
    // 액티비티가 아닌 곳에서 레이아웃 리소스를 가져오려면 LayoutInflater객체의 inflate()를 사용함
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_photo, container, false)
    }


    // newInstance()를 이용해서 프래그먼트를 생성할 수 있고 인자로 uri 값을 전달
    // 이 값은 Bundle 객체에 ARG_URI 키로 저장되고 arguments 프로퍼티에 저장됨
    companion object {
        @JvmStatic
        fun newInstance(uri: Uri) =
            PhotoFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_URI, uri)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val descriptor = requireContext().contentResolver.openFileDescriptor(uri,"r")
        descriptor?.use {
            val bitmap=BitmapFactory.decodeFileDescriptor(descriptor.fileDescriptor)
            Glide.with(this).load(bitmap).into(imageView1) // 사진을 이미지뷰에 표시
            // with(): 사용준비, load(): 이미지 로드, into(): 이미지 표시
        }
    }
}