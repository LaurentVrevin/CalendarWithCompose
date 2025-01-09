# CalendarView with Jetpack Compose

A **simple**, **customizable**, and **scalable** calendar built with **Jetpack Compose** in Kotlin. This project demonstrates how to create a dynamic calendar with **month navigation**, a responsive UI, and a modular structure following **clean architecture** principles.

![Snapshot-Calendar-Jetpack-Compose-github](https://github.com/user-attachments/assets/8c08d600-a828-4a21-9467-7c11402f459c)

----------

## 🚀 **Features**

-   Displays a **calendar grid** for the current month.
-   **Fixed 5-row grid layout** for consistent design, including days from the previous and next months.
-   Navigation buttons to **switch between months**.
-   Highlights the **current day** with a circular background.
-   Days from the **current month** are displayed in bold, while those from adjacent months are grayed out.
-   **Clean Architecture** implementation for better maintainability and scalability.

----------

## 📂 **Architecture Overview**

This project follows the principles of **Clean Architecture**, splitting the codebase into layers for clarity and reusability:

1.  **Domain Layer:**
    
    -   Decoupled from UI frameworks for easy testing and adaptability.
2.  **Presentation Layer:**
    
    -   Manages UI-related components (`CalendarHeader`, `CalendarGrid`, `DaysOfWeek`).
    -   Built entirely with **Jetpack Compose**.
3.  **Utils:**
    
    -   Includes helper functions for reusable logic (e.g., calendar data generation).

----------

## 📋 **Requirements**

-   **Android 8.0 (API 26)** or higher.
-   **Kotlin 1.8** or higher.
-   **Jetpack Compose 1.4** or higher.

----------

## 🎥 **Demo**

https://github.com/user-attachments/assets/42cc5beb-2f09-40d3-b4d2-232a89966119

----------

## 🛠 **How to Use**

1.  **Clone the repository:**
    

    

    
    `git clone https://github.com/your-username/calendar-view-compose.git` 
    
2.  **Open the project in Android Studio.**
    
3.  **Build and run** the project on an emulator or physical device.
    
4.  The `CalendarView` composable will display a calendar for the current month, including:
    
    -   Buttons to navigate to previous and next months.
    -   A highlight for the current day with a circular marker.

----------

## 💡 **Code Structure**

### 📂 Domain Layer (`domain`)

Handles business logic and data processing:



### 📂 Presentation Layer (`presentation`)

Contains the UI components:

-   **Components (`components`)**:
    -   `CalendarHeader`: Displays the month and year with navigation buttons.
    -   `DaysOfWeek`: Displays the days of the week.
    -   `CalendarGrid`: Renders the calendar grid for the current month.
    -   `CalendarFooter`: Contains navigation actions like "Today", "Previous", and "Next".
-   **Screens (`screen`)**:
    -   `CalendarView`: The main screen composable that integrates all components.

### 📂 Utils (`utils`)

Houses helper utilities:

-   **`generateCalendarData.kt`**: Provides the days for the current, previous, and next months to populate the grid.

----------

## 🧪 **How It Works**

1.  **Dynamic Grid**: Always displays 6 rows (42 cells) to maintain a consistent layout.
2.  **Highlighting**:
    -   **Current Day**: Highlighted with a circular background.
    -   **Current Month Days**: Shown in bold.
    -   **Adjacent Month Days**: Shown in gray.
3.  **Clean Architecture**: Ensures a modular and testable codebase.

----------

## 🤝 **Contributing**

We welcome contributions! If you find a bug or have suggestions for improvements, feel free to open an issue or submit a pull request.

----------

## 📜 **License**

This project is licensed under the MIT License. See the `LICENSE` file for details.

----------

## 🎉 Happy coding!
