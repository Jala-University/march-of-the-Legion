# 🎖️ March of the Legion

> **A tactical battlefield simulation showcasing sorting algorithms through military unit formations**

[![Java](https://img.shields.io/badge/Java-24-orange.svg)](https://openjdk.java.net/)
[![Maven](https://img.shields.io/badge/Maven-3.11.0-blue.svg)](https://maven.apache.org/)
[![License](https://img.shields.io/badge/License-MIT-green.svg)](LICENSE)

---

## 🚀 Overview

**March of the Legion** is an innovative Java application that transforms abstract sorting algorithms into a visual military battlefield simulation. Watch as different unit types reorganize themselves across the battlefield using various sorting strategies, creating an engaging way to understand algorithmic performance and behavior.

### ✨ Key Features

- 🎯 **4 Sorting Algorithms**: Counting Sort, Radix Sort, Quick Sort, and Insertion Sort
- ⚔️ **5 Military Unit Types**: Commander, Medic, Tank, Sniper, and Infantry
- 🗺️ **Dynamic Battlefield**: Customizable grid sizes from 5x5 to 1000x1000
- 🧭 **Formation Orientations**: North, South, East, and West deployment patterns
- 📊 **Dual Display Modes**: Character symbols or numeric ranges
- ⚡ **Performance Metrics**: Real-time execution time measurement

---

## 🏗️ Architecture

```
src/main/java/university/jala/legion/
├── Main.java                    # Application entry point
├── cli/
│   └── Parameters.java          # Command-line argument parser
├── model/
│   ├── Battlefield.java         # Grid management and rendering
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
    ├── SortingStrategyFactory.java
    ├── CountingSort.java        # O(n + k) complexity
    ├── RadixSort.java          # O(d × (n + k)) complexity
    ├── QuickSort.java          # O(n log n) average case
    └── InsertionSort.java      # O(n²) complexity
```

---

## 🚀 Quick Start

### Prerequisites

- ☕ **Java 24** or higher
- 🔧 **Maven 3.8+**

### Installation

```bash
# Clone the repository
git clone https://github.com/Jala-University/march-of-the-Legion.git
cd march-of-the-Legion

# Compile the project
mvn compile

# Run with sample parameters (note the correct syntax)
mvn exec:java "-Dexec.args=a=q u=2,1,1,1,3 f=8 o=n t=c"
```

---

## 🎮 Usage

### Command Line Parameters

| Parameter | Description | Values | Required |
|-----------|-------------|--------|----------|
| `a` | Sorting Algorithm | `c` (Counting), `r` (Radix), `q` (Quick), `i` (Insertion) | ✅ |
| `u` | Unit Distribution | `commander,medic,tank,sniper,infantry` (comma-separated) | ✅ |
| `f` | Battlefield Size | `5-1000` (creates NxN grid) | ❌ (default: 10) |
| `o` | Formation Orientation | `n` (North), `s` (South), `e` (East), `w` (West) | ❌ (default: North) |
| `t` | Display Type | `c` (Character), `n` (Numeric) | ❌ (default: Character) |

### Example Commands

```bash
# Quick Sort with mixed units on 12x12 battlefield
mvn exec:java "-Dexec.args=a=q u=1,2,2,3,4 f=12 o=e t=c"

# Counting Sort demo with numeric display
mvn exec:java "-Dexec.args=a=c u=2,1,1,1,1 f=8 o=n t=n"

# Large battlefield stress test
mvn exec:java "-Dexec.args=a=r u=10,5,5,8,12 f=50 o=s t=c"

# Alternative: Build JAR first, then run
mvn clean package
java -jar target/legion-1.0-SNAPSHOT.jar a=q u=2,1,1,1,3 f=8 o=n t=c
```

### Alternative Running Methods

If you encounter issues with `mvn exec:java`, try these alternatives:

**Option 1: Build and run JAR directly**
```bash
mvn clean compile package
java -jar target/legion-1.0-SNAPSHOT.jar a=q u=2,1,1,1,3 f=8 o=n t=c
```

**Option 2: Run with compiled classes**
```bash
mvn compile
java -cp target/classes university.jala.legion.Main a=q u=2,1,1,1,3 f=8 o=n t=c
```

**Option 3: Using PowerShell (Windows)**
```powershell
mvn exec:java '-Dexec.args=a=q u=2,1,1,1,3 f=8 o=n t=c'
```

---

## 📊 Sample Output

```
Algorithm: [Quick Sort]
Type: [Character]
Orientation: [North]
Troops: [8]
Battlefield: [8 x 8]

Initial Position:
+----------------+
|* * * * * * * T |
|* C I * * * * * |
|* * * * * * * * |
|* * * * * * * S |
|* * * * * I * * |
|* I * * C * * * |
|* * * * * M * * |
|* * * * * * * * |
+----------------+

Applying Quick Sort...

Final Position:
+----------------+
|C * * * * * * * |
|C * * * * * * * |
|M * * * * * * * |
|T * * * * * * * |
|S * * * * * * * |
|I * * * * * * * |
|I * * * * * * * |
|I * * * * * * * |
+----------------+

Execution time: 0ms
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

## ⚡ Algorithm Performance

| Algorithm | Best Case | Average Case | Worst Case | Space | Stable |
|-----------|-----------|--------------|------------|-------|--------|
| **Counting Sort** | O(n + k) | O(n + k) | O(n + k) | O(k) | ✅ |
| **Radix Sort** | O(d(n + k)) | O(d(n + k)) | O(d(n + k)) | O(n + k) | ✅ |
| **Quick Sort** | O(n log n) | O(n log n) | O(n²) | O(log n) | ❌ |
| **Insertion Sort** | O(n) | O(n²) | O(n²) | O(1) | ✅ |

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
java -jar target/legion-1.0-SNAPSHOT.jar a=q u=1,1,1,1,1
```

### Project Structure

The project follows Maven standard directory layout and implements several design patterns:

- **Strategy Pattern**: For interchangeable sorting algorithms
- **Factory Pattern**: For creating sorting strategy instances
- **Command Pattern**: For parameter parsing and validation

---

## 🤝 Contributing

We welcome contributions! Please feel free to:

1. 🍴 Fork the repository
2. 🌿 Create a feature branch (`git checkout -b feature/amazing-feature`)
3. 💾 Commit your changes (`git commit -m 'Add amazing feature'`)
4. 📤 Push to the branch (`git push origin feature/amazing-feature`)
5. 🔄 Open a Pull Request

---

## 📜 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

## 🙏 Acknowledgments

- Inspired by military tactical formations and algorithmic visualization
- Built as an educational tool for understanding sorting algorithm behavior
- Developed using modern Java features and best practices

---

<div align="center">

**⭐ Star this repo if you found it interesting! ⭐**

Made with ❤️ by [University JALA Students](https://github.com/yourusername)

</div>