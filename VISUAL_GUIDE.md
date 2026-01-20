# Visual App Structure and Flow

## Screen Overview

```
┌─────────────────────────────────────────────────────────────┐
│                      HINTS DATING APP                        │
└─────────────────────────────────────────────────────────────┘

┌──────────────────── MAIN ACTIVITY ─────────────────────────┐
│                                                              │
│  ┌────────────────── FRAGMENT CONTAINER ─────────────────┐  │
│  │                                                         │  │
│  │  [Current Fragment: Discover/Profile/Wall/etc.]        │  │
│  │                                                         │  │
│  └─────────────────────────────────────────────────────────┘  │
│                                                              │
│  ┌────────────── BOTTOM NAVIGATION BAR ──────────────────┐  │
│  │  [Profile]  [Discover]  [Wall]  [Likes]  [Settings]   │  │
│  └─────────────────────────────────────────────────────────┘  │
│                                                              │
└──────────────────────────────────────────────────────────────┘
```

## Navigation Flow

```
                    ┌────────────────┐
                    │  MainActivity  │
                    │   (Launcher)   │
                    └────────┬───────┘
                             │
                             ▼
                    ┌────────────────┐
                    │ Bottom Nav Bar │
                    └────────┬───────┘
                             │
         ┌───────────────────┼───────────────────┬──────────────┐
         │                   │                   │              │
         ▼                   ▼                   ▼              ▼
    ┌────────┐          ┌─────────┐        ┌────────┐     ┌──────────┐
    │Profile │          │Discover │        │  Wall  │     │  Likes   │
    │Fragment│          │Fragment │        │Fragment│     │ Fragment │
    └────────┘          └─────────┘        └────────┘     └──────────┘
         │                   │                   │              │
         ▼                   ▼                   ▼              ▼
    Upload              Swipe Cards         Post Text      Grid View
    Photo/Video         Like/Pass           View Feed      Liked Users
```

## Profile Fragment Layout

```
┌─────────────────────────────────────────┐
│         PROFILE FRAGMENT                │
├─────────────────────────────────────────┤
│                                         │
│         ┌───────────────┐               │
│         │   Profile     │               │
│         │    Image      │               │
│         │   (400x400)   │               │
│         └───────────────┘               │
│                                         │
│          John Doe                       │
│          Age: 28                        │
│          San Francisco, CA              │
│                                         │
│      Love to travel and explore         │
│         new places                      │
│                                         │
│    ┌─────────────────────────┐          │
│    │   Edit Profile Button   │          │
│    └─────────────────────────┘          │
│                                         │
│    ┌─────────────────────────┐          │
│    │  Upload Photo Button    │          │
│    └─────────────────────────┘          │
│                                         │
│    ┌─────────────────────────┐          │
│    │  Upload Video Button    │          │
│    └─────────────────────────┘          │
│                                         │
└─────────────────────────────────────────┘
```

## Discover Fragment Layout

```
┌─────────────────────────────────────────┐
│        DISCOVER FRAGMENT                │
├─────────────────────────────────────────┤
│                                         │
│    ┌────────────────────────┐           │
│    │                        │           │
│    │    Profile Image       │           │
│    │    (Full card)         │           │
│    │                        │           │
│    │                        │           │
│    └────────────────────────┘           │
│                                         │
│    Sarah Smith, 26                      │
│    New York, NY                         │
│    Coffee enthusiast and bookworm       │
│                                         │
│    ┌────────┐      ┌────────┐           │
│    │ ✗ Pass │      │ ♥ Like │           │
│    └────────┘      └────────┘           │
│                                         │
│    Swipe left ← or → right              │
│                                         │
└─────────────────────────────────────────┘
```

## Wall Fragment Layout

```
┌─────────────────────────────────────────┐
│          WALL FRAGMENT                  │
├─────────────────────────────────────────┤
│  ┌──────────────────────────────┐       │
│  │  Write on your wall...       │       │
│  │                              │       │
│  └──────────────────────────────┘       │
│                          [Post]         │
├─────────────────────────────────────────┤
│  ┌────────────────────────────────┐     │
│  │ John Doe                       │     │
│  │ Jan 20, 2026 22:00            │     │
│  │                               │     │
│  │ Just had an amazing day at    │     │
│  │ the beach! 🏖️                 │     │
│  │                               │     │
│  │ ♥ 15                          │     │
│  └────────────────────────────────┘     │
│                                         │
│  ┌────────────────────────────────┐     │
│  │ Sarah Smith                    │     │
│  │ Jan 20, 2026 20:00            │     │
│  │                               │     │
│  │ Reading my favorite book at   │     │
│  │ the cafe ☕📚                   │     │
│  │                               │     │
│  │ ♥ 23                          │     │
│  └────────────────────────────────┘     │
│                                         │
│  [Scrollable list of posts...]         │
│                                         │
└─────────────────────────────────────────┘
```

