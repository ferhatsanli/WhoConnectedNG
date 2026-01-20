# WhoConnectedNG

## Project Overview

WhoConnectedNG is a small Android portfolio project that demonstrates practical experience with Kotlin, Retrofit-based API consumption, and Jetpack Compose UI development. It is intended to show recruiters that I can build a modern Android app using REST APIs and Compose, follow MVVM patterns, and produce maintainable code.

This repository is presented by a computer engineering graduate who recently learned Android Kotlin development and has 2 years of professional experience in RPA (UiPath). I am currently applying for Junior Android Developer roles and this project highlights relevant skills for those positions.

Key skills and keywords: Kotlin, Android, Jetpack Compose, Retrofit, REST API, MVVM, ViewModel, Coroutines, UI, portfolio, RPA, UiPath.

---

<!-- Screenshots section (HTML table 5x2) -->
<h2>Screenshots</h2>
<p>Placeholder table for screenshots. Replace filenames with actual images in the repo under a suitable folder (for example <code>screenshots/</code>).</p>
<table>
  <tr>
    <td>ss_day_1.jpg</td>
    <td>ss_day_2.jpg</td>
    <td>ss_day_3.jpg</td>
    <td>ss_day_4.jpg</td>
    <td>ss_day_5.jpg</td>
  </tr>
  <tr>
    <td>ss_night_1.jpg</td>
    <td>ss_night_2.jpg</td>
    <td>ss_night_3.jpg</td>
    <td>ss_night_4.jpg</td>
    <td>ss_night_5.jpg</td>
  </tr>
</table>

---

## Table of Contents (code files)

Below is a clickable listing of the folder and file structure under `app/src/main/java/com/ferhat/whoconnectedng`. Click any file to view its source on GitHub (or in your local copy of the repo).

- api/
  - [HomeApi.kt](app/src/main/java/com/ferhat/whoconnectedng/api/HomeApi.kt)
  - [MacVenApi.kt](app/src/main/java/com/ferhat/whoconnectedng/api/MacVenApi.kt)
- model/
  - [Device.kt](app/src/main/java/com/ferhat/whoconnectedng/model/Device.kt)
  - [MacData.kt](app/src/main/java/com/ferhat/whoconnectedng/model/MacData.kt)
  - [Token.kt](app/src/main/java/com/ferhat/whoconnectedng/model/Token.kt)
- view/
  - [DeviceView.kt](app/src/main/java/com/ferhat/whoconnectedng/view/DeviceView.kt)
  - [DeviceListView.kt](app/src/main/java/com/ferhat/whoconnectedng/view/DeviceListView.kt)
  - [MainActivity.kt](app/src/main/java/com/ferhat/whoconnectedng/view/MainActivity.kt)
- viewmodel/
  - [DeviceViewModel.kt](app/src/main/java/com/ferhat/whoconnectedng/viewmodel/DeviceViewModel.kt)
- ui/theme/
  - [Color.kt](app/src/main/java/com/ferhat/whoconnectedng/ui/theme/Color.kt)
  - [Theme.kt](app/src/main/java/com/ferhat/whoconnectedng/ui/theme/Theme.kt)
  - [Type.kt](app/src/main/java/com/ferhat/whoconnectedng/ui/theme/Type.kt)

---

## Why this project matters (for recruiters)

- Shows hands-on use of Retrofit to consume REST APIs and handle JSON responses.
- Demonstrates modern UI development using Jetpack Compose and theming.
- Applies the MVVM pattern with a ViewModel to separate UI and business logic.
- Uses Kotlin language features and (likely) coroutines for asynchronous work.

This makes the repository a compact but complete showcase for a candidate applying to Junior Android Developer roles.

## What to look for in the code

- API contracts and network calls: check `api/HomeApi.kt` and `api/MacVenApi.kt` to see how endpoints and data models are defined.
- Data models: `model/*.kt` hold the data shapes and parsing targets.
- UI components: `view/*.kt` are where Jetpack Compose UI components and screens live.
- App state and business logic: `viewmodel/DeviceViewModel.kt` exposes state for the UI and encapsulates logic.
- Theming: `ui/theme/*` shows how colors and typography are applied with Compose Theme.

## Short self-introduction (recruiter-ready)

I am a Computer Engineering graduate who recently transitioned to Android development. I have two years of industry experience in Robotic Process Automation (UiPath), which strengthened my automation mindset and ability to design reliable flows. I now focus on Android using Kotlin, Retrofit, and Jetpack Compose. I am seeking Junior Android Developer roles where I can contribute, learn, and grow.

If you want to see how I approach API integration, UI structure, and state management, the files linked in the Table of Contents are a good place to start.

---

## Contact / Next steps

- If you are a recruiter or hiring manager: please review `view/`, `viewmodel/`, and `api/` folders first to see API usage and Compose UI.
- I welcome feedback and opportunities — add your contact details or a link to your profile here as needed.
