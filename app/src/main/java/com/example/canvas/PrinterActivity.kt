package ir.trano.keeper.activity.print

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ir.ikccc.externalpayment.Library
import ir.ikccc.externalpayment.PrinterRequest
import ir.trano.keeper.R
import ir.trano.keeper.widget.ikcc.PrintableLine
import ir.trano.keeper.widget.ikcc.PrintableReceiptBuilder
import kotlinx.android.synthetic.main.activity_printer.*
import java.util.*


class PrinterActivity : AppCompatActivity() {
    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_printer)

        btn_test_print.setOnClickListener {
            val printableLines: ArrayList<PrintableLine> = ArrayList()
            printableLines.add(PrintableLine("قبض ترانو", "").setContext(this@PrinterActivity))
//            printableLines.add(PrintableLine("", "",Typeface.createFromAsset(context.getAssets(), "fonts/materialdesignicons-webfont.ttf"),false,false).setContext(this@PrinterActivity))
            printableLines.add(PrintableLine(true).setContext(this@PrinterActivity))
            printableLines.add(PrintableLine("کد پیگیری", "82045").setContext(this@PrinterActivity))
            printableLines.add(PrintableLine("آورنده", "مهدی اکبری").setContext(this@PrinterActivity))
            printableLines.add(PrintableLine("فرستنده", "محمد نیایشی").setContext(this@PrinterActivity))
            printableLines.add(PrintableLine("گیرنده", "شرکت هما پخش").setContext(this@PrinterActivity))
            printableLines.add(PrintableLine("مبدا", "قم. قم").setContext(this@PrinterActivity))
            printableLines.add(PrintableLine("مقصد", "خراسان. مشهد").setContext(this@PrinterActivity))
            printableLines.add(PrintableLine(true).setContext(this@PrinterActivity))
            printableLines.add(PrintableLine("اطلاعات بار", "").setContext(this@PrinterActivity))
            printableLines.add(PrintableLine(true).setContext(this@PrinterActivity))
            printableLines.add(PrintableLine("تعداد", "25 پلاستیک").setContext(this@PrinterActivity))
            printableLines.add(PrintableLine("وزن", "540 کلیوگرم").setContext(this@PrinterActivity))
            printableLines.add(PrintableLine("توضیحات", "شکستنی").setContext(this@PrinterActivity))
            val receiptBuilder =
                PrintableReceiptBuilder(this@PrinterActivity, printableLines, false, false)
            val printerRequest = PrinterRequest(this@PrinterActivity)
            if (printerRequest.send(receiptBuilder.getReceipt(10))) {
                Toast.makeText(this@PrinterActivity, "ارسال موفق", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this@PrinterActivity, "خطا در ارسال", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onResume() {
        initUiForResume()
        super.onResume()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.e("specialTag", "=============== onActivityResult ================")
        Log.e("specialTag", "| onActivityResult->requestCode-> $requestCode")
        Log.e("specialTag", "| onActivityResult->resultCode-> $resultCode")
        if (data != null) {
            val resultTextView = findViewById<TextView>(R.id.result)
            if (requestCode == Library.REQUEST_CODE) {
                Log.e("specialTag", "===============================================")
                Log.e("specialTag", "| paymentAmount  -> " + data.getStringExtra("paymentAmount"))
                Log.e("specialTag", "| paymentId      -> " + data.getStringExtra("paymentId"))
                Log.e("specialTag", "| message        -> " + data.getStringExtra("message"))
                Log.e("specialTag", "| cardNumber     -> " + data.getStringExtra("cardNumber"))
                Log.e("specialTag", "| cardBank       -> " + data.getStringExtra("cardBank"))
                Log.e("specialTag", "| referenceCode  -> " + data.getStringExtra("referenceCode"))
                Log.e("specialTag", "| dateTime       -> " + data.getStringExtra("dateTime"))
                Log.e("specialTag", "| merchantID     -> " + data.getStringExtra("merchantID"))
                Log.e("specialTag", "| terminalID     -> " + data.getStringExtra("terminalID"))
                Log.e("specialTag", "| stan           -> " + data.getStringExtra("stan"))
                Log.e("specialTag", "| txResponseCode -> " + data.getStringExtra("txResponseCode"))
                Log.e("specialTag", "| txResponseTitle-> " + data.getStringExtra("txResponseTitle"))
                Log.e("specialTag", "===============================================")
                resultTextView.append("========================================\n")
                resultTextView.append("| resultCode           -> $resultCode\n")
                resultTextView.append(
                    """
                    | paymentAmount  -> ${data.getStringExtra("paymentAmount")}
                    
                    """.trimIndent()
                )
                resultTextView.append(
                    """
                    | paymentId      -> ${data.getStringExtra("paymentId")}
                    
                    """.trimIndent()
                )
                resultTextView.append(
                    """
                    | message        -> ${data.getStringExtra("message")}
                    
                    """.trimIndent()
                )
                resultTextView.append(
                    """
                    | cardNumber     -> ${data.getStringExtra("cardNumber")}
                    
                    """.trimIndent()
                )
                resultTextView.append(
                    """
                    | cardBank       -> ${data.getStringExtra("cardBank")}
                    
                    """.trimIndent()
                )
                resultTextView.append(
                    """
                    | referenceCode  -> ${data.getStringExtra("referenceCode")}
                    
                    """.trimIndent()
                )
                resultTextView.append(
                    """
                    | merchantID     -> ${data.getStringExtra("merchantID")}
                    
                    """.trimIndent()
                )
                resultTextView.append(
                    """
                    | terminalID     -> ${data.getStringExtra("terminalID")}
                    
                    """.trimIndent()
                )
                resultTextView.append(
                    """
                    | dateTime       -> ${data.getStringExtra("dateTime")}
                    
                    """.trimIndent()
                )
                resultTextView.append(
                    """
                    | stan           -> ${data.getStringExtra("stan")}
                    
                    """.trimIndent()
                )
                resultTextView.append(
                    """
                    | txResponseCode -> ${data.getStringExtra("txResponseCode")}
                    
                    """.trimIndent()
                )
                resultTextView.append(
                    """
                    | txResponseTitle-> ${data.getStringExtra("txResponseTitle")}
                    
                    """.trimIndent()
                )
                resultTextView.append("========================================\n")
            } else if (requestCode == Library.PRINT_REQUEST_CODE) {
                Log.e("specialTag", "===============================================")
                Log.e("specialTag", "resultCode        ->" + data.getStringExtra("message"))
                Log.e("specialTag", "message           ->" + data.getStringExtra("message"))
                Log.e("specialTag", "===============================================")
                resultTextView.append("========================================\n")
                resultTextView.append("| resultCode           -> $resultCode\n")
                resultTextView.append(
                    """
                    | message        -> ${data.getStringExtra("message")}
                    
                    """.trimIndent()
                )
                resultTextView.append("========================================\n")
            } else if (requestCode == Library.SEARCH_REQUEST_CODE) {
                Log.e("specialTag", "===============================================")
                Log.e("specialTag", "| paymentAmount  -> " + data.getStringExtra("paymentAmount"))
                Log.e("specialTag", "| paymentId      -> " + data.getStringExtra("paymentId"))
                Log.e("specialTag", "| message        -> " + data.getStringExtra("message"))
                Log.e("specialTag", "| cardNumber     -> " + data.getStringExtra("cardNumber"))
                Log.e("specialTag", "| cardBank       -> " + data.getStringExtra("cardBank"))
                Log.e("specialTag", "| referenceCode  -> " + data.getStringExtra("referenceCode"))
                Log.e("specialTag", "| dateTime       -> " + data.getStringExtra("dateTime"))
                Log.e("specialTag", "| merchantID     -> " + data.getStringExtra("merchantID"))
                Log.e("specialTag", "| terminalID     -> " + data.getStringExtra("terminalID"))
                Log.e("specialTag", "| stan           -> " + data.getStringExtra("stan"))
                Log.e("specialTag", "| txResponseCode -> " + data.getStringExtra("txResponseCode"))
                Log.e("specialTag", "| txResponseTitle-> " + data.getStringExtra("txResponseTitle"))
                Log.e("specialTag", "===============================================")
                resultTextView.append("========================================\n")
                resultTextView.append("| resultCode     -> $resultCode\n")
                resultTextView.append(
                    """
                    | paymentAmount  -> ${data.getStringExtra("paymentAmount")}
                    
                    """.trimIndent()
                )
                resultTextView.append(
                    """
                    | paymentId      -> ${data.getStringExtra("paymentId")}
                    
                    """.trimIndent()
                )
                resultTextView.append(
                    """
                    | message        -> ${data.getStringExtra("message")}
                    
                    """.trimIndent()
                )
                resultTextView.append(
                    """
                    | cardNumber     -> ${data.getStringExtra("cardNumber")}
                    
                    """.trimIndent()
                )
                resultTextView.append(
                    """
                    | cardBank       -> ${data.getStringExtra("cardBank")}
                    
                    """.trimIndent()
                )
                resultTextView.append(
                    """
                    | referenceCode  -> ${data.getStringExtra("referenceCode")}
                    
                    """.trimIndent()
                )
                resultTextView.append(
                    """
                    | merchantID     -> ${data.getStringExtra("merchantID")}
                    
                    """.trimIndent()
                )
                resultTextView.append(
                    """
                    | terminalID     -> ${data.getStringExtra("terminalID")}
                    
                    """.trimIndent()
                )
                resultTextView.append(
                    """
                    | dateTime       -> ${data.getStringExtra("dateTime")}
                    
                    """.trimIndent()
                )
                resultTextView.append(
                    """
                    | stan           -> ${data.getStringExtra("stan")}
                    
                    """.trimIndent()
                )
                resultTextView.append(
                    """
                    | txResponseCode -> ${data.getStringExtra("txResponseCode")}
                    
                    """.trimIndent()
                )
                resultTextView.append(
                    """
                    | txResponseTitle-> ${data.getStringExtra("txResponseTitle")}
                    
                    """.trimIndent()
                )
                resultTextView.append("========================================\n")
            } else if (requestCode == Library.CHECK_UPDATE_REQUEST_CODE) {
                Log.e("specialTag", "===============================================")
                Log.e("specialTag", "| message        -> " + data.getStringExtra("message"))
                Log.e("specialTag", "| currentVersion -> " + data.getStringExtra("currentVersion"))
                Log.e("specialTag", "| lastVersion    -> " + data.getStringExtra("lastVersion"))
                Log.e("specialTag", "===============================================")
                resultTextView.append("========================================\n")
                resultTextView.append("| resultCode     -> $resultCode\n")
                resultTextView.append(
                    """
                    | message        -> ${data.getStringExtra("message")}
                    
                    """.trimIndent()
                )
                resultTextView.append(
                    """
                    | currentVersion -> ${data.getStringExtra("currentVersion")}
                    
                    """.trimIndent()
                )
                resultTextView.append(
                    """
                    | lastVersion    -> ${data.getStringExtra("lastVersion")}
                    
                    """.trimIndent()
                )
                resultTextView.append("========================================\n")
            }
        } else {
            Log.e("specialTag", "onActivityResult->Intent data is null")
        }
    }

    private fun initUiForResume() {
        val decorView = window.decorView
        decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
    }
}