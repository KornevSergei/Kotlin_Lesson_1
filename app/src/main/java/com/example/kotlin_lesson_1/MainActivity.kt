package com.example.kotlin_lesson_1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ActionMode
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {


    //переменные с разным заниманием памяти
    private var number1: Int = 2
    private var number2: Double = 4.5
    private var number3: Int = 20

    //Строка
    private var text: String = "qwewe1112334esh"

    //Символ
    private var ch: Char = 'f'

    //переменная для установки нового текста, ставим вопрос потому что значение нулл
    private var helloText: TextView? = null


    //переменная для счетчика
    private var counter: Int = 0
    private var start: Boolean = false

    //переменная для смены фона лайаут
    private var layoutStart: ConstraintLayout? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        //складываем и провидим в Инт результат
//        number1 = (number2 + number3).toInt()
//        //Инт превращаем в Чар
//        number3.toChar()


        //связываем переменную с ХМЛ по айди
        helloText = findViewById(R.id.helloText)
        //связываем лайаут
        layoutStart = findViewById(R.id.layoutStart)


        //запускаемновый поток
        Thread {
            //присваиваем новое значение
            start = true

            //бесконечный цикл
            while (start) {
                //делаем засыпание потока на 1секунду
                Thread.sleep(1000)

                //даём возможность менть интерфейс во второстепенном потоке
                runOnUiThread {

                    //проверяем если счетчик дошел до пяти
                    if (counter == 5)
                    //если дошел ставим цвет
                        layoutStart?.setBackgroundColor(Color.BLUE)

                    //устанавливаем новый текст, если не нулл то изменяем по этому вопрос
                    helloText?.setText(counter.toString())

                    //увеличивается счетчик
                    counter++
                }
            }
        }.start()
    }

    //метод при закритии приложения - останавливаем счетчик
    override fun onDestroy() {
        super.onDestroy()
        //меняем значение
        start = false
    }
}