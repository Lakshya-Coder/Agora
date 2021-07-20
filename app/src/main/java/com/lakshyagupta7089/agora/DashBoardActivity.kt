package com.lakshyagupta7089.agora

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.lakshyagupta7089.agora.databinding.ActivityDashBoardBinding
import org.jitsi.meet.sdk.JitsiMeet
import org.jitsi.meet.sdk.JitsiMeetActivity
import org.jitsi.meet.sdk.JitsiMeetConferenceOptions
import java.net.URL

class DashBoardActivity : AppCompatActivity() {
    private var binding: ActivityDashBoardBinding ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDashBoardBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding!!.root)

        try {

            var url: URL ?= null

            url = URL("https://meet.jit.si")

            val defaultOptions: JitsiMeetConferenceOptions =
                JitsiMeetConferenceOptions.Builder()
                    .setServerURL(url)
                    .setWelcomePageEnabled(false)
                    .build()

            JitsiMeet.setDefaultConferenceOptions(defaultOptions)
        } catch (e: Exception) {}

        binding!!.joinBtn.setOnClickListener {
            val options: JitsiMeetConferenceOptions = JitsiMeetConferenceOptions.Builder()
                .setRoom(binding!!.codeBox.text.toString())
                .setWelcomePageEnabled(false)
                .build()

            JitsiMeetActivity.launch(this, options)
        }
    }
}

/**

2021-07-11 18:53:12.979 16580-16580/com.lakshyagupta7089.agora E/AndroidRuntime: FATAL EXCEPTION: main
Process: com.lakshyagupta7089.agora, PID: 16580
android.util.AndroidRuntimeException: Calling startActivity() from outside of an Activity  context requires the FLAG_ACTIVITY_NEW_TASK flag. Is this really what you want?
at android.app.ContextImpl.startActivity(ContextImpl.java:962)
at android.app.ContextImpl.startActivity(ContextImpl.java:938)
at android.content.ContextWrapper.startActivity(ContextWrapper.java:393)
at org.jitsi.meet.sdk.JitsiMeetActivity.launch(JitsiMeetActivity.java:53)
at com.lakshyagupta7089.agora.DashBoardActivity.onCreate$lambda-0(DashBoardActivity.kt:42)
at com.lakshyagupta7089.agora.DashBoardActivity.lambda$8SOuYASIJYTgiO88jmUHQ0pTcp0(Unknown Source:0)
at com.lakshyagupta7089.agora.-$$Lambda$DashBoardActivity$8SOuYASIJYTgiO88jmUHQ0pTcp0.onClick(Unknown Source:2)
at android.view.View.performClick(View.java:7185)
at android.view.View.performClickInternal(View.java:7162)
at android.view.View.access$3500(View.java:819)
at android.view.View$PerformClick.run(View.java:27691)
at android.os.Handler.handleCallback(Handler.java:883)
at android.os.Handler.dispatchMessage(Handler.java:100)
at android.os.Looper.loop(Looper.java:224)
at android.app.ActivityThread.main(ActivityThread.java:7560)
at java.lang.reflect.Method.invoke(Native Method)
at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:539)
at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:950)


 */