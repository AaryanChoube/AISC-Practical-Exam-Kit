# Experiment 2: Water Jug Problem (Python State Space Search)
from collections import defaultdict

jug1, jug2, aim = 4, 3, 2
visited = defaultdict(lambda: False)

def waterJugSolver(amt1, amt2):
    if (amt1 == aim and amt2 == 0) or (amt2 == aim and amt1 == 0):
        print(f"Goal Reached: ({amt1}, {amt2})")
        return True

    if not visited[(amt1, amt2)]:
        print(f"State: ({amt1}, {amt2})")
        visited[(amt1, amt2)] = True

        return (waterJugSolver(0, amt2) or                          # Empty Jug 1
                waterJugSolver(amt1, 0) or                          # Empty Jug 2
                waterJugSolver(jug1, amt2) or                       # Fill Jug 1
                waterJugSolver(amt1, jug2) or                       # Fill Jug 2
                waterJugSolver(amt1 + min(amt2, (jug1 - amt1)),      # Pour Jug 2 -> Jug 1
                               amt2 - min(amt2, (jug1 - amt1))) or
                waterJugSolver(amt1 - min(amt1, (jug2 - amt2)),      # Pour Jug 1 -> Jug 2
                               amt2 + min(amt1, (jug2 - amt2))))
    else:
        return False

print("=== Water Jug Problem (Capacities: 4L, 3L | Goal: 2L) ===")
waterJugSolver(0, 0)
