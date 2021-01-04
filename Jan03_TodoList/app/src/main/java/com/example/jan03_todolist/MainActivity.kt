package com.example.jan03_todolist

import android.graphics.Paint
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jan03_todolist.databinding.ActivityMainBinding
import com.example.jan03_todolist.databinding.ItemTodoBinding
import kotlin.coroutines.coroutineContext

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val data = arrayListOf<Todo>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        data.add(Todo("인생", false))
        data.add(Todo("그만살래잉", false))

        /*
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = TodoAdapter(data,
        onClickDeleteIcon = {
            deleteTodo(it)
            }
        )
         */

        binding.recyclerView.apply{
            layoutManager = LinearLayoutManager(this@MainActivity)
            binding.recyclerView.adapter = TodoAdapter(data,
                    onClickDeleteIcon = {
                        deleteTodo(it)
                    },
                    onClickItem = {
                        toggleTodo(it)
                    }
            )
        }

        binding.addButton.setOnClickListener {
            addTodo()
        }
    }

    private fun toggleTodo(todo: Todo) {
        todo.isDone=!todo.isDone
        binding.recyclerView.adapter?.notifyDataSetChanged()
    }

    private fun addTodo() {
        val todo = Todo(binding.editText.text.toString(), false)
        data.add(todo)
        binding.recyclerView.adapter?.notifyDataSetChanged() //데이터가 변경됐다는 사실을 어댑터한테 알려주는 것. 이렇게 해야 데이터가 뜸.

    }

    private fun deleteTodo(todo: Todo) {
        data.remove(todo)
        binding.recyclerView.adapter?.notifyDataSetChanged()
    }
}

data class Todo(
        val text: String,
        var isDone: Boolean
) // val은 읽기 전용 var은 쓰기 전용

class TodoAdapter(
        private val myDataset: List<Todo>,
        val onClickDeleteIcon: (todo:Todo) -> Unit, // 이 함수를 통해서 바깥에 삭제할 todo를 전달할 것. Unit은 함수 자체에 대한 리턴은 없다는 뜻. 인풋이 하나고, 아웃풋이 없음.
        val onClickItem: (todo:Todo) -> Unit // 위에 딜리트와 같이 todo를 바깥으로 전달
    ) : //리싸이클러뷰 안에 데이터를 어떤식으로 표현할지를 정의하는게 어댑터 ( 이름을 수정해도 됨!), 우리는 data를 todo 객체 사용
        RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() { //리싸이클러뷰에 있는 어댑터를 상속을 받은 나만의 어댑터를 만들어야 함!


    class TodoViewHolder(val binding: ItemTodoBinding) : RecyclerView.ViewHolder(binding.root) // 리싸이클러뷰의 뷰홀더는 뷰를 받는 함수니까 바인딩.루트
    //binding 객체는 모두 root라는 정체성을 가지고 있어서 본인이 어떤 뷰로부터 생성된 바인딩인지 root에 가지고 있음.


    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): TodoAdapter.TodoViewHolder {

        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_todo, parent, false) // 내가 만든 뷰(item_todo)를 사용할 것이고,

        return TodoViewHolder(ItemTodoBinding.bind(view))  // view에 있는 모든 레퍼런스들을 바인딩객체로 변환시켜 줌.
    }


    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val todo = myDataset[position]
        holder.binding.todoText.text = myDataset[position].text
        //         holder.binding.todoText.text =todo.text
        if (todo.isDone) {
            //  holder.binding.todoText.paintFlags=holder.binding.todoText.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
            holder.binding.todoText.apply {
                paintFlags = paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
                setTypeface(null, Typeface.ITALIC )
            }
        } else {
            holder.binding.todoText.apply {
                paintFlags = 0
                setTypeface(null, Typeface.NORMAL)
            }
            holder.binding.deleteImageView.setOnClickListener {
                onClickDeleteIcon.invoke(todo)
            }

            holder.binding.root.setOnClickListener {
                onClickItem.invoke(todo)
            }

        }
    }

    override fun getItemCount() = myDataset.size
}
    