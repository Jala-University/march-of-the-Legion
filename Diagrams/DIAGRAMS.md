# Project Class Diagrams

This document contains the class diagrams for the **March of the Legion** project, illustrating its architecture based on SOLID principles.

---

## 1. CLI and Validation Architecture

This diagram shows how command-line parameters are parsed and validated. The design uses the **Strategy** and **Factory** patterns to create a flexible and extensible validation system, adhering to the **Single Responsibility Principle (SRP)** and the **Open/Closed Principle (OCP)**.

```plantuml
@startuml
skinparam classAttributeIconSize 0

package "cli" {
    interface CliParameters {
        + getAlgorithm(): String
        + getOrientation(): String
        + getType(): String
        + getBattlefieldSize(): int
        + getUnitDistribution(): int[]
    }

    class Parameters implements CliParameters {
        - parameters: Map<String, String>
        + Parameters(args: String[])
    }
}

package "cli.validation" {
    interface ParameterValidator {
        + validate(parameters: Map<String, String>): void
    }

    class AlgorithmValidator implements ParameterValidator
    class BattlefieldSizeValidator implements ParameterValidator
    class OrientationValidator implements ParameterValidator
    class TypeValidator implements ParameterValidator
    class UnitDistributionValidator implements ParameterValidator

    class ParameterValidatorFactory {
        + {static} createValidators(): List<ParameterValidator>
    }
}

Parameters ..> ParameterValidatorFactory : uses
ParameterValidatorFactory ..> ParameterValidator : creates
Parameters ..> ParameterValidator : uses

@enduml
```

---

## 2. Domain Model Architecture

This diagram illustrates the core domain model. It follows the **Interface Segregation Principle (ISP)** by defining fine-grained interfaces (`Positionable`, `Displayable`) and the **Dependency Inversion Principle (DIP)** by ensuring that high-level components depend on the `ICharacter` abstraction, not on concrete unit classes. The **Factory Pattern** is used to decouple unit creation from the client.

```plantuml
@startuml
skinparam classAttributeIconSize 0

package "model" {
    class UnitFactory {
        + {static} createUnit(type: String): ICharacter
    }

    abstract class Character implements ICharacter {
        # rank: int
        # symbol: char
        # numericRange: int
        # position: Position
    }

    class Position <<record>> {
        + row: int
        + column: int
    }
}

package "model.interfaces" {
    interface ICharacter extends Positionable, Displayable {
        + getRank(): int
        + getType(): String
    }

    interface Positionable {
        + getPosition(): Position
        + setPosition(position: Position): void
    }

    interface Displayable {
        + getSymbol(): char
        + getNumericRange(): int
    }
}

package "model.units" {
    class Commander extends Character
    class Medic extends Character
    class Tank extends Character
    class Sniper extends Character
    class Infantry extends Character
}

UnitFactory ..> ICharacter : creates
UnitFactory ..> Commander : creates
UnitFactory ..> Medic : creates
UnitFactory ..> Tank : creates
UnitFactory ..> Sniper : creates
UnitFactory ..> Infantry : creates

@enduml
```

---

## 3. Sorting and Placement Architecture

This diagram shows the orchestration of sorting and placement logic. The `TroopArranger` acts as a coordinator, using the **Strategy Pattern** for both sorting and placement. This design adheres to **SRP** by separating sorting from placement and **OCP** by allowing new algorithms to be added via factories without modifying the client code.

```plantuml
@startuml
skinparam classAttributeIconSize 0

package "sorting" {
    class TroopArranger {
        - sortingStrategy: SortingStrategy
        - placementStrategy: PlacementStrategy
        + arrange(units: List<ICharacter>, size: int): void
    }

    interface SortingStrategy {
        + sort(units: List<ICharacter>): void
    }

    class SortingStrategyFactory {
        + {static} create(code: String): SortingStrategy
    }

    class CountingSort implements SortingStrategy
    class RadixSort implements SortingStrategy
    class QuickSort implements SortingStrategy
    class InsertionSort implements SortingStrategy
}

package "sorting.placement" {
    interface PlacementStrategy {
        + place(units: List<ICharacter>, size: int): void
    }

    class PlacementStrategyFactory {
        + {static} create(orientation: char): PlacementStrategy
    }

    class NorthPlacementStrategy implements PlacementStrategy
    class SouthPlacementStrategy implements PlacementStrategy
    class EastPlacementStrategy implements PlacementStrategy
    class WestPlacementStrategy implements PlacementStrategy
}

TroopArranger -> SortingStrategy
TroopArranger -> PlacementStrategy
TroopArranger ..> SortingStrategyFactory
TroopArranger ..> PlacementStrategyFactory

@enduml
```

---

## 4. Battlefield and Rendering Architecture

This diagram illustrates the separation of battlefield state management from rendering. The `Battlefield` class implements the `IBattlefield` interface, which provides a read-only contract for the rendering components. This design follows **SRP** and **DIP**, as the renderers depend on an abstraction, not on the concrete `Battlefield` class.

```plantuml
@startuml
skinparam classAttributeIconSize 0

package "model" {
    class Battlefield implements IBattlefield {
        - size: int
        - grid: ICharacter[][]
        - units: List<ICharacter>
        + setUnits(troops: List<ICharacter>): void
    }
}

package "model.interfaces" {
    interface IBattlefield {
        + getSize(): int
        + getUnitAt(row: int, column: int): ICharacter
    }
}

package "rendering" {
    interface BattlefieldRenderer {
        + render(battlefield: IBattlefield): String
    }

    class RendererFactory {
        + {static} create(type: String): BattlefieldRenderer
    }

    class CharacterRenderer implements BattlefieldRenderer
    class NumericRenderer implements BattlefieldRenderer
}

BattlefieldRenderer ..> IBattlefield : uses
RendererFactory ..> BattlefieldRenderer : creates

@enduml
```
