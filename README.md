# March of the Legion
## RTS Military Unit Simulator in Java

Development of an RTS (Real Time Strategy) troop simulator in Java that applies Object-Oriented Programming (OOP) principles for creating military units and uses sorting algorithms to organize them on a battlefield.

## Objectives

### General Objective
Develop a Java program that uses OOP pillars to model different types of troops and sorting algorithms to organize them on a battlefield.

### Specific Objectives
- Implement classes and inheritance to model different unit types: Infantry, Sniper, Tanks, Medics, Engineers, Artillery, and Commanders
- Apply polymorphism and encapsulation to manage actions and attributes of each troop type
- Use data structures like matrices and lists to represent the battlefield
- Implement at least four sorting algorithms to organize troops based on rank attributes
- Handle exceptions and validate inputs to ensure program robustness

## Problem Description

Create a military troop simulator that can efficiently organize units on an N x N (or configurable) battlefield, showing how they are sorted according to different attributes using various sorting algorithms. The program must also allow random troop placement and properly manage exceptions and validations.

## Theoretical Framework

### Object-Oriented Programming (OOP)
- **Classes** for military units
- **Inheritance** for subcategories (e.g., Sniper inherits from Character)
- **Polymorphism** in actions (e.g., move() or sort())
- **Encapsulation** of attributes (health, speed, strength, range)

### Data Structures
- Lists for troop collections
- Matrix (N x N) for the battlefield
- Maps for parameter validation

### Sorting Algorithms
- Implementation of at least four algorithms (Bubble Sort, Merge Sort, Insertion Sort, Quick Sort)
- Sorting by strength attributes

### Validations and Exceptions
- Ensure proper error handling and unexpected situations
- Argument control

## Project Requirements

- Troop modeling with classes and interfaces
- Implementation of customizable attribute sorting
- Battlefield visualization
- CLI parameters for user input
- Time measurement of sorting execution
- Documented code + UML diagram
- Git with change history

## Key Evaluation Aspects

### 1. OOP Implementation
- **Troop Types Creation**: Classes like Infantry, Tank, Sniper, Medic, Engineer, Artillery, and Anti-Aircraft Unit
- **Inheritance and Polymorphism**: Base class hierarchy (Character or Troop) and child classes with different behaviors (e.g., damage or speed)
- **Encapsulation and Abstraction**: Private attributes and public access/modification methods

### 2. Sorting Algorithms
- Implement at least four algorithms (e.g., Bubble, Insertion, Selection, MergeSort)
- Visualize how troops reorganize

### 3. Parameterization and Configuration
- Algorithm selection using parameter `a=`
- Input list type selection: `t=n` for number list (priority) or `t=c` for characters (types)
- Allow sorting troops on battlefield according to their relative geographical position using parameter `o`
- Number of units to deploy: `u=1,2,4,7,8`

### 4. User Interface and Visualization
- CLI (command line) interface or future integration with graphical UI
- Visual display of battlefield at the beginning and end of sorting

### 5. Validation and Error Control
- Validate valid positions on the field
- Validate that troops don't exceed battlefield boundaries
- Handle user input errors
- Validate that different units don't mix

### 6. Iterative Development and Evaluation
- Weekly progress reviewed by a tutor, emphasizing progressive feature implementation
- Partial evaluations to ensure compliance with project objectives and requirements

## Command Line Interface

The program is executed via CLI command line with parameters:

```bash
java Troops a=q t=n o=s u=1,1,4,7,10 f=10
```

## Parameter Meanings

### Algorithm Parameter (a)
The sorting algorithm to use:
- `"S"` or `"s"` → Selection sort
- `"B"` or `"b"` → Bubble sort
- `"I"` or `"i"` → Insertion sort
- `"M"` or `"m"` → Merge sort
- `"Q"` or `"q"` → Quick sort
- `"H"` or `"h"` → Heap sort
- `"C"` or `"c"` → Counting sort
- `"R"` or `"r"` → Radix sort

### Type Parameter (t)
Parameterizes the list type (numeric or character) where numbers or characters determine unit type:

#### Character List (`"C"` or `"c"`)
- `a → j` → Commander
- `k → t` → Medic
- `u → z` continues with `A – J` → Tank
- `K – N` → Sniper
- `O – X` → Infantry

#### Number List (`"N"` or `"n"`)
- `n > 0 and n < 11` → Commander
- `n > 10 and n < 21` → Medic
- `n > 20 and n < 31` → Tank
- `n > 30 and n < 41` → Sniper
- `n > 40 and n < 51` → Infantry

### Orientation Parameter (o)
Allows sorting troops on battlefield according to their relative geographical position:
- `"N"` or `"n"` → Sort from south to north
- `"S"` or `"s"` → Sort from north to south
- `"E"` or `"e"` → Sort from west to east
- `"W"` or `"w"` → Sort from east to west

### Units Parameter (u) - Troop Distribution by Role
An integer array representing the number of troops per type, organized hierarchically according to their battlefield role. The index position indicates troop type, and the numeric value represents how many units of that type will be deployed.

**Example structure:**
```
u=1,2,5,4,10
```
Means:
- `u[0] = 1` → 1 Commander
- `u[1] = 2` → 2 Medics
- `u[2] = 5` → 5 Tanks
- `u[3] = 4` → 4 Snipers
- `u[4] = 10` → 10 Infantry Units

