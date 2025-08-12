# 🎖️ March of the Legion

> **A tactical battlefield simulation showcasing Insertion Sort through military unit formations**

[![Java](https://img.shields.io/badge/Java-24-orange.svg)](https://openjdk.java.net/)
[![Maven](https://img.shields.io/badge/Maven-3.11.0-blue.svg)](https://maven.apache.org/)
[![License](https://img.shields.io/badge/License-MIT-green.svg)](LICENSE)

---

## 🚀 Overview

**March of the Legion** is a Java application that demonstrates the Insertion Sort algorithm through a visual military battlefield simulation. Watch as different military unit types reorganize themselves on a 6x6 battlefield grid, creating an engaging way to understand sorting algorithm behavior.

### ✨ Key Features

- 🎯 **Insertion Sort Algorithm**: Demonstrates O(n²) sorting complexity
- ⚔️ **5 Military Unit Types**: Commander, Medic, Tank, Sniper, and Infantry
- 🗺️ **Fixed 6x6 Battlefield**: Compact grid for clear visualization
- 🧭 **South Formation**: Units arrange in column-based formation after sorting
- 📊 **Dual Display Modes**: Character symbols or numeric representation
- 🎮 **Simple Command Interface**: Easy-to-use parameter system

---

## 🏗️ Architecture

```
src/main/java/university/jala/legion/
├── Main.java                    # Application entry point
├── cli/
│   └── Parameters.java          # Command-line argument parser
├── model/
│   ├── Battlefield.java         # 6x6 grid management and rendering
│   ├── Character.java           # Base unit class
│   ├── Position.java            # Coordinate system
│   └── units/                   # Military unit implementations
│       ├── Commander.java       # Rank 0 - Highest priority
│       ├── Medic.java          # Rank 1 - Medical support
│       ├── Tank.java           # Rank 2 - Heavy armor
│       ├── Sniper.java         # Rank 3 - Precision units
│       └── Infantry.java       # Rank 4 - Ground troops
└── sorting/
    ├── SortingStrategy.java     # Strategy pattern interface
    ├── SortingStrategyFactory.java # Factory (prepared for future algorithms)
    └── InsertionSort.java      # O(n²) sorting implementation
```

---

## 🚀 Quick Start

### Prerequisites

- ☕ **Java 24** or higher
- 🔧 **Maven 3.8+**

### Installation

```bash
# Clone the repository
git clone https://github.com/yourusername/march-of-the-legion.git
cd march-of-the-legion

# Compile the project
mvn compile

# Run with sample parameters
mvn exec:java "-Dexec.args=a=i u=2,1,1,1,3 t=c"
```

---

## 🎮 Usage

### Command Line Parameters

| Parameter | Description | Values | Required | Notes |
|-----------|-------------|--------|----------|-------|
| `a` | Sorting Algorithm | `i` (Insertion Sort only) | ✅ | Only Insertion Sort supported |
| `u` | Unit Distribution | `commander,medic,tank,sniper,infantry` | ✅ | Comma-separated, max 36 total |
| `t` | Display Type | `c` (Character), `n` (Numeric) | ✅ | Character or numeric display |

**Note**: The battlefield size is fixed at 6x6, and formation orientation is fixed to South.

### Example Commands

```bash
# Basic example with character display
mvn exec:java "-Dexec.args=a=i u=2,1,1,1,3 t=c"

# Numeric display example
mvn exec:java "-Dexec.args=a=i u=1,1,2,2,2 t=n"

# Maximum units example
mvn exec:java "-Dexec.args=a=i u=5,5,5,5,5 t=c"

# Alternative: Build JAR first, then run
mvn clean package
java -jar target/legion-1.0-SNAPSHOT.jar a=i u=2,1,1,1,3 t=c
```

### Alternative Running Methods

**Option 1: Build and run JAR directly**
```bash
mvn clean compile package
java -jar target/legion-1.0-SNAPSHOT.jar a=i u=2,1,1,1,3 t=c
```

**Option 2: Run with compiled classes**
```bash
mvn compile
java -cp target/classes university.jala.legion.Main a=i u=2,1,1,1,3 t=c
```

**Option 3: Using PowerShell (Windows)**
```powershell
mvn exec:java '-Dexec.args=a=i u=2,1,1,1,3 t=c'
```

---

## 📊 Sample Output

```
Algorithm: [Insertion sort]
Type: [Character]
Troops: [8]
Battlefield: [6 x 6]

Initial Position:
* * * * * T 
* C I * * * 
* * * * * * 
* * * * * S 
* * * * I * 
* I * * C M 

Final Position:
C * * * * * 
C * * * * * 
M * * * * * 
T * * * * * 
S * * * * * 
I * * * * * 
```

---

## 🎖️ Military Unit Hierarchy

| Unit | Symbol | Rank | Numeric | Description |
|------|--------|------|---------|-------------|
| **Commander** | `C` | 0 | 1 | Strategic leadership - highest priority |
| **Medic** | `M` | 1 | 2 | Medical support and field treatment |
| **Tank** | `T` | 2 | 3 | Heavy armored assault units |
| **Sniper** | `S` | 3 | 4 | Precision long-range specialists |
| **Infantry** | `I` | 4 | 5 | Standard ground combat forces |

---

## ⚡ Algorithm Details

### Insertion Sort Implementation

- **Time Complexity**: O(n²) in worst and average case, O(n) in best case
- **Space Complexity**: O(1) - sorts in place
- **Stability**: Stable - maintains relative order of equal elements
- **Method**: Builds sorted array one element at a time by inserting each element into its correct position

The algorithm sorts units by their military rank, with Commanders (rank 0) having the highest priority and Infantry (rank 4) having the lowest priority.

---

## 🛠️ Development

### Building from Source

```bash
# Clean and compile
mvn clean compile

# Run tests
mvn test

# Create executable JAR
mvn package

# Run the JAR directly
java -jar target/legion-1.0-SNAPSHOT.jar a=i u=1,1,1,1,1 t=c
```

### Running Tests

The project includes custom test classes that output results to the console:

```bash
# Run all tests
mvn test

# Run specific test classes
java -cp target/test-classes:target/classes university.jala.legion.model.CharacterTest
java -cp target/test-classes:target/classes university.jala.legion.model.PositionTest
java -cp target/test-classes:target/classes university.jala.legion.sorting.InsertionSortTest
```

### Project Structure

The project follows Maven standard directory layout and implements design patterns:

- **Strategy Pattern**: Interface for sorting algorithms (prepared for future expansion)
- **Factory Pattern**: For creating sorting strategy instances
- **Template Method**: Base Character class with concrete unit implementations

---

## 🎯 Current Limitations

This version is a simplified implementation with the following constraints:

- **Single Algorithm**: Only Insertion Sort is implemented
- **Fixed Battlefield**: 6x6 grid size only
- **Fixed Orientation**: South formation pattern only
- **No Performance Metrics**: Execution time not displayed
- **Limited Validation**: Basic parameter validation only

---

## 🚀 Future Enhancements

The architecture is designed to support future expansions:

- Additional sorting algorithms (Quick Sort, Merge Sort, Radix Sort, Counting Sort)
- Variable battlefield sizes
- Multiple formation orientations (North, East, West)
- Performance timing and comparison features
- Advanced visualization options

---

## 🤔 How It Works

1. **Initialization**: Units are randomly placed on the 6x6 battlefield
2. **Display**: Initial random formation is shown
3. **Sorting**: Insertion Sort algorithm organizes units by military rank
4. **Final Formation**: Sorted units are displayed in South orientation (column-wise placement from bottom-left)

The sorting is based on military hierarchy where lower rank numbers indicate higher priority in formation.

---

## 🤝 Contributing

We welcome contributions! Please feel free to:

1. 🍴 Fork the repository
2. 🌿 Create a feature branch (`git checkout -b feature/amazing-feature`)
3. 💾 Commit your changes (`git commit -m 'Add amazing feature'`)
4. 📤 Push to the branch (`git push origin feature/amazing-feature`)
5. 📄 Open a Pull Request

---

## 📜 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

## 🙏 Acknowledgments

- Educational tool for understanding sorting algorithm behavior
- Demonstrates military tactical formations through algorithmic visualization
- Built using modern Java features and object-oriented design principles

---

<div align="center">

**⭐ Star this repo if you found it interesting! ⭐**

Made with ❤️ for algorithmic learning

</div>