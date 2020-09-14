
<h1 align="center">Yue SHG App</h1></br>

<p align="center">
:eyeglasses: Yue App for Self Help Groups
</p>
<br>

<p align="center">
  <a href="#"><img alt="Android Language Badge" src="https://badgen.net/badge/OS/Android?icon=https://raw.githubusercontent.com/androiddevnotes/awesome-android-kotlin-apps/master/assets/android.svg&color=3ddc84"/></a>
  <a href="#"><img alt="Kotlin Language Badge" src="https://badgen.net/badge/language/Kotlin?icon=https://raw.githubusercontent.com/androiddevnotes/awesome-android-kotlin-apps/master/assets/kotlin.svg&color=f18e33"/></a>

</p>

<br>
<p align="center">

</p><br>

**Zomato API Demo App** searches the restaurants in the entered city.

Uses Retrofit for making API calls and MVVM architecture for better code management.

## Contents

- [Demo](#demo)
- [Codebase Focus](#codebase-focus)
- [Use Case](#use-case)
- [Technologies used](#technologies-used)


## Codebase Focus

Codebase focuses 👓 on following key things:
- MVVM
- Retrofit for network calls
- Gson for parsing the JSON response
- Coroutines for running network tasks in background
- Reactive UIs using LiveData


## Use Case

User can find the restaurants in the desired city.



## Demo 

### City search

<div align="center">	 
    <img width="320px" src="yueassets/launcher.png" alt="launcher"></img>
    <img width="320px" src="yueassets/login.png" alt="login"></img>
    <img width="320px" src="yueassets/account_profile.png" alt="account_profile"></img>
</div>



## Technologies used:

* [Retrofit](https://square.github.io/retrofit/) a REST Client for Android which makes it relatively easy to retrieve and upload JSON (or other structured data) via a REST based webservice.
* [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) to store and manage UI-related data in a lifecycle conscious way.
* [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) to handle data in a lifecycle-aware fashion.
* [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) used to manage the heavy operations i.e. `making network calls`. Coroutines help in managing background threads and reduces the need for callbacks.

## Installation

Clone the repository. Open in Android Studio. Sync Gradle and Run.

## :computer: Thank You