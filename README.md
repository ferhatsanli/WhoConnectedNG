# WhoConnectedNG

## Project Overview

WhoConnectedNG is a small Android portfolio project that demonstrates practical experience with Kotlin, Retrofit-based API consumption, and Jetpack Compose UI development. It is intended to show recruiters that I can build a modern Android app using REST APIs and Compose, follow MVVM patterns, and produce maintainable code.

This repository is presented by a computer engineering graduate who recently learned Android Kotlin development and has 2 years of professional experience in RPA (UiPath). I am currently applying for Junior Android Developer roles and this project highlights relevant skills for those positions.

Key skills and keywords: Kotlin, Android, Jetpack Compose, Retrofit, REST API, MVVM, ViewModel, Coroutines, UI, portfolio, RPA, UiPath.

---

<!-- Screenshots section (HTML table 5x2) -->
<h2>Screenshots</h2>
<p>If you add screenshots to a <code>screenshots/</code> folder at the project root, they will render here on GitHub. Filenames follow the pattern <code>ss_day_1.jpg</code>, <code>ss_day_2.jpg</code>, ..., <code>ss_night_1.jpg</code>, etc.</p>
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

## How to run

- Open the project in Android Studio (Arctic Fox or newer recommended).
- Let Gradle sync and install any missing SDK components.
- Run the app on a physical device or an emulator configured with internet access.
- The main screen triggers data download on start (see `MainActivity` → `DeviceViewModel.downloadDeviceData()`).

Note: No additional setup steps are required in this README. If you need mock data or offline testing, create a local `screenshots/` folder and add images, or run the app with a connected test server.

---

## API notes (no URLs disclosed)

- Network code lives under `app/src/main/java/com/ferhat/whoconnectedng/api`.
- The project uses Retrofit instances created in `HomeService` and `MacVenService`. Those services define the base URLs inside their respective objects. (I intentionally do not publish those URL strings here.)
- Token flow: the app requests a token from `HomeApi.getMVToken()` and then uses that token as an Authorization header when calling the Mac Vendor API (`MacVenApi.getMacData(..., "Bearer <token>")`).
- Error handling: `DeviceViewModel` contains simple retry and delay logic around network calls and sets `successful` / `error` state flags used by the UI.

---

## Table of Contents (code files)

Below is a clickable listing of the folder and file structure under `app/src/main/java/com/ferhat/whoconnectedng`. These are relative links so they work locally or on GitHub without exposing any external URLs.

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

## Key files & where to look

- `app/src/main/java/com/ferhat/whoconnectedng/api/HomeApi.kt` — device list endpoint and token endpoint declarations; service builder is in `HomeService`.
- `app/src/main/java/com/ferhat/whoconnectedng/api/MacVenApi.kt` — Mac vendor lookup interface; service builder is in `MacVenService`.
- `app/src/main/java/com/ferhat/whoconnectedng/viewmodel/DeviceViewModel.kt` — business logic: fetching devices, retrieving vendor names, retry/delay strategy, and clipboard helper.
- `app/src/main/java/com/ferhat/whoconnectedng/view/DeviceListView.kt` and `DeviceView.kt` — Jetpack Compose UI that displays devices, brand names, and copy-to-clipboard buttons.
- `app/src/main/java/com/ferhat/whoconnectedng/view/MainActivity.kt` — app entry point and initial download trigger.

---

## What I learned / Why this matters

- Practical use of Retrofit to consume REST endpoints and map JSON to Kotlin data classes.
- Using Jetpack Compose for declarative UI and theme management (`ui/theme/*`).
- Applying a lightweight MVVM approach with `ViewModel`, `mutableStateOf`, and `mutableStateMapOf` to expose state to Compose.
- Simple resilience patterns: retries, delays, and error state propagation to the UI.

These are the precise skills I want recruiters to notice when evaluating this repository.

---

## Contact / Next steps

- If you are a recruiter or hiring manager: start by reviewing `view/`, `viewmodel/`, and `api/` to see API usage and Compose UI.
- To make screenshots appear in the README, add your images into a `screenshots/` folder at the project root with the filenames used in the table.

If you want, I can also:
- Convert the screenshot placeholders to links to files you add.
- Add a short sample of the JSON returned by the device endpoint (redacted) for clarity.
