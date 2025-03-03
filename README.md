C:\Users\dvha\AppData\Local\Android\Sdk\platform-tools\adb shell am startservice -n com.example.finaltestphase2_transfer/.TransferService -e command "requestFirst100"
C:\Users\dvha\AppData\Local\Android\Sdk\platform-tools\adb shell am startservice -n com.example.finaltestphase2_transfer/.TransferService --es command "request10BySubject" --es subject "Math"
C:\Users\dvha\AppData\Local\Android\Sdk\platform-tools\adb shell am startservice -n com.example.finaltestphase2_transfer/.TransferService --es command "request10BySumA" --es city "Hanoi"


C:\Users\dvha\AppData\Local\Android\Sdk\platform-tools\adb shell run-as com.example.finaltestphase2_transfer cat /data/data/com.example.finaltestphase2_transfer/shared_prefs/TransferServicePrefs.xml