## Likes Fragment Layout

```
┌─────────────────────────────────────────┐
│         LIKES FRAGMENT                  │
├─────────────────────────────────────────┤
│                                         │
│  ┌───────────┐    ┌───────────┐        │
│  │  Profile  │    │  Profile  │        │
│  │   Image   │    │   Image   │        │
│  │           │    │           │        │
│  │  Sarah    │    │  Emily    │        │
│  │   26      │    │   25      │        │
│  └───────────┘    └───────────┘        │
│                                         │
│  ┌───────────┐    ┌───────────┐        │
│  │  Profile  │    │  Profile  │        │
│  │   Image   │    │   Image   │        │
│  │           │    │           │        │
│  │  Michael  │    │   David   │        │
│  │   30      │    │   29      │        │
│  └───────────┘    └───────────┘        │
│                                         │
│  [2-column grid layout...]              │
│                                         │
└─────────────────────────────────────────┘
```

## Settings Fragment Layout

```
┌─────────────────────────────────────────┐
│        SETTINGS FRAGMENT                │
├─────────────────────────────────────────┤
│                                         │
│  Settings                               │
│                                         │
│  ┌──────────────────────────────────┐   │
│  │ Theme Settings                   │   │
│  │                                  │   │
│  │ Switch between day and night     │   │
│  │ mode                             │   │
│  │                                  │   │
│  │                  [Night Mode] ○  │   │
│  └──────────────────────────────────┘   │
│                                         │
│  Toggle switch changes theme instantly  │
│                                         │
└─────────────────────────────────────────┘
```

## Day vs Night Mode Comparison

```
┌──────────────────── DAY MODE ────────────────────┐
│  Background: White (#FFFFFF)                     │
│  Primary: Blue (#2196F3)                         │
│  Text: Black (#000000)                           │
│  Cards: White with shadows                       │
│  Icons: Dark icons                               │
│                                                  │
│  ┌────────────────────────────┐                  │
│  │ ☀️ Bright & Clean          │                  │
│  │                            │                  │
│  │ High contrast for outdoor  │                  │
│  │ Professional look          │                  │
│  └────────────────────────────┘                  │
└──────────────────────────────────────────────────┘

┌──────────────────── NIGHT MODE ──────────────────┐
│  Background: Dark (#121212)                      │
│  Primary: Dim Blue (#1E88E5)                     │
│  Text: White (#FFFFFF)                           │
│  Cards: Dark gray with elevation                 │
│  Icons: Light icons                              │
│                                                  │
│  ┌────────────────────────────┐                  │
│  │ 🌙 Dark & Comfortable      │                  │
│  │                            │                  │
│  │ Reduced eye strain         │                  │
│  │ Battery efficient          │                  │
│  └────────────────────────────┘                  │
└──────────────────────────────────────────────────┘
```

## Swipe Gesture Flow

```
    ┌────────────┐
    │  Profile   │
    │   Card     │
    └──────┬─────┘
           │
    User touches screen
           │
           ▼
    ┌─────────────┐
    │  Dragging   │
    │   Left/     │
    │   Right     │
    └──────┬──────┘
           │
    ┌──────┴──────┐
    │             │
    ▼             ▼
┌────────┐    ┌────────┐
│ Swipe  │    │ Swipe  │
│  Left  │    │ Right  │
└───┬────┘    └───┬────┘
    │             │
    ▼             ▼
┌────────┐    ┌────────┐
│  Pass  │    │  Like  │
│ Profile│    │Profile │
└───┬────┘    └───┬────┘
    │             │
    │             ▼
    │      ┌────────────┐
    │      │Add to Likes│
    │      └────────────┘
    │             │
    └─────┬───────┘
          ▼
    ┌─────────────┐
    │Animate Exit │
    │Show Next    │
    │Profile      │
    └─────────────┘
```

## Data Flow Architecture

