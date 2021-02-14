package com.example.jan_assignment

import android.Manifest
import android.app.Activity
import android.app.Instrumentation
import android.content.ContentUris
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.drawable.Drawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import androidx.annotation.NonNull
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.jan_assignment.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val REQUEST_READ_EXTERMAL_STORAGE = 1000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)



        // 권한 부여 확인
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
            // 권한 허용 안됨
            if(ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)){
                // 이전에 이미 권한이 거부되었을 때 설명
                alert("사진 정보를 얻으려면 외부 저장소 권한이 필수로 필요합니다",
                        "권한이 필요한 이유") {
                    yesButton {
                        // 권한 요청
                        ActivityCompat.requestPermissions(this@MainActivity,
                                arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                                REQUEST_READ_EXTERMAL_STORAGE)
                    }
                    noButton {  }
                }.show()
            } else {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                        REQUEST_READ_EXTERMAL_STORAGE)
            }
        } else {
            // 권한이 이미 허용됨

            getAllPhotos()

        }
    }


    // 사용자가 권한 요청 시 호출되는 메서드
    override fun onRequestPermissionsResult(
            requestCode: Int,
            permissions: Array<out String>,
            grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
            REQUEST_READ_EXTERMAL_STORAGE -> {
                if((grantResults.isNotEmpty() && grantResults[0]
                                == PackageManager.PERMISSION_GRANTED)) {
                    getAllPhotos()
                } else {
                    toast("권한 거부 됨")
                }
                return
            }
        }
    }

    private fun getAllPhotos(){
        val uriArr = ArrayList<String>()
        val query = contentResolver.query(                        // *1
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,   // 가져올 데이터의 URI
                // EXTERNAL_CONTENT_URI 는 외부 저장소를 의미함
                null,        // 가져올 항목들을 문자열 배열로 지정 (null : 모든 항목을 가져옴)
                null,        // 조건1 (null : 전체 데이터)
                null,        // 조건2 (조건1과 조합하여 조건 지정)
                // MediaStore.Images.ImageColumns.DATE_TAKEN + " DESC" // 정렬방법 (촬영날짜 내림차순)
                "${MediaStore.Images.ImageColumns.DATE_ADDED} DESC"
        )
        /*
        val fragmentArray=ArrayList<Fragment>()
        // 이 코드는 사진이 제대로 읽어지는지 로그로 확인해 보려고 작성
        if (query != null) {      // photosCursor == null 이면 사진이 없는 것임
        */
        query?.use { cursor ->
            val idColumn = cursor.getColumnIndexOrThrow(MediaStore.Images.Media._ID)

            while (cursor.moveToNext()) {  // PhotosCursor 객체 내부에 데이터 이동용 포인터가 있음
                /*
                val uri = query.getString(
                    query.getColumnIndexOrThrow(MediaStore.Images.Media.DATA))
                // 사진의 경로가 저장된 데이터베이스의 컬럼명은 DATA 상수에 정의되어 있음
                Log.d("MainActivity", uri)   // 안드로이드 스튜디오의 Logcat에서
                // MainActivity로 필터링 했을 때 사진의 URI가 표시됨

                 */
                val id = cursor.getLong(idColumn)
                val contentUri = ContentUris.withAppendedId(
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                        id
                )
                uriArr.add(id.toString())
                


            }
            //    query.close()  // 이 객체를 더 이상 사용하지 않으므로 닫아줘야 함 (메모리 누수 방지)
        }

        /*
        val cursor = contentResolver.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                null,
                null,
                null,
                MediaStore.Images.ImageColumns.DATE_TAKEN + " DESC")
        val uriArr = ArrayList<String>()
        if(cursor!=null){
            while(cursor.moveToNext()){
                // 사진 경로 Uri 가져오기
                val uri = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA))
                uriArr.add(uri)
            }
            cursor.close()
        }


        val adapter= MyAdapter(this,uriArr)


            gridview.numColumns=3 // 한 줄에 3개씩
            gridview.adapter = adapter

         */

        val adapter=MyAdapter(this,uriArr)
        gridview.numColumns=3
        gridview.adapter=adapter




    }


}




/*
    fun LoadImage(v:View){
        startActivityForResult(Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI),0)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(data!=null) binding.imageView.setImageURI(data?.data)
    }
*/
