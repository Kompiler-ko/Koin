package com.pss.koin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.qualifier.named
import org.koin.dsl.module

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //컨테이너 만들기
        startKoin {

            //라이프사이클 설정
            androidContext(this@MainActivity)

            //모듈 만들기
            modules(
                module {

                    //객체 만들기

                    //singleton 으로 생성
                    single { Cpu("i5") }

                    //필요할 때마다 새로 생성
                    factory(named("Dell")) { Computer("Dell") }
                    factory(named("HP")) { Computer("HP") }
                    single { User(get(named("Dell"))) }
                }
            )
        }

        val cpu by inject<Cpu>()
        val computer by inject<Computer>(named("HP"))
        val user by inject<User>()

        Log.d("로그","${cpu.name}, ${computer.name}, ${user.computer.name}")
    }
}