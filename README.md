# March of the Legion - Java Project

## Overview
This project simulates the arrangement of military troops on a battlefield using sorting algorithms. The application generates troops based on command-line parameters, displays their initial random positions, sorts them by rank, and displays their final sorted positions.

## Key Features
- Generates different troop types (Commanders, Medics, Tanks, Snipers, Infantry)
- Supports character-based (`c`) and number-based (`n`) troop representations
- Implements insertion sort algorithm for troop ranking
- Displays troops on a 6x6 battlefield grid
- Handles invalid parameters with clear error messages

## Prerequisites
- Java 24 (Project uses Java 24 features)
- Apache Maven 3.8.1 or later

## Build Instructions
```bash
mvn clean package
```

The executable JAR will be generated at:
`target/legion-1.0-SNAPSHOT.jar`

## Usage
```bash
java -jar target/legion-1.0-SNAPSHOT.jar a=<algorithm> t=<type> u=<units>
```

### Parameters:
| Parameter | Values         | Description                               |
|-----------|----------------|-------------------------------------------|
| `a`       | `i`            | Sorting algorithm (insertion sort)        |
| `t`       | `c` or `n`     | Troop type: characters (`c`) or numbers (`n`) |
| `u`       | Comma-separated integers | Unit distribution (e.g., `1,1,2,3,5`) |

### Example:
```bash
java -jar target/legion-1.0-SNAPSHOT.jar a=i t=c u=1,1,2,3,5
```

## Output
```
Algorithm: [Insertion sort]
Type: [Character]
Troops: [23]
Battlefield: [6 x 6]

Initial Position:
S   I   *   S   I   C   
I   *   T   M   M   S   
I   I   I   S   *   C   
*   I   C   *   *   T   
I   I   *   S   T   *   
T   *   *   *   *   S   

Final Position:
*   *   *   *   *   *   
*   *   *   *   *   *
T   M   M   C   C   C
S   S   S   T   T   T
I   I   I   S   S   S
I   I   I   I   I   I   
```

## Project Structure
### Core Packages:
- `university.jala.legion`: Main application entry point
- `university.jala.legion.core`: Battlefield and position logic
- `university.jala.legion.core.sorting`: Sorting algorithms
- `university.jala.legion.core.trooper`: Troop implementations
- `university.jala.legion.util`: Utility classes
- `university.jala.legion.exception`: Custom exceptions

### Key Classes:
| Class                   | Responsibility                          |
|-------------------------|-----------------------------------------|
| `Main`                 | Application entry point                |
| `CommandLineParser`    | Parses and validates CLI arguments     |
| `TroopGenerator`       | Generates troops based on parameters   |
| `Battlefield`          | Manages grid and troop positioning     |
| `InsertionSort`        | Sorting algorithm implementation       |
| `Troop`                | Base class for all troop types         |

## Sorting Implementation
Troops are sorted in descending order by rank using insertion sort:
1. Commander (Rank 0)
2. Medic (Rank 1)
3. Tank (Rank 2)
4. Sniper (Rank 3)
5. Infantry (Rank 4)

## Error Handling
Invalid parameters display formatted error messages:
```
Algorithm: [Invalid]
Type: [Invalid]
Troops: [Invalid]
Invalid Values
```

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.