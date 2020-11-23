# CheckInternetKT

- Manifest
```xml
<manifest >

    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />

    ...
    
</manifest>
```

- Android 9 or Oldest

Not Realtime
```kotlin
val cm: ConnectivityManager = applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
val isConnect: Boolean =  cm.activeNetworkInfo != null && cm.activeNetworkInfo!!.isConnected

Log.d(TAG, "startNetworkCalilback: $isConnect")
```

- Android 10

Realtime every connection connect or not
```kotlin
val cm: ConnectivityManager = application.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
val builder: NetworkRequest.Builder = NetworkRequest.Builder()

cm.registerNetworkCallback(builder.build(),
    object : ConnectivityManager.NetworkCallback() {

        override fun onAvailable(network: Network) {
            Log.d(TAG, "onAvailable: true")
        }

        override fun onLost(network: Network) {
            Log.d(TAG, "onAvailable: false")
        }
    })
```

---

```
Copyright 2020 M. Fadli Zein
```

