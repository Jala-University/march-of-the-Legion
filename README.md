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

## 📐 System Architecture

### Class Diagram
![Class Diagram](https://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/march-of-the-Legion/First-Stage/First-Stage/Diagrams/class-diagram.puml)

### Component Architecture
![Component Diagram](https://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/yourusername/march-of-the-legion/main/Diagrams/component-diagram.puml)

### Execution Flow
![Sequence Diagram](https://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/yourusername/march-of-the-legion/main/Diagrams/sequence-diagram.puml)

### Main Process Flow
![Activity Diagram](https://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/yourusername/march-of-the-legion/main/Diagrams/activity-diagram.puml)

### Use Cases
![Use Case Diagram](https://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/yourusername/march-of-the-legion/main/Diagrams/use-case-diagram.puml)

### Deployment Architecture
![Deployment Diagram](https://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/yourusername/march-of-the-legion/main/Diagrams/deployment-diagram.puml)

---

## 🗃️ Architecture

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

# Create Diagrams folder and add PlantUML files
mkdir Diagrams

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

### Creating Diagrams

This project includes PlantUML diagrams in the `Diagrams/` folder:

- `class-diagram.puml` - Complete class structure and relationships
- `component-diagram.puml` - High-level component architecture
- `sequence-diagram.puml` - Main execution flow sequence
- `activity-diagram.puml` - Process flow and decision points
- `use-case-diagram.puml` - User interactions and system features
- `deployment-diagram.puml` - Deployment and runtime architecture

To create the `Diagrams` folder and add the PlantUML files:

```bash
mkdir Diagrams
# Copy the .puml files to the Diagrams folder
```

### Running Tests

The project includes custom test classes that output results to the console:

```bash
# Run all tests (recommended)
mvn test

# Compile test classes first
mvn test-compile

# Run specific test classes (Windows)
java -cp "target/test-classes;target/classes" university.jala.legion.cli.ParametersTest
java -cp "target/test-classes;target/classes" university.jala.legion.model.BattlefieldTest
java -cp "target/test-classes;target/classes" university.jala.legion.model.CharacterTest
java -cp "target/test-classes;target/classes" university.jala.legion.model.PositionTest
java -cp "target/test-classes;target/classes" university.jala.legion.sorting.InsertionSortTest

# Run specific test classes (Linux/Mac)
java -cp target/test-classes:target/classes university.jala.legion.cli.ParametersTest
java -cp target/test-classes:target/classes university.jala.legion.model.BattlefieldTest
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

## 📋 Design Patterns Used

### Strategy Pattern
The `SortingStrategy` interface allows for different sorting algorithms to be implemented and swapped easily:

```java
public interface SortingStrategy {
    void sort(List<Character> units);
    String getName();
}
```

### Factory Pattern
The `SortingStrategyFactory` creates appropriate sorting strategy instances:

```java
public static SortingStrategy createStrategy(String algorithmCode) {
    return switch (algorithmCode) {
        case "i" -> new InsertionSort();
        default -> throw new IllegalArgumentException("Invalid algorithm code");
    };
}
```

### Template Method Pattern
The abstract `Character` class provides a template for all military units:

```java
public abstract class Character {
    // Common properties and methods
    public abstract String getType();
}
```

---

## 🏗️ Architecture Highlights

### Layered Architecture
- **CLI Layer**: Command-line parameter handling and validation
- **Application Layer**: Main execution flow and orchestration
- **Model Layer**: Core domain objects and battlefield representation
- **Algorithm Layer**: Sorting strategy implementations

### Key Components

#### Battlefield Management
- **Grid System**: 6x6 matrix for unit placement
- **Random Placement**: Initial random distribution of units
- **Formation Rendering**: ASCII visualization in both character and numeric modes
- **South Orientation**: Final sorted placement follows military formation patterns

#### Unit Hierarchy
- **Rank-Based System**: Military hierarchy from Commander (0) to Infantry (4)
- **Polymorphic Design**: All units extend the base `Character` class
- **Position Management**: Each unit maintains its battlefield coordinates

#### Algorithm Implementation
- **Insertion Sort**: O(n²) time complexity, O(1) space complexity
- **Stable Sorting**: Maintains relative order of equal-ranked units
- **In-Place Sorting**: Sorts the unit list without additional memory overhead

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
- Add appropriate unit tests for new functionality
- Update documentation and diagrams as needed
- Ensure all tests pass before submitting PR

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
- **Sorting Algorithms**: Practical implementation of Insertion Sort
- **Design Patterns**: Strategy, Factory, and Template Method patterns
- **Object-Oriented Programming**: Inheritance, polymorphism, and encapsulation

### Software Engineering Practices
- **Clean Architecture**: Separation of concerns and layered design
- **Unit Testing**: Custom test implementations and validation
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

[![GitHub issues](https://img.shields.io/github/issues/yourusername/march-of-the-legion)](https://github.com/yourusername/march-of-the-legion/issues)
[![GitHub forks](https://img.shields.io/github/forks/yourusername/march-of-the-legion)](https://github.com/yourusername/march-of-the-legion/network)
[![GitHub stars](https://img.shields.io/github/stars/yourusername/march-of-the-legion)](https://github.com/yourusername/march-of-the-legion/stargazers)

</div>