```
┌──────────────────────────────────────────────────┐
│                   UI Layer                        │
│  ┌──────────┐  ┌──────────┐  ┌──────────┐       │
│  │ Fragment │  │ Fragment │  │ Fragment │       │
│  │    1     │  │    2     │  │    3     │       │
│  └────┬─────┘  └────┬─────┘  └────┬─────┘       │
│       │             │             │              │
└───────┼─────────────┼─────────────┼──────────────┘
        │             │             │
        └─────────────┼─────────────┘
                      │
┌─────────────────────▼───────────────────────────┐
│               Repository Layer                   │
│                                                  │
│           ┌───────────────────┐                  │
│           │  DataRepository   │                  │
│           │    (Singleton)    │                  │
│           └─────────┬─────────┘                  │
│                     │                            │
└─────────────────────┼────────────────────────────┘
                      │
┌─────────────────────▼───────────────────────────┐
│                 Data Layer                       │
│                                                  │
│  ┌────────┐  ┌────────┐  ┌────────┐            │
│  │  User  │  │  Post  │  │ Match  │            │
│  │  Data  │  │  Data  │  │  Data  │            │
│  └────────┘  └────────┘  └────────┘            │
│                                                  │
│      (In-memory storage for demo)               │
│      (Would be Room DB in production)           │
└──────────────────────────────────────────────────┘
```

## Theme Manager Flow

```
┌──────────────────────────────────────┐
│     SettingsFragment                 │
│                                      │
│   User toggles theme switch          │
└──────────────┬───────────────────────┘
               │
               ▼
┌──────────────────────────────────────┐
│        ThemeManager                  │
│                                      │
│  setNightMode(isNight: Boolean)     │
└──────────────┬───────────────────────┘
               │
               ▼
┌──────────────────────────────────────┐
│         DataStore                    │
│                                      │
│  Persist preference                  │
└──────────────┬───────────────────────┘
               │
               ▼
┌──────────────────────────────────────┐
│     AppCompatDelegate                │
│                                      │
│  setDefaultNightMode()               │
└──────────────┬───────────────────────┘
               │
               ▼
┌──────────────────────────────────────┐
│     System Theme Change              │
│                                      │
│  All UI components update            │
│  New theme applied instantly         │
└──────────────────────────────────────┘
```

## Color Palette

### Day Mode Colors
```
┌─────────────────────────────────────────┐
│ Primary:      #2196F3 ■ Bright Blue     │
│ Variant:      #1976D2 ■ Darker Blue     │
│ Secondary:    #FF4081 ■ Pink            │
│ Background:   #FFFFFF ■ White           │
│ Surface:      #FFFFFF ■ White           │
│ Error:        #B00020 ■ Red             │
│ On Primary:   #FFFFFF ■ White           │
│ On Secondary: #000000 ■ Black           │
│ On Background:#000000 ■ Black           │
│ On Surface:   #000000 ■ Black           │
└─────────────────────────────────────────┘
```

### Night Mode Colors
```
┌─────────────────────────────────────────┐
│ Primary:      #1E88E5 ■ Dimmer Blue     │
│ Variant:      #0D47A1 ■ Dark Blue       │
│ Secondary:    #FF4081 ■ Pink            │
│ Background:   #121212 ■ Near Black      │
│ Surface:      #1E1E1E ■ Dark Gray       │
│ Error:        #CF6679 ■ Light Red       │
│ On Primary:   #FFFFFF ■ White           │
│ On Secondary: #000000 ■ Black           │
│ On Background:#FFFFFF ■ White           │
│ On Surface:   #FFFFFF ■ White           │
└─────────────────────────────────────────┘
```

## Permission Request Flow

```
┌───────────────────────────────┐
│   User clicks Upload Photo    │
└───────────┬───────────────────┘
            │
            ▼
┌───────────────────────────────┐
│  Check if permission granted  │
└───────────┬───────────────────┘
            │
     ┌──────┴──────┐
     │             │
     ▼             ▼
 ┌───────┐    ┌───────────┐
 │Granted│    │Not Granted│
 └───┬───┘    └─────┬─────┘
     │              │
     │              ▼
     │     ┌─────────────────┐
     │     │Request Permission│
     │     └────────┬─────────┘
     │              │
     │       ┌──────┴──────┐
     │       │             │
     │       ▼             ▼
     │   ┌───────┐    ┌────────┐
     │   │Granted│    │ Denied │
     │   └───┬───┘    └────┬───┘
     │       │             │
     └───────┼─────────────┘
             │             │
             ▼             ▼
     ┌────────────┐   ┌──────────┐
     │Open Gallery│   │Show Toast│
     └────────────┘   └──────────┘
```

This visual representation helps understand the complete structure and flow of the Hints dating application!
