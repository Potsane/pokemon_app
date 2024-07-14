# Pokemon App
This is Pokemon application, made with Jetpack Compose, Coroutines, Flow, Hilt, and Material Desing and follows a multi-module MVVM Architecture. It shows a list of the first 100 Pokemon elements, the ability to search and the Pokemon details screen. 

## API 
```
https://pokeapi.co/api/v2/
```

## Artchitecture
The application follows Google’s Layered architecture design [guideline](https://developer.android.com/topic/architecture). The app's overall architecture comprises of three layers: the UI, Domain Layer, and Data layers. 
Each of these has different responsibilities. 

<img width="878" alt="Screenshot 2024-01-16 at 13 05 06" src="https://github.com/Potsane/pokemon_app/assets/7416651/327baccf-fc41-4768-931e-4a2f7522e273">

The solution makes use of a Unidirectional Flow of data between each of the layers, the UI Layer components send events to the Domain Layer, which in turn sends data requests to the Data Layer. In return, the Data Layers send data to the Domain Layer, which sends UI events to the UI layer. 

On the UI Layer, we make use of StateFlow for reactive state management. The views (composables) send events and observe data updates on the view model, and the view model responds by updating the state variables in question. 

![Screenshot 2024-01-16 at 13 10 37](https://github.com/Potsane/pokemon_app/assets/7416651/a522ebdb-2c8b-4617-b045-68f115d51668)

Modularization

To achieve a better code organization and a loosely coupled code base, we have separated each part into a different module. This is the dependency graph for all the modules defined on the app

<img width="922" alt="Screenshot 2024-01-16 at 13 35 19" src="https://github.com/Potsane/pokemon_app/assets/7416651/df7364de-57f6-4d06-bdd7-5688001166d0">


## Illustraton
[Screen_recording_20240116_101548.webm](https://github.com/Potsane/pokemon_app/assets/7416651/692c6bfc-ea89-42fd-aaee-337adbd250c8)

<img src="https://github.com/Potsane/pokemon_app/assets/7416651/ac18227a-7557-4490-a4eb-b059a07512f7" width="200" height = "500">&emsp;
<img src="https://github.com/Potsane/pokemon_app/assets/7416651/87df0ac4-3f23-4b60-988c-4ca10a4eb61d" width="200" height = "500">&emsp;
<img src="https://github.com/Potsane/pokemon_app/assets/7416651/96a27d97-0dce-4926-8af0-af8ff9d4bb63" width="200" height = "500">&emsp;
<img src="https://github.com/Potsane/pokemon_app/assets/7416651/7c6f9b86-8cd9-41bf-8eab-eb554d33de81" width="200" height = "500">&emsp;



## LIBRARIES USED

- [Compose](https://developer.android.com/jetpack/compose/documentation) - For the UI, screens and custom views

- [Kotlin coroutines](https://kotlinlang.org/docs/coroutines-overview.html)  - Multithreading and Async operations

- [Hilt](https://dagger.dev/hilt/) - Dependency management & injection

- [Retrofit](https://square.github.io/retrofit/) - For communicating with the Pokemon API

- [Coil](https://coil-kt.github.io/coil/) - Image loading, and displaying remote source images

- [Lottie](https://airbnb.io/lottie/#/) - Used for some funky animations

- [Navigation componemt](https://developer.android.com/guide/navigation/navigation-getting-started) - For navigation between the composables

## License
```
Copyright 2024 Potsane Mohale

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    https://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
