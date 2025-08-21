# 🎖️ March of the Legion

> **A tactical battlefield simulation showcasing sorting algorithms through military unit formations**

[![Java](https://img.shields.io/badge/Java-24-orange.svg)](https://openjdk.java.net/)
[![Maven](https://img.shields.io/badge/Maven-3.11.0-blue.svg)](https://maven.apache.org/)
[![License](https://img.shields.io/badge/License-MIT-green.svg)](LICENSE)

---

## 🚀 Overview

**March of the Legion** is a Java application that demonstrates sorting algorithms through a visual military battlefield simulation. Watch as different military unit types reorganize themselves on a customizable battlefield grid, creating an engaging way to understand sorting algorithm behavior.

### ✨ Key Features

- 🎯 **Multiple Sorting Algorithms**: Insertion Sort (implemented) with placeholders for future algorithms
- ⚔️ **5 Military Unit Types**: Commander, Medic, Tank, Sniper, and Infantry
- 🗺️ **Customizable Battlefield**: Grid size from 5x5 to 1000x1000
- 🧭 **Multiple Formations**: North, South, East, West orientation support
- 📊 **Dual Display Modes**: Character symbols or numeric representation
- 🎮 **Flexible Command Interface**: Comprehensive parameter system with validation

---

## 📐 System Architecture

### Class Diagram
![Class Diagram](https://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/Jala-University/march-of-the-Legion/implementation-parameters/Diagrams/class-diagram.puml)

### Component Architecture
![Component Diagram](https://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/Jala-University/march-of-the-Legion/implementation-parameters/Diagrams/component-diagram.puml)

### Execution Flow
![Sequence Diagram](https://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/Jala-University/march-of-the-Legion/implementation-parameters/Diagrams/sequence-diagram.puml)

### Main Process Flow
![Activity Diagram](https://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/Jala-University/march-of-the-Legion/implementation-parameters/Diagrams/activity-diagram.puml)

### Use Cases
![Use Case Diagram](https://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/Jala-University/march-of-the-Legion/implementation-parameters/Diagrams/use-case-diagram.puml)

### Deployment Architecture
![Deployment Diagram](https://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/Jala-University/march-of-the-Legion/implementation-parameters/Diagrams/deployment-diagram.puml)

---

## 🗃️ Architecture

```
src/main/java/university/jala/legion/
├── Main.java                    # Application entry point
├── cli/
│   └── Parameters.java          # Command-line argument parser with validation
├── model/
│   ├── Battlefield.java         # Dynamic grid management and rendering
│   ├── Character.java           # Base unit class with Comparable
│   ├── Position.java            # Coordinate system
│   └── units/                   # Military unit implementations
│       ├── Commander.java       # Rank 0 - Highest priority
│       ├── Medic.java          # Rank 1 - Medical support
│       ├── Tank.java           # Rank 2 - Heavy armor
│       ├── Sniper.java         # Rank 3 - Precision units
│       └── Infantry.java       # Rank 4 - Ground troops
└── sorting/
    ├── SortingStrategy.java     # Strategy pattern interface
    ├── SortingStrategyFactory.java # Factory for algorithm selection
    ├── InsertionSort.java      # O(n²) sorting implementation
    ├── QuickSort.java          # Placeholder for future implementation
    ├── CountingSort.java       # Placeholder for future implementation
    └── RadixSort.java          # Placeholder for future implementation
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

# Run with sample parameters
mvn exec:java "-Dexec.args=a=i u=2,1,1,1,3 t=c o=s f=6"
```

---

## 🎮 Usage

### Command Line Parameters

| Parameter | Description | Values | Required | Default | Notes |
|-----------|-------------|--------|----------|---------|-------|
| `a` | Sorting Algorithm | `i` (Insertion Sort) | ✅ | - | Only Insertion Sort currently implemented |
| `u` | Unit Distribution | `commander,medic,tank,sniper,infantry` | ✅ | - | Comma-separated, max f*f total |
| `t` | Display Type | `c` (Character), `n` (Numeric) | ✅ | - | Character symbols or numeric values |
| `o` | Formation Orientation | `n` (North), `s` (South), `e` (East), `w` (West) | ✅ | - | Final formation direction |
| `f` | Battlefield Size | `5` to `1000` | ❌ | `6` | Grid size (f x f) |

### Example Commands

```bash
# Basic example with all parameters
mvn exec:java "-Dexec.args=a=i u=2,1,1,1,3 t=c o=s f=8"

# Numeric display with North orientation
mvn exec:java "-Dexec.args=a=i u=1,2,3,2,1 t=n o=n f=10"

# Large battlefield example
mvn exec:java "-Dexec.args=a=i u=5,5,5,5,5 t=c o=e f=12"

# Minimal parameters (uses defaults for o and f)
mvn exec:java "-Dexec.args=a=i u=1,1,1,1,1 t=c"

# Build JAR and run directly
mvn clean package
java -jar target/legion-1.0-SNAPSHOT.jar a=i u=2,1,1,1,3 t=c o=w f=8
```

### Alternative Running Methods

**Option 1: Build and run JAR directly**
```bash
mvn clean compile package
java -jar target/legion-1.0-SNAPSHOT.jar a=i u=2,1,1,1,3 t=c o=s f=8
```

**Option 2: Run with compiled classes**
```bash
mvn compile
java -cp target/classes university.jala.legion.Main a=i u=2,1,1,1,3 t=c o=s f=8
```

**Option 3: Using PowerShell (Windows)**
```powershell
mvn exec:java '-Dexec.args=a=i u=2,1,1,1,3 t=c o=s f=8'
```

---

## 📊 Sample Output

```
Algorithm: [Insertion sort]
Type: [Character]
Orientation: [South]
Troops: [8]
Battlefield: [8 x 8]

Initial Position:
*   R   *   *   *   *   *   *
*   *   *   *   *   *   *   *
*   *   V   *   *   *   *   *
j   *   *   *   *   *   *   *   
*   *   *   *   *   *   *   *
*   w   *   *   y   *   *   *
*   *   *   *   *   *   *   T
*   *   *   t   *   j   *   *

Final Position:
V   *   *   *   *   *   *   *
T   *   *   *   *   *   *   *
R   *   *   *   *   *   *   *   
y   *   *   *   *   *   *   *
w   *   *   *   *   *   *   *
t   *   *   *   *   *   *   *
j   *   *   *   *   *   *   *
j   *   *   *   *   *   *   *
```

---

## 🎖️ Military Unit Hierarchy

| Unit | Rank | Character Range | Numeric Range | Description |
|------|------|-----------------|---------------|-------------|
| **Commander** | 0 | a-j | 1-10 | Strategic leadership - highest priority |
| **Medic** | 1 | k-t | 11-20 | Medical support and field treatment |
| **Tank** | 2 | u-z, A-J | 21-30 | Heavy armored assault units |
| **Sniper** | 3 | u-z, A-J | 31-40 | Precision long-range specialists |
| **Infantry** | 4 | O-X | 41-50 | Standard ground combat forces |

**Note**: Each unit displays random values within their designated ranges for variety.

---

## 🧭 Formation Orientations

- **North (n)**: Fill from top-left, column by column
- **South (s)**: Fill from bottom-left, column by column
- **East (e)**: Fill from top-right, row by row
- **West (w)**: Fill from top-left, row by row

---

## ⚡ Algorithm Details

### Insertion Sort Implementation

- **Time Complexity**: O(n²) in worst and average case, O(n) in best case
- **Space Complexity**: O(1) - sorts in place
- **Stability**: Stable - maintains relative order of equal elements
- **Method**: Builds sorted array one element at a time by inserting each element into its correct position

The algorithm sorts units by their military rank, with Commanders (rank 0) having the highest priority and Infantry (rank 4) having the lowest priority.

### Prepared for Future Algorithms

The architecture supports easy addition of:
- **Quick Sort** (`a=q`) - Prepared placeholder
- **Counting Sort** (`a=c`) - Prepared placeholder
- **Radix Sort** (`a=r`) - Prepared placeholder

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

# Run the JAR with custom parameters
java -jar target/legion-1.0-SNAPSHOT.jar a=i u=1,1,1,1,1 t=c o=s f=8
```

### Running Tests

The project includes comprehensive test coverage:

```bash
# Run all tests
mvn test

# Run specific test classes
java -cp "target/test-classes;target/classes" university.jala.legion.cli.ParametersTest
java -cp "target/test-classes;target/classes" university.jala.legion.model.BattlefieldTest
java -cp "target/test-classes;target/classes" university.jala.legion.model.CharacterTest
java -cp "target/test-classes;target/classes" university.jala.legion.model.PositionTest
java -cp "target/test-classes;target/classes" university.jala.legion.sorting.InsertionSortTest
```

### Project Structure

The project follows Maven standard directory layout and implements design patterns:

- **Strategy Pattern**: Interface for sorting algorithms
- **Factory Pattern**: For creating sorting strategy instances
- **Template Method**: Base Character class with concrete unit implementations
- **Command Pattern**: CLI parameter parsing and validation

---

## 🎯 Current Features

- ✅ **Multiple Sorting Algorithms**: Framework ready for expansion
- ✅ **Dynamic Battlefield**: Configurable grid size (5-1000)
- ✅ **Flexible Formations**: Four orientation options
- ✅ **Robust Validation**: Comprehensive parameter checking
- ✅ **Randomized Display**: Varied character and numeric representations
- ✅ **Extensible Architecture**: Prepared for future enhancements

---

## 🚀 Future Enhancements

The architecture is designed to support future expansions:

- **Additional Algorithms**: Implement Quick Sort, Counting Sort, Radix Sort
- **Performance Metrics**: Execution timing and comparison features
- **Advanced Visualization**: Graphical interface options
- **Unit Animations**: Visual sorting process demonstration
- **Battle Scenarios**: Thematic military engagement simulations

---

## 🤔 How It Works

1. **Parameter Parsing**: CLI arguments are validated and processed
2. **Unit Creation**: Military units are generated based on distribution
3. **Initial Placement**: Units are randomly positioned on the battlefield
4. **Algorithm Execution**: Selected sorting algorithm organizes units by rank
5. **Formation Placement**: Sorted units are arranged based on orientation
6. **Visualization**: Both initial and final states are displayed

---

## 📋 Design Patterns Used

### Strategy Pattern
```java
public interface SortingStrategy {
    void sort(List<Character> units);
    String getName();
}
```

### Factory Pattern
```java
public static SortingStrategy createStrategy(String algorithmCode) {
    return switch (algorithmCode.toLowerCase()) {
        case "i" -> new InsertionSort();
        case "q" -> new QuickSort();
        case "c" -> new CountingSort();
        case "r" -> new RadixSort();
        default -> throw new IllegalArgumentException("Invalid algorithm code");
    };
}
```

### Template Method Pattern
```java
public abstract class Character implements Comparable<Character> {
    // Common properties and ranking system
    public abstract int getRank();
}
```

---

## 🏗️ Architecture Highlights

### Enhanced CLI Layer
- Comprehensive parameter validation
- Default value handling
- Error messaging and usage guidance

### Dynamic Battlefield Management
- Configurable grid sizes
- Multiple formation algorithms
- Efficient unit placement strategies

### Robust Unit System
- Randomized display values within type ranges
- Military hierarchy preservation
- Position tracking and management

---

## 🤝 Contributing

We welcome contributions! Please feel free to:

1. 🍴 Fork the repository
2. 🌿 Create a feature branch (`git checkout -b feature/amazing-feature`)
3. 💾 Commit your changes (`git commit -m 'Add amazing feature'`)
4. 📤 Push to the branch (`git push origin feature/amazing-feature`)
5. 📄 Open a Pull Request

### Contribution Guidelines

- Follow existing code style and conventions
- Add comprehensive unit tests for new functionality
- Update documentation and diagrams as needed
- Ensure all tests pass before submitting PR
- Include examples of new features in README

---

## 📜 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

## 🙏 Acknowledgments

- Educational tool for understanding sorting algorithm behavior
- Demonstrates military tactical formations through algorithmic visualization
- Built using modern Java features and object-oriented design principles
- Architecture designed for extensibility and maintainability

---

## 📚 Educational Value

This project serves as an excellent educational resource for:

### Computer Science Concepts
- **Algorithm Analysis**: Understanding time and space complexity
- **Sorting Algorithms**: Practical implementation and comparison
- **Design Patterns**: Strategy, Factory, and Template Method patterns
- **Object-Oriented Programming**: Inheritance, polymorphism, and encapsulation

### Software Engineering Practices
- **Clean Architecture**: Separation of concerns and layered design
- **Unit Testing**: Test-driven development practices
- **Build Management**: Maven configuration and dependency management
- **Documentation**: Comprehensive README and code documentation

### Military/Strategic Thinking
- **Hierarchy Systems**: Understanding organizational structures
- **Formation Tactics**: Military unit arrangement and positioning
- **Command Structure**: Chain of command and priority systems

---

<div align="center">

**⭐ Star this repo if you found it interesting! ⭐**

Made with ❤️ for algorithmic learning

[![GitHub issues](https://img.shields.io/github/issues/Jala-University/march-of-the-Legion)](https://github.com/Jala-University/march-of-the-Legion/issues)
[![GitHub forks](https://img.shields.io/github/forks/Jala-University/march-of-the-Legion)](https://github.com/Jala-University/march-of-the-Legion/network)
[![GitHub stars](https://img.shields.io/github/stars/Jala-University/march-of-the-Legion)](https://github.com/Jala-University/march-of-the-Legion/stargazers)

</div>
