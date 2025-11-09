package com.example.destinydraw

import UserInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import com.example.destinydraw.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(s: Bundle?) {
        super.onCreate(s)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val user = intent.getParcelableExtra<UserInfo>("extra_user")
        binding.txtFortune.text = generateText(user)
        binding.btnBack.setOnClickListener { finish() }

        val pulseAnimation = AnimationUtils.loadAnimation(this, R.anim.pulse_animation)
        binding.btnBack.startAnimation(pulseAnimation)

    }

    private fun generateText(user: UserInfo?): String {
        if (user == null) return "No fortune data found."

        val cardNum = user.cardNum
        val name = user.name

        val randomValue = (1..100).random()
        val isRare = randomValue <= 5

        val rarePrefix = if (isRare) {
            val prefixes = listOf(
                "✨ RARE CARD! CONGRATS! ✨",
                "💫 ยินดีด้วย! การ์ดแรร์! 🌟",
                "💖 ดวงระดับจักรวาล! 🔥"
            )
            "${prefixes.random()}\n\n"
        } else {
            ""
        }

        val fortuneList = if (isRare) {
            listOf( // Rare Card
                "วันนี้คุณคือ การ์ดแรร์🌻 ของใครบางคน 🕺💫",
                "ในชาติที่แล้ว คุณเกือบได้เป็น อัลเบิร์ต ไอน์สไตน์ 🧠✨ ที่กำลังจะไขปริศนาแห่งเอกภพ... แต่คุณหาหวีไม่เจอ 🪮😅 เลยรู้สึกว่าวันนี้เป็นวันที่ยุ่งเหยิงเกินกว่าจะมานั่งคิดทฤษฎีควอนตัม 👩🏼‍🦱👅",
                ".... . .. ....... .... . .. ....... ... - ..- .--. .. -..ข้อความนี้ไม่ได้ผิดระบบ แค่โชคชะตาไม่อยากให้คุณเข้าใจ 😌🔮",
                "คุณเคยเป็น นักกินบุฟเฟต์ 🍣🍕🍰 ที่กินหนักมาก จนเจ้าของร้านบุฟเฟต์ต้องมาเกิดเป็นคู่แข่งทางการงานในชาตินี้ เพื่อทวงทุนคืน💸✨",
                "ถึงโลกร้อน 🌍🔥 แต่อยากใ🐱ห้รู้ไว้ว่าคุณร้อนกว่า 🥵... SO HOT เลยล่ะ"
            )
        } else  {
            when (cardNum) {
                1 -> listOf( // bad
                    "คุณรู้สึกหิวทันทีหลังแปรงฟัน 🥪🪥",
                    "ระวังโดนสปอยซีรีส์ที่ยังดูไม่จบ 📺⚠️",
                    "วันนี้คุณจะเปิดตู้เย็นหลายรอบ แต่ก็ไม่ได้อะไรกลับมา🎂😅",
                    "คุณจะประหยัดเงินได้เยอะมาก 💸… เพราะของที่คุณต้องการหมด!",
                    "คุณจะค้นพบซองบะหมี่กึ่งสำเร็จรูปรสชาติโปรด 🍜… แต่หมดอายุไปแล้ว 2 วัน⏳😢"
                )

                2 -> listOf( // super lucky
                    "ในตอนพักกลางวัน คุณพบว่า โรงอาหารคณะวิทยาศาสตร์มีที่นั่งว่าง 🍽️✨",
                    "🪐จักรวาลกำลังจัดฉากให้คุณมีความสุข🌠",
                    "สิ่งที่คิดว่าจะพัง กลับออกมาดีสุดๆ 🪄🤍",
                    "คุณจะได้รับ เกรด A💯 ในวิชา ANDROID MOBILE APPLICATION PROGRAMMING 📱✨ เพราะอาจารย์วิชานี้ดีที่สุดในเลิศหล้า 🤩🌟",
                    "คุณจะเจอ ที่จอดรถที่ดีที่สุด 🚗 และอยู่ใกล้ทางเข้าที่สุดในวันที่คุณรีบมาก ๆ⏰"
                )

                3 -> listOf( // neutral
                    "เมื่อวานคุณดวงดีมาก 🍀 — และใช่ค่ะ… เมื่อวาน แต่ไม่ใช่วันนี้😅",
                    "เจอแบงค์พันตก 💵… แต่เมื่อคุณหยิบขึ้นมามันเป็น แบงค์กาโม่😬",
                    "คุณจะได้ยินเพลงที่ชอบโดยบังเอิญในร้านกาแฟ 🎶☕… ฟินไปทั้งวันเลย!",
                    "คุณจะค้นพบร้านอาหารใหม่ที่อร่อยที่สุดในโลก 🍝🌎 ซึ่งตั้งอยู่ไกลมากและมีคิวยาวเป็นกิโล",
                    "คืนนี้คุณจะนอนหลับอย่างเต็มอิ่ม 😴💤… หลังจากที่พยายามข่มตามาแล้ว 3 ชั่วโมง และนับแกะไปแล้ว 500 ตัว 🐑🐑🐑"
                )

                4 -> listOf( // good
                    "จะมีคนชมคุณ... หรือไม่ก็ แมวในซอยมองคุณแบบชื่นชม🐱✨",
                    "มีเกณฑ์ได้รับมอบหมาย งานสำคัญ(ที่ไม่มีใครอยากทำ)💐😎",
                    "สิ่งที่คุณตามหามาทั้งวัน จะไปปรากฏอยู่ตรงหน้า👀🎯",
                    "โชคลาภกำลังมา!💰เพราะแม่ค้าที่ร้านจะทอนเงินเกินมาให้ 5 บาท🪙✨",
                    "คุณจะสามารถจัดตารางงานได้อย่างลงตัว🗓️… แต่ก็จะเลื่อนมันไปทำวันพรุ่งนี้อยู่ดี😅"
                )

                else -> listOf( // very bad
                    "เมื่อเจอกองขยะ... อย่าเพิ่งเดินผ่านไป 🗑️😂 เพราะในอนาคตคุณอาจต้องกลับมาหาของกินในนั้นเอง",
                    "ขนมที่ซ่อนไว้จะถูกคนอื่นกิน 😭",
                    "อย่าหยิบของร่วงนะ เพราะอาจจะร่วงตามของไปทั้งวัน 🤦‍♀️💥",
                    "คุณจะไปถึง สถานที่นัดหมายตรงเวลาเป๊ะ ๆ 🕒… แต่เพื่อนจะมาสายเพราะ เพิ่งตื่น🌞",
                    "คุณจะเพิ่งซื้อของไปในราคาเต็ม 💸 และวันรุ่งขึ้นร้านก็ประกาศ ลดราคา 50% ทันที🛍️"

                )
            }
        }

        val randomFortune = fortuneList.random()

        return """
        Hi $name 🍀
        $rarePrefix
        ✨ Today's Fortune ✨
        "$randomFortune"
        """.trimIndent()
    }

}
