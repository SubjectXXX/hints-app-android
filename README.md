# Hints - Android Dating App

A native Android dating application built with Kotlin featuring profile management, social wall, swipe-based discovery, and day/night themes.

## Features

### 👤 User Profile
- View and edit user profile
- Upload profile photos and videos
- Display name, age, bio, and location
- Profile image gallery

### 💬 Wall (Social Feed)
- Post text updates to your wall
- View posts from all users
- See post timestamps and like counts
- Scrollable feed with Material Design cards

### 💕 Discover & Swipe
- Swipe through potential matches
- Swipe right to like, left to pass
- Touch/gesture-based interaction
- Animated transitions between profiles
- View profile details (name, age, bio, location)

### ⭐ Likes
- View all profiles you've liked
- Grid layout of liked users
- Profile images and basic info
- Easy access to your connections

### ⚙️ Settings
- Day/Night mode toggle
- Real-time theme switching
- Persisted theme preference
- Visually distinct light and dark themes

### 🎨 Themes
- **Day Mode**: Light, vibrant colors with blue primary
- **Night Mode**: Dark theme with comfortable contrast
- Automatic UI updates when theme changes
- Material Design 3 components

## Technical Details

### Architecture
- **Language**: Kotlin
- **UI Framework**: Android Views + Material Design 3
- **Min SDK**: 24 (Android 7.0)
- **Target SDK**: 34 (Android 14)
- **Architecture Pattern**: MVVM-ready with Repository pattern

### Key Dependencies
- Material Design Components 1.11.0
- AndroidX Core KTX 1.12.0
- Navigation Component 2.7.6
- Lifecycle Components 2.7.0
- Coil for image loading 2.5.0
- DataStore for preferences 1.0.0
- Coroutines for async operations 1.7.3

### Project Structure
```
app/
├── src/main/
│   ├── java/com/hints/datingapp/
│   │   ├── data/
│   │   │   ├── User.kt
│   │   │   ├── WallPost.kt
│   │   │   ├── Match.kt
│   │   │   └── DataRepository.kt
│   │   ├── ui/
│   │   │   ├── MainActivity.kt
│   │   │   ├── ProfileFragment.kt
│   │   │   ├── DiscoverFragment.kt
│   │   │   ├── WallFragment.kt
│   │   │   ├── LikesFragment.kt
│   │   │   └── SettingsFragment.kt
│   │   └── util/
│   │       └── ThemeManager.kt
│   └── res/
│       ├── layout/ (XML layouts)
│       ├── values/ (colors, strings, themes)
│       ├── values-night/ (night theme)
│       └── menu/ (bottom navigation)
```

## Permissions
The app requires the following permissions:
- `INTERNET` - For loading images
- `READ_EXTERNAL_STORAGE` - For accessing photos/videos (SDK < 33)
- `READ_MEDIA_IMAGES` - For accessing photos (SDK >= 33)
- `READ_MEDIA_VIDEO` - For accessing videos (SDK >= 33)
- `CAMERA` - For taking photos

## Building the Project

### Prerequisites
- Android Studio Hedgehog or later
- JDK 8 or higher
- Android SDK 34
- Gradle 8.2

### Build Instructions
1. Clone the repository
```bash
git clone https://github.com/SubjectXXX/hints-app-android.git
cd hints-app-android
```

2. Open the project in Android Studio

3. Sync Gradle files

4. Run the app on an emulator or physical device

### Using Command Line
```bash
# Build debug APK
./gradlew assembleDebug

# Install on connected device
./gradlew installDebug

# Run tests
./gradlew test
```

## Features in Detail

### Profile Management
Users can view and edit their profile information including:
- Profile photo (with image picker integration)
- Video uploads
- Personal information (name, age, location)
- Bio/description

### Swipe Mechanism
The discover screen implements a Tinder-style swiping interface:
- Touch-based gesture detection
- Smooth animations for swipe actions
- Automatic progression to next profile
- "No more profiles" state when all viewed

### Theme System
The app uses Android's native theme system with:
- Separate theme files for day/night modes
- DataStore for persisting user preference
- Dynamic theme switching without restart
- Material Design 3 color system

### Data Layer
Currently uses in-memory data storage with sample data. In a production app, this would be replaced with:
- Room database for local storage
- REST API integration for server communication
- User authentication system
- Real-time updates with WebSockets or Firebase

## Future Enhancements
- Chat messaging system
- Push notifications for matches
- Advanced profile filters
- Video profile support
- Location-based matching
- Photo verification
- In-app purchases/premium features
- Social media integration

## License
This project is part of a demonstration/portfolio application.
