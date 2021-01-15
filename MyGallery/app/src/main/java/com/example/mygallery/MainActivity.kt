package com.example.mygallery

import android.Manifest
import android.content.ContentUris
import android.content.pm.PackageManager
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.mygallery.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.noButton
import org.jetbrains.anko.support.v4.viewPager
import org.jetbrains.anko.view
import org.jetbrains.anko.yesButton
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val REQUEST_READ_EXTERNAL_STORAGE = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
            != PackageManager.PERMISSION_GRANTED
        ) {

            // 권한 승인이 안되어 있는 경우
            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    this,
                    Manifest.permission.READ_EXTERNAL_STORAGE
                )
            ) {     // true: 거부한 적이 있음

                // 이전에 이미 권한 거부가 있었을 경우 설명 (Anko 라이브러리를 쓰면 편하다)
                alert("사진을 표시하려면 외부 저장소 권한이 필요합니다!", "권한이 필요한 이유") {
                    yesButton {
                        ActivityCompat.requestPermissions(   // 권한 요청
                            this@MainActivity,
                            arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                            REQUEST_READ_EXTERNAL_STORAGE
                        ) // 권한 요청에 대한 분기 처리를 위해
                        // 만든 적당한 정수 값임
                    }
                    noButton { }
                }.show()

            } else {

                // 이전에 권한 거부가 없었을 경우 권한 요청
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                    REQUEST_READ_EXTERNAL_STORAGE
                )
            }

        } else {
            // 권한이 이미 승인되어 있는 상태
            getAllPhotos()
        }
    }


    private fun getAllPhotos() {
        val fragments = ArrayList<Fragment>()
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

                fragments.add(PhotoFragment.newInstance(contentUri))
            }
             //   query.close()  // 이 객체를 더 이상 사용하지 않으므로 닫아줘야 함 (메모리 누수 방지)
        }

        val adapter = MyPagerAdapter1(supportFragmentManager)
        // 프래그먼트 관리자는 getSupportFragmentManager()로 가져올 수 있는데,
        // 코틀린에서는 supportFragmentManager 프로퍼티로 접근할 수 있음
        adapter.updateFragments(fragments)
        viewPager1.adapter = adapter


        timer(period = 3000) {
            runOnUiThread {
                if (viewPager1.currentItem < adapter.count - 1) {
                    viewPager1.currentItem = viewPager1.currentItem + 1
                } else {
                    viewPager1.currentItem = 0
                }
            }
        }
    }
}