### Battlefield Size Parameter (f)
Defines battlefield dimensions as an NxN square matrix of cells.

Where N is a positive integer ≥ 5 and ≤ 1000 (default is 10 if not specified).

Example: `f=10` creates a 10x10 battlefield.

## Random Troop Generation on Battlefield

Initial troop positions will be randomly generated. The program must execute the following actions:

### Random Troop Selection
Units will be randomly selected from the available set of troop types (commander, medic, infantry, and other related elements) until reaching quantities indicated by parameter `u`. This selection must use a random number generator.

### Battlefield Size Restrictions
- Multiple infantry soldiers, medics, or commanders are allowed, but limited by field dimensions (`f`) and troop number (`u`)
- Must not exceed total available cells (`f x f`), knowing each unit type must be on a separate line
- Each troop type must be positioned in distinct rows to avoid mixing

### Random Field Placement
Each troop must be placed in a random position within the battlefield, represented by an `f x f` square matrix.

### Position Conflict Avoidance
The system must validate that no two troops occupy the same cell. In case of conflict, it should attempt a new random position.

### Internal Field Representation
An internal battlefield structure (matrix, list, or map) must be created to register troops and their positions.

### Initial Visualization
The initial field with randomly positioned troops must be displayed to the user through command line interface.

### Object-Oriented Design (OOP)
The entire solution must implement Object-Oriented Programming principles, including inheritance, polymorphism, encapsulation, and abstraction to model troops and battlefield.

### Documentation and Metrics
Must include UML class diagram, code documentation, and display total time elapsed for sorting troops according to chosen algorithm.

## Examples

### Example 1
**Input:**
```bash
java Troops a=i t=c o=s u=1,2,5,5,10 f=10
```

**Output:**
```
Algorithm: [Insertion sort]
Type: [Character]
Orientation: [South]
Troops: [23]
Battlefield: [10 x 10]

Initial Position:
* * S * * T * * * I
I * * * * * * S * *
* * * I * * * * M *
* T * * * * I I * *
* * * * C * * * * I
I * S * * * S * T *
* * S * * T * * * *
* * * I * * * * I *
* M * * * I * * * *
S * * * * * * * T *

Legend:
C: Commander  M: Medic  T: Tank  S: Sniper
I: Infantry   *: Empty position

Final Position:
C * * * * * * * * *
M M * * * * * * * *
T T T T T * * * * *
S S S S S * * * * *
I I I I I I I I I I
* * * * * * * * * *
* * * * * * * * * *
* * * * * * * * * *
* * * * * * * * * *
* * * * * * * * * *
```

### Example 2
**Input:**
```bash
java Troops a=q t=c o=n u=1,2,5,5,10 f=10
```

**Output:**
```
Algorithm: [Quick sort]
Type: [Character]  
Orientation: [North]
Troops: [23]
Battlefield: [10 x 10]

Initial Position:
* * S * * T * * * S
I * * * * I * S * *
* * * T * * * * M *
* T * * * * I I * *
* * * * C * * * * I
I * * * * * S * T *
* * * * * * * * * *
* * * I * * * S I *
* M * * S I * * * *
* * * * * * * * T I

Final Position:
* * * * * * * * * *
* * * * * * * * * *
* * * * * * * * * *
* * * * * * * * * *
* * * * * * * * * *
I I I I I I I I I I
S S S S S * * * * *
T T T T T * * * * *
M M * * * * * * * *
C * * * * * * * * *
```

### Example 3
**Input:**
```bash
java Troops a=r t=c o=e u=1,2,5,5,10 f=6
```

**Output:**
```
Algorithm: [Radix]
Type: [Character]
Orientation: [East]
Troops: [23]
Battlefield: [6 x 6]

Initial Position:
S I S I T *
I I * S * I
* T M T * M
T * I I * I
* S C * * I
I * S * T *

Final Position:
* * * * I *
* * T S I *
* * T S I I
* * T S I I
* M T S I I
C M T S I I
```

### Example 4 (Size Error)
**Input:**
```bash
java Troops a=c t=c o=e u=1,2,5,5,13 f=6
```

**Output:**
```
Algorithm: [Counting sort]
Type: [Character]
Orientation: [East]
Troops: [26]
Battlefield: [6 x 6]
Error: "invalid battlefield size"
```

**Explanation:** Should return error since battlefield is full and according to restrictions, each different unit type must be separated. In this case, only 12 infantry units would fit - there's no room for 13 infantry units as they would mix with snipers.

### Example 5
**Input:**
```bash
java Troops a=r t=c o=w u=1,1,2,3,5 f=6
```

**Output:**
```
Algorithm: [Radix]
Type: [Character]
Orientation: [West]
Troops: [12]
Battlefield: [6 x 6]

Initial Position:
S * S * T *
* I * * * I
* T M * * *
* * * I * *
* S C * * I
I * * * * *

Final Position:
* * * * * *
* I * * * *
* I * * * *
* I S * * *
* I S T * *
* I S T M C
```

### Example 6 (Argument Error)
**Input:**
```bash
java Troops a=c t=c o=ajs u=1,2,5,5,13 f=6
```

**Output:**
```
Algorithm: [Counting sort]
Type: [Character]
Orientation: [invalid]
Troops: [26]
Battlefield: [6 x 6]
Error: "Value of Orientation is invalid"
```