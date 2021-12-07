# WeatherApp
# Setup and run application
- Clone source code from develop branch
- Open Android studio and open project after clone source code done.
# Overview
This Repository contains a Weather app that Implements MVVM clean Architecture in Kotlin using Retorfit2, Hilt, Coroutines, AndroidX, Android Jetpack
# Implemented by Clean Architecture
The following diagram shows the structure of this project with 3 layers:
- Presentation
- Domain
- Data

<img width="782" alt="Screen Shot 2021-12-07 at 11 05 12 AM" src="https://user-images.githubusercontent.com/5003463/144964438-ba1c235c-3f07-49f1-a41b-63151107c636.png">

- Communication between layers
  - UI calls method from ViewModel.
  - ViewModel executes Use case.
  - Use case combines data from Weather Repositories.
  - Each Repository returns data from a Data Source
  - Information StateFlow back to the UI where we display the list of Weahther.

# MVVM (Model View ViewModel Reperesentation) Flow of Weather App
- View

  - Define the compose UI 
  
  - Request data from viewModel
  
  - Observe viewmodel using StateFlow for response

- ViewModel

  - Having all Flow of DataModels

  - Call getDataRequest from Repository

  - Send requested param to Repository

- Repository

  - Get RequestData & Flow as Param from ViewModel

  - Fetch data from Network

  - Fetch data and post it on Flow get from viewmodel

# Libraries Used
- Hilt Library is used for Define DI-Dependencies Injections

- Retrofit2 Used to call Data Fetch from network

- Kotlin Coroutines Used to Define a thread or scope to call API's

- Jetpack Compose is Android’s modern toolkit for building native UI. 

# Scenario
- Searching with a condition of the search term length must be from 3
characters or above 
- Render the searched results as a list of weather items 
- Support caching mechanism so as to prevent the app from generating a bunch of
API requests
# Result
![first_screen](https://user-images.githubusercontent.com/5003463/144965656-f167e96d-ce79-4a5f-a8a3-ad99f7f33f56.png)
![result_screen](https://user-images.githubusercontent.com/5003463/144965671-09290d5d-5677-4c8c-8792-17ba2a81a13b.png)



