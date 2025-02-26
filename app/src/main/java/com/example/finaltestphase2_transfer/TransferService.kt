package com.example.finaltestphase2_transfer

import android.app.Service
import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.IBinder
import android.util.Log
import com.example.finaltestphase2_ui.IStudentUI


class TransferService : Service() {
    var command: String = ""
    private var aidlUI: IStudentUI? = null

    private val serviceUIConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            if (service != null) {
                aidlUI = IStudentUI.Stub.asInterface(service)
                Log.d("TransferService", "onServiceConnected")
                // Có thể thực hiện các thao tác với aidlUI sau khi kết nối
            } else {
                Log.d("TransferService", "Service is null")
            }
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            aidlUI = null
        }
    }

    override fun onCreate() {
        super.onCreate()
        bindUIService()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        command = intent?.getStringExtra("command") ?: ""

        when (command) {
            "requestFirst100" -> {
                Log.d("TransferAppService", "Requesting First 100 students")
                // Do something here
                val first100 = aidlUI?.get100Students()
                Log.d(
                    "TransferService",
                    "onStartCommand: ${aidlUI?.get100Students()?.firstOrNull()}"
                )
            }

            "request10BySubject" -> {
                val subject = intent?.getStringExtra("subject") ?: ""
                if (subject.isNotEmpty()) {
                    Log.d("TransferAppService", "Requesting 10 students by subject: $subject")

                    //
//                    request10BySubjectAsync(subject = subject)


                } else {
                    Log.d("TransferAppService", "No subject provided")
                }
            }

            "request10BySumA" -> {
                Log.d("TransferAppService", "Requesting 10 students by SumA")
            }

            "request10BySumB" -> {
                Log.d("TransferAppService", "Requesting 10 students by SumB")
            }

            "requestStudent" -> {
                Log.d("TransferAppService", "Requesting a specific student")
            }


            "resFirst100" -> {
                Log.d("TransferAppService", "Res First 100 students")
                // Do something here
            }

            "res10BySubject" -> {
                Log.d("TransferAppService", "Res 10 students by subject")
            }

            "res10BySumA" -> {
                Log.d("TransferAppService", "Res 10 students by SumA")
            }

            "res10BySumB" -> {
                Log.d("TransferAppService", "Res 10 students by SumB")
            }

            "resStudent" -> {
                Log.d("TransferAppService", "Res a specific student")
            }

            else -> {
                Log.d("TransferAppService", "Unknown command: $command")
            }
        }

        return START_STICKY
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    private fun bindUIService() {
        val intent =
            Intent("com.example.finaltestphase2_ui.IStudentUI")  // Đảm bảo đúng action của app UI
        intent.setPackage("com.example.finaltestphase2_ui")  // Thay bằng package của app UI
        bindService(intent, serviceUIConnection, BIND_AUTO_CREATE)
    }

    override fun onUnbind(intent: Intent?): Boolean {
        unbindService(serviceUIConnection)
        return super.onUnbind(intent)
    }

    override fun onDestroy() {
        if (aidlUI != null) {
            unbindService(serviceUIConnection)
        }
        super.onDestroy()
    }